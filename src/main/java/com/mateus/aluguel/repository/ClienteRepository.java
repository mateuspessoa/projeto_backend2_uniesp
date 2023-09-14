package com.mateus.aluguel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mateus.aluguel.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("select s from Cliente s where s.status = 'Ativo'")
	List<Cliente> buscarClientesAtivos();
	
	@Query("select s from Cliente s where s.status = 'Inativo'")
	List<Cliente> buscarClientesInativos();

}
