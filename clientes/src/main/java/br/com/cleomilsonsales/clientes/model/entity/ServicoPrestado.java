package br.com.cleomilsonsales.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class ServicoPrestado {
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

    @Column
    private LocalDate data;
}
