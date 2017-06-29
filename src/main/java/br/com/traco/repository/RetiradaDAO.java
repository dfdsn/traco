package br.com.traco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.traco.model.Retirada;

@Repository
public interface RetiradaDAO extends JpaRepository<Retirada, Long>{
	
	

}
