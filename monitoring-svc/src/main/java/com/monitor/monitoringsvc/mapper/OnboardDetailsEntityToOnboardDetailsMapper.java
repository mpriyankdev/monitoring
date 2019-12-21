package com.monitor.monitoringsvc.mapper;

import com.monitor.monitoringsvc.entity.OnboardDetailsEntity;
import com.monitor.monitoringsvc.model.OnboardDetails;
import org.springframework.stereotype.Component;

@Component
public class OnboardDetailsEntityToOnboardDetailsMapper {

    public OnboardDetails map(final OnboardDetailsEntity onboardDetailsEntity) {

        final OnboardDetails onboardDetails = new OnboardDetails();
        onboardDetails.setServiceId(onboardDetailsEntity.getServiceId());
        onboardDetails.setServiceName(onboardDetailsEntity.getServiceName());
        onboardDetails.setServiceContextPath(onboardDetailsEntity.getServiceContextPath());
        onboardDetails.setServiceUrl(onboardDetailsEntity.getServiceUrl());
        onboardDetails.setApplicationProfile(onboardDetailsEntity.getApplicationProfile());


        return onboardDetails;


    }
}
