package com.mateus.aluguel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mateus.aluguel.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	@Query("select s from Veiculo s where s.status = 'Disponível'")
	List<Veiculo> buscarVeiculosDisponiveis();
	
	@Query("select s from Veiculo s where s.status = 'Indisponível'")
	List<Veiculo> buscarVeiculosIndisponiveis();
	
	@Query("select s from Veiculo s where s.status = 'Manutenção'")
	List<Veiculo> buscarVeiculosManutencao();

}
