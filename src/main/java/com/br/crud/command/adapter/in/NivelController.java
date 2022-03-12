package com.br.crud.command.adapter.in;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.crud.command.domain.nivel.usecase.AlterarNivelUseCase;
import com.br.crud.command.domain.nivel.usecase.AlterarNivelUseCase.AlterarNivel;
import com.br.crud.command.domain.nivel.usecase.ExcluirNivelUseCase;
import com.br.crud.command.domain.nivel.usecase.ExcluirNivelUseCase.ExcluirNivel;
import com.br.crud.command.domain.nivel.usecase.RegistrarNivelUseCase;
import com.br.crud.command.domain.nivel.usecase.RegistrarNivelUseCase.RegistrarNivel;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "/api/v1/nivel")
public class NivelController {

    private final RegistrarNivelUseCase registrarNivelUseCase;
    private final AlterarNivelUseCase alterarNivelUseCase;
    private final ExcluirNivelUseCase excluirNivelUseCase;

    @ResponseStatus(CREATED)
    @PostMapping
    public void registrar(@RequestBody RegistrarNivel cmd) {
        this.registrarNivelUseCase.handle(cmd);
    }

    @PutMapping(path = "/{id}")
    public void alterar(@PathVariable UUID id, @RequestBody AlterarNivel cmd) {
        this.alterarNivelUseCase.handle(cmd.withId(id));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void excluir(@PathVariable UUID id) {
        this.excluirNivelUseCase.handle(ExcluirNivel.from(id));
    }

}
