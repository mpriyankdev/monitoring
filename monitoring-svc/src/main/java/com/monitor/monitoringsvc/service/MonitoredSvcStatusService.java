package com.monitor.monitoringsvc.service;

import com.monitor.monitoringsvc.entity.MonitoredSvcStatusEntity;
import com.monitor.monitoringsvc.mapper.MonitoredSvcStatusEntityToMonitoredSvcStatusMapper;
import com.monitor.monitoringsvc.mapper.MonitoredSvcStatusToMonitoredSvcStatusEntityMapper;
import com.monitor.monitoringsvc.model.MonitoredSvcStatus;
import com.monitor.monitoringsvc.repository.MonitoredSvcStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MonitoredSvcStatusService {

    @Autowired
    private MonitoredSvcStatusRepository monitoredSvcStatusRepository;

    @Autowired
    private MonitoredSvcStatusEntityToMonitoredSvcStatusMapper monitoredSvcStatusEntityToMonitoredSvcStatusMapper;
    @Autowired
    private MonitoredSvcStatusToMonitoredSvcStatusEntityMapper monitoredSvcStatusToMonitoredSvcStatusEntityMapper;

    public MonitoredSvcStatus saveMonitoringDetails(final MonitoredSvcStatus monitoredSvcStatus) {

        final MonitoredSvcStatusEntity savedEntity = monitoredSvcStatusRepository.save(monitoredSvcStatusToMonitoredSvcStatusEntityMapper.map(monitoredSvcStatus));

        return monitoredSvcStatusEntityToMonitoredSvcStatusMapper.map(savedEntity);


    }

    public MonitoredSvcStatus findMonitoringDetails(String serviceName) {
        final Optional<MonitoredSvcStatusEntity> byId = monitoredSvcStatusRepository.findById(serviceName);
        if (!byId.isPresent()) {
            throw new RuntimeException("serviceId not found with serviceName : " + serviceName);
        }
        return monitoredSvcStatusEntityToMonitoredSvcStatusMapper.map(byId.get());
    }

    public List<MonitoredSvcStatus> findAllMonitoredSvcDetails() {
        List<MonitoredSvcStatus> monitoredSvcStatuses = new ArrayList<>();

        monitoredSvcStatusRepository.findAll().stream().forEach(x -> {
            monitoredSvcStatuses.add(monitoredSvcStatusEntityToMonitoredSvcStatusMapper.map(x));
        });

        return monitoredSvcStatuses;
    }

    public MonitoredSvcStatus resetSvcStatus(final String serviceName) {
        final Optional<MonitoredSvcStatusEntity> byId = monitoredSvcStatusRepository.findById(serviceName);
        if (!byId.isPresent()) {
            throw new RuntimeException("service not found with serviceName :" + serviceName);
        }

        final MonitoredSvcStatusEntity monitoredSvcStatusEntity = byId.get();
        final MonitoredSvcStatusEntity monitoredSvcStatusEntityResetted = resetSvc(monitoredSvcStatusEntity);
        final MonitoredSvcStatusEntity savedObj = monitoredSvcStatusRepository.save(monitoredSvcStatusEntityResetted);

        return monitoredSvcStatusEntityToMonitoredSvcStatusMapper.map(savedObj);


    }

    private MonitoredSvcStatusEntity resetSvc(final MonitoredSvcStatusEntity monitoredSvcStatusEntity) {

        monitoredSvcStatusEntity.setServiceStatus("UNDEFINED");
        monitoredSvcStatusEntity.setServiceUpTime(0L);
        monitoredSvcStatusEntity.setServiceDownTime(0L);
        monitoredSvcStatusEntity.setLastPollTime(LocalDateTime.of(1970, 12, 31, 00, 00, 00));
        monitoredSvcStatusEntity.setCreatedTs(LocalDateTime.now());

        return monitoredSvcStatusEntity;


    }
}
