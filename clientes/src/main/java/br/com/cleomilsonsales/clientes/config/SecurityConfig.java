package br.com.cleomilsonsales.clientes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
//@EnableResourceServer //recurso em memoria so para testar
//@EnableAuthorizationServer //recurso em memoria so para testar
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //classe da segurança oauth2

//testando serviço de segurança oauth2 com o postman - pegando o token
//http://localhost:8080/oauth/token
//usa o Basic Auth passando os codigo do run do springboot
//depois vai em Body e em x-www-form-urlencode
//passa o
// username: user
//password dbadd254-c0fd-4636-9d32-22b34f27f20b (esta no console de run do spring
//grant_type = password

//depois que pegou o token é so ir no teste do webservice e pass o bearer token e dar send no json


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Teste com usuario fixo em memoria
        auth.inMemoryAuthentication()
            .withUser("teste")
            .password("123")
            .roles("USER");
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //configurações da web
        http
            .csrf().disable() //essa opção é para aplicação web diretamente dentro do spring
            .cors()
        .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //pra não guardar sessão, será usado nesse caso o token

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance(); //não faz criptografia
    }

}
