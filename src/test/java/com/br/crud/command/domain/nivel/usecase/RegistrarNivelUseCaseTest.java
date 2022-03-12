package com.br.crud.command.domain.nivel.usecase;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.br.crud.command.domain.nivel.usecase.RegistrarNivelUseCase.RegistrarNivel.RegistrarNivelBuilder;
import com.br.crud.command.sk.constraintValidator.ConstraintAssert;

class RegistrarNivelUseCaseTest {

    @Nested
    class Command {

        private RegistrarNivelBuilder builder;

        @BeforeEach
        void beforeEach() {
            this.builder = RegistrarNivelUseCase.RegistrarNivel.builder()
                .descricao("Senior");
        }

        @Test
        void descricaoNull() {
            var cmd = this.builder.descricao(null).build();
            ConstraintAssert.validate(cmd, NotBlank.class);
        }

        @Test
        void descricaoVazio() {
            var cmd = this.builder.descricao("").build();
            ConstraintAssert.validate(cmd, NotBlank.class);
        }

        @Test
        void descricaoMenorQueTresCaracteres() {
            var cmd = this.builder.descricao("12").build();
            ConstraintAssert.validate(cmd, Size.class);
        }

    }

}
