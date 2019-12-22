package com.monitor.monitoringsvc.mapper;

import com.monitor.monitoringsvc.model.MonitoredSvcStatus;
import com.monitor.monitoringsvc.model.RealTimeStatus;
import org.springframework.stereotype.Component;

@Component
public class MonitoredSvcStatusToRealTimeStatusMapper {

    public RealTimeStatus map(final MonitoredSvcStatus monitoredSvcStatus) {

        final RealTimeStatus realTimeStatus = new RealTimeStatus();
        realTimeStatus.setServiceName(monitoredSvcStatus.getServiceName());
        realTimeStatus.setServiceStatus(monitoredSvcStatus.getServiceStatus());

        return realTimeStatus;

    }
}
