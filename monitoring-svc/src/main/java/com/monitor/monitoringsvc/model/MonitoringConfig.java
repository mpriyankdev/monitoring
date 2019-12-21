package com.monitor.monitoringsvc.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class MonitoringConfig {


    private String configId;
    private String application;
    private String profile;
    private String label;
    private String key;
    private String value;


}
