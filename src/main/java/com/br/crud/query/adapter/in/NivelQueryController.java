package com.br.crud.query.adapter.in;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.crud.query.domain.nivel.app.NivelQueryAppService;
import com.br.crud.query.domain.nivel.model.NivelQuery;
import com.br.crud.query.domain.nivel.model.NivelSearch;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "/api/v1/nivel")
public class NivelQueryController {

    private final NivelQueryAppService service;

    /*
        - Para paginação utilizar os querys params como "page=0&size=3"
        - Para ordenação utilizar os querys params "sort=descricao,desc"
        - Para consultar utilizar os querys params "descricao=Senior"
    */
    @GetMapping
    public List<NivelQuery> listar(NivelSearch nivelSearch, Pageable pageable) {
        return this.service.listar(nivelSearch, pageable);
    }

}
