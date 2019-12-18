package com.monitor.monitoringconfigsvc.service;

import com.monitor.monitoringconfigsvc.entity.MonitoringConfigEntity;
import com.monitor.monitoringconfigsvc.mapper.MonitoringConfigEntityToMonitoringConfigModelMapper;
import com.monitor.monitoringconfigsvc.mapper.MonitoringConfigModelToMonitoringConfigEntityMapper;
import com.monitor.monitoringconfigsvc.model.MonitoringConfigModel;
import com.monitor.monitoringconfigsvc.repository.MonitoringConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoringConfigService {

    @Autowired
    private MonitoringConfigRepository monitoringConfigRepository;
    @Autowired
    private MonitoringConfigModelToMonitoringConfigEntityMapper monitoringConfigModelToMonitoringConfigEntityMapper;
    @Autowired
    private MonitoringConfigEntityToMonitoringConfigModelMapper monitoringConfigEntityToMonitoringConfigModelMapper;


    public MonitoringConfigEntity saveMonitoringConfiguration(final MonitoringConfigModel monitoringConfigModel) {
        return monitoringConfigRepository.save(monitoringConfigModelToMonitoringConfigEntityMapper.map(monitoringConfigModel));
    }

}
