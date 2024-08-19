package org.gabrielbarrilli.financeiro.controller;

import org.gabrielbarrilli.financeiro.mapper.ColaboradorTipoMapper;
import org.gabrielbarrilli.financeiro.model.dto.request.ColaboradorTipoRequest;
import org.gabrielbarrilli.financeiro.model.dto.response.ColaboradorTipoResponse;
import org.gabrielbarrilli.financeiro.service.ColaboradorTipoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/colaboradorTipo")
public class ColaboradorTipoController {

    private final ColaboradorTipoService colaboradorTipoService;

    public ColaboradorTipoController(ColaboradorTipoService colaboradorTipoService) {
        this.colaboradorTipoService = colaboradorTipoService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public ColaboradorTipoResponse createColaboradorTipo(@RequestBody ColaboradorTipoRequest colaboradorTipoRequest) {
        return ColaboradorTipoMapper.toResponse(colaboradorTipoService.createColaboradorTipo(colaboradorTipoRequest));
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<ColaboradorTipoResponse> getAllColaboradorTipos() {
        return ColaboradorTipoMapper.toResponseList(colaboradorTipoService.findAllColaboradorTipo());
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public ColaboradorTipoResponse getColaboradorTipoById(@PathVariable Long id) {
        return ColaboradorTipoMapper.toResponse(colaboradorTipoService.findColaboradorTipoById(id));
    }

    @ResponseStatus(ACCEPTED)
    @PutMapping("/{id}")
    public ColaboradorTipoResponse updateColaboradorTipo(@PathVariable Long id, @RequestBody ColaboradorTipoRequest colaboradorTipoRequest) {
        return ColaboradorTipoMapper.toResponse(colaboradorTipoService.updateColaboradorTipo(id, colaboradorTipoRequest));
    }

    @ResponseStatus(OK)
    @DeleteMapping("{id}")
    public String deleteColaboradorTipo(@PathVariable Long id) {
        colaboradorTipoService.deleteColaboradorTipo(id);

        return "Tipo de colaborador deletado com sucesso!";
    }
}
