package br.com.traco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.traco.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	
	@Query("select c from Cliente c where c.nome=:nome")
	public void buscarPorNome(@Param("nome") String nome);

}
