package com.monitor.monitoringsvc.config;

import com.monitor.monitoringsvc.filter.ResponsePostFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {


    @Bean
    public ResponsePostFilter responsePostFilter() {
        return new ResponsePostFilter();
    }
}
