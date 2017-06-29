package br.com.traco.model;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
@Named
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="seq_pessoa")
	@SequenceGenerator(name="seq_pessoa", sequenceName="seq_pessoa" , initialValue=1)
	private Long id;
	private String nome;
	private Integer idade;
}
