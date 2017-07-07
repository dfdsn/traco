package br.com.traco.service;

import org.springframework.stereotype.Service;

import br.com.traco.model.Produto;

@Service
public class ProdutoService {

	
	public void movimentar(Produto produto){
		
		System.out.println(produto);
		
		
	}
	
	
}
