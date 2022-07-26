package com.crja.backend.repositories;

import com.crja.backend.entities.Tarefa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query(value = "SELECT t FROM Tarefa t WHERE t.pessoaId is null order by t.prazo asc")
    Page<Tarefa> findAllPendentes(Pageable pageable);
}
