package br.com.traco.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.traco.model.NotaFiscal;
import br.com.traco.repository.NFRepo;
import lombok.Data;

@Named
@Data
@ViewScoped
public class NFBean {

	@Autowired
	private NFRepo dao;
	
	@Autowired
	private NotaFiscal nf;
	
	private List<NotaFiscal> nfs;
	
	
	public void novo(){
		nf = new NotaFiscal();
	}
	
	
	@PostConstruct
	public void listar(){
		
		nfs = dao.todos();
		novo();
	}
	
	public void salvar(){
		try {

			dao.save(nf);
			
			Messages.addGlobalInfo("Nota Fiscal " +nf.getNunNF()+ "salva com sucesso");
			System.out.println("Nota Fiscal " +nf.getNunNF()+ "salva com sucesso");
			
			listar();
		} catch (RuntimeException e) {

			Messages.addGlobalError("Erro ao salvar nota fiscal");
			e.printStackTrace();
			
		}
	}
	
	
	public void excluir(ActionEvent evento){
		
		try {

			nf = (NotaFiscal)	evento.getComponent().getAttributes().get("nfSelecionada");
			dao.delete(nf);

			Messages.addGlobalInfo("Nota Fiscal " +nf.getNunNF()+ "excluida com sucesso");
			System.out.println("Nota Fiscal " +nf.getNunNF()+ "excluida com sucesso");
			
			listar();
		} catch (Exception e) {

			Messages.addGlobalError("Erro ao excluir nota fiscal");
			e.printStackTrace();
			
		}
		
		
	}
	
	
	public void editar(ActionEvent evento){
		nf = (NotaFiscal)	evento.getComponent().getAttributes().get("nfSelecionada");
	}
}
