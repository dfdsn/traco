package br.com.traco.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.traco.model.NotaFis;
import br.com.traco.model.Pedido;
import br.com.traco.repository.NFRepo;
import br.com.traco.repository.PedidoRepository;
import lombok.Data;

@Named
@ViewScoped
@Data
public class NotaBean {

	@Autowired
	private NFRepo dao;

	@Autowired
private PedidoRepository pDAO;	
	
	@Autowired
	private NotaFis fiscal;

	private List<Pedido> pedidos;
	
//	@Autowired
//	 private NotaFis nota;

	private List<NotaFis> notas;

	@PostConstruct
	public void listar() {
		
		pedidos = pDAO.findAll();
		notas = dao.findAllByOrderByDataNFDesc();
		novo();
	}

	public void salvar() {
		try {
			dao.save(fiscal);

			Messages.addGlobalInfo("nota " + fiscal.getNumNF() + " salvo com sucesso!");
			System.out.println("nota " + fiscal.getNumNF() + " salvo com sucesso!");
			
			listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o nota " );
			e.printStackTrace();
		}
	}
	

	public void novo() {
		fiscal = new NotaFis();
	}

	public void excluir(ActionEvent evento) {

		try {
			fiscal = (NotaFis) evento.getComponent().getAttributes().get("nfSelecionado");

			dao.delete(fiscal);

			Messages.addGlobalInfo("NF " + fiscal.getNumNF() + " excluido com sucesso");
			System.out.println("NF " + fiscal.getNumNF() + " excluido com sucesso");

			listar();
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o nf " + fiscal.getNumNF());
		}
	}
	
	public void editar(ActionEvent evento){
		
		try {

			fiscal = (NotaFis) evento.getComponent().getAttributes().get("nfSelecionado");			
//			Messages.addGlobalInfo(usuario.getNome());
			
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao editar o usuario");	
		
		}
		

	}
	


	
	
	
	
}