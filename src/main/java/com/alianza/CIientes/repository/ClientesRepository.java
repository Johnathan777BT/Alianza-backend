package com.alianza.CIientes.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alianza.CIientes.model.Clientes;

@Repository
public interface ClientesRepository  extends JpaRepository<Clientes, Long> {

	
	
	@Query(value="select sharedkey, nombre, telefono , email, fechainicio, fechafin "
			+ " "
			+ " from clientes  where sharedkey like concat( '%', :nombre ,'%') "
			+ " ", 
			nativeQuery=true)
	public List<Object[]> getList(@Param("nombre") String nombre);
	
	
	
}
