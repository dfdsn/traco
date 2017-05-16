package br.com.traco.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.traco.model.Usuario;
import br.com.traco.repository.UsuarioRepository;
import lombok.Data;

@Named
@ViewScoped
@Data
public class UsuarioBean {

	@Autowired
	private UsuarioRepository dao;

	@Autowired
	private Usuario usuario;

	// private Usuario usuario = new Usuario();

	private List<Usuario> usuarios;

	@PostConstruct
	public void listar() {

		usuarios = dao.todos();
		novo();
	}

	public void salvar() {
		try {
			dao.save(usuario);

			Messages.addGlobalInfo("Usuario " + usuario.getNome() + " salvo com sucesso!");
			System.out.println("Usuario " + usuario.getNome() + " salvo com sucesso!");

			listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o usuario " + usuario.getNome());
			e.printStackTrace();
		}
	}
	

	public void novo() {
		usuario = new Usuario();
	}

	public void excluir(ActionEvent evento) {

		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuSelecionado");

			dao.delete(usuario);

			Messages.addGlobalInfo("Usuario " + usuario.getNome() + " excluido com sucesso");
			System.out.println("excluindo usuario: " + usuario.getNome());

			listar();
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o usuario " + usuario.getNome());
		}
	}
	
	public void editar(ActionEvent evento){
		
		try {

			usuario =	(Usuario) evento.getComponent().getAttributes().get("usuSelecionado");
			
			Messages.addGlobalInfo(usuario.getNome());
			
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao editar o usuario");	
		
		}
		

	}
	


	
	
	
	
}