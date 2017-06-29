package br.com.traco.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.traco.model.Produto;
import br.com.traco.model.Retirada;
import br.com.traco.model.Usuario;
import br.com.traco.repository.ProdutoRepo;
import br.com.traco.repository.RetiradaDAO;
import br.com.traco.repository.UsuarioRepository;
import br.com.traco.service.RetiradaService;
import lombok.Data;

@Named
@Data
@ViewScoped
public class RetiradaBean {
	
	
	@Autowired
	private UsuarioRepository usuDAO;
	@Autowired
	private ProdutoRepo prodDAO;
	@Autowired
	private RetiradaDAO dao;

	
	@Autowired
	private Retirada retirada;
	
	
	@Autowired
	private RetiradaService service;
	
	@Autowired
	private Produto produto;
	
	private List<Retirada> retiradas;
	private List<Produto> produtos;
	private List<Usuario> usuarios;
	

//	este metodo esta funcionando
//	public void salvar(){
//		try {
//			
//		dao.save(retirada);
//		System.out.println("retirada salva no teste " + retirada);			
//		
//		Produto produto =	retirada.getProdutoMovimentado();
//		
//		produto.setQto( produto.getQto() - retirada.getQuantidade()   );
//
//		System.out.println(produto.getQto());
//		
//		prodDAO.save(produto);
//		
//		System.out.println("retirada realizada com sucesso");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
	public void salvar(ActionEvent evento){

		produto = (Produto) evento.getComponent().getAttributes().get("prodSelecionado");

	}
	
	
	
	
	
	@PostConstruct
	public void listar(){
		retiradas = dao.findAll();
		usuarios = usuDAO.findAll();
		produtos = prodDAO.findAll();
		
		System.out.println(usuarios);
		
		novo();
	}
	
	
	public void novo(){
		retirada = new Retirada();
		
	}
	
	
	
}
