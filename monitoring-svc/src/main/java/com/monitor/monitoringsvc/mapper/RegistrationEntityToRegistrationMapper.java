package com.monitor.monitoringsvc.mapper;

import com.monitor.monitoringsvc.entity.RegistrationEntity;
import com.monitor.monitoringsvc.model.Registration;
import org.springframework.stereotype.Component;

@Component
public class RegistrationEntityToRegistrationMapper {

    public Registration map(final RegistrationEntity registrationEntity) {
        final Registration registration = new Registration();

        registration.setServiceName(registrationEntity.getServiceName());
        registration.setMonitoringEnabled(registrationEntity.isMonitoringEnabled());

        return registration;
    }
}
