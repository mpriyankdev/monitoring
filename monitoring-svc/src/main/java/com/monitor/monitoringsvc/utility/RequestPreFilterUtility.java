package com.monitor.monitoringsvc.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RequestPreFilterUtility {

    @Autowired
    private ZuulProperties zuulProperties;


    public void testZuulProperties(){
        final Map<String, ZuulProperties.ZuulRoute> routes = this.zuulProperties.getRoutes();
    }

}
