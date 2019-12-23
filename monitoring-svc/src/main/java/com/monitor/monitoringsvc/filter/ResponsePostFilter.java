package com.monitor.monitoringsvc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ResponsePostFilter extends ZuulFilter {

    @Autowired
    private ZuulProperties zuulProperties;
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 100;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        zuulProperties.getRoutes().forEach((k,v)-> {
            System.out.println("path after replacing : "+v.getPath().replace("**" , ""));
            //pathToServiceMap.putIfAbsent(v.getPath().replace("**" , "").toString() , k);
        });

        System.out.println("\n\n[PRIYANK]ResponsePostFilter invoked\n\n");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();


        System.out.println("Servlet Path : " + request.getServletPath());

        System.out.println("POSTFILTER : StatusCode" + context.getResponseStatusCode());

        zuulProperties.getRoutes().forEach((k,v)-> {
            System.out.println("KEY : "+k+ " VALUE : "+v);
            System.out.println();



        });



        return null;
    }
}
