package com.br.crud.command.domain.nivel.usecase;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PRIVATE;

import java.util.UUID;

import javax.validation.Valid;

import com.br.crud.command.domain.nivel.model.Nivel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

public interface ExcluirNivelUseCase {

    void handle(@Valid ExcluirNivel cmd);

    void on(NivelExcluido event);

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    class ExcluirNivel {

        @JsonIgnore
        UUID id;

        public static ExcluirNivel from(UUID id) {
            return ExcluirNivel.builder()
                .id(requireNonNull(id))
                .build();
        }
    }

    @Value
    @Builder(access = PRIVATE)
    class NivelExcluido {

        UUID id;

        public static NivelExcluido from(Nivel nivel) {
            return NivelExcluido.builder()
                .id(nivel.getId())
                .build();
        }
    }
}
