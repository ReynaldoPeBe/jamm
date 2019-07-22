package com.core.jamm.app.jamm;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MvcConfig
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /*
    Para agregar recursos estaticos, ahora agregaremos direccion para uploads 
    para cargado de fotos fuera del proyecto.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        // esto debe ir en (para mostrar uploads)  th:src="@{'/uploads/' + ${persona.foto}}">
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:/D:/Temp/uploads/");
    }

}