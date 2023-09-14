package com.mateus.aluguel.controller;

import java.util.List;
import java.util.Optional;

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

import com.mateus.aluguel.entity.Veiculo;
import com.mateus.aluguel.service.VeiculoService;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping("/")
	@CrossOrigin("http://127.0.0.1:5173")
	public List<Veiculo> buscarTodos(){
		return veiculoService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	@CrossOrigin("http://127.0.0.1:5173")
	public Optional<Veiculo> buscarVeiculoPorId(@PathVariable("id") Long idVeiculo){
		return veiculoService.buscarVeiculoPorId(idVeiculo);
	}
	
	@GetMapping("/disponiveis")
	@CrossOrigin("http://127.0.0.1:5173")
	public List<Veiculo> buscarVeiculosDisponiveis(){
		return veiculoService.buscarVeiculosDisponiveis();
	}
	
	@GetMapping("/indisponiveis")
	@CrossOrigin("http://127.0.0.1:5173")
	public List<Veiculo> buscarVeiculosIndisponiveis(){
		return veiculoService.buscarVeiculosIndisponiveis();
	}
	
	@GetMapping("/manutencao")
	@CrossOrigin("http://127.0.0.1:5173")
	public List<Veiculo> buscarVeiculosManutencao(){
		return veiculoService.buscarVeiculosManutencao();
	}
	
	@PostMapping("/")
	@CrossOrigin("http://127.0.0.1:5173")
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
		return veiculoService.inserir(veiculo);
	}
	
	@PutMapping("/")
	@CrossOrigin("http://127.0.0.1:5173")
	public Veiculo alterar(@RequestBody Veiculo veiculo) {
		return veiculoService.alterar(veiculo);
	}
	
	@PostMapping("/tornardisponivel/{id}")
	@CrossOrigin("http://127.0.0.1:5173")
	public ResponseEntity<Void> tornarDisponivel(@PathVariable("id") Long id) {
		veiculoService.tornarDisponível(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/tornarindisponivel/{id}")
	@CrossOrigin("http://127.0.0.1:5173")
	public ResponseEntity<Void> tornarIndisponivel(@PathVariable("id") Long id) {
		veiculoService.tornarIndisponível(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/colocarmanutencao/{id}")
	@CrossOrigin("http://127.0.0.1:5173")
	public ResponseEntity<Void> colocarManutencao(@PathVariable("id") Long id) {
		veiculoService.colocarManutencao(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/removerdafrota/{id}")
	@CrossOrigin("http://127.0.0.1:5173")
	public ResponseEntity<Void> removerDaFrota(@PathVariable("id") Long id) {
		veiculoService.RemoverDaFrota(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin("http://127.0.0.1:5173")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		try {
			veiculoService.excluir(id);
			return ResponseEntity.ok().build();
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
