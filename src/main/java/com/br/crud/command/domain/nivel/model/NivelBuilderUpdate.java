package com.br.crud.command.domain.nivel.model;

import static java.util.Objects.requireNonNull;

import java.util.UUID;
import java.util.function.Consumer;

import lombok.Getter;

@Getter
public class NivelBuilderUpdate {

    protected UUID id;
    protected String descricao;

    private final Consumer<NivelBuilderUpdate> action;

    NivelBuilderUpdate(UUID id, Consumer<NivelBuilderUpdate> action) {
        this.id = requireNonNull(id);
        this.action = requireNonNull(action);
    }

    public NivelBuilderUpdate descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public void apply() {
        action.accept(this);
    }

}
