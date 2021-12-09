package com.Cruds.jaxb;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.Cruds.JOptionpaneUtility;
import com.Cruds.constants.Constants;

public class LeerJAXB {
	public static void leer() {
		try {
			if(!Constants.FILE.exists()) {
				JOptionpaneUtility.error("No ha encontrado el archivo","Error");
			}else {
				JAXBContext context = JAXBContext.newInstance(Empleados.class);
	
				Unmarshaller ms = context.createUnmarshaller();
	
				Empleados empleados = (Empleados) ms.unmarshal(Constants.FILE);
				List<Empleado> lista = empleados.getListaEmpleados();
				String listaS = "";
				for (Empleado e : lista) {
					listaS += e.toString() + "\n";
				}
				JOptionpaneUtility.mensage(listaS, "listado");
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
