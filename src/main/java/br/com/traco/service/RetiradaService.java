package br.com.traco.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.traco.model.Produto;
import br.com.traco.model.Retirada;
import br.com.traco.repository.RetiradaDAO;
import lombok.Data;

@Service
@Data
public class RetiradaService {
	
	@Autowired
	private RetiradaDAO dao;
	
	@Transactional
	public void salvar(Retirada retirada){
		
//		retirada.getProdutoMovimentado();
		
		
		
		dao.save(retirada);
		
	}
	

}
