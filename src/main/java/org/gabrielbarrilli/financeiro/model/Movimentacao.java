package org.gabrielbarrilli.financeiro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movimentacao")
public class Movimentacao {

    @Id
    @Column(name = "movimentacao_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movimentacao_valor")
    private Double movimentacaoValor;

    @JoinColumn(name = "movimentacao_movimentacaocategoria_id")
    @OneToOne
    private MovimentacaoCategoria movimentacaoCategoriaId;

    @JoinColumn(name = "movimentacao_movimentacaotipo_id")
    @OneToOne
    private MovimentacaoTipo movimentacaoTipoId;

    @JoinColumn(name = "movimentacao_conta_id")
    @OneToOne
    private MovimentacaoCategoria movimentacaoContaId;

    @JoinColumn(name = "movimentacao_colaborador_id")
    @OneToOne
    private Colaborador movimentacaoColaboradorId;

    @CreatedDate
    @Column(name = "movimentacao_created_at")
    private LocalDateTime movimentacaoCreatedAt;

    @LastModifiedDate
    @Column(name = "movimentacaotipo_updated_at")
    private LocalDateTime movimentacaoTipoUpdatedAt;

    @CreatedBy
    @Column(name = "movimentacaotipo_created_by")
    private String movimentacaoTipoCreatedBy;

    @LastModifiedBy
    @Column(name = "movimentacaotipo_updated_by")
    private String movimentacaoTipoUpdatedBy;
}
