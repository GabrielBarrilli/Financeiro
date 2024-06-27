package org.gabrielbarrilli.financeiro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @Column(name = "id_fornecedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_fornecedor")
    private String nome;

    @Column(name = "contato_fornecedor")
    private String contato;
}
