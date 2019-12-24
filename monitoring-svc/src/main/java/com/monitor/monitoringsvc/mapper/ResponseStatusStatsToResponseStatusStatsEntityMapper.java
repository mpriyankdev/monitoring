package com.monitor.monitoringsvc.mapper;

import com.monitor.monitoringsvc.entity.ResponseStatusStatsEntity;
import com.monitor.monitoringsvc.model.ResponseStatusStats;
import org.springframework.stereotype.Component;

@Component
public class ResponseStatusStatsToResponseStatusStatsEntityMapper {

    public ResponseStatusStatsEntity map(final ResponseStatusStats responseStatusStats) {

        final ResponseStatusStatsEntity responseStatusStatsEntity = new ResponseStatusStatsEntity();

        responseStatusStatsEntity.setServiceName(responseStatusStats.getServiceName());
        responseStatusStatsEntity.setStatusCode(responseStatusStats.getStatusCode());
        responseStatusStatsEntity.setStatusCount(responseStatusStats.getStatusCount());

        return responseStatusStatsEntity;

    }
}
