package com.mateus.aluguel.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String cpf;
	private String habilitacao;
	private String estado;
	private String email;
	private String telefone;
	private String status;
	

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;

}
