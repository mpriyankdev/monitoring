package com.monitor.monitoringconfigsvc.service;

import com.monitor.monitoringconfigsvc.entity.MonitoringConfigEntity;
import com.monitor.monitoringconfigsvc.mapper.MonitoringConfigEntityToMonitoringConfigModelMapper;
import com.monitor.monitoringconfigsvc.mapper.MonitoringConfigModelToMonitoringConfigEntityMapper;
import com.monitor.monitoringconfigsvc.repository.MonitoringConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonitoringConfigService {

    @Autowired
    private MonitoringConfigRepository monitoringConfigRepository;
    @Autowired
    private MonitoringConfigModelToMonitoringConfigEntityMapper monitoringConfigModelToMonitoringConfigEntityMapper;
    @Autowired
    private MonitoringConfigEntityToMonitoringConfigModelMapper monitoringConfigEntityToMonitoringConfigModelMapper;


    public MonitoringConfigEntity saveMonitoringConfiguration(final MonitoringConfigEntity monitoringConfigEntity) {

        return monitoringConfigRepository.save(monitoringConfigEntity);

    }

    public MonitoringConfigEntity viewMonitoringConfiguration(final String configId) {

        final Optional<MonitoringConfigEntity> config = monitoringConfigRepository.findById(configId);

        if (!config.isPresent()) {
            throw new RuntimeException("No config found with configId : " + configId);

        }

        return config.get();

    }

}
