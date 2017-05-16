package br.com.traco.model;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
@Named
public class Produto {

	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String dimensoes;
	private Long qto;
	private String qtoMin;
	
//	@OneToMany
//	private Fornecedor fornecedor;
	
	
	
}
