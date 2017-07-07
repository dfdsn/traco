package br.com.traco.model;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Data;

@Entity
@Data
@Named
public class Empresa {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="seq_empresa")
	@SequenceGenerator(name="seq_empresa", sequenceName="seq_empresa" , initialValue=1)
	private Long id;
	private String contato;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String tel;
	
	
}
