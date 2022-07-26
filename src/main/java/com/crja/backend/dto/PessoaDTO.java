package com.crja.backend.dto;

import com.crja.backend.entities.Pessoa;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Long departamentoId;

    private List<TarefaDTO> tarefas;

    private Double duracaoTotal;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa entity) {
        id = entity.getId();
        nome = entity.getNome();
        departamentoId = entity.getDepartamento().getId();
        tarefas = entity.getTarefas().stream().map(TarefaDTO::new).collect(Collectors.toList());
        duracaoTotal = tarefas.stream().map(TarefaDTO::getDuracao).reduce(0.0, Double::sum);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long DepartamentoId) {
        this.departamentoId = DepartamentoId;
    }

    public List<TarefaDTO> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<TarefaDTO> tarefas) {
        this.tarefas = tarefas;
    }

    public Double getDuracaoTotal() {
        return duracaoTotal;
    }

    public void setDuracaoTotal(Double duracaoTotal) {
        this.duracaoTotal = duracaoTotal;
    }
}
