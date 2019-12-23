package com.monitor.monitoringsvc.controller;

import com.monitor.monitoringsvc.mapper.MonitoredSvcStatusToRealTimeStatsMapper;
import com.monitor.monitoringsvc.mapper.MonitoredSvcStatusToRealTimeStatusMapper;
import com.monitor.monitoringsvc.model.MonitoredSvcStatus;
import com.monitor.monitoringsvc.model.RealTimeStats;
import com.monitor.monitoringsvc.model.RealTimeStatus;
import com.monitor.monitoringsvc.service.MonitoredSvcStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service_monitor")
public class MonitoredSvcStatusController {

    @Autowired
    private MonitoredSvcStatusService monitoredSvcStatusService;
    @Autowired
    private MonitoredSvcStatusToRealTimeStatusMapper monitoredSvcStatusToRealTimeStatusMapper;
    @Autowired
    private MonitoredSvcStatusToRealTimeStatsMapper monitoredSvcStatusToRealTimeStatsMapper;


    @GetMapping("/current_status")
    public ResponseEntity<List<RealTimeStatus>> realTimeSvcStatus() {

        List<RealTimeStatus> realTimeStatuses = new ArrayList<>();
        final List<MonitoredSvcStatus> allMonitoredSvcDetails = monitoredSvcStatusService.findAllMonitoredSvcDetails();
        allMonitoredSvcDetails.stream().forEach(x -> {
            realTimeStatuses.add(monitoredSvcStatusToRealTimeStatusMapper.map(x));
        });

        return new ResponseEntity<>(realTimeStatuses, HttpStatus.OK);


    }

    @GetMapping("/service_stats")
    public ResponseEntity<List<RealTimeStats>> realTimeSvcStats() {
        List<RealTimeStats> realTimeStats = new ArrayList<>();
        monitoredSvcStatusService.findAllMonitoredSvcDetails().stream().forEach(x -> {
            realTimeStats.add(monitoredSvcStatusToRealTimeStatsMapper.map(x));
        });

        return new ResponseEntity<>(realTimeStats, HttpStatus.OK);
    }

    @PostMapping("/reset_stats/{serviceName}")
    public ResponseEntity<RealTimeStats> resetRealTimeSvcStatsByServiceName(@PathVariable("serviceName") final String serviceName) {

        final MonitoredSvcStatus monitoringDetails = monitoredSvcStatusService.findMonitoringDetails(serviceName);
        final MonitoredSvcStatus monitoredSvcStatus = monitoredSvcStatusService.resetSvcStatus(serviceName);

        final RealTimeStats resettedStats = monitoredSvcStatusToRealTimeStatsMapper.map(monitoredSvcStatus);

        return new ResponseEntity<>(resettedStats, HttpStatus.ACCEPTED);


    }


}
