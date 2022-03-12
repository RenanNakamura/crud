package com.br.crud.query.domain.nivel.app;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.crud.query.domain.nivel.model.NivelQuery;
import com.br.crud.query.domain.nivel.model.NivelSearch;
import com.br.crud.query.domain.nivel.repository.NivelQueryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Transactional(readOnly = true)
@Service
public class NivelQueryAppService {

    private final NivelQueryRepository repository;

    public List<NivelQuery> listar(NivelSearch nivelSearch, Pageable pageable) {
        return this.repository.findAll(nivelSearch.getExample(), pageable);
    }
}
