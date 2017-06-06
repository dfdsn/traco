package br.com.traco;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.traco.model.Usuario;
import br.com.traco.repository.UsuarioRepository;





@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection=EmbeddedDatabaseConnection.H2,replace=Replace.NONE)
public class UsuarioCrud {
	
	
	
	private UsuarioRepository dao;
	
	
	
	
	@Test
	public void salvar(){
		
		 Usuario u = new Usuario();
		
		u.setEmail("email");
		u.setNome("nome");
		u.setPass("pass");
		
		dao.save(u);
		
		System.out.println(u.toString());
		
	}

}
