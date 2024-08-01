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
@Table(name = "banco")
public class Banco {

    @Id
    @Column(name = "banco_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "banco_name")
    private String movimentacaoTipoName;

    @CreatedDate
    @Column(name = "banco_created_at")
    private LocalDateTime bancoCreatedAt;

    @LastModifiedDate
    @Column(name = "banco_updated_at")
    private LocalDateTime bancoUpdatedAt;

    @CreatedBy
    @Column(name = "banco_created_by")
    private String bancoCreatedBy;

    @LastModifiedBy
    @Column(name = "banco_updated_by")
    private String bancoUpdatedBy;
}
