package com.Cruds.jaxb;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.Cruds.constants.Constants;

public class EscrituraJAXB {
	public static void escribir() {
		try {
			if(!Constants.FILE.exists()) {
				Constants.FILE.createNewFile();
			}
			FileWriter fw = new FileWriter(Constants.FILE, false);

			JAXBContext context = JAXBContext.newInstance(Empleados.class);

			Marshaller ms = context.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			Empleados empleados = new Empleados(DatosPrueba.crearListaEmpleados(20));

			ms.marshal(empleados, fw);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
