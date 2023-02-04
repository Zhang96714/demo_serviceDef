package com.example.service;

import java.util.ServiceLoader;

public class Service {

    public void invoke(){
        ServiceProvider serviceProvider=provider();
        if(serviceProvider == null){
            System.out.println("no service found.");
            return;
        }
        serviceProvider.doSomeThings();
    }

    private ServiceProvider provider(){
        ServiceLoader<ServiceProvider> serviceLoader=ServiceLoader.load(ServiceProvider.class);
        for (ServiceProvider serviceProvider : serviceLoader) {
            return serviceProvider;
        }
        return null;
    }
}
