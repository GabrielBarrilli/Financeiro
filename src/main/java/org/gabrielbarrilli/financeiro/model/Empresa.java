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
@Table(name = "empresa")
@EntityListeners(AuditingEntityListener.class)
public class Empresa {

    @Id
    @Column(name = "empresa_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "empresa_name")
    private String empresaName;

    @Column(name = "empresa_cnpj")
    private String empresaCnpj;

    @CreatedDate
    @Column(name = "empresa_created_at")
    private LocalDateTime empresaCreatedAt;

    @LastModifiedDate
    @Column(name = "empresa_updated_at")
    private LocalDateTime empresaUpdatedAt;

    @CreatedBy
    @Column(name = "empresa_created_by")
    private String empresaCreatedBy;

    @LastModifiedBy
    @Column(name = "empresa_updated_by")
    private String empresaUpdatedBy;
}
