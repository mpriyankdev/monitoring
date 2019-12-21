package com.monitor.monitoringsvc.mapper;

import com.monitor.monitoringsvc.entity.OnboardDetailsEntity;
import com.monitor.monitoringsvc.model.OnboardDetails;
import org.springframework.stereotype.Component;

@Component
public class OnboardDetailsToOnboardDetailsEntityMapper {

    public OnboardDetailsEntity map(final OnboardDetails onboardDetails) {

        final OnboardDetailsEntity onboardDetailsEntity = new OnboardDetailsEntity();

        onboardDetailsEntity.setServiceId(onboardDetails.getServiceId());
        onboardDetailsEntity.setServiceName(onboardDetails.getServiceName());
        onboardDetailsEntity.setServiceContextPath(onboardDetails.getServiceContextPath());
        onboardDetailsEntity.setServiceUrl(onboardDetails.getServiceUrl());
        onboardDetailsEntity.setApplicationProfile(onboardDetails.getApplicationProfile());


        return onboardDetailsEntity;


    }

}
