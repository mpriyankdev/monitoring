package com.monitor.monitoringsvc.repository;

import com.monitor.monitoringsvc.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, String> {
}
