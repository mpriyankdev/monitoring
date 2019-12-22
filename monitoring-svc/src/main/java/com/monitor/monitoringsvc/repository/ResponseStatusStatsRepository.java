package com.monitor.monitoringsvc.repository;

import com.monitor.monitoringsvc.entity.ResponseStatusStatsEntity;
import com.monitor.monitoringsvc.entity.ResponseStatusStatsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseStatusStatsRepository extends JpaRepository<ResponseStatusStatsEntity, ResponseStatusStatsId> {
}
