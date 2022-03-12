package com.br.crud.command.domain.nivel.app;

import javax.validation.Valid;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.br.crud.command.domain.nivel.repository.NivelRepository;
import com.br.crud.command.domain.nivel.usecase.RegistrarNivelUseCase;
import com.br.crud.command.domain.nivel.model.Nivel;

import lombok.AllArgsConstructor;

@AllArgsConstructor

@Validated
@Transactional
@Service
public class RegistrarNivelAppService implements RegistrarNivelUseCase {

    private final NivelRepository repository;

    @Override
    public void handle(@Valid RegistrarNivel cmd) {
        var nivel = Nivel.builder()
            .descricao(cmd.getDescricao())
            .build();
        this.repository.save(nivel);
    }

    @EventListener
    @Override
    public void on(NivelRegistrado event) {
        System.out.printf("Nível %s registrado!", event.getId());
    }

}
