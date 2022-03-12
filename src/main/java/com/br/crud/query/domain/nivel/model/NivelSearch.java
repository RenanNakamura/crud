package com.br.crud.query.domain.nivel.model;

import org.springframework.data.domain.Example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NivelSearch {

    private final String descricao;

    public Example<NivelQuery> getExample() {
        return this.getExampleDefault();
    }

    private Example<NivelQuery> getExampleDefault() {
        return Example.of(
            NivelQuery.builder()
                .descricao(this.descricao)
                .build()
        );
    }

}
