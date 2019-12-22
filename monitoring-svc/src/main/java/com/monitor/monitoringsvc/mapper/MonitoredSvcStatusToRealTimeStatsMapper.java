package com.monitor.monitoringsvc.mapper;

import com.monitor.monitoringsvc.model.MonitoredSvcStatus;
import com.monitor.monitoringsvc.model.RealTimeStats;
import org.springframework.stereotype.Component;

@Component
public class MonitoredSvcStatusToRealTimeStatsMapper {

    public RealTimeStats map(final MonitoredSvcStatus monitoredSvcStatus) {

        final RealTimeStats realTimeStats = new RealTimeStats();
        realTimeStats.setServiceName(monitoredSvcStatus.getServiceName());
        realTimeStats.setServiceCurrentStatus(monitoredSvcStatus.getServiceStatus());
        realTimeStats.setServiceStatsStartDate(monitoredSvcStatus.getCreatedTs());
        realTimeStats.setServiceDownTime(monitoredSvcStatus.getServiceDownTime());
        realTimeStats.setServiceUpTime(monitoredSvcStatus.getServiceUpTime());
        
        return realTimeStats;
    }
}
