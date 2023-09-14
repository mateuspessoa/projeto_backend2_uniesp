package com.mateus.aluguel.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.aluguel.entity.Funcionario;
import com.mateus.aluguel.repository.FuncionarioRepository;


@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> buscarTodos(){
		return funcionarioRepository.findAll();
	}
	
	public List<Funcionario> buscarFuncionariosFerias(){
		return funcionarioRepository.buscarFuncionariosFerias();
	}
	
	public List<Funcionario> buscarFuncionariosAtestado(){
		return funcionarioRepository.buscarFuncionariosAtestado();
	}
	
	public List<Funcionario> buscarFuncionariosRegulares(){
		return funcionarioRepository.buscarFuncionariosRegulares();
	}
	
	public Funcionario inserir(Funcionario funcionario) {
		funcionario.setDataCadastro(new Date());
		funcionario.setStatus("Regular");
		return funcionarioRepository.saveAndFlush(funcionario);
	}
	
	public Funcionario alterar(Funcionario funcionario) {
		funcionario.setDataCadastro(new Date());
		funcionario.setStatus("Regular");
		return funcionarioRepository.saveAndFlush(funcionario);
	}
	
	public void colocarFerias(Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id).get();
		funcionario.setStatus("Férias");
		funcionarioRepository.saveAndFlush(funcionario);
	}
	
	public void colocarAtestado(Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id).get();
		funcionario.setStatus("Atestado");
		funcionarioRepository.saveAndFlush(funcionario);
	}
	
	public void deixarRegular(Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id).get();
		funcionario.setStatus("Regular");
		funcionarioRepository.saveAndFlush(funcionario);
	}
	
	public void demitir(Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id).get();
		funcionario.setStatus("Demitido");
		funcionarioRepository.saveAndFlush(funcionario);
	}
	
	public void excluir(Long id) {
		try {
			Funcionario funcionario = funcionarioRepository.findById(id).get();
			funcionarioRepository.delete(funcionario);
		} catch (Exception e) {
			throw new RuntimeException("Existem aluguéis com esse funcionário");
		}
	}

}
