package com.monitor.monitoringsvc.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ResponseStatusStats {

    private String serviceName;
    private Integer statusCode;
    private Integer statusCount;

}
