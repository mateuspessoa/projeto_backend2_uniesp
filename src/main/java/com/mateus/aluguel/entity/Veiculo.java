package com.mateus.aluguel.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "veiculo")
@Data
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String placa;
	private String ano;
	private int valorDiaria;
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
}
