package org.gabrielbarrilli.financeiro.model.dto.response;

public record ColaboradorResponse(
        Long id,
        String colaboradorName,
        Long colaboradorTipoId
) {
}
