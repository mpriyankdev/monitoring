package com.monitor.monitoringsvc.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CAT1_RESPONSE_STATS")
@IdClass(ResponseStatusStatsId.class)
@ToString
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class ResponseStatusStatsEntity {

    @Id
    @Column(name = "SERVICE_NAME")
    private String serviceName;
    @Id
    @Column(name = "STATUS_CODE")
    private Integer statusCode;
    @Column(name = "STATUS_COUNT")
    private Integer statusCount;


}
