package br.com.traco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.traco.model.Colaborador;

public interface ColaboradorRepo extends JpaRepository<Colaborador, Long>{

}
