package org.gabrielbarrilli.financeiro.controller;

import org.gabrielbarrilli.financeiro.mapper.EmpresaMapper;
import org.gabrielbarrilli.financeiro.model.dto.request.EmpresaRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.EmpresaResponse;
import org.gabrielbarrilli.financeiro.service.EmpresaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public EmpresaResponse createEmpresa(@RequestBody EmpresaRequest empresaRequest) {
        return EmpresaMapper.toResponse(empresaService.createEmpresa(empresaRequest));
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<EmpresaResponse> getAllEmpresa() {
        return EmpresaMapper.toResponseList(empresaService.getAllEmpresa());
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public EmpresaResponse getEmpresaById(@PathVariable Long id) {
        return EmpresaMapper.toResponse(empresaService.getEmpresaById(id));
    }

    @ResponseStatus(ACCEPTED)
    @PutMapping("/{id}")
    public EmpresaResponse updateEmpresa(@PathVariable Long id, @RequestBody EmpresaRequest empresaRequest) {
        return EmpresaMapper.toResponse(empresaService.updateEmpresa(id, empresaRequest));
    }

    @ResponseStatus(OK)
    @DeleteMapping("/{id}")
    public String deleteEmpresa(@PathVariable Long id) {
        empresaService.deleteEmpresa(id);

        return "Empresa deletada com sucesso!";
    }
}
