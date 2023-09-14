package com.mateus.aluguel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.aluguel.entity.Funcionario;
import com.mateus.aluguel.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/")
	@CrossOrigin("http://127.0.0.1:5173")
	public List<Funcionario> buscarTodos(){
		return funcionarioService.buscarTodos();
	}
	
	@GetMapping("/ferias")
	@CrossOrigin("http://127.0.0.1:5173")
	public List<Funcionario> buscarFuncionariosFerias(){
		return funcionarioService.buscarFuncionariosFerias();
	}
	
	@GetMapping("/atestado")
	@CrossOrigin("http://127.0.0.1:5173")
	public List<Funcionario> buscarFuncionariosAtestado(){
		return funcionarioService.buscarFuncionariosAtestado();
	}
	
	@GetMapping("/regular")
	@CrossOrigin("http://127.0.0.1:5173")
	public List<Funcionario> buscarFuncionariosRegulares(){
		return funcionarioService.buscarFuncionariosRegulares();
	}

	
	@PostMapping("/")
	@CrossOrigin("http://127.0.0.1:5173")
	public Funcionario inserir(@RequestBody Funcionario funcionario) {
		return funcionarioService.inserir(funcionario);
	}
	
	@PutMapping("/")
	@CrossOrigin("http://127.0.0.1:5173")
	public Funcionario alterar(@RequestBody Funcionario funcionario) {
		return funcionarioService.alterar(funcionario);
	}
	
	@PostMapping("/ferias/{id}")
	@CrossOrigin("http://127.0.0.1:5173")
	public ResponseEntity<Void> colocarFerias(@PathVariable("id") Long id) {
		funcionarioService.colocarFerias(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/atestado/{id}")
	@CrossOrigin("http://127.0.0.1:5173")
	public ResponseEntity<Void> colocarAtestado(@PathVariable("id") Long id) {
		funcionarioService.colocarAtestado(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/regular/{id}")
	@CrossOrigin("http://127.0.0.1:5173")
	public ResponseEntity<Void> deixarRegular(@PathVariable("id") Long id) {
		funcionarioService.deixarRegular(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/demitido/{id}")
	@CrossOrigin("http://127.0.0.1:5173")
	public ResponseEntity<Void> Demitir(@PathVariable("id") Long id) {
		funcionarioService.demitir(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin("http://127.0.0.1:5173")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		try {
			funcionarioService.excluir(id);
			return ResponseEntity.ok().build();
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
