package br.com.traco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.traco.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	
@Query("select u from Usuario u order by nome asc")	
public List<Usuario>todos();

}
