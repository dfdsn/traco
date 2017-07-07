package br.com.traco.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.traco.model.Produto;
import br.com.traco.model.Retirada;
import br.com.traco.repository.ProdutoRepo;
import br.com.traco.repository.RetiradaDAO;
import lombok.Data;

@Service
@Data
public class RetiradaService {
	
	@Autowired
	private RetiradaDAO dao;
	
	@Autowired
	ProdutoRepo prodDAO;
	
	@Transactional
	public void salvar(Produto produto, Retirada retirada){
		
		retirada.setProdutoMovimentado(produto);

		System.out.println("========INICIO DA REGRA DE RETIRADA DO ESTOQUE DE MATERIAL===========");
		
		produto =	retirada.getProdutoMovimentado();
		System.out.println(produto.getNome());
		System.out.println(produto.getDimensoes());
		System.out.println(produto.getQtoMin());
		System.out.println(produto.getId());
		System.out.println(produto.getQto());
		System.out.println(produto);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		prodDAO.save(produto);
		dao.save(retirada);
		
	}
	

}
