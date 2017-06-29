package br.com.traco.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.traco.model.Pedido;
import br.com.traco.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository dao;
	
	@Transactional
	public void salvar(Pedido pedido){
		
		
		if(pedido.getStatus() == null){
			pedido.setStatus("ABERTO");
			dao.save(pedido);
		}
		
//		dao.save(pedido);
	}
	
	
	
	
	
}
