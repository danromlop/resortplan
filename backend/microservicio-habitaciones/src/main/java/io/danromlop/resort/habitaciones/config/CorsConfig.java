package io.danromlop.resort.habitaciones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
	
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // Permitir credenciales (cookies, auth headers)
        config.addAllowedOriginPattern("*"); // Permitir todos los orígenes (en desarrollo)
        config.addAllowedHeader("*"); // Permitir todos los encabezados
        config.addAllowedMethod("*"); // Permitir todos los métodos HTTP (GET, POST, etc.)
        
        // Si prefieres especificar solo ciertos orígenes (más seguro)
        // config.addAllowedOrigin("http://localhost:4200"); // Solo Angular local

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Aplicar a todas las rutas
        
        return new CorsFilter(source);
    }

}
