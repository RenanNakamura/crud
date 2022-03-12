package com.br.crud.command.domain.nivel.usecase;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PRIVATE;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.br.crud.command.domain.nivel.model.Nivel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

public interface AlterarNivelUseCase {

    void handle(@Valid AlterarNivel cmd);

    void on(NivelAlterado event);

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    class AlterarNivel {

        @JsonIgnore
        UUID id;

        @Size(min = 3, max = 120, message = "A descrição deve ter no mínimo 3 caracteres e no máximo 120.")
        @NotBlank(message = "A descrição é obrigatório.")
        String descricao;

        public AlterarNivel withId(UUID id) {
            return AlterarNivel.builder()
                .id(requireNonNull(id))
                .descricao(descricao)
                .build();
        }
    }

    @Value
    @Builder(access = PRIVATE)
    class NivelAlterado {

        UUID id;

        public static NivelAlterado from(Nivel nivel) {
            return NivelAlterado.builder()
                .id(nivel.getId())
                .build();
        }
    }
}
