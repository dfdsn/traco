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
public class Pedido {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="seq_pedido")
	@SequenceGenerator(name="seq_pedido", sequenceName="seq_pedido" , initialValue=1)
	private Long id;
	private String numPedido;
	private String dados;
	private Long qto;
	private String obs;
	
	private String status;
	
	
//	@Enumerated(EnumType.STRING)
//	private StatusPedido status;
	


	
	
	
}
