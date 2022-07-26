package com.crja.backend.dto;

import com.crja.backend.entities.Tarefa;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

public class TarefaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime prazo;
    private Double duracao;
    private Boolean finalizado;
    private Long departamentoId;
    private Long pessoaId;


    public TarefaDTO() {
    }

    public TarefaDTO(Long id, String titulo, String descricao, LocalDateTime prazo, Double duracao, Boolean finalizado, Long pessoaId, Long departamentoId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.duracao = duracao;
        this.finalizado = finalizado;
        this.pessoaId = pessoaId;
        this.departamentoId = departamentoId;

    }

    public TarefaDTO(Tarefa entity) {
        id = entity.getId();
        titulo = entity.getTitulo();
        descricao = entity.getDescricao();
        prazo = entity.getPrazo();
        duracao = entity.getDuracao();
        finalizado = entity.getFinalizado();
        pessoaId = entity.getPessoaId();
        departamentoId = entity.getDepartamento().getId();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }

    public Double getDuracao() {
        return duracao;
    }

    public void setDuracao(Double duracao) {
        this.duracao = duracao;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }
}
