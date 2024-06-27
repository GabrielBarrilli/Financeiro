package org.gabrielbarrilli.financeiro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transacao_financeira")
public class TransacaoFinanceira {

    @Id
    @Column(name = "id_transacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_transacao")
    private String tipo;

    @Column(name = "data_transacao")
    private LocalDate data;

    @Column(name = "valor_transacao")
    private Double valor;
}
