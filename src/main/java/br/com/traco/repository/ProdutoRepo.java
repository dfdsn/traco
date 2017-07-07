package br.com.traco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.traco.model.Produto;

public interface ProdutoRepo extends JpaRepository<Produto, Long>{
	
	
	
	@Query("select p from Produto p order by nome asc")
	public List<Produto> todos();
	
	

}
