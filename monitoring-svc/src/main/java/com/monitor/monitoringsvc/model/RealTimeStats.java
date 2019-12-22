package com.monitor.monitoringsvc.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RealTimeStats {

    private String serviceName;
    private String serviceCurrentStatus;
    private LocalDateTime serviceStatsStartDate;
    private Long serviceDownTime;
    private Long serviceUpTime;

}
