package br.com.traco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.traco.model.Fornecedor;

public interface FornecedorRepo extends JpaRepository<Fornecedor, Long>{

	
	@Query("select f from Fornecedor f order by nome asc")	
	List<Fornecedor> todos();

}
