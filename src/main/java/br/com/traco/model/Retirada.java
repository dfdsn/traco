package br.com.traco.model;

import java.util.Date;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Named
@Entity
public class Retirada {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO , generator="seq_retirada")
	@SequenceGenerator(name="seq_retirada", sequenceName="seq_retirada" , initialValue= 1 )
	private Long id;
	
	private Integer quantidade;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@JoinColumn
	@OneToOne
	private Usuario usuario;
	@JoinColumn
	@ManyToOne
	private Produto produtoMovimentado;
	
}
