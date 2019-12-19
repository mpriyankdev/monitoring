package com.monitor.monitoringconfigsvc.mapper;

import com.monitor.monitoringconfigsvc.entity.MonitoringConfigEntity;
import com.monitor.monitoringconfigsvc.model.MonitoringConfigModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MonitoringConfigModelToMonitoringConfigEntityMapper {

    public MonitoringConfigEntity map(final MonitoringConfigModel monitoringConfigModel) {

        final MonitoringConfigEntity monitoringConfigEntity = new MonitoringConfigEntity();
        monitoringConfigEntity.setConfigId(UUID.randomUUID().toString());
        monitoringConfigEntity.setApplication(monitoringConfigModel.getApplication());
        monitoringConfigEntity.setProfile(monitoringConfigModel.getProfile());
        monitoringConfigEntity.setLabel(monitoringConfigModel.getLabel());
        monitoringConfigEntity.setKey(monitoringConfigModel.getKey());
        monitoringConfigEntity.setValue(monitoringConfigModel.getValue());


        return monitoringConfigEntity;

    }


}
