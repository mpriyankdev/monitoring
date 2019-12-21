package com.monitor.monitoringsvc.repository;

import com.monitor.monitoringsvc.entity.OnboardDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnboardDetailsRepository extends JpaRepository<OnboardDetailsEntity, String> {


}
