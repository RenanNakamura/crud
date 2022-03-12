package com.br.crud.command.domain.desenvolvedor.usecase;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PRIVATE;

import java.util.UUID;

import javax.validation.Valid;

import com.br.crud.command.domain.desenvolvedor.model.Desenvolvedor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

public interface ExcluirDesenvolvedorUseCase {

    void handle(@Valid ExcluirDesenvolvedor cmd);

    void on(DesenvolvedorExcluido event);

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    class ExcluirDesenvolvedor {

        @JsonIgnore
        UUID id;

        public static ExcluirDesenvolvedor from(UUID id) {
            return ExcluirDesenvolvedor.builder()
                .id(requireNonNull(id))
                .build();
        }
    }

    @Value
    @Builder(access = PRIVATE)
    class DesenvolvedorExcluido {

        UUID id;

        public static DesenvolvedorExcluido from(Desenvolvedor desenvolvedor) {
            return DesenvolvedorExcluido.builder()
                .id(desenvolvedor.getId())
                .build();
        }
    }
}
