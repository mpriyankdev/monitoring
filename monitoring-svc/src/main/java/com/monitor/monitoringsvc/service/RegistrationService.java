package com.monitor.monitoringsvc.service;

import com.monitor.monitoringsvc.entity.RegistrationEntity;
import com.monitor.monitoringsvc.mapper.RegistrationEntityToRegistrationMapper;
import com.monitor.monitoringsvc.mapper.RegistrationToRegistrationEntityMapper;
import com.monitor.monitoringsvc.model.Registration;
import com.monitor.monitoringsvc.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationToRegistrationEntityMapper registrationToRegistrationEntityMapper;
    @Autowired
    private RegistrationEntityToRegistrationMapper registrationEntityToRegistrationMapper;
    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration registerService(final Registration registration) {
        return registrationEntityToRegistrationMapper.map(registrationRepository.save(registrationToRegistrationEntityMapper.map(registration)));
    }

    public Registration findRegisteredServiceByServiceName(final String serviceName) {

        final Optional<RegistrationEntity> registeredService = registrationRepository.findById(serviceName);
        if (registeredService.isPresent()) {
            return registrationEntityToRegistrationMapper.map(registeredService.get());
        } else {
            throw new RuntimeException("requested service not found");
        }

    }

    public List<Registration> findAllRegisteredService() {
        final List<Registration> registeredEntities = new ArrayList<>();
        registrationRepository.findAll().stream().forEach(x -> {
            registeredEntities.add(registrationEntityToRegistrationMapper.map(x));
        });

        return registeredEntities;
    }

    public void degisterService(final String serviceName) {
        registrationRepository.deleteById(serviceName);
    }

}
