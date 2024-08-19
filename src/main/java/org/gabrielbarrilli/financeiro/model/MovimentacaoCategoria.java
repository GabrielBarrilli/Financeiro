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
@Table(name = "movimentacaocategoria")
@EntityListeners(AuditingEntityListener.class)
public class MovimentacaoCategoria {

    @Id
    @Column(name = "movimentacaocategoria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movimentacaocategoria_name")
    private String movimentacaoCategoriaName;

    @CreatedDate
    @Column(name = "movimentacaocategoria_created_at")
    private LocalDateTime movimentacaoCategoriaCreatedAt;

    @LastModifiedDate
    @Column(name = "movimentacaocategoria_updated_at")
    private LocalDateTime movimentacaoCategoriaUpdatedAt;

    @CreatedBy
    @Column(name = "movimentacaocategoria_created_by")
    private String movimentacaoCategoriaCreatedBy;

    @LastModifiedBy
    @Column(name = "movimentacaocategoria_updated_by")
    private String movimentacaoCategoriaUpdatedBy;
}
