package br.com.traco.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.traco.model.Empresa;
import br.com.traco.repository.EmpresaRepository;
import lombok.Data;

//@ManagedBean
@Data
@ViewScoped
@Named
public class EmpresaBean {

	@Autowired
	private EmpresaRepository dao;

	@Autowired
	private Empresa empresa;


	private List<Empresa> empresas;
	
	private List<Empresa> filtrados;

	@PostConstruct
	public void listar() {

		empresas = dao.todos();
		novo();
	}

	public void salvar() {
		try {
			dao.save(empresa);

			Messages.addGlobalInfo("Empresa " + empresa.getNome() + " salvo com sucesso!");
			System.out.println("Empresa " + empresa.getNome() + " salvo com sucesso!");

			listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o empresa " + empresa.getNome());
			e.printStackTrace();
		}
	}
	

	public void novo() {
		empresa = new Empresa();
	}

	public void excluir(ActionEvent evento) {

		try {
			empresa = (Empresa) evento.getComponent().getAttributes().get("empSelecionado");

			dao.delete(empresa);

			Messages.addGlobalInfo("Empresa " + empresa.getNome() + " excluido com sucesso");
			System.out.println("excluindo empresa: " + empresa.getNome());

			listar();
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o empresa " + empresa.getNome());
		}
	}
	
	public void editar(ActionEvent evento){
		
		try {

			empresa =	(Empresa) evento.getComponent().getAttributes().get("empSelecionado");
			
			Messages.addGlobalInfo(empresa.getNome());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	


	
	
	

	
	
}
