package com.crja.backend.services;

import com.crja.backend.dto.PessoaDTO;
import com.crja.backend.dto.TarefaDTO;
import com.crja.backend.entities.Departamento;
import com.crja.backend.entities.Pessoa;
import com.crja.backend.entities.Tarefa;
import com.crja.backend.repositories.PessoaRepository;
import com.crja.backend.repositories.TarefaRepository;
import com.crja.backend.services.exceptions.DataBaseException;
import com.crja.backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private TarefaRepository tarefaRepository;

    @Transactional(readOnly = true)
    public Page<PessoaDTO> findAll(Pageable pageable) {
        Page<Pessoa> page = repository.findAll(pageable);
        return page.map(PessoaDTO::new);
    }

    @Transactional
    public PessoaDTO insert(PessoaDTO dto) {
        Pessoa entity = new Pessoa();
        entity.setNome(dto.getNome());
        entity.setDepartamento(new Departamento(dto.getDepartamentoId(), null));
        entity = repository.save(entity);
        return new PessoaDTO(entity);
    }

    @Transactional
    public PessoaDTO update(Long id, PessoaDTO dto) {

        Pessoa entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PessoaDTO(entity);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("ID não encontrado: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Violação de integridade");
        }
    }

    private void copyDtoToEntity(PessoaDTO dto, Pessoa entity) {
        Departamento departamento = new Departamento();
        departamento.setId(dto.getDepartamentoId());
        entity.setDepartamento(departamento);
        entity.setNome(dto.getNome());
    }

    public Double findbyNameAndPeriod(String nome, LocalDateTime inicio, LocalDateTime fim, Pageable pageable) {

        Pessoa pessoa = repository.findByNome(nome);

        return pessoa.getTarefas().stream()
                .map(TarefaDTO::new)
                .filter(t -> t.getPrazo().isAfter(inicio) && t.getPrazo().isBefore(fim))
                .mapToDouble(TarefaDTO::getDuracao)
                .average()
                .orElse(0.0);

    }
}
