package br.com.cleomilsonsales;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/*@Configuration
@Profile("development") //dessa forma essa classe so funciona em perfil de desenvolvimento
 */
//com annotation personalizada
@Development
public class Conf {
    @Bean(name = "applicationName")
    public String applicationName(){
        return "Sistema de Vendas";
    }

    //quando o spring iniciar ele procura todos os CommandLineRunner com bean e executa
    @Bean
    public CommandLineRunner executar(){
        return args -> {
          System.out.println("Rodando em desenvolvimento");
        };
    }
}
