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
@Table(name = "insumo")
public class Insumo {

    @Id
    @Column(name = "id_insumo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_insumo")
    private String nome;

    @Column(name = "preco_de_compra_insumo")
    private Double precoDeCompra;

    @Column(name = "estoque")
    private int estoque;
}
