package com.br.crud.command.domain.desenvolvedor.usecase;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PRIVATE;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.br.crud.command.domain.desenvolvedor.model.Desenvolvedor;
import com.br.crud.command.domain.desenvolvedor.model.Sexo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

public interface AlterarDesenvolvedorUseCase {

    void handle(@Valid AlterarDesenvolvedor cmd);

    void on(DesenvolvedorAlterado event);

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    class AlterarDesenvolvedor {

        @JsonIgnore
        UUID id;

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

        public AlterarDesenvolvedor withId(UUID id) {
            return AlterarDesenvolvedor.builder()
                .id(requireNonNull(id))
                .nivel(nivel)
                .nome(nome)
                .sexo(sexo)
                .dataNascimento(dataNascimento)
                .hobby(hobby)
                .build();
        }
    }

    @Value
    @Builder(access = PRIVATE)
    class DesenvolvedorAlterado {

        UUID id;

        public static DesenvolvedorAlterado from(Desenvolvedor desenvolvedor) {
            return DesenvolvedorAlterado.builder()
                .id(desenvolvedor.getId())
                .build();
        }
    }
}
