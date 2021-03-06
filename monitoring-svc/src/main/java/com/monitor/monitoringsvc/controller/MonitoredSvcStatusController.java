package com.monitor.monitoringsvc.controller;

import com.monitor.monitoringsvc.mapper.MonitoredSvcStatusToRealTimeStatsMapper;
import com.monitor.monitoringsvc.mapper.MonitoredSvcStatusToRealTimeStatusMapper;
import com.monitor.monitoringsvc.model.MonitoredSvcStatus;
import com.monitor.monitoringsvc.model.RealTimeStats;
import com.monitor.monitoringsvc.model.RealTimeStatus;
import com.monitor.monitoringsvc.model.ResponseStatusStats;
import com.monitor.monitoringsvc.service.MonitoredSvcStatusService;
import com.monitor.monitoringsvc.service.ResponseStatusStatsService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service_monitor")
public class MonitoredSvcStatusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonitoredSvcStatusController.class);

    @Autowired
    private MonitoredSvcStatusService monitoredSvcStatusService;
    @Autowired
    private MonitoredSvcStatusToRealTimeStatusMapper monitoredSvcStatusToRealTimeStatusMapper;
    @Autowired
    private MonitoredSvcStatusToRealTimeStatsMapper monitoredSvcStatusToRealTimeStatsMapper;
    @Autowired
    private ResponseStatusStatsService responseStatusStatsService;


    @GetMapping("/current_status")
    @ApiOperation("real-time service status for the service registered for monitoring")
    public ResponseEntity<List<RealTimeStatus>> realTimeSvcStatus() {

        List<RealTimeStatus> realTimeStatuses = new ArrayList<>();
        final List<MonitoredSvcStatus> allMonitoredSvcDetails = monitoredSvcStatusService.findAllMonitoredSvcDetails();
        allMonitoredSvcDetails.stream().forEach(x -> {
            realTimeStatuses.add(monitoredSvcStatusToRealTimeStatusMapper.map(x));
        });

        return new ResponseEntity<>(realTimeStatuses, HttpStatus.OK);


    }

    @GetMapping("/service_stats")
    @ApiOperation("real time stats i.e service uptime , downtime and current-status")
    public ResponseEntity<List<RealTimeStats>> realTimeSvcStats() {
        List<RealTimeStats> realTimeStats = new ArrayList<>();
        monitoredSvcStatusService.findAllMonitoredSvcDetails().stream().forEach(x -> {
            realTimeStats.add(monitoredSvcStatusToRealTimeStatsMapper.map(x));
        });

        return new ResponseEntity<>(realTimeStats, HttpStatus.OK);
    }

    @PostMapping("/reset_stats/{serviceName}")
    @ApiOperation("reset the service stats i.e service uptime and downtime")
    public ResponseEntity<RealTimeStats> resetRealTimeSvcStatsByServiceName(@PathVariable("serviceName") final String serviceName) {

        LOGGER.info("Resetting stats for {}", serviceName);
        final MonitoredSvcStatus monitoredSvcStatus = monitoredSvcStatusService.resetSvcStatus(serviceName);
        final RealTimeStats resettedStats = monitoredSvcStatusToRealTimeStatsMapper.map(monitoredSvcStatus);

        return new ResponseEntity<>(resettedStats, HttpStatus.ACCEPTED);


    }

    @GetMapping("/response_status_stats")
    @ApiOperation("aggregated view for service responses. for any service-unavailability , it will be recoreded under default-error")
    public ResponseEntity<List<ResponseStatusStats>> responseStatusStats() {

        final List<ResponseStatusStats> allServiceResponseStats = responseStatusStatsService.findAllServiceResponseStats();
        return new ResponseEntity<>(allServiceResponseStats, HttpStatus.OK);
    }


}
