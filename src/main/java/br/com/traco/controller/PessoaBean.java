package br.com.traco.controller;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.traco.model.Pessoa;
import br.com.traco.repository.PessoaDao;
import lombok.Data;

@Named
@javax.faces.view.ViewScoped
@Data
//@ManagedBean
public class PessoaBean {
	
	@Autowired
	private PessoaDao dao;

	@Autowired
	Pessoa pessoa;
	
//	Pessoa pessoa = new Pessoa();
	
	
	public void salvar(){
		
		dao.save(pessoa);
		
		System.out.println(pessoa.toString());
	}
	
	
	
}
