package com.empresa.pfdesarrollo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
public class SoapConfig {

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setDefaultUri("https://www.banguat.gob.gt/variables/ws/TipoCambio.asmx");
        webServiceTemplate.setMessageSender(new HttpComponentsMessageSender());
        return webServiceTemplate;
    }
}
