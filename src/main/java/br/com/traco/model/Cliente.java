package br.com.traco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="seq_cliente")
	@SequenceGenerator(name="seq_cliente", sequenceName="seq_cliente" , initialValue=0)
	private Long id;
	private String nome;
	private String email;
	
	
	
}
