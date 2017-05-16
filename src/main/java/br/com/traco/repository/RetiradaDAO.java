package br.com.traco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.traco.model.Cliente;

@Repository
public interface RetiradaDAO extends JpaRepository<Cliente, Long>{
	
	

}
