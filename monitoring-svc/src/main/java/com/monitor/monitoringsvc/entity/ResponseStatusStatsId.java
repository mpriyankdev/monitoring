package com.monitor.monitoringsvc.entity;

import lombok.*;

import java.io.Serializable;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class ResponseStatusStatsId implements Serializable {

    private String serviceName;
    private Integer statusCode;
}
