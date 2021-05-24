package br.com.cleomilsonsales.clientes.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterFilterRegistrationBean(){
        CorsConfiguration corsConfiguration =  new CorsConfiguration();
        List<String> all = Arrays.asList("*");
        corsConfiguration.setAllowedOrigins(all); //estou dizendo que qualquer dominio pode acessa o spring
        corsConfiguration.setAllowedHeaders(all);
        corsConfiguration.setAllowedMethods(all);
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); //novamente digo que qualquer url tem acesso ao serviço

        CorsFilter corsFilter =  new CorsFilter(source);
        FilterRegistrationBean<CorsFilter> filter =  new FilterRegistrationBean<>(corsFilter);
        filter.setOrder(Ordered.HIGHEST_PRECEDENCE); //informaçao alta necessidade desse filtro para servilet sempre carregar ele primeiro

        return filter;

    }

}
