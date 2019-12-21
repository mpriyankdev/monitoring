package com.monitor.monitoringsvc.utility;

import com.monitor.monitoringsvc.service.MonitoredSvcStatusService;
import com.monitor.monitoringsvc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonitoredSvcStatusUtility {

    @Autowired
    private MonitoredSvcStatusService monitoredSvcStatusService;

    @Autowired
    private RegistrationService registrationService;

    public void checkSvcStatus(){

        //registrationService.findAllRegisteredService().stream().

    }


}
