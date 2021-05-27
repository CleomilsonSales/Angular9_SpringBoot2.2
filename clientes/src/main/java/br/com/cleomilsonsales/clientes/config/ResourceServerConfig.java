package br.com.cleomilsonsales.clientes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    //classe da segurança oauth2

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //configurações do resource (API) dando acesso as API por role
        http
            .authorizeRequests()
            .antMatchers("/api/usuarios").permitAll()
                //.antMatchers("/api/clientes/**").hasAnyRole("USER","ADMIN") //nesse caso a api clientes so pode ser acessada pelos USER
                .antMatchers(
                        "/api/clientes/**",
                        "/api/servicos-prestados/**").authenticated() //nesse caso quem estiver autentificado pode acessar

                .anyRequest().denyAll(); //qualquer outra requisição sera negada

    }
}
