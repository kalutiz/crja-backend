package com.crja.backend.dto;

import com.crja.backend.entities.Departamento;
import com.crja.backend.entities.Pessoa;
import com.crja.backend.entities.Tarefa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DepartamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String titulo;
    private List<PessoaDTO> pessoas = new ArrayList<>();
    private List<TarefaDTO> tarefas = new ArrayList<>();
    private int qtdTarefas;
    private int qtdPessoas;


    public DepartamentoDTO() {
    }

    public DepartamentoDTO(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public DepartamentoDTO(Departamento entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        pessoas = entity.getPessoas().stream().map(PessoaDTO::new).collect(Collectors.toList());
        tarefas = entity.getTarefas().stream().map(TarefaDTO::new).collect(Collectors.toList());
        qtdPessoas = pessoas.size();
        qtdTarefas = tarefas.size();

    }

    public DepartamentoDTO(Departamento entity, Set<Pessoa> pessoas, Set<Tarefa> tarefas) {
        this(entity);
        pessoas.forEach(cat -> this.pessoas.add(new PessoaDTO(cat)));
        tarefas.forEach(cat -> this.tarefas.add(new TarefaDTO(cat)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<PessoaDTO> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaDTO> pessoas) {
        this.pessoas = pessoas;
    }

    public List<TarefaDTO> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<TarefaDTO> tarefas) {
        this.tarefas = tarefas;
    }
}
