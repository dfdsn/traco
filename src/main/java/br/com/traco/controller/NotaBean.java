package br.com.traco.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.traco.model.NotaFis;
import br.com.traco.repository.NFRepo;
import lombok.Data;

@Named
@ViewScoped
@Data
public class NotaBean {

	@Autowired
	private NFRepo dao;

	@Autowired
	private NotaFis fiscal;

	// private Usuario usuario = new Usuario();

	private List<NotaFis> notas;

	@PostConstruct
	public void listar() {

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

//	public void excluir(ActionEvent evento) {
//
//		try {
//			usuario = (Usuario) evento.getComponent().getAttributes().get("usuSelecionado");
//
//			dao.delete(usuario);
//
//			Messages.addGlobalInfo("Usuario " + usuario.getNome() + " excluido com sucesso");
//			System.out.println("excluindo usuario: " + usuario.getNome());
//
//			listar();
//		} catch (Exception e) {
//			e.printStackTrace();
//			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o usuario " + usuario.getNome());
//		}
//	}
//	
//	public void editar(ActionEvent evento){
//		
//		try {
//
//			usuario =	(Usuario) evento.getComponent().getAttributes().get("usuSelecionado");
//			
//			Messages.addGlobalInfo(usuario.getNome());
//			
//		} catch (Exception e) {
//			Messages.addGlobalInfo("Erro ao editar o usuario");	
//		
//		}
//		
//
//	}
//	


	
	
	
	
}