package com.crja.backend.services;

import com.crja.backend.dto.DepartamentoDTO;
import com.crja.backend.entities.Departamento;
import com.crja.backend.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;

    @Transactional(readOnly = true)
    public Page<DepartamentoDTO> findAllPaged(Pageable pageable) {
        Page<Departamento> list = repository.findAll(pageable);
        return list.map(x -> new DepartamentoDTO(x, x.getPessoas(), x.getTarefas()));
    }
}
