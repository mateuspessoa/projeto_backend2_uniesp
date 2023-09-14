package com.mateus.aluguel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mateus.aluguel.entity.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
	
	public Optional<Aluguel> findById(Long id);
	
	@Query("select s from Aluguel s where s.statusDevolucao = 'Dentro do Prazo'")
	List<Aluguel> buscarAlugueisPrazo();
	
	@Query("select s from Aluguel s where s.statusDevolucao = 'Devolvido'")
	List<Aluguel> buscarAlugueisDevolvidos();
	
	@Query("select s from Aluguel s where s.statusDevolucao = 'Atrasado'")
	List<Aluguel> buscarAlugueisAtrasados();

}
