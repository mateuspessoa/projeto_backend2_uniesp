package com.mateus.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.aluguel.entity.Pessoa;


public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {

}
