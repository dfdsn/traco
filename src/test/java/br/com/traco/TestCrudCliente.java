package br.com.traco;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.traco.model.Cliente;
import br.com.traco.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection=EmbeddedDatabaseConnection.H2,replace=Replace.NONE)
public class TestCrudCliente {

//	@Autowired
//	private TestEntityManager em;
	
	@Autowired
	ClienteRepository dao;
	
	@Test
	public void salvar(){
		
		 Cliente c = new Cliente();
		 
		 c.setEmail("email");
		 c.setNome("diego");
		 
		 dao.save(c);
		 dao.buscarPorNome("diego");
		
		 
//	System.out.println(c.toString());
	}
	
	
}
