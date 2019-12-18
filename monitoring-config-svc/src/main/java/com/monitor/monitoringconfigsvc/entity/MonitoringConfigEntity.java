package com.monitor.monitoringconfigsvc.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CAT1_MONITOR_CONFIG_PROPERTIES")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MonitoringConfigEntity {

    @Id
    @Column(name = "CONFIG_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String configId;
    @Column(name = "APPLICATION")
    private String application;
    @Column(name = "PROFILE")
    private String profile;
    @Column(name = "LABEL")
    private String label;
    @Column(name = "KEY")
    private String key;
    @Column(name = "VALUE")
    private String value;
}
