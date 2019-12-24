package com.monitor.monitoringsvc.filter;

import com.monitor.monitoringsvc.mapper.ResponseStatusStatsMapper;
import com.monitor.monitoringsvc.service.ResponseStatusStatsService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

public class ResponsePostFilter extends ZuulFilter {

    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ResponseStatusStatsService responseStatusStatsService;
    @Autowired
    private ResponseStatusStatsMapper responseStatusStatsMapper;

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

        System.out.println("\n\n[PRIYANK]ResponsePostFilter invoked\n\n");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        final String servletPath = request.getServletPath();
        final int responseStatusCode = context.getResponseStatusCode();

        System.out.println("SERVLET-PATH : "+servletPath);
        System.out.println("RESPONSE-STATUS : "+responseStatusCode);

        zuulProperties.getRoutes().forEach((k, v) -> {

            if (servletPath.startsWith(v.getPath().replace("/**", "/"))) {
                System.out.println("KEY : " + k + " VALUE : " + v);

                responseStatusStatsService.saveResponseStats(responseStatusStatsMapper.map(k, responseStatusCode));
            }


        });


        return null;
    }
}
