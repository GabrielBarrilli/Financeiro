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
@Table(name = "detalhe_da_compra")
public class DetalheDaCompra {

    @Id
    @Column(name = "id_detalhe")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantidade_detalhe")
    private int quantidade;

    @Column(name = "preco_unitario_detalhe")
    private Double precoUnitario;

    @OneToOne
    @JoinColumn(name = "fk_insumo_detalhe")
    private Insumo idInsumo;
}
