package br.com.remysoncosta.controller;

import br.com.remysoncosta.configuration.ParameterStoreConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ParameterStoreController {

    @Autowired
    private ParameterStoreConfiguration configuration;

    @GetMapping("/parameterStore")
    public String configuration() {
        return configuration.getHelloWorld();
    }

}
