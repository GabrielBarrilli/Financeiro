package org.gabrielbarrilli.financeiro.model.dto;

import java.io.Serializable;

/**
 * DTO for {@link org.gabrielbarrilli.financeiro.model.Banco}
 */
public record BancoRequest(
        String movimentacaoTipoName
) { }