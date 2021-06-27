package com.stakater.techincal.task.backendapi.controller;

import com.stakater.techincal.task.backendapi.config.BackendApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("backend-api")
public class BackendApiController {
    @Autowired
    private BackendApiConfig backendApiConfig;

    @GetMapping
    public String getBackendEnvironmentName()
    {
        return "Hello " +backendApiConfig.getName();
    }
}
