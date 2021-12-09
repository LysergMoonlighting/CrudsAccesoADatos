package com.Cruds.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.Cruds.JOptionpaneUtility;
import com.Cruds.LogsUtility;
import com.Cruds.constants.Constants;
import com.Cruds.constants.ConstantsWarns;

public class LeerDOM {
	public static void leerTodo() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(Constants.FILE);
			document.getDocumentElement().normalize();

			NodeList nodosEmpleado = document.getElementsByTagName("empleado");
			String listaEmp="";
			for (int i = 0; i < nodosEmpleado.getLength(); i++) {
				Node empleado = nodosEmpleado.item(i);
				if (empleado.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) empleado;
					listaEmp+= "Id: "+elemento.getAttribute("id")+", ";
					listaEmp+=elemento.getElementsByTagName("nombre").item(0).getNodeName() + ": "
							+ elemento.getElementsByTagName("nombre").item(0).getTextContent()+", ";
					listaEmp+=elemento.getElementsByTagName("apellidos").item(0).getNodeName() + ": "
							+ elemento.getElementsByTagName("apellidos").item(0).getTextContent()+", ";
					listaEmp+=elemento.getElementsByTagName("edad").item(0).getNodeName() + ": "
							+ elemento.getElementsByTagName("edad").item(0).getTextContent()+", ";
					listaEmp+=elemento.getElementsByTagName("salario").item(0).getNodeName() + ": "
							+ elemento.getElementsByTagName("salario").item(0).getTextContent()+"\n";
				}
			}
			JOptionpaneUtility.mensage(listaEmp, "Lista Empleados");
		} catch (ParserConfigurationException e) {
			LogsUtility.WriteLog(e);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			LogsUtility.WriteLog(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LogsUtility.WriteLog(e);
		}
	}

	public static void buscarId(int id) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(Constants.FILE);
			document.getDocumentElement().normalize();

			NodeList nodosEmpleado = document.getElementsByTagName("empleado");
			String listaEmp="";
			boolean encontrado=false;
			for (int i = 0; i < nodosEmpleado.getLength(); i++) {
				Node empleado = nodosEmpleado.item(i);
				if (empleado.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) empleado;
					if(id==Integer.parseInt(elemento.getAttribute("id"))) {
						encontrado=true;
						listaEmp+= "Id: "+elemento.getAttribute("id")+", ";
						listaEmp+=elemento.getElementsByTagName("nombre").item(0).getNodeName() + ": "
								+ elemento.getElementsByTagName("nombre").item(0).getTextContent()+", ";
						listaEmp+=elemento.getElementsByTagName("apellidos").item(0).getNodeName() + ": "
								+ elemento.getElementsByTagName("apellidos").item(0).getTextContent()+", ";
						listaEmp+=elemento.getElementsByTagName("edad").item(0).getNodeName() + ": "
								+ elemento.getElementsByTagName("edad").item(0).getTextContent()+", ";
						listaEmp+=elemento.getElementsByTagName("salario").item(0).getNodeName() + ": "
								+ elemento.getElementsByTagName("salario").item(0).getTextContent()+"\n";
					}
				}
			}
			if(encontrado) {
				JOptionpaneUtility.mensage(listaEmp, "Empleado");
			}else {
				JOptionpaneUtility.mensage(ConstantsWarns.NOT_FOUND, "NOT_FOUND");
			}
			
		} catch (ParserConfigurationException e) {
			LogsUtility.WriteLog(e);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			LogsUtility.WriteLog(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LogsUtility.WriteLog(e);
		}
	}
}
