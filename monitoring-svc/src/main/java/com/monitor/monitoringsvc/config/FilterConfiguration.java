package com.monitor.monitoringsvc.config;

import com.monitor.monitoringsvc.filter.RequestPreFilter;
import com.monitor.monitoringsvc.filter.ResponsePostFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public RequestPreFilter requestPreFilter() {
        return new RequestPreFilter();
    }

    @Bean
    public ResponsePostFilter responsePostFilter() {
        return new ResponsePostFilter();
    }
}
