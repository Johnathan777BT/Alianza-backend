package com.alianza.CIientes.report;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alianza.CIientes.dto.ClientesDTO;


@Component
public class CsvGeneratorUtil {

	 private static final String CSV_HEADER = "SharedKey|Nombre|Email|Telefono|FechaInicio|FechaFin\n";

	    public String generateCsv(List<ClientesDTO> comers) {
	        StringBuilder csvContent = new StringBuilder();
	        csvContent.append(CSV_HEADER);

	        for (ClientesDTO comer : comers) {
	            csvContent.append(comer.getSharedkey()).append("|")
	                      .append(comer.getNombre()).append("|")	           
	                      .append(comer.getEmail()).append("|")
	                      .append(comer.getTelefono()).append("|")
	                      .append(comer.getFecha_inicio()).append("|")
	                      .append(comer.getFecha_fin()).append("\n")                   
	                      ;
	        }

	        return csvContent.toString();
	    }
	
}
