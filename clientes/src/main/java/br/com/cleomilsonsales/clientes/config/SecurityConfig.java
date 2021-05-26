package br.com.cleomilsonsales.clientes.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableWebSecurity
@EnableResourceServer
@EnableAuthorizationServer
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//testando serviço de segurança oauth2 com o postman - pegando o token
//http://localhost:8080/oauth/token
//usa o Basic Auth passando os codigo do run do springboot
//depois vai em Body e em x-www-form-urlencode
//passa o
// username: user
//password dbadd254-c0fd-4636-9d32-22b34f27f20b (esta no console de run do spring
//grant_type = password

//depois que pegou o token é so ir no teste do webservice e pass o bearer token e dar send no json


}
