package br.com.traco.model;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Named
@Entity
@Data
public class Fornecedor {

	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String endereco;
	@NotEmpty
	private String tel;

}
