package br.com.traco.model;

import java.util.Date;

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
public class Produto {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="seq_produto")
	@SequenceGenerator(name="seq_produto", sequenceName="seq_produto" , initialValue=1)
	private Long id;
	private String nome;
	private String dimensoes;
	private Long qto;
	private String qtoMin;
	
	private Integer qtoRetirada;
	private Date dataRetirada;
	
	
//	@OneToMany
//	private Fornecedor fornecedor;
	
	
	
}
