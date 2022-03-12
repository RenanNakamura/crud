package com.br.crud.command.domain.nivel.repository;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.crud.command.domain.nivel.model.Nivel;

public interface NivelRepository extends JpaRepository<Nivel, UUID> {

    default Nivel get(UUID id) {
        return this.findById(id).orElseThrow(() -> new EntityNotFoundException("Nível não encontrado."));
    }

}
