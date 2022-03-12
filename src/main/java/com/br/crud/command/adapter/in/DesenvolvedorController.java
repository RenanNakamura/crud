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

import com.br.crud.command.domain.desenvolvedor.usecase.AlterarDesenvolvedorUseCase;
import com.br.crud.command.domain.desenvolvedor.usecase.AlterarDesenvolvedorUseCase.AlterarDesenvolvedor;
import com.br.crud.command.domain.desenvolvedor.usecase.ExcluirDesenvolvedorUseCase;
import com.br.crud.command.domain.desenvolvedor.usecase.ExcluirDesenvolvedorUseCase.ExcluirDesenvolvedor;
import com.br.crud.command.domain.desenvolvedor.usecase.RegistrarDesenvolvedorUseCase;
import com.br.crud.command.domain.desenvolvedor.usecase.RegistrarDesenvolvedorUseCase.RegistrarDesenvolvedor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping(path = "/api/v1/desenvolvedor")
public class DesenvolvedorController {

    private final RegistrarDesenvolvedorUseCase registrarDesenvolvedorUseCase;
    private final AlterarDesenvolvedorUseCase alterarDesenvolvedorUseCase;
    private final ExcluirDesenvolvedorUseCase excluirDesenvolvedorUseCase;

    @ResponseStatus(CREATED)
    @PostMapping
    public void registrar(@RequestBody RegistrarDesenvolvedor cmd) {
        this.registrarDesenvolvedorUseCase.handle(cmd);
    }

    @PutMapping(path = "/{id}")
    public void alterar(@PathVariable UUID id, @RequestBody AlterarDesenvolvedor cmd) {
        this.alterarDesenvolvedorUseCase.handle(cmd.withId(id));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void excluir(@PathVariable UUID id) {
        this.excluirDesenvolvedorUseCase.handle(ExcluirDesenvolvedor.from(id));
    }

}
