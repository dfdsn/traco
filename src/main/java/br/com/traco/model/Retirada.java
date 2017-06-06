package br.com.traco.model;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Named
@Entity
public class Retirada {

	@Id
	@GeneratedValue
	private Long id;
	
}
