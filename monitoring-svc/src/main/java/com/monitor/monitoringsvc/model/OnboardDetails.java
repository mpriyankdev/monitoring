package com.monitor.monitoringsvc.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OnboardDetails {

    private String serviceName;
    private String serviceId;
    private String serviceUrl;
    private String serviceContextPath;
    private String applicationProfile;


}
