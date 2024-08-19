package org.gabrielbarrilli.financeiro.controller;

import org.gabrielbarrilli.financeiro.mapper.ColaboradorMapper;
import org.gabrielbarrilli.financeiro.model.dto.request.ColaboradorRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.ColaboradorResponse;
import org.gabrielbarrilli.financeiro.service.ColaboradorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public ColaboradorResponse createColaborador(@RequestBody ColaboradorRequest colaboradorRequest) {
        return ColaboradorMapper.toResponse(colaboradorService.createColaborador(colaboradorRequest));
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<ColaboradorResponse> getAllColaborador() {
        return ColaboradorMapper.toResponseList(colaboradorService.getAllColaborador());
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public ColaboradorResponse getColaboradorById(@PathVariable Long id) {
        return ColaboradorMapper.toResponse(colaboradorService.getColaboradorById(id));
    }

    @ResponseStatus(ACCEPTED)
    @PutMapping("/{id}")
    public ColaboradorResponse updateColaborador(@PathVariable Long id, @RequestBody ColaboradorRequest colaboradorRequest) {
        return ColaboradorMapper.toResponse(colaboradorService.updateColaborador(id, colaboradorRequest));
    }

    @ResponseStatus(OK)
    @DeleteMapping("/{id}")
    public String deleteColaborador(@PathVariable Long id) {
        colaboradorService.deleteColaborador(id);

        return "Colaborador deletado com sucesso!";
    }
}
