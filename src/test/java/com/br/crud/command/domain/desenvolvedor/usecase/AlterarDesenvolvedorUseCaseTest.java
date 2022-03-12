package com.br.crud.command.domain.desenvolvedor.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.br.crud.command.domain.desenvolvedor.model.Sexo;
import com.br.crud.command.domain.desenvolvedor.usecase.AlterarDesenvolvedorUseCase.AlterarDesenvolvedor;
import com.br.crud.command.domain.desenvolvedor.usecase.AlterarDesenvolvedorUseCase.AlterarDesenvolvedor.AlterarDesenvolvedorBuilder;
import com.br.crud.command.sk.constraintValidator.ConstraintAssert;
import com.br.crud.command.sk.util.StringUtil;

class AlterarDesenvolvedorUseCaseTest {

    @Nested
    class Command {

        private AlterarDesenvolvedorBuilder builder;

        @BeforeEach
        void beforeEach() {
            this.builder = AlterarDesenvolvedor.builder()
                .nivel(UUID.randomUUID())
                .nome("Renan Junji Nakamura")
                .sexo(Sexo.MASCULINO)
                .dataNascimento(LocalDate.now())
                .hobby("Dançar");
        }

        @Test
        void semId() {
            assertThrows(NullPointerException.class, () -> this.builder.build().withId(null));
        }

        @Test
        void nivelNull() {
            var cmd = this.builder.nivel(null).build();
            ConstraintAssert.validate(cmd, NotNull.class);
        }

        @Test
        void nomeNull() {
            var cmd = this.builder.nome(null).build();
            ConstraintAssert.validate(cmd, NotBlank.class);
        }

        @Test
        void nomeVazio() {
            var cmd = this.builder.nome("").build();
            ConstraintAssert.validate(cmd, NotBlank.class);
        }

        @Test
        void nomeMenorQueTresCaracteres() {
            var cmd = this.builder.nome("12").build();
            ConstraintAssert.validate(cmd, Size.class);
        }

        @Test
        void sexoNull() {
            var cmd = this.builder.sexo(null).build();
            ConstraintAssert.validate(cmd, NotNull.class);
        }

        @Test
        void dataNascimentoNull() {
            var cmd = this.builder.dataNascimento(null).build();
            ConstraintAssert.validate(cmd, NotNull.class);
        }

        @Test
        void hobbyMaiorQueDuzentosCaracteres() {
            var cmd = this.builder.hobby(StringUtil.STRING_258).build();
            ConstraintAssert.validate(cmd, Size.class);
        }

    }

}
