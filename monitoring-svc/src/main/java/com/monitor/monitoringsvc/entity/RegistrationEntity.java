package com.monitor.monitoringsvc.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

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
    @Column(name = "EFFECTIVE_DATE")
    private LocalDateTime effectiveDate;
    @Column(name = "EXPIRATION_DATE")
    private LocalDateTime expirationDate;
    
}
