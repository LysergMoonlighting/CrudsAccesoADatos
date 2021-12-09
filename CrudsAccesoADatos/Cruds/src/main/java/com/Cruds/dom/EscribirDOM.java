package com.Cruds.dom;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.Cruds.DatosPrueba;
import com.Cruds.JOptionpaneUtility;
import com.Cruds.LogsUtility;
import com.Cruds.constants.Constants;

public class EscribirDOM {
	public static void insertarTodo() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();

			List<Empleado> lista = DatosPrueba.crearListaEmpleados(10);

			Element empXML = document.createElement("Empleados");
			document.appendChild(empXML);

			for (Empleado emp : lista) {

				Element empleadoXML = document.createElement("empleado");
				empXML.appendChild(empleadoXML);
				empleadoXML.setAttribute("id", String.valueOf(emp.getId()));

				Element nombre = document.createElement("nombre");
				nombre.appendChild(document.createTextNode(emp.getNombre()));
				empleadoXML.appendChild(nombre);

				Element apellidos = document.createElement("apellidos");
				apellidos.appendChild(document.createTextNode(emp.getApellidos()));
				empleadoXML.appendChild(apellidos);

				Element edad = document.createElement("edad");
				edad.appendChild(document.createTextNode(String.valueOf(emp.getEdad())));
				empleadoXML.appendChild(edad);

				Element salario = document.createElement("salario");
				salario.appendChild(document.createTextNode(String.valueOf(emp.getSalario())));
				empleadoXML.appendChild(salario);
			}

			TransformerFactory factoria = TransformerFactory.newInstance();
			Transformer transformer = factoria.newTransformer();

			Source source = new DOMSource(document);
			FileWriter fw = new FileWriter(Constants.FILE);

			Result result = new StreamResult(fw);
			transformer.transform(source, result);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void insertar() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(Constants.FILE);
			document.getDocumentElement().normalize();
			NodeList nodosEmpleado = document.getElementsByTagName("empleado");
//			private int id;
//			private String nombre;
//			private String apellidos;
//			private int edad;
//			private double salario;
			int idE=0;
				Node empleado = nodosEmpleado.item(nodosEmpleado.getLength()-1);
				if (empleado.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) empleado; // OBTENEMOS LOS ELEMENTS DEL NODO
					idE= Integer.parseInt(elemento.getAttribute("id"));
				}
				
			idE++;
			String nombreE = JOptionpaneUtility.readString("Introduzca su nombre", "nombre");
			String apellidosE = JOptionpaneUtility.readString("Introduzca sus apellidos", "apellidos");
			int edadE = JOptionpaneUtility.readInt("Introduzca su edad", "edad");
			double salarioE = JOptionpaneUtility.readDouble("Introduzca su salario", "salario");
			
			Empleado empleadoOBJ= new Empleado(idE, nombreE, apellidosE, edadE, salarioE);
			Node empleadosXML= document.getFirstChild();

			Element empleadoXML = document.createElement("empleado");
			empleadosXML.appendChild(empleadoXML);
			empleadoXML.setAttribute("id", String.valueOf(empleadoOBJ.getId()));

			Element nombre = document.createElement("nombre");
			nombre.appendChild(document.createTextNode(empleadoOBJ.getNombre()));
			empleadoXML.appendChild(nombre);
			
			Element apellidos = document.createElement("apellidos");
			apellidos.appendChild(document.createTextNode(empleadoOBJ.getApellidos()));
			empleadoXML.appendChild(apellidos);
			
			Element edad = document.createElement("edad");
			edad.appendChild(document.createTextNode(String.valueOf(empleadoOBJ.getEdad())));
			empleadoXML.appendChild(edad);
			
			Element salario = document.createElement("salario");
			salario.appendChild(document.createTextNode(String.valueOf(empleadoOBJ.getSalario())));
			empleadoXML.appendChild(salario);
			
			TransformerFactory factoria = TransformerFactory.newInstance();
			Transformer transformer = factoria.newTransformer();

			Source source = new DOMSource(document);
			FileWriter fw = new FileWriter(Constants.FILE);

			Result result = new StreamResult(fw);
			transformer.transform(source, result);
		} catch (ParserConfigurationException e) {
			LogsUtility.WriteLog(e);
		} catch (TransformerConfigurationException e) {
			LogsUtility.WriteLog(e);
		} catch (TransformerException e) {
			LogsUtility.WriteLog(e);
		} catch (IOException e) {
			LogsUtility.WriteLog(e);
		} catch (SAXException e) {
			LogsUtility.WriteLog(e);
		}

	}

}
