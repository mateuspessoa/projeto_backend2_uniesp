package com.mateus.aluguel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.aluguel.dto.PessoaClienteRequestDTO;
import com.mateus.aluguel.entity.Pessoa;
import com.mateus.aluguel.service.PessoaClienteService;


@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {
	
	@Autowired
	private PessoaClienteService pessoaClienteService;
	
	@PostMapping("/cadastar")
	public Pessoa inserir(@RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO) {
		return pessoaClienteService.registrar(pessoaClienteRequestDTO);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Pessoa> atualizarDados(@PathVariable("id") Long pessoaId,
			@RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO) {
		Pessoa pessoaAtualizada = pessoaClienteService.atualizarDados(pessoaId, pessoaClienteRequestDTO);
		return ResponseEntity.status(HttpStatus.OK).body(pessoaAtualizada);
	}

}
