package br.com.cleomilsonsales;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplication {
    /* usando o bean
    @Autowired
    @Qualifier("applicationName")*/
    //injeção de propriedade - usando chave de configuração
    @Value("${application.name}")
    private String applicationName;

    @GetMapping("/index")
    public String helloWorld(){
        return applicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}