package com.monitor.monitoringconfigsvc.mapper;

import com.monitor.monitoringconfigsvc.entity.MonitoringConfigEntity;
import com.monitor.monitoringconfigsvc.model.MonitoringConfigModel;
import org.springframework.stereotype.Component;

@Component
public class MonitoringConfigModelToMonitoringConfigEntityMapper {

    public MonitoringConfigEntity map(final MonitoringConfigModel monitoringConfigModel) {

        final MonitoringConfigEntity monitoringConfigEntity = new MonitoringConfigEntity();


        return monitoringConfigEntity;

    }


}
