package br.com.cleomilsonsales.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 150)
    private String descricao;
    @ManyToOne //relacionamento de muito serviços para um cliente
    @JoinColumn (name = "id_cliente") //chave estrangeira
    private Cliente cliente;
    @Column
    private BigDecimal valor;
}
