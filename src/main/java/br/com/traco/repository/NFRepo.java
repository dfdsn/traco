package br.com.traco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.traco.model.NotaFiscal;


@Repository
public interface NFRepo extends JpaRepository<NotaFiscal, Long>{
	
	
	@Query("select nf from NotaFiscal nf order by dataNF asc")
	public List<NotaFiscal> todos();

}
