package com.mateus.aluguel.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private String codigoRecuperacaoSenha;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;
	
	private String numeroCartao;
	private String codigoSegurancaCartao;
	private String titularCartao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataValidade;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEnvioCodigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;
	
	@OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@Setter(value = AccessLevel.NONE)
	private List<PermissaoPessoa> permissaoPessoas;
	
	public void setPermissaoPessoas(List<PermissaoPessoa> pp) {
		for(PermissaoPessoa p:pp) {
			p.setPessoa(this);
		}
		this.permissaoPessoas = pp;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return permissaoPessoas;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
