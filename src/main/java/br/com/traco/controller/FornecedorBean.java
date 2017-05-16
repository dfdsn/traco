package br.com.traco.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.traco.model.Fornecedor;
import br.com.traco.repository.FornecedorRepo;
import lombok.Data;

@Named
@ViewScoped
@Data
public class FornecedorBean {

	@Autowired
	private FornecedorRepo dao;
	
	@Autowired
	private Fornecedor fornecedor;
	
	private List<Fornecedor> fornecedores;
	
	private List<Fornecedor> filtrados;
	
	
	@PostConstruct
	public void listar(){
		
		fornecedores = dao.todos();
		novo();	
	}
	
	
	public void novo(){
		fornecedor = new Fornecedor();
	}
	
	public void salvar(){
		try {

			dao.save(fornecedor);
			
			Messages.addGlobalInfo("Fornecedor " + fornecedor.getNome() +  " salvo com sucesso!");
			System.out.println(fornecedor.getNome() + "salvo com sucesso");

			listar();
			
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao tentar salvar fornecedor");	
			System.out.println("Erro ao salvar fornecedor");
		}
	}
	

	public void excluir(ActionEvent evento){
		
		try {

			fornecedor = (Fornecedor) evento.getComponent().getAttributes().get("fornSelecionado");
			dao.delete(fornecedor);
			
			Messages.addGlobalInfo("Fornecedor " + fornecedor.getNome() + " excluido com sucesso");
			
			System.out.println("Forcedor" + fornecedor.getNome() + " excluido com sucesso");
listar();
			
		} catch (Exception e) {

			Messages.addGlobalError("Erro ao excluir fornecedor");
		}
		
	}
	
	public void editar(ActionEvent evento){
		
		fornecedor = (Fornecedor) evento.getComponent().getAttributes().get("fornSelecionado");
	}
	
	
	
	
}