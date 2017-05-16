package br.com.traco.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.traco.model.Cliente;
import br.com.traco.repository.ClienteRepository;
import lombok.Data;

@Named
//@ManagedBean
@ViewScoped
@Data
public class ClienteBean {

	
	@Autowired
	private ClienteRepository dao;
	
	Cliente cliente = new Cliente();
	

	
	
	
	
	public void salvar(){
	
//		Cliente cliente = new Cliente();
		
		dao.save(cliente);
		
		System.out.println("Cliente " + cliente.getNome() + " salvo com sucesso");
	}
	
	
	
}
