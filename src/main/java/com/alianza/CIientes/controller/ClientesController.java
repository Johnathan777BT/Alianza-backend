package com.alianza.CIientes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alianza.CIientes.dto.ClientesDTO;
import com.alianza.CIientes.model.Clientes;
import com.alianza.CIientes.report.CsvGeneratorUtil;
import com.alianza.CIientes.repository.ClientesRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/clientes")
public class ClientesController {

	
	@Autowired
	private ClientesRepository repo;
	
	 @Autowired
	 private CsvGeneratorUtil csvGeneratorUtil;
	
	@GetMapping("/listardto")
	public List<Clientes> list(){
		
		return repo.findAll();
	}
	
	@GetMapping("/listar")
	public List<ClientesDTO> listDto( @RequestParam(name = "nombre") String nombre) {

		System.out.println("entro a listar comerciantes");
		List<ClientesDTO> values = new ArrayList<>();
		
		var results =repo.getList(nombre);
		System.out.println("nombre:"+nombre);
		System.out.println(results.size());
		ClientesDTO[] com = new  ClientesDTO[results.size()+1];
		
		 int x=0; int i=0;
		 for (Object[] r : results) {
			 System.out.println("-a-"+ r[i]+"-b-"+r[i+1]+"-c-"+r[i+2]+"-d-"+r[i+3]+"-e-"+r[i+4]
					+"-f-" +r[i+5]);

				 
			 com[x] = new ClientesDTO((String) r[i+1],  (String) r[i], 
					 (String) r[i+2], (String) r[i+3], (java.sql.Date) r[i+4], (java.sql.Date) r[i+5]
				);
		
			 values.add(com[x]); x++;
		 }
		 
		return  values;
	}
	
	

	@GetMapping("/listar/csv")
    public void generateCsvFile(HttpServletResponse response, @RequestParam(name = "nombre") String nombre) {
    	List<ClientesDTO> values = new ArrayList<>();
		
    	var results = repo.getList(nombre);
		System.out.println(results.size());
		ClientesDTO[] com = new  ClientesDTO[results.size()+1];
		
		 int x=0; int i=0;
		 for (Object[] r : results) {
			 System.out.println("-a-"+ r[i]+"-b-"+r[i+1]+"-c-"+r[i+2]+"-d-"+r[i+3]+"-e-"+r[i+4]
					+"-f-" +r[i+5]);

			 
			 com[x] = new ClientesDTO((String) r[i+1],  (String) r[i], 
					 (String) r[i+2],  (String) r[i+3],  (java.sql.Date) r[i+4], (java.sql.Date) r[i+5] 
					);
		
			 values.add(com[x]); x++;
	
			 
		 }
		 
		  response.addHeader("Content-Type", "application/csv");
		  response.addHeader("Content-Disposition", "attachment; filename=export.csv");
		   try {
		       PrintWriter out = response.getWriter();		     
		       out.write(csvGeneratorUtil.generateCsv(values));
		       out.write("\n");		     
		       out.flush();
		       out.close();
		   } catch (IOException ix) {
		       throw new RuntimeException("There was an error while retrieving CSV data", ix);
		   } 

    }
	
	
	@PostMapping("/guardar")
	public Clientes save(@RequestBody @Valid  Clientes cli) {
		
		System.out.print("Name:" + cli.getNombre());
		String sharedKey = cli.getNombre();
		int index = cli.getNombre().indexOf(" ");
	   if(index != -1) {
		String _1 = cli.getNombre().substring(0,1);
		String _2 = cli.getNombre().substring(index+1, cli.getNombre().length());
		
		sharedKey = _1.toLowerCase() + _2.toLowerCase();
		
	   }
	   
	   cli.setSharedkey(sharedKey);
	   System.out.print("sharedkey:" + cli.getSharedkey());
		//System.out.print("Id:" + prod.getProductId());
		
		return repo.save(cli);
	}
	
	
	
	
}
