package com.monitor.monitoringsvc.mapper;

import com.monitor.monitoringsvc.model.ResponseStatusStats;
import org.springframework.stereotype.Component;

@Component
public class ResponseStatusStatsMapper {

    public ResponseStatusStats map(String serviceName, Integer statusCode) {
        final ResponseStatusStats responseStatusStats = new ResponseStatusStats();
        responseStatusStats.setServiceName(serviceName);
        responseStatusStats.setStatusCode(statusCode);
        responseStatusStats.setStatusCount(1);

        return responseStatusStats;
    }
}
