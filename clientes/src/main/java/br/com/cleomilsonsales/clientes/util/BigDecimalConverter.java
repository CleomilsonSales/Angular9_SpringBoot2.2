package br.com.cleomilsonsales.clientes.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConverter {
    public BigDecimal converter(String value){
        if(value == null){ //para evitar uma execeção
            return null;
        }

        value = value
                .replace(".", "")
                .replace(",",".");
        return new BigDecimal(value);
    }
}
