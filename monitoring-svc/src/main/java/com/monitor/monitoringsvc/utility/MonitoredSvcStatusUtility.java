package com.monitor.monitoringsvc.utility;

import com.monitor.monitoringsvc.model.MonitoredSvcStatus;
import com.monitor.monitoringsvc.service.MonitoredSvcStatusService;
import com.monitor.monitoringsvc.service.OnboardDetailsService;
import com.monitor.monitoringsvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class MonitoredSvcStatusUtility {

    @Autowired
    private MonitoredSvcStatusService monitoredSvcStatusService;
    @Autowired
    private OnboardDetailsService onboardDetailsService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(fixedDelay = 10000)
    public void checkSvcStatus() {

        registrationService.findAllRegisteredService().stream().forEach(x -> {
            if (x.isMonitoringEnabled()) {
                final String serviceUrl = onboardDetailsService.onboardServiceStatus(x.getServiceName()).getServiceUrl() + "/mgmt/health/";
                System.out.println("serviceUrl : " + serviceUrl);
                pollSvcHealth(serviceUrl, x.getServiceName());
            }
        });


    }

    private void pollSvcHealth(String serviceUrl, String serviceName) {
        ResponseEntity<String> forEntity = new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        try {
            forEntity = restTemplate.getForEntity(serviceUrl, String.class);
        } catch (ResourceAccessException rae) {
            System.out.println("service is down :" + serviceName);
            populateServiceStatus(serviceName, "DOWN");
        }

        if (forEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("service is up : " + serviceName);
            populateServiceStatus(serviceName, "UP");
        }


    }

    private void populateServiceStatus(String serviceName, String serviceStatus) {

        final MonitoredSvcStatus monitoringDetails = monitoredSvcStatusService.findMonitoringDetails(serviceName);


        if (monitoringDetails.getLastPollTime().equals(LocalDateTime.of(1970, 12, 31, 00, 00, 00))) {
            System.out.println("\n\nchecking for the first time");
            monitoringDetails.setLastPollTime(LocalDateTime.now());
            monitoringDetails.setServiceUpTime(0L);
            monitoringDetails.setServiceDownTime(0L);

        }

        //monitoringDetails.setLastPollTime(LocalDateTime.now());

        final LocalDateTime lastPollTime = monitoringDetails.getLastPollTime();
        final LocalDateTime currentTime = LocalDateTime.now();

        final Long timeDifference = timeDifferenceInSeconds(lastPollTime, currentTime);

        monitoringDetails.setLastPollTime(currentTime);

        if ("UP".equals(serviceStatus)) {
            monitoringDetails.setServiceStatus("UP");
            monitoringDetails.setServiceUpTime(monitoringDetails.getServiceUpTime() + timeDifference);

        } else if ("DOWN".equals(serviceStatus)) {
            monitoringDetails.setServiceStatus("DOWN");
            monitoringDetails.setServiceDownTime(monitoringDetails.getServiceDownTime() + timeDifference);

        }

        monitoredSvcStatusService.saveMonitoringDetails(monitoringDetails);


    }

    private Long timeDifferenceInSeconds(LocalDateTime from, LocalDateTime to) {

        LocalDateTime tempDateTime = LocalDateTime.from(from);
        Long secs = tempDateTime.until(to, ChronoUnit.SECONDS);

        return secs;


    }


}
