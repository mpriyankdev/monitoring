package com.monitor.monitoringsvc.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "CAT1_SVC_ONBOARD_DETAILS")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class OnboardDetailsEntity implements Serializable {

    @Id
    @Column(name = "SERVICE_NAME")
    private String serviceName;
    @Column(name = "SERVICE_ID")
    private String serviceId;
    @Column(name = "SERVICE_URL")
    private String serviceUrl;
    @Column(name = "SERVICE_CONTEXT_PATH")
    private String serviceContextPath;
    @Column(name = "APP_PROFILE")
    private String applicationProfile;
    @Column(name = "ONBOARD_STATUS")
    private String onboardStatus;
    @Column(name = "ONBOARD_TIME")
    private LocalDateTime onboardTime;

}
