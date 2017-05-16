package br.com.traco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Colaborador {

	
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private Long idade;
	private String endereco;
	private String bairro;
	private String cidade;
	private String tel;
	private String especialidade;


}

