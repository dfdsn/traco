package br.com.traco.model;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
@Named
public class Pedido {

	
	@Id
	@GeneratedValue
	private Long id;
	private String numPedido;
	private String dados;
	private Long qto;
	private String obs;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	
	

	
	
	
}
