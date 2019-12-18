package com.monitor.monitoringconfigsvc.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MonitoringConfigModel {

    private String application;
    private String profile;
    private String label;
    private String key;
    private String value;

}
