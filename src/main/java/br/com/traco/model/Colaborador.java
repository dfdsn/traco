package br.com.traco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Colaborador {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="seq_colaborador")
	@SequenceGenerator(name="seq_colaborador", sequenceName="seq_colaborador" , initialValue=1)
	private Long id;
	private String nome;
	private Long idade;
	private String endereco;
	private String bairro;
	private String cidade;
	private String tel;
	private String especialidade;


}

