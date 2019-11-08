package controller;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import model.Coleccion;
import model.Pelicula;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionController {
	
	private Coleccion coleccion;
	
	public boolean parseFile(String path) {
		Coleccion c = new Coleccion();
		if(!path.endsWith(".xml")) path+= ".xml";
		File file = new File(path);
		Document doc;
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
			doc.getDocumentElement().normalize();
			NodeList peliculas = doc.getElementsByTagName("pelicula");
			for(int i = 0; i<peliculas.getLength();i++) {
				Node node = peliculas.item(i);
				Element element = (Element) node;
				String titulo = element.getElementsByTagName("titulo").item(0).getTextContent();
				String fecha = element.getElementsByTagName("fecha").item(0).getTextContent();
				Pelicula p = new Pelicula( titulo, fecha);
				NodeList d = element.getElementsByTagName("director");
				String director = (d == null || d.getLength() == 0) ? null : d.item(0).getTextContent();
				if(director != null) {
					p.setDirector(director);
				}
				NodeList a = element.getElementsByTagName("actores");
				Element actores = (a == null || a.getLength() == 0) ? null : (Element) a.item(0);
				if(actores != null) {
					NodeList lista = actores.getElementsByTagName("actor");
					if(lista == null || lista.getLength() == 0) break;
					List<String> nombres = new ArrayList<String> ();
					for(int j=0;j<lista.getLength();j++) {
						Element actor = (Element) lista.item(j);
						nombres.add(actor.getTextContent());
					}
					if(!nombres.isEmpty()) {
						p.setActores(nombres);
					}
				}
				c.addPelicula(p);
			}
		this.coleccion = c;
		return true;
		
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Coleccion getColeccion() {
		return coleccion != null ? coleccion : noFile();
	}
	
	public Coleccion noFile() {
		return coleccion = new Coleccion();
	}
	
	public void addPelicula(String nombre, String año, String director, String actores) {
		getColeccion().addPelicula(new Pelicula(nombre, año, director, actores));
	}

	public void addPelicula(Pelicula p) {
		getColeccion().addPelicula(p);
		
	}
	public void removePelicula(Pelicula p) {
		getColeccion().removePelicula(p);
	}
	public void removePelicula(int i) {
		getColeccion().removePelicula(i);
	}
	public Pelicula getPelicula(int i) {
		return getColeccion().getPeliculas().get(i);
	}
	public String getTitulo(int i) {
		return getPelicula(i).getTitulo();
	}
	public String getFecha(int i) {
		return getPelicula(i).getFecha();
	}
	public String getDirector(int i) {
		return getPelicula(i).getDirector();
	}
	public String getActores(int i) {
		if(getPelicula(i).getActores() != null) return String.join(",", getPelicula(i).getActores());
		else return "";
	}
	public boolean saveXML(String path) {
		path += path.endsWith(".xml") ?  "": ".xml" ;
		return write(path, getColeccion().getXML());
	}
	
	public boolean savePretty(String path) {
		path += path.endsWith(".txt") ?  "": ".txt" ;
		return write(path, getColeccion().getPrettyPrint()); 
	}
	
	private boolean write(String path, String text) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(text);
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} 
	}

	public void printPretty() {
		System.out.println(coleccion.getPrettyPrint());
	}

	
}
