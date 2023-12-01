package com.mateus.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.aluguel.entity.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	Pessoa findByEmail(String email);
	
	Pessoa findByEmailAndCodigoRecuperacaoSenha(String email, String codigoRecuperacaoSenha);

}
