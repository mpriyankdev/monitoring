package com.monitor.monitoringsvc.repository;

import com.monitor.monitoringsvc.entity.ServicePropertiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicePropertiesRepository extends JpaRepository<ServicePropertiesEntity, String> {
}
