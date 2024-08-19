package org.gabrielbarrilli.financeiro.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.model.Empresa;
import org.gabrielbarrilli.financeiro.model.dto.request.EmpresaRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.EmpresaResponse;
import org.gabrielbarrilli.financeiro.repository.EmpresaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class EmpresaMapper {

    private static EmpresaRepository empresaRepository;

    public EmpresaMapper(
            EmpresaRepository empresaRepository
    ) {
        EmpresaMapper.empresaRepository = empresaRepository;
    }

    public static EmpresaResponse toResponse(Empresa empresa) {

        return new EmpresaResponse(
                empresa.getId(),
                empresa.getEmpresaName(),
                empresa.getEmpresaCnpj()
        );
    }

    public static Empresa toEntity(EmpresaRequest empresaRequest) {
        Empresa empresa = new Empresa();

        empresa.setEmpresaName(empresaRequest.empresaName());
        empresa.setEmpresaCnpj(empresaRequest.empresaCnpj());

        return empresa;
    }

    public static Empresa toEntityUpdate(Long id, EmpresaRequest empresaRequest) {
        var empresa = empresaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Empresa não encontrada pelo id: " + id)
        );

        empresa.setEmpresaName(empresaRequest.empresaName());
        empresa.setEmpresaCnpj(empresaRequest.empresaCnpj());

        return empresa;
    }

    public static List<EmpresaResponse> toResponseList(List<Empresa> cempresaList) {
        return cempresaList.stream()
                .map(EmpresaMapper::toResponse)
                .collect(Collectors.toList());
    }
}
