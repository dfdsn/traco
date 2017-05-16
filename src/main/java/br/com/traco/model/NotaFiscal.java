package br.com.traco.model;

import java.util.Date;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
@Named
public class NotaFiscal {

	
	@Id
	@GeneratedValue
	private Long id;
	private Long nunNF;
	private String chNF;
	private Date dataNF;
	
	
}
