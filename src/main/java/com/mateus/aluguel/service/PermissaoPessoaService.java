package com.mateus.aluguel.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.aluguel.entity.Permissao;
import com.mateus.aluguel.entity.PermissaoPessoa;
import com.mateus.aluguel.entity.Pessoa;
import com.mateus.aluguel.repository.PermissaoPessoaRepository;
import com.mateus.aluguel.repository.PermissaoRepository;


@Service
public class PermissaoPessoaService {
	
	@Autowired
	private PermissaoPessoaRepository permissaoPessoaRepository;
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
public void vincularPessoaPermissaoCLiente(Pessoa pessoa) {
		
		List<Permissao> listaPermissao = permissaoRepository.findByNome("Cliente");
		if(listaPermissao.size() > 0) {
			PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
			permissaoPessoa.setPessoa(pessoa);
			permissaoPessoa.setPermissao(listaPermissao.get(0));
			permissaoPessoa.setDataCriacao(new Date());
			permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
		}
	}

}
