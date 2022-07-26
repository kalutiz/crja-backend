package com.crja.backend.repositories;

import com.crja.backend.entities.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByNome(String nome);
}
