package br.com.traco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.traco.model.Empresa;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	
	@Query("select e from Empresa e order by nome asc")
	public List<Empresa> todos();

}
