package com.mateus.aluguel.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.aluguel.entity.Aluguel;
import com.mateus.aluguel.repository.AluguelRepository;


@Service
public class AluguelService {
	
	@Autowired
	private AluguelRepository aluguelRepository;
	
	
	
	public List<Aluguel> buscarTodos(){
		return aluguelRepository.findAll();
	}
	
	public Optional<Aluguel> buscarAluguelPorId(Long id) {
		return aluguelRepository.findById(id);
	}
	
	public List<Aluguel>buscarAlugueisPrazo(){
		return aluguelRepository.buscarAlugueisPrazo();
	}
	
	public List<Aluguel>buscarAlugueisDevolvidos(){
		return aluguelRepository.buscarAlugueisDevolvidos();
	}
	
	public List<Aluguel>buscarAlugueisAtrasados(){
		return aluguelRepository.buscarAlugueisAtrasados();
	}
	
	public Aluguel inserir(Aluguel aluguel) {
		aluguel.setDataCadastro(LocalDate.now());
		aluguel.setStatusPagamento("Pendente");
		aluguel.setStatusDevolucao("Dentro do Prazo");
		return aluguelRepository.saveAndFlush(aluguel);
	}
	
	public Aluguel alterar(Aluguel aluguel) {
		aluguel.setDataCadastro(LocalDate.now());
		if(aluguel.getStatusPagamento() == "Confirmado") {
			aluguel.setStatusPagamento("Confirmado");
		}else {
			aluguel.setStatusPagamento("Pendente");
		}
		aluguel.setStatusDevolucao("Dentro do Prazo");
		return aluguelRepository.saveAndFlush(aluguel);
	}
	
	public void confirmarPagamento(Long id) {
		Aluguel aluguel = aluguelRepository.findById(id).get();
		aluguel.setStatusPagamento("Confirmado");
		aluguelRepository.saveAndFlush(aluguel);
	}
	
	public void confirmarDevolucao(Long id) {
		Aluguel aluguel = aluguelRepository.findById(id).get();
		aluguel.setStatusDevolucao("Devolvido");
		aluguelRepository.saveAndFlush(aluguel);
	}
	
	public void colocarEmAtraso(Long id) {
		Aluguel aluguel = aluguelRepository.findById(id).get();
		aluguel.setStatusDevolucao("Atrasado");
		aluguelRepository.saveAndFlush(aluguel);
	}
	
	public void excluir(Long id) {
		try {
			Aluguel cliente = aluguelRepository.findById(id).get();
			aluguelRepository.delete(cliente);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro");
		}
	}

}
