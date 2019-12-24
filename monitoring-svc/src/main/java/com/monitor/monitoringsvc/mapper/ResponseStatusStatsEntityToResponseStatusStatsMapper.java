package com.monitor.monitoringsvc.mapper;

import com.monitor.monitoringsvc.entity.ResponseStatusStatsEntity;
import com.monitor.monitoringsvc.model.ResponseStatusStats;
import org.springframework.stereotype.Component;

@Component
public class ResponseStatusStatsEntityToResponseStatusStatsMapper {

    public ResponseStatusStats map(final ResponseStatusStatsEntity responseStatusStatsEntity) {
        final ResponseStatusStats responseStatusStats = new ResponseStatusStats();

        responseStatusStats.setServiceName(responseStatusStatsEntity.getServiceName());
        responseStatusStats.setStatusCode(responseStatusStatsEntity.getStatusCode());
        responseStatusStats.setStatusCount(responseStatusStatsEntity.getStatusCount());

        return responseStatusStats;
    }
}
