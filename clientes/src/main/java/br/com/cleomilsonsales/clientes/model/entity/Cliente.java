package br.com.cleomilsonsales.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
//@Getter@Setter //lombok cria em tempo de execução os getters e setters automaticamente //tem que baixar o pluging do lombok
@Data //lombok criar tudo get, set, toString ...
@NoArgsConstructor //para ter um construtor sem argumentos
@AllArgsConstructor //para ter um contrutor com todos os argumentos;
@Builder //cria um builder de clientes para ficar mais facil a criação do objeto como se fosse um formulario
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{campo.nome.obrigatorio}") //nem nula nem vazia
    private String nome;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(name = "data_cadastro", updatable = false) //updatable - nunca atualiza, mesmo que seja passado algo
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }


}
