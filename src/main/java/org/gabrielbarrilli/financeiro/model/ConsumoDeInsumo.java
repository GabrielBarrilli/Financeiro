package org.gabrielbarrilli.financeiro.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "consumo_de_insumo")
public class ConsumoDeInsumo {

    @Id
    @Column(name = "id_consumo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantidade_consumo")
    private int quantidade;

    @Column(name = "data_consumo")
    private LocalDate data;

    @OneToOne
    @JoinColumn(name = "fk_insumo_consumo")
    private Insumo idInsumo;
}
