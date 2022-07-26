package com.crja.backend.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @OneToMany(mappedBy = "departamento")
    private Set<Pessoa> pessoas = new HashSet<>();

    @OneToMany(mappedBy = "departamento")
    private Set<Tarefa> tarefas = new HashSet<>();


    public Departamento() {
    }

    public Departamento(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
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

    public Set<Pessoa> getPessoas() {
        return pessoas;
    }

    public Set<Tarefa> getTarefas() {
        return tarefas;
    }
}
