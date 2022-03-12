package com.br.crud.command.domain.nivel.model;

import static java.util.Objects.requireNonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.br.crud.command.domain.nivel.usecase.AlterarNivelUseCase;
import com.br.crud.command.domain.nivel.usecase.RegistrarNivelUseCase;
import com.br.crud.command.sk.AbstractEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

@Entity
@Table
public class Nivel extends AbstractEntity<Nivel> {

    @Column(length = 120)
    private String descricao;

    public static NivelBuilder builder() {
        return new NivelBuilder();
    }

    Nivel(NivelBuilder builder) {
        super.id = requireNonNull(builder.id);
        this.descricao = requireNonNull(builder.descricao);

        registerEvent(RegistrarNivelUseCase.NivelRegistrado.from(this));
    }

    public NivelBuilderUpdate alterar() {
        return new NivelBuilderUpdate(id, form -> {
            descricao = requireNonNull(form.getDescricao());
            registerEvent(AlterarNivelUseCase.NivelAlterado.from(this));
        });
    }

}
