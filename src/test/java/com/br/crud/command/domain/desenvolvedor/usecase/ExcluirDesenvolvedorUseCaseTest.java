package com.br.crud.command.domain.desenvolvedor.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.br.crud.command.domain.desenvolvedor.usecase.ExcluirDesenvolvedorUseCase.ExcluirDesenvolvedor;

public class ExcluirDesenvolvedorUseCaseTest {

    @Nested
    class Command {

        @Test
        void semId() {
            assertThrows(NullPointerException.class, () -> ExcluirDesenvolvedor.from(null));
        }
    }
}
