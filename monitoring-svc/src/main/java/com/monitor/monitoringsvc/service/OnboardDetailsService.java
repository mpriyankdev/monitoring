package com.monitor.monitoringsvc.service;

import com.monitor.monitoringsvc.entity.OnboardDetailsEntity;
import com.monitor.monitoringsvc.mapper.OnboardDetailsEntityToOnboardDetailsMapper;
import com.monitor.monitoringsvc.mapper.OnboardDetailsToOnboardDetailsEntityMapper;
import com.monitor.monitoringsvc.model.OnboardDetails;
import com.monitor.monitoringsvc.repository.OnboardDetailsRepository;
import com.monitor.monitoringsvc.utility.OnboardDetailsUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OnboardDetailsService {

    @Autowired
    private OnboardDetailsRepository onboardDetailsRepository;
    @Autowired
    private OnboardDetailsEntityToOnboardDetailsMapper onboardDetailsEntityToOnboardDetailsMapper;
    @Autowired
    private OnboardDetailsToOnboardDetailsEntityMapper onboardDetailsToOnboardDetailsEntityMapper;
    @Autowired
    private OnboardDetailsUtility onboardDetailsUtility;

    public OnboardDetailsEntity onboardService(OnboardDetails onboardDetails) {
        final OnboardDetailsEntity mappedOnboardDetailsEntity = onboardDetailsToOnboardDetailsEntityMapper.map(onboardDetails);
        mappedOnboardDetailsEntity.setOnboardTime(LocalDateTime.now());
        mappedOnboardDetailsEntity.setOnboardStatus("NEW");

        final OnboardDetailsEntity savedOnboardDetailsEntity = onboardDetailsRepository.save(mappedOnboardDetailsEntity);
        onboardDetailsUtility.onboard(savedOnboardDetailsEntity);
        return savedOnboardDetailsEntity;
    }

    public OnboardDetailsEntity onboardServiceStatus(final String serviceName) {
        final Optional<OnboardDetailsEntity> byId = onboardDetailsRepository.findById(serviceName);
        if (!byId.isPresent()) {
            throw new RuntimeException("service details not found with serviceName : " + serviceName);
        }

        return byId.get();
    }


}
