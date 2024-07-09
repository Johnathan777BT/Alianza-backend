package com.alianza.CIientes;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alianza.CIientes.model.Clientes;
import com.alianza.CIientes.repository.ClientesRepository;



@SpringBootTest
class ClientesApplicationTests {

	
	@Autowired
	ClientesRepository repo; 
	
	
	Clientes c1 = new Clientes();
	
	@Test
	@Order(3)
	public void readAll	() {
		List<Clientes> list =(List<Clientes>) repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	
	@Test
	@Order(1)
	public void create() {
		
		java.sql.Date date_create = Date.valueOf("2021-05-19");
		java.sql.Date date_fin = Date.valueOf("2028-02-11");
		c1.setFechainicio(date_create);
		c1.setFechafin(date_fin);
		c1.setNombre("Juan Becerra");
		c1.setSharedkey("jbecerra");
		c1.setEmail("beccera@gamil.com");
		c1.setTelefono("3124527489");
		var y = repo.save(c1);
		assertThat(y).isNotNull();
	}
	
	
	
	@Test
	void contextLoads() {
	}

}
