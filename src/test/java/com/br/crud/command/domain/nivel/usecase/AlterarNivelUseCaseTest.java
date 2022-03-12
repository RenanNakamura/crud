package com.br.crud.command.domain.nivel.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.br.crud.command.domain.nivel.usecase.AlterarNivelUseCase.AlterarNivel;
import com.br.crud.command.domain.nivel.usecase.AlterarNivelUseCase.AlterarNivel.AlterarNivelBuilder;
import com.br.crud.command.sk.constraintValidator.ConstraintAssert;

class AlterarNivelUseCaseTest {

    @Nested
    class Command {

        private AlterarNivelBuilder builder;

        @BeforeEach
        void beforeEach() {
            this.builder = AlterarNivel
                .builder()
                .descricao("Senior");
        }

        @Test
        void semId() {
            assertThrows(NullPointerException.class, () -> this.builder.build().withId(null));
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
