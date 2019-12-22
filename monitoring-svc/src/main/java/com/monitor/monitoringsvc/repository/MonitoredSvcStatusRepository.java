package com.monitor.monitoringsvc.repository;

import com.monitor.monitoringsvc.entity.MonitoredSvcStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoredSvcStatusRepository extends JpaRepository<MonitoredSvcStatusEntity, String> {
}
