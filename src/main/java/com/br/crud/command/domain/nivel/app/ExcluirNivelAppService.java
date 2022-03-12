package com.br.crud.command.domain.nivel.app;

import javax.validation.Valid;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.br.crud.command.domain.nivel.repository.NivelRepository;
import com.br.crud.command.domain.nivel.usecase.ExcluirNivelUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor

@Validated
@Transactional
@Service
public class ExcluirNivelAppService implements ExcluirNivelUseCase {

    private final NivelRepository repository;

    @Override
    public void handle(@Valid ExcluirNivel cmd) {
        var nivel = this.repository.get(cmd.getId());
        this.repository.deleteById(nivel.getId());
        this.on(NivelExcluido.from(nivel));
    }

    @EventListener
    @Override
    public void on(NivelExcluido event) {
        System.out.printf("Nível %s excluído!", event.getId());
    }

}
