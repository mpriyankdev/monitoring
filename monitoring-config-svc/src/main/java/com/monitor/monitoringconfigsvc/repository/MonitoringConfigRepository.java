package com.monitor.monitoringconfigsvc.repository;

import com.monitor.monitoringconfigsvc.entity.MonitoringConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringConfigRepository extends JpaRepository<MonitoringConfigEntity, String> {
}
