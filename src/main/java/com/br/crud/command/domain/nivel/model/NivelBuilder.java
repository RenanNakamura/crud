package com.br.crud.command.domain.nivel.model;

import java.util.UUID;

public class NivelBuilder {

    protected UUID id;
    protected String descricao;

    public NivelBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Nivel build() {
        this.id = UUID.randomUUID();
        return new Nivel(this);
    }

}
