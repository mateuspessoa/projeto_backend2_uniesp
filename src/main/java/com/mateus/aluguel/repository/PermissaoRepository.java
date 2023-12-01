package com.mateus.aluguel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.aluguel.entity.Permissao;


public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	
	List<Permissao> findByNome(String Nome);

}
