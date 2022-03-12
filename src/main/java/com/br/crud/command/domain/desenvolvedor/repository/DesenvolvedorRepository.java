package com.br.crud.command.domain.desenvolvedor.repository;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.crud.command.domain.desenvolvedor.model.Desenvolvedor;

public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, UUID> {

    default Desenvolvedor get(UUID id) {
        return this.findById(id).orElseThrow(() -> new EntityNotFoundException("Desenvolvedor não encontrado."));
    }

}
