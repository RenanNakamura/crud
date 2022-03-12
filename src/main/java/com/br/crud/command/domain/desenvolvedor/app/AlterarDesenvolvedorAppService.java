package com.br.crud.command.domain.desenvolvedor.app;

import javax.validation.Valid;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.br.crud.command.domain.desenvolvedor.repository.DesenvolvedorRepository;
import com.br.crud.command.domain.desenvolvedor.usecase.AlterarDesenvolvedorUseCase;
import com.br.crud.command.domain.nivel.repository.NivelRepository;
import com.br.crud.command.sk.vo.DataNascimento;

import lombok.AllArgsConstructor;

@AllArgsConstructor

@Validated
@Transactional
@Service
public class AlterarDesenvolvedorAppService implements AlterarDesenvolvedorUseCase {

    private final DesenvolvedorRepository repository;
    private final NivelRepository nivelRepository;

    @Override
    public void handle(@Valid AlterarDesenvolvedor cmd) {
        var desenvolvedor = this.repository.get(cmd.getId());

        desenvolvedor.alterar()
            .nivel(cmd.getNivel())
            .nome(cmd.getNome())
            .sexo(cmd.getSexo())
            .dataNascimento(DataNascimento.from(cmd.getDataNascimento()))
            .hobby(cmd.getHobby())
            .nivelConstraint(nivelRepository::existsById)
            .apply();

        this.repository.save(desenvolvedor);
    }

    @EventListener
    @Override
    public void on(DesenvolvedorAlterado event) {
        System.out.printf("Desenvolvedor %s alterado!", event.getId());
    }

}
