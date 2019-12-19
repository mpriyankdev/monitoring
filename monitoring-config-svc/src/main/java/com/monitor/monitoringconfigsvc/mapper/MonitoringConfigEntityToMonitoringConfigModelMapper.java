package com.monitor.monitoringconfigsvc.mapper;

import com.monitor.monitoringconfigsvc.entity.MonitoringConfigEntity;
import com.monitor.monitoringconfigsvc.model.MonitoringConfigModel;
import org.springframework.stereotype.Component;

@Component
public class MonitoringConfigEntityToMonitoringConfigModelMapper {

    public MonitoringConfigModel map(final MonitoringConfigEntity monitoringConfigEntity) {

        final MonitoringConfigModel monitoringConfigModel = new MonitoringConfigModel();

        monitoringConfigModel.setApplication(monitoringConfigEntity.getApplication());
        monitoringConfigModel.setProfile(monitoringConfigEntity.getProfile());
        monitoringConfigModel.setLabel(monitoringConfigEntity.getLabel());
        monitoringConfigModel.setKey(monitoringConfigEntity.getKey());
        monitoringConfigModel.setValue(monitoringConfigEntity.getValue());


        return monitoringConfigModel;

    }


}
