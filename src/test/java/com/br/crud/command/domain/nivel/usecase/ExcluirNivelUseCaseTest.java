package com.br.crud.command.domain.nivel.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.br.crud.command.domain.nivel.usecase.ExcluirNivelUseCase.ExcluirNivel;

public class ExcluirNivelUseCaseTest {

    @Nested
    class Command {

        @Test
        void semId() {
            assertThrows(NullPointerException.class, () -> ExcluirNivel.from(null));
        }
    }
}
