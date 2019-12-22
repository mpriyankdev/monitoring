package com.monitor.monitoringsvc.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "CAT1_SVC_STATUS")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class MonitoredSvcStatusEntity {

    @Id
    @Column(name = "SERVICE_NAME")
    private String serviceName;
    @Column(name = "SERVICE_STATUS")
    private String serviceStatus;
    @Column(name = "CREATED_TS")
    private LocalDateTime createdTs;
    @Column(name = "LAST_POLL_TIME")
    private LocalDateTime lastPollTime;
    @Column(name = "SERVICE_UP_TIME")
    private Long serviceUpTime;
    @Column(name = "SERVICE_DOWN_TIME")
    private Long serviceDownTime;


}
