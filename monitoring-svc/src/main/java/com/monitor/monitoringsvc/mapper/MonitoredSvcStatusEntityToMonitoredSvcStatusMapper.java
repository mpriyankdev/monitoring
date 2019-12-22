package com.monitor.monitoringsvc.mapper;

import com.monitor.monitoringsvc.entity.MonitoredSvcStatusEntity;
import com.monitor.monitoringsvc.model.MonitoredSvcStatus;
import org.springframework.stereotype.Component;

@Component
public class MonitoredSvcStatusEntityToMonitoredSvcStatusMapper {

    public MonitoredSvcStatus map(MonitoredSvcStatusEntity monitoredSvcStatusEntity) {
        final MonitoredSvcStatus monitoredSvcStatus = new MonitoredSvcStatus();

        monitoredSvcStatus.setCreatedTs(monitoredSvcStatusEntity.getCreatedTs());
        monitoredSvcStatus.setLastPollTime(monitoredSvcStatusEntity.getLastPollTime());
        monitoredSvcStatus.setServiceDownTime(monitoredSvcStatusEntity.getServiceDownTime());
        monitoredSvcStatus.setServiceUpTime(monitoredSvcStatusEntity.getServiceUpTime());
        monitoredSvcStatus.setServiceName(monitoredSvcStatusEntity.getServiceName());
        monitoredSvcStatus.setServiceStatus(monitoredSvcStatusEntity.getServiceStatus());


        return monitoredSvcStatus;
    }
}
