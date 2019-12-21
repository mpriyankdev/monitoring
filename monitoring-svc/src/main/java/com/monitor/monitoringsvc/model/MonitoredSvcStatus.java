package com.monitor.monitoringsvc.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class MonitoredSvcStatus {

    private String serviceName;
    private String serviceStatus;
    private LocalDateTime createdTs;
    private LocalDateTime lastPollTime;
    private Long serviceUpTime;
    private Long serviceDownTime;


}
