package com.monitor.monitoringsvc.init;

import com.monitor.monitoringsvc.model.MonitoredSvcStatus;
import com.monitor.monitoringsvc.service.MonitoredSvcStatusService;
import com.monitor.monitoringsvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
public class MonitoredSvcStatusInit {

    @Autowired
    private MonitoredSvcStatusService monitoredSvcStatusService;

    @Autowired
    private RegistrationService registrationService;

    @PostConstruct
    public void initializeSvcToBeMonitored() {
        final MonitoredSvcStatus monitoredSvcStatus = new MonitoredSvcStatus();

        registrationService.findAllRegisteredService().stream().forEach(x -> {
            if (x.isMonitoringEnabled()) {
                monitoredSvcStatus.setServiceName(x.getServiceName());
                monitoredSvcStatus.setCreatedTs(LocalDateTime.now());
                monitoredSvcStatus.setLastPollTime(LocalDateTime.of(1970 , 12 , 31 , 00 , 00 , 00));
                monitoredSvcStatus.setServiceStatus("UNDEFINED");
                monitoredSvcStatus.setServiceDownTime(0L);
                monitoredSvcStatus.setServiceUpTime(0L);
                monitoredSvcStatusService.saveMonitoringDetails(monitoredSvcStatus);
            }
        });
    }

}
