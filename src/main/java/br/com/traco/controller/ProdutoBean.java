package br.com.traco.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.traco.model.Produto;
import br.com.traco.repository.ProdutoRepo;
import br.com.traco.service.ProdutoService;
import lombok.Data;

@Named
@Data
@ViewScoped
//@ManagedBean
public class ProdutoBean {
	
	@Autowired
	private ProdutoRepo dao;
	
	@Autowired
	ProdutoService service;
	
	@Autowired
	private Produto produto;
	
	@Autowired
	private Produto prodMov;
	
	private List<Produto> produtos;
	
	public void novo(){
		produto = new Produto();
	}
	
	@PostConstruct
	public void listar(){
		
		produtos = dao.todos();
		novo();
		
	}
	
	public void salvar(){
		
		try {
			dao.save(produto);
			
			Messages.addGlobalInfo("Produto " + produto.getNome() + " salvo com sucesso!");
			System.out.println("Produto " + produto.getNome() + " salvo com sucesso!");
			
			listar();
			
		} catch (Exception e) {
			
			Messages.addGlobalError("Erro ao salvar o produto");
			System.out.println("Erro ao salvar o produto");
			e.printStackTrace();
			
		}
		
		
	}
	
	public void excluir(ActionEvent evento){
		
		try {

			produto = (Produto) evento.getComponent().getAttributes().get("prodSelecionado");
			
			dao.delete(produto);
			
			Messages.addGlobalInfo("Produto " + produto.getNome() + " excluido com sucesso!");
			System.out.println("Produto " + produto.getNome() + " excluido com sucesso!");
			
			listar();
			
		} catch (Exception e) {
			
			Messages.addGlobalError("Erro ao excluir o produto");
			System.out.println("Erro ao excluir o produto");
			e.printStackTrace();
			
		}
	}

	
	public void editar(ActionEvent evento){

		produto = (Produto) evento.getComponent().getAttributes().get("prodSelecionado");
		
		System.out.println(produto);

	}

	public void retirada(ActionEvent evento){
		
		produto = (Produto) evento.getComponent().getAttributes().get("prodSelecionado");
		
		System.out.println(prodMov +" teste schedule");
	}

	
//	public void movimentar(ActionEvent evento){
//		
//		produto = (Produto) evento.getComponent().getAttributes().get("prodSelecionado");
//		System.out.println(produto);
//		
//		
//		System.out.println("==============================TESTES=================================");
//		System.out.println(produto.getNome());
//		System.out.println(produto.getQtoMin());
//		System.out.println(produto.getQto());
//		System.out.println(produto.getDimensoes());
//		System.out.println("==============================TESTES=================================");
//		
//		
//		
//		
//	}
	
	public void movimentar(ActionEvent evento){
		
		produto = (Produto) evento.getComponent().getAttributes().get("prodSelecionado");
		
		service.movimentar(produto);
		
		
	}
	
	

}
