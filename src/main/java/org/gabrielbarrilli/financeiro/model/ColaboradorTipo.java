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
@Table(name = "colaboradortipo")
@EntityListeners(AuditingEntityListener.class)
public class ColaboradorTipo {

    @Id
    @Column(name = "colaboradortipo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "colaboradortipo_name")
    private String colaboradorTipoName;

    @CreatedDate
    @Column(name = "colaboradortipo_created_at")
    private LocalDateTime colaboradorTipoCreatedAt;

    @LastModifiedDate
    @Column(name = "colaboradortipo_updated_at")
    private LocalDateTime colaboradorTipoUpdatedAt;

    @CreatedBy
    @Column(name = "colaboradortipo_created_by")
    private String colaboradorTipoCreatedBy;

    @LastModifiedBy
    @Column(name = "colaboradortipo_updated_by")
    private String colaboradorTipoUpdatedBy;
}
