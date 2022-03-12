package com.br.crud.command.domain.nivel.usecase;

import static lombok.AccessLevel.PRIVATE;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.br.crud.command.domain.nivel.model.Nivel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

public interface RegistrarNivelUseCase {

    void handle(@Valid RegistrarNivel cmd);

    void on(NivelRegistrado event);

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    class RegistrarNivel {

        @Size(min = 3, max = 120, message = "A descrição deve ter no mínimo 3 caracteres e no máximo 120.")
        @NotBlank(message = "A descrição é obrigatório.")
        String descricao;

    }

    @Value
    @Builder(access = PRIVATE)
    class NivelRegistrado {

        UUID id;

        public static NivelRegistrado from(Nivel nivel) {
            return NivelRegistrado.builder()
                .id(nivel.getId())
                .build();
        }
    }
}
