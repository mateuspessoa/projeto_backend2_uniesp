package com.mateus.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mateus.aluguel.entity.Pessoa;
import com.mateus.aluguel.repository.PessoaRepository;


@Service
public class PessoaDetailService implements UserDetailsService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Pessoa pessoa = pessoaRepository.findByEmail(username);
		if(pessoa == null) {
			throw new UsernameNotFoundException("Usuário não encontrada pelo email");
		}
		return pessoa;
	}

}
