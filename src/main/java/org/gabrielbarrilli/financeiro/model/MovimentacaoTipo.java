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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movimentacaotipo")
@EntityListeners(AuditingEntityListener.class)
public class MovimentacaoTipo {

    @Id
    @Column(name = "movimentacaotipo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movimentacaotipo_name")
    private String movimentacaoTipoName;

    @CreatedDate
    @Column(name = "movimentacaotipo_created_at")
    private LocalDateTime movimentacaoTipoCreatedAt;

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
