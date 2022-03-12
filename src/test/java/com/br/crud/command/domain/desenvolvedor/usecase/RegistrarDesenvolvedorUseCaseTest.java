package com.br.crud.command.domain.desenvolvedor.usecase;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.br.crud.command.domain.desenvolvedor.model.Sexo;
import com.br.crud.command.domain.desenvolvedor.usecase.RegistrarDesenvolvedorUseCase.RegistrarDesenvolvedor;
import com.br.crud.command.domain.desenvolvedor.usecase.RegistrarDesenvolvedorUseCase.RegistrarDesenvolvedor.RegistrarDesenvolvedorBuilder;
import com.br.crud.command.sk.constraintValidator.ConstraintAssert;
import com.br.crud.command.sk.util.StringUtil;

class RegistrarDesenvolvedorUseCaseTest {

    @Nested
    class Command {

        private RegistrarDesenvolvedorBuilder builder;

        @BeforeEach
        void beforeEach() {
            this.builder = RegistrarDesenvolvedor.builder()
                .nivel(UUID.randomUUID())
                .nome("Renan Junji Nakamura")
                .sexo(Sexo.MASCULINO)
                .dataNascimento(LocalDate.now())
                .hobby("Dançar");
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
