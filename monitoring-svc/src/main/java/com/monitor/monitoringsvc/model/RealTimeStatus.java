package com.monitor.monitoringsvc.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RealTimeStatus {

    private String serviceName;
    private String serviceStatus;


}
