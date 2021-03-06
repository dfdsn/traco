package br.com.traco.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.traco.model.Pedido;
import br.com.traco.repository.PedidoRepository;
import br.com.traco.service.PedidoService;
import lombok.Data;

//@ManagedBean
@Named
@Data
@ViewScoped
public class PedidoBean {
	
	@Autowired
	private PedidoService service;
	
	@Autowired
	private PedidoRepository dao;
	
	@Autowired
	private Pedido pedido;
	
	private List<Pedido> pedidos;
	
	private List<Pedido> pedidosFechado;
	
	public void novo(){
		pedido = new Pedido();
	}
	
	@PostConstruct
	public void listar(){
		pedidosFechado = dao.fechados();
		pedidos = dao.abertos();
		novo();
		
	}
	
	public void fechados(){
		pedidosFechado = dao.fechados();
	}
	
	
	
	public void salvar(){
		
		try {
			
			service.salvar(pedido);
			
			
//			dao.save(pedido);
			
			Messages.addGlobalInfo("Pedido " + pedido.getNumPedido() + " salvo com sucesso!");
			System.out.println("Pedido " + pedido.getNumPedido() + " salvo com sucesso!");
			
			listar();
			
		} catch (Exception e) {
			
			Messages.addGlobalError("Erro ao salvar o pedido");
			System.out.println("Erro ao salvar o pedido");
			e.printStackTrace();
			
		}
	}
	
	public void excluir(ActionEvent evento){
		
		try {

			pedido = (Pedido) evento.getComponent().getAttributes().get("pedSelecionado");
			
			dao.delete(pedido);
			
			Messages.addGlobalInfo("Pedido " + pedido.getNumPedido() + " excluido com sucesso!");
			System.out.println("Pedido " + pedido.getNumPedido() + " excluido com sucesso!");
			
			listar();
			
		} catch (Exception e) {
			
			Messages.addGlobalError("Erro ao excluir o pedido");
			System.out.println("Erro ao excluir o pedido");
			e.printStackTrace();
			
		}
	}

	
	public void editar(ActionEvent evento){

		pedido = (Pedido) evento.getComponent().getAttributes().get("pedSelecionado");

	}
	
	
	
	public void fechar(ActionEvent evento) {

		try {
			pedido = (Pedido) evento.getComponent().getAttributes().get("pedSelecionado");

			pedido.setStatus("FECHADO");
			dao.save(pedido);

			Messages.addGlobalInfo("Pedido fechado com sucesso");
			System.out.println("O pedido " + pedido.getNumPedido() + "foi fechado com sucesso");

			listar();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
