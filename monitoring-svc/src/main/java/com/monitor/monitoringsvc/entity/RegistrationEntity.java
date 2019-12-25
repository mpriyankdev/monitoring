package com.monitor.monitoringsvc.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAT1_SERVICE_REGISTER")
@ToString
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class RegistrationEntity {

    @Id
    @Column(name = "SERVICE_NAME")
    private String serviceName;
    @Column(name = "MONITORING_ENABLED")
    private boolean monitoringEnabled;
    @Column(name = "REGISTRATION_STATUS")
    private String registrationStatus;

}
