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
@Table(name = "colaborador")
public class Colaborador {

    @Id
    @Column(name = "colaborador_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "colaborador_name")
    private String colaboradorName;

    @JoinColumn(name = "colaborador_colaboradortipo_id")
    @OneToOne
    private ColaboradorTipo colaboradorTipoId;

    @CreatedDate
    @Column(name = "colaborador_created_at")
    private LocalDateTime colaboradorCreatedAt;

    @LastModifiedDate
    @Column(name = "colaborador_updated_at")
    private LocalDateTime colaboradorUpdatedAt;

    @CreatedBy
    @Column(name = "colaborador_created_by")
    private String colaboradorCreatedBy;

    @LastModifiedBy
    @Column(name = "colaborador_updated_by")
    private String colaboradorUpdatedBy;
}
