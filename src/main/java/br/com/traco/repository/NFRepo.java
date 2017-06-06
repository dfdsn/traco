package br.com.traco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.traco.model.NotaFis;


@Repository
public interface NFRepo extends JpaRepository<NotaFis, Long>{
	
	
	@Query("select nf from NotaFis nf order by dataNF asc")
	public List<NotaFis> todos();
	
	
	public List<NotaFis>	findAllByOrderByDataNFDesc();

}
