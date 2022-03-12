package com.br.crud.command.domain.nivel.app;

import javax.validation.Valid;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.br.crud.command.domain.nivel.repository.NivelRepository;
import com.br.crud.command.domain.nivel.usecase.AlterarNivelUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor

@Validated
@Transactional
@Service
public class AlterarNivelAppService implements AlterarNivelUseCase {

    private final NivelRepository repository;

    @Override
    public void handle(@Valid AlterarNivel cmd) {
        var nivel = this.repository.get(cmd.getId());

        nivel.alterar()
            .descricao(cmd.getDescricao())
            .apply();

        this.repository.save(nivel);
    }

    @EventListener
    @Override
    public void on(NivelAlterado event) {
        System.out.printf("Nível %s alterado!", event.getId());
    }

}
