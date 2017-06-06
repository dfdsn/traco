package br.com.traco.model;

import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Named
@Entity
@Data
public class Pedido {

	@Id
	@GeneratedValue
	private Long id;
	private String pedido;
	private String xPedido;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPedido;
	@OneToMany
	private List<Produto> produto;
	private String obs;
	
}
