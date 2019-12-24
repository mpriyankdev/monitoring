package com.monitor.monitoringsvc.service;

import com.monitor.monitoringsvc.entity.ResponseStatusStatsEntity;
import com.monitor.monitoringsvc.entity.ResponseStatusStatsId;
import com.monitor.monitoringsvc.mapper.ResponseStatusStatsEntityToResponseStatusStatsMapper;
import com.monitor.monitoringsvc.mapper.ResponseStatusStatsToResponseStatusStatsEntityMapper;
import com.monitor.monitoringsvc.model.ResponseStatusStats;
import com.monitor.monitoringsvc.repository.ResponseStatusStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResponseStatusStatsService {

    @Autowired
    private ResponseStatusStatsRepository responseStatusStatsRepository;
    @Autowired
    private ResponseStatusStatsEntityToResponseStatusStatsMapper responseStatusStatsEntityToResponseStatusStatsMapper;
    @Autowired
    private ResponseStatusStatsToResponseStatusStatsEntityMapper responseStatusStatsToResponseStatusStatsEntityMapper;

    public List<ResponseStatusStats> findAllServiceResponseStats() {
        List<ResponseStatusStats> listOfResponseStats = new ArrayList<>();

        final List<ResponseStatusStatsEntity> all = responseStatusStatsRepository.findAll();
        all.stream().forEach(x -> {
            listOfResponseStats.add(responseStatusStatsEntityToResponseStatusStatsMapper.map(x));
        });

        return listOfResponseStats;

    }

    public ResponseStatusStats saveResponseStats(final ResponseStatusStats responseStatusStats) {

        ResponseStatusStats finalSaveObj = null;

        if (!checkIfStatusAlreadyExists(responseStatusStats.getServiceName(), responseStatusStats.getStatusCode())) {
            final ResponseStatusStatsEntity savedObj = responseStatusStatsRepository.save(responseStatusStatsToResponseStatusStatsEntityMapper.map(responseStatusStats));
            finalSaveObj = responseStatusStatsEntityToResponseStatusStatsMapper.map(savedObj);
        } else {
            //fetch , increment counter and then save again.
            final ResponseStatusStatsId responseStatusStatsId = formId(responseStatusStats.getServiceName(), responseStatusStats.getStatusCode());
            final Optional<ResponseStatusStatsEntity> byId = responseStatusStatsRepository.findById(responseStatusStatsId);
            if (!byId.isPresent()) {
                throw new RuntimeException("id not found with status code");
            }
            final ResponseStatusStatsEntity responseStatusStatsEntity = byId.get();
            responseStatusStatsEntity.setStatusCount(responseStatusStatsEntity.getStatusCount() + 1);

            final ResponseStatusStatsEntity savedObj = responseStatusStatsRepository.save(responseStatusStatsEntity);
            finalSaveObj = responseStatusStatsEntityToResponseStatusStatsMapper.map(savedObj);

        }

        return finalSaveObj;

    }

    private boolean checkIfStatusAlreadyExists(String serviceName, Integer statusCode) {

        final ResponseStatusStatsId responseStatusStatsId = new ResponseStatusStatsId();
        responseStatusStatsId.setServiceName(serviceName);
        responseStatusStatsId.setStatusCode(statusCode);

        return responseStatusStatsRepository.existsById(responseStatusStatsId);


    }

    private ResponseStatusStatsId formId(String serviceName, Integer statusCode) {
        final ResponseStatusStatsId responseStatusStatsId = new ResponseStatusStatsId();
        responseStatusStatsId.setServiceName(serviceName);
        responseStatusStatsId.setStatusCode(statusCode);

        return responseStatusStatsId;


    }

}
