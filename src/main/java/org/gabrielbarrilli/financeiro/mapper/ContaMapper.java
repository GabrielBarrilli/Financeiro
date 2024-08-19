package org.gabrielbarrilli.financeiro.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.gabrielbarrilli.financeiro.model.Banco;
import org.gabrielbarrilli.financeiro.model.Conta;
import org.gabrielbarrilli.financeiro.model.dto.request.BancoRequest;
import org.gabrielbarrilli.financeiro.model.dto.request.ContaRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.BancoResponse;
import org.gabrielbarrilli.financeiro.model.dto.response.ContaResponse;
import org.gabrielbarrilli.financeiro.model.dto.response.EmpresaResponse;
import org.gabrielbarrilli.financeiro.repository.BancoRepository;
import org.gabrielbarrilli.financeiro.repository.ContaRepository;
import org.gabrielbarrilli.financeiro.repository.EmpresaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ContaMapper {

    private static ContaRepository contaRepository;
    private static EmpresaRepository empresaRepository;
    private static BancoRepository bancoRepository;

    public ContaMapper(
            ContaRepository contaRepository,
            EmpresaRepository empresaRepository,
            BancoRepository bancoRepository
    ) {
        ContaMapper.contaRepository = contaRepository;
        ContaMapper.empresaRepository = empresaRepository;
        ContaMapper.bancoRepository = bancoRepository;
    }

    public static ContaResponse toResponse(Conta conta) {

        return new ContaResponse(
                conta.getId(),
                conta.getContaName(),
                conta.getContaAg(),
                conta.getContaNumero(),
                conta.getContaSaldo(),
                conta.getContaEmpresaId().getId(),
                conta.getContaBancoId().getId()
        );
    }

    public static Conta toEntity(ContaRequest contaRequest) {
        Conta conta = new Conta();

        return getConta(contaRequest, conta);
    }

    public static Conta toEntityUpdate(Long id, ContaRequest contaRequest) {
        var conta =  contaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Conta não encontrada pelo id: " + id)
        );

        return getConta(contaRequest, conta);
    }

    private static Conta getConta(ContaRequest contaRequest, Conta conta) {
        var empresa = empresaRepository.findById(contaRequest.contaEmpresaId()).orElseThrow(
                () -> new EntityNotFoundException("Empresa não encontrada pelo id: " + contaRequest.contaEmpresaId())
        );

        var banco = bancoRepository.findById(contaRequest.contaBancoId()).orElseThrow(
                () -> new EntityNotFoundException("Banco não encontrado pelo id: " + contaRequest.contaBancoId())
        );

        conta.setContaName(contaRequest.contaName());
        conta.setContaAg(contaRequest.contaAg());
        conta.setContaNumero(contaRequest.contaNumero());
        conta.setContaSaldo(contaRequest.contaSaldo());
        conta.setContaEmpresaId(empresa);
        conta.setContaBancoId(banco);

        return conta;
    }

    public static List<ContaResponse> toResponseList(List<Conta> contaList) {
        return contaList.stream()
                .map(ContaMapper::toResponse)
                .collect(Collectors.toList());
    }
}
