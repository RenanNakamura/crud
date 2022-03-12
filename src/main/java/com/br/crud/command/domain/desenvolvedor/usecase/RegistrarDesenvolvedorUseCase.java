package com.br.crud.command.domain.desenvolvedor.usecase;

import static lombok.AccessLevel.PRIVATE;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.br.crud.command.domain.desenvolvedor.model.Desenvolvedor;
import com.br.crud.command.domain.desenvolvedor.model.Sexo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

public interface RegistrarDesenvolvedorUseCase {

    void handle(@Valid RegistrarDesenvolvedor cmd);

    void on(DesenvolvedorRegistrado event);

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    class RegistrarDesenvolvedor {

        @NotNull(message = "O nível é obrigatório.")
        UUID nivel;

        @Size(min = 3, max = 180, message = "O nome deve ter no mínimo 3 caracteres e no máximo 180.")
        @NotBlank(message = "O nome é obrigatório.")
        String nome;

        @NotNull(message = "O sexo é obrigatório.")
        Sexo sexo;

        @NotNull(message = "A data de nascimento é obrigatório.")
        LocalDate dataNascimento;

        @Size(max = 200, message = "O hobby deve ter no máximo 200.")
        String hobby;

    }

    @Value
    @Builder(access = PRIVATE)
    class DesenvolvedorRegistrado {

        UUID id;

        public static DesenvolvedorRegistrado from(Desenvolvedor desenvolvedor) {
            return DesenvolvedorRegistrado.builder()
                .id(desenvolvedor.getId())
                .build();
        }
    }
}
