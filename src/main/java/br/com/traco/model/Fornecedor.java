package br.com.traco.model;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Named
@Entity
@Data
public class Fornecedor {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="seq_fornecedor")
	@SequenceGenerator(name="seq_fornecedor", sequenceName="seq_fornecedor" , initialValue=0)
	private Long id;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String endereco;
	@NotEmpty
	private String tel;

}
