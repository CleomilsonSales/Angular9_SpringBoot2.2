package br.com.cleomilsonsales.clientes.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServicoPrestadorDTO {
    private String descricao;
    private String preco;
    private String data;
    private Integer idCliente;
}
