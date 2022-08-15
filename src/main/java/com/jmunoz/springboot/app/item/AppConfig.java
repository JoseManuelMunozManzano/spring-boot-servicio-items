package com.jmunoz.springboot.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Necesitamos crear componentes de Spring, beans
@Configuration
public class AppConfig {

    // RestTemplate es un cliente HTTP para trabajar con API Rest, para poder acceder a recursos que están en otros
    // microservicios.
    @Bean("clienteRest")
    public RestTemplate registrarRestTemplate() {
        return new RestTemplate();
    }
}
