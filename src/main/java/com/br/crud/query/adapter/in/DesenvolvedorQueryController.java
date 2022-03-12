package com.br.crud.query.adapter.in;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.crud.query.domain.desenvolvedor.app.DesenvolvedorQueryAppService;
import com.br.crud.query.domain.desenvolvedor.model.DesenvolvedorQuery;
import com.br.crud.query.domain.desenvolvedor.model.DesenvolvedorSearch;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "/api/v1/desenvolvedor")
public class DesenvolvedorQueryController {

    private final DesenvolvedorQueryAppService service;

    /*
        - Para paginação utilizar os querys params como "page=0&size=3"
        - Para ordenação utilizar os querys params "sort=nome,desc"
        - Para consultar utilizar os querys params "nome=Renan"
    */
    @GetMapping
    public List<DesenvolvedorQuery> listar(DesenvolvedorSearch desenvolvedorSearch, Pageable pageable) {
        return this.service.listar(desenvolvedorSearch, pageable);
    }

}
