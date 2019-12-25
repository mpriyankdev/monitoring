package com.monitor.monitoringsvc.model;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Component
public class Registration {

    private String serviceName;
    private boolean monitoringEnabled;
    private String registrationStatus;
}
