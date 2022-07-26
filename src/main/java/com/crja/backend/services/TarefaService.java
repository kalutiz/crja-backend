package com.crja.backend.services;

import com.crja.backend.dto.TarefaDTO;
import com.crja.backend.entities.Departamento;
import com.crja.backend.entities.Pessoa;
import com.crja.backend.entities.Tarefa;
import com.crja.backend.repositories.PessoaRepository;
import com.crja.backend.repositories.TarefaRepository;
import com.crja.backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private PessoaRepository repositoryPessoa;

    @Transactional(readOnly = true)
    public Page<TarefaDTO> findAllPendentes(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), 3);
        Page<Tarefa> page = repository.findAllPendentes(pageRequest);
        return page.map(x -> new TarefaDTO(x));
    }

    @Transactional(readOnly = true)
    public Page<TarefaDTO> findAll(Pageable pageable) {
        Page<Tarefa> page = repository.findAll(pageable);
        return page.map(x -> new TarefaDTO(x));
    }

    @Transactional
    public TarefaDTO insert(TarefaDTO dto) {
        Tarefa entity = new Tarefa();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new TarefaDTO(entity);
    }

    @Transactional
    public TarefaDTO updatePessoa(Long id, TarefaDTO dto) {

        Tarefa entity = repository.getReferenceById(id);
        Pessoa entityPessoa = repositoryPessoa.getReferenceById(dto.getPessoaId());

        if (entity.getDepartamento() == entityPessoa.getDepartamento()) {
            dtoToPessoa(dto, entity);
            entity = repository.save(entity);
            return new TarefaDTO(entity);
        } else {
            throw new ResourceNotFoundException("Usuário não possui departamento da tarefa");
        }

    }

    private void dtoToPessoa(TarefaDTO dto, Tarefa entity) {
        entity.setPessoaId(dto.getPessoaId());
    }

    private void copyDtoToEntity(TarefaDTO dto, Tarefa entity) {
        Departamento departamento = new Departamento();
        departamento.setId(dto.getDepartamentoId());
        entity.setDepartamento(departamento);

        entity.setTitulo(dto.getTitulo());
        entity.setDescricao(dto.getDescricao());
        entity.setPrazo(dto.getPrazo());
//        entity.setDuracao(dto.getDuracao());
        entity.setFinalizado(dto.getFinalizado());
        entity.setPessoaId(dto.getPessoaId());
    }

    @Transactional
    public TarefaDTO finalizarTarefa(Long id) {
        Tarefa entity = repository.getReferenceById(id);
        if (entity.getFinalizado() == true) {
            throw new ResourceNotFoundException("Tarefa já está finalizada");
        } else {
            entity.setFinalizado(true);
            entity = repository.save(entity);
            return new TarefaDTO(entity);
        }
    }
}
