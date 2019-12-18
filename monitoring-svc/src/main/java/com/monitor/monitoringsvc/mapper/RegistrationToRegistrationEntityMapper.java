package com.monitor.monitoringsvc.mapper;

import com.monitor.monitoringsvc.entity.RegistrationEntity;
import com.monitor.monitoringsvc.model.Registration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RegistrationToRegistrationEntityMapper {

    public RegistrationEntity map(final Registration registration) {
        final RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setServiceName(registration.getServiceName());
        registrationEntity.setMonitoringEnabled(registration.isMonitoringEnabled());
        registrationEntity.setEffectiveDate(LocalDateTime.now());

        return registrationEntity;

    }
}
