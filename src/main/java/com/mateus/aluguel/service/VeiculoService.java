package com.mateus.aluguel.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.aluguel.entity.Veiculo;
import com.mateus.aluguel.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public List<Veiculo> buscarTodos(){
		return veiculoRepository.findAll();
	}
	
	public List<Veiculo> buscarVeiculosDisponiveis(){
		return veiculoRepository.buscarVeiculosDisponiveis();
	}
	
	public List<Veiculo> buscarVeiculosIndisponiveis(){
		return veiculoRepository.buscarVeiculosIndisponiveis();
	}
	
	public List<Veiculo> buscarVeiculosManutencao(){
		return veiculoRepository.buscarVeiculosManutencao();
	}
	
	public Optional<Veiculo> buscarVeiculoPorId(Long id) {
		return veiculoRepository.findById(id);
	}
	
	public Veiculo inserir(Veiculo veiculo) {
		veiculo.setDataCadastro(new Date());
		veiculo.setStatus("Disponível");
		return veiculoRepository.saveAndFlush(veiculo);
	}
	
	public Veiculo alterar(Veiculo veiculo) {
		veiculo.setDataCadastro(new Date());
		veiculo.setStatus("Disponível");
		return veiculoRepository.saveAndFlush(veiculo);
	}
	
	public void tornarDisponível(Long id) {
		Veiculo veiculo = veiculoRepository.findById(id).get();
		veiculo.setStatus("Disponível");
		veiculoRepository.saveAndFlush(veiculo);
	}
	
	public void tornarIndisponível(Long id) {
		Veiculo veiculo = veiculoRepository.findById(id).get();
		veiculo.setStatus("Indisponível");
		veiculoRepository.saveAndFlush(veiculo);
	}
	
	public void colocarManutencao(Long id) {
		Veiculo veiculo = veiculoRepository.findById(id).get();
		veiculo.setStatus("Manutenção");
		veiculoRepository.saveAndFlush(veiculo);
	}
	
	public void RemoverDaFrota(Long id) {
		Veiculo veiculo = veiculoRepository.findById(id).get();
		veiculo.setStatus("Removido da Frota");
		veiculoRepository.saveAndFlush(veiculo);
	}
	
	public void excluir(Long id) {
		try {
			Veiculo veiculo = veiculoRepository.findById(id).get();
			veiculoRepository.delete(veiculo);
		} catch (Exception e) {
			throw new RuntimeException("Existem aluguéis com esse veículo");
		}
	}

}
