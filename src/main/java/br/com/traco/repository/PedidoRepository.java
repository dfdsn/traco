package br.com.traco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.traco.model.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	
	
	@Query("select p from Pedido p where status = 'FECHADO' ")
	public List<Pedido> fechados();
	
	
	@Query("select p from Pedido p where status = 'ABERTO' ")
	public List<Pedido> abertos();
	


}
