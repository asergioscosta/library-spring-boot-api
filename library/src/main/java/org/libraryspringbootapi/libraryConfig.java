package org.libraryspringbootapi;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class libraryConfig {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS");
    }
}
