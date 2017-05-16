package br.com.traco.model;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Data;

@Entity
@Data
@Named
public class Empresa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@CNPJ
@Column(unique=true)
	private String cnpj;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String tel;
	
	
}
