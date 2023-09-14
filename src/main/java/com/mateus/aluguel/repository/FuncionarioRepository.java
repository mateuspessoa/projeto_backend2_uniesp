package com.mateus.aluguel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mateus.aluguel.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	@Query("select s from Funcionario s where s.status = 'Ferias'")
	List<Funcionario> buscarFuncionariosFerias();
	
	@Query("select s from Funcionario s where s.status = 'Atestado'")
	List<Funcionario> buscarFuncionariosAtestado();
	
	@Query("select s from Funcionario s where s.status = 'Regular'")
	List<Funcionario> buscarFuncionariosRegulares();

}
