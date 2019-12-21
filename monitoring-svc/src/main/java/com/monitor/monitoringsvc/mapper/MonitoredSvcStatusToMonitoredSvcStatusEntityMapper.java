package com.monitor.monitoringsvc.mapper;

import com.monitor.monitoringsvc.entity.MonitoredSvcStatusEntity;
import com.monitor.monitoringsvc.model.MonitoredSvcStatus;
import org.springframework.stereotype.Component;

@Component
public class MonitoredSvcStatusToMonitoredSvcStatusEntityMapper {

    public MonitoredSvcStatusEntity map(MonitoredSvcStatus monitoredSvcStatus){
        final MonitoredSvcStatusEntity monitoredSvcStatusEntity = new MonitoredSvcStatusEntity();

        monitoredSvcStatusEntity.setCreatedTs(monitoredSvcStatus.getCreatedTs());
        monitoredSvcStatusEntity.setLastPollTime(monitoredSvcStatus.getLastPollTime());
        monitoredSvcStatusEntity.setServiceDownTime(monitoredSvcStatus.getServiceDownTime());
        monitoredSvcStatusEntity.setServiceUpTime(monitoredSvcStatus.getServiceUpTime());
        monitoredSvcStatusEntity.setServiceName(monitoredSvcStatus.getServiceName());
        monitoredSvcStatusEntity.setServiceStatus(monitoredSvcStatus.getServiceStatus());


        return monitoredSvcStatusEntity;
    }
}
