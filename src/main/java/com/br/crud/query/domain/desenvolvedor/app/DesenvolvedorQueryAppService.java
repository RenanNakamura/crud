package com.br.crud.query.domain.desenvolvedor.app;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.crud.query.domain.desenvolvedor.model.DesenvolvedorQuery;
import com.br.crud.query.domain.desenvolvedor.model.DesenvolvedorSearch;
import com.br.crud.query.domain.desenvolvedor.repository.DesenvolvedorQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Transactional(readOnly = true)
@Service
public class DesenvolvedorQueryAppService {

    private final DesenvolvedorQueryRepository repository;

    public List<DesenvolvedorQuery> listar(DesenvolvedorSearch desenvolvedorSearch, Pageable pageable) {
        return this.repository.findAll(desenvolvedorSearch.getExample(), pageable);
    }
}
