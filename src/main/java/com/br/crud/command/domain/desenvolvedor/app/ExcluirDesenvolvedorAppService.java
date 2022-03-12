package com.br.crud.command.domain.desenvolvedor.app;

import javax.validation.Valid;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.br.crud.command.domain.desenvolvedor.repository.DesenvolvedorRepository;
import com.br.crud.command.domain.desenvolvedor.usecase.ExcluirDesenvolvedorUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor

@Validated
@Transactional
@Service
public class ExcluirDesenvolvedorAppService implements ExcluirDesenvolvedorUseCase {

    private final DesenvolvedorRepository repository;

    @Override
    public void handle(@Valid ExcluirDesenvolvedor cmd) {
        var desenvolvedor = this.repository.get(cmd.getId());
        this.repository.deleteById(desenvolvedor.getId());
        this.on(DesenvolvedorExcluido.from(desenvolvedor));
    }

    @EventListener
    @Override
    public void on(DesenvolvedorExcluido event) {
        System.out.printf("Desenvolvedor %s excluído!", event.getId());
    }

}
