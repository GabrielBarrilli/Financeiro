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
@Table(name = "conta")
@EntityListeners(AuditingEntityListener.class)
public class Conta {

    @Id
    @Column(name = "conta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conta_name")
    private String contaName;

    @Column(name = "conta_ag")
    private String contaAg;

    @Column(name = "conta_numero")
    private String contaNumero;

    @Column(name = "conta_saldo")
    private Double contaSaldo;

    @JoinColumn(name = "conta_empresa_id")
    @ManyToOne
    private Empresa contaEmpresaId;

    @JoinColumn(name = "conta_banco_id")
    @OneToOne
    private Banco contaBancoId;

    @CreatedDate
    @Column(name = "conta_created_at")
    private LocalDateTime contaCreatedAt;

    @LastModifiedDate
    @Column(name = "conta_updated_at")
    private LocalDateTime contaUpdatedAt;

    @CreatedBy
    @Column(name = "conta_created_by")
    private String contaCreatedBy;

    @LastModifiedBy
    @Column(name = "conta_updated_by")
    private String contaUpdatedBy;
}
