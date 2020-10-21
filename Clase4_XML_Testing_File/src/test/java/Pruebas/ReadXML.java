package Pruebas;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class ReadXML {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

       File xmlFile = new File("..\\Clase4_XML_Testing_File\\src\\test\\java\\Pruebas\\data.xml");
       //Creamos una instancia para el document builder factory
       //La DocumentBuilderFactory obtiene un analizador que produce objetos DOM en forma de arbol para xml
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       //una vez generada la instancia previa, se crea un analizador para poder pasar o analizar un 
       //xml a traves de diferentes sources, ej InputStreams, files, URLs, SAX
       DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
       //Document es una interface lo que 
       //permite es un acceso primario a la informacion del documento a partir del cual
       //se puede acceder al xml
       Document doc = dbuilder.parse(xmlFile);
       
       //Obtenemos los nodos del xml y los guardamos en una lista de nodos 
       //NodeList es una interface que nos permite crear una coleccion ordenada de los nodos
       NodeList nodo = doc.getChildNodes();
       
       //Obtenemos el primer child del node y lo guardamos en un Node object
       Node child = nodo.item(0);
       
       //Asignamos el nodo a un elemento
       //La interfaz Element representa la creacion de un elemento en un html o xml. 
       //de esta manera podemos llegar a algun atributo del elemento
       Element element = (Element)child;
       
       //Imprimimos por consola el contenido del tag APP_URL
       //esto lo podemos hacer porque accedemos al elemento por tagName donde contiene la
       //informacion y la mostramos.
       System.out.println("URL: "+ element.getElementsByTagName("APP_URL").item(0).getTextContent());

         
       
       
       
	}

}
