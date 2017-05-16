package br.com.traco.model;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


import lombok.Data;

@Entity
@Data
@Named
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="O campo 'Nome' deve ser preenchido")
	private String nome;
	@DecimalMin(value="18" , message="Idade deve ser superior a 18 anos")
	@DecimalMax(value="99", message="idade deve ser inferior a 99 anos")
	private Integer idade;
	@Email(message="Favor indormar um email valido")
	private String email;
	@Size(min= 4 , max= 8, message="O campo 'senha' deve ter no minimo 4 e maximo 8 digitos")
	private String pass;
	
	@NotNull(message="O campo 'empresa' deve ser preenchido")
	private String empresa;
	@NotNull(message="O campo 'função' deve ser preenchido")
	private String funcao;

}
 