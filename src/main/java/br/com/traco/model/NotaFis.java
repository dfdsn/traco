package br.com.traco.model;

import java.util.Date;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
@Named
public class NotaFis {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="O campo 'Numero da nota' deve ser preenchido")
	private String numNF;

	private String pedido;
	
	
	@Temporal(TemporalType.DATE)
	private Date dataNF;

	
}
 