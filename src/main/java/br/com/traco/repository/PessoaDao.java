package br.com.traco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.traco.model.Pessoa;


@Repository
public interface PessoaDao extends JpaRepository<Pessoa, Long>{

}
