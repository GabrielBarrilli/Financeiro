package org.gabrielbarrilli.financeiro.controller;

import org.gabrielbarrilli.financeiro.mapper.ContaMapper;
import org.gabrielbarrilli.financeiro.model.dto.request.ContaRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.ContaResponse;
import org.gabrielbarrilli.financeiro.service.ContaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public ContaResponse createConta(@RequestBody ContaRequest contaRequest) {
        return ContaMapper.toResponse(contaService.createConta(contaRequest));
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<ContaResponse> getAllContas() {
        return ContaMapper.toResponseList(contaService.getAllConta());
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public ContaResponse getContaById(@PathVariable Long id) {
        return ContaMapper.toResponse(contaService.getContaById(id));
    }

    @ResponseStatus(ACCEPTED)
    @PutMapping("/{id}")
    public ContaResponse updateConta(@PathVariable Long id, ContaRequest contaRequest) {
        return ContaMapper.toResponse(contaService.updateConta(id, contaRequest));
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public String deleteConta(@PathVariable Long id) {
        contaService.deleteConta(id);

        return "Conta removida com sucesso!";
    }
}
