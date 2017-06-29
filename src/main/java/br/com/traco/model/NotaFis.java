package br.com.traco.model;

import java.util.Date;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
@Named
public class NotaFis {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="seq_nf")
	@SequenceGenerator(name="seq_nf", sequenceName="seq_nf" , initialValue=1)
	private Long id;
	@NotEmpty(message="O campo 'Numero da nota' deve ser preenchido")
	private String numNF;

	@JoinColumn
	@ManyToOne
	@NotEmpty(message="O campo 'pedido' deve ser preenchido")
	private Pedido pedido;
	
	@NotEmpty(message="O campo 'Data da NF' deve ser preenchido")
	@Temporal(TemporalType.DATE)
	private Date dataNF;

	
}
 