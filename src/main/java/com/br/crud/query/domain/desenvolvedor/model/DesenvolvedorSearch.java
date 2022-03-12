package com.br.crud.query.domain.desenvolvedor.model;

import org.springframework.data.domain.Example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DesenvolvedorSearch {

    private final String nome;
    private final String sexo;
    private final Integer idade;

    public Example<DesenvolvedorQuery> getExample() {
        return this.getExampleDefault();
    }

    private Example<DesenvolvedorQuery> getExampleDefault() {
        return Example.of(
            DesenvolvedorQuery.builder()
                .nome(this.nome)
                .sexo(this.sexo)
                .idade(this.idade)
                .build()
        );
    }

}
