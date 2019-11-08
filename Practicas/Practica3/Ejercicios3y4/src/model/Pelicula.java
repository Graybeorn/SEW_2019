package model;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {

	String nombre;
	String director;
	List<String> actores;
	String fecha;
	
	public Pelicula(String nombre, String fecha) {
		this.nombre = nombre;
		this.fecha = fecha;
	}
	
	public Pelicula(String nombre, String fecha, String director, List<String> actores) {
		this(nombre, fecha);
		if(!director.isBlank()) this.director = director;
		if(!actores.isEmpty()) this.actores = actores;
	}
	
	public Pelicula(String nombre, String fecha, String director, String actores) {
		this(nombre, fecha);
		if(!director.isBlank()) this.director = director;
		String[] act = actores.split(",");
		List<String> list = new ArrayList<String>();
		String s2;
		for(int i=0;i<act.length;i++) {
			s2 = act[i].trim();
			if(!s2.isBlank()) list.add(s2);
		}
		this.actores = list;
	}

	public String getTitulo() {
		return nombre;
	}
	public void setTitulo(String nombre) {
		this.nombre = nombre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public List<String> getActores() {
		return actores;
	}
	public void setActores(List<String> actores) {
		this.actores = actores;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String toXML() {
		String aux = "";
		if(this.getTitulo()!=null && this.getFecha()!=null) {
			aux+= "\t<pelicula>\n";
			aux+= "\t\t<titulo>" + this.getTitulo() + "</titulo>\n";
			aux+= "\t\t<fecha>" + this.getFecha().toString() + "</fecha>\n";
			if(this.getDirector()!=null && !this.getDirector().isBlank()) {
				aux+= "\t\t<director>" + this.getDirector() + "</director>\n";
			}
			if(this.getActores()!=null && !this.getActores().isEmpty()) {
				aux+= "\t\t<actores>\n";
				for(String s:actores) {
					aux+="\t\t\t<actor>" + s + "</actor>\n";
				}
				aux+= "\t\t</actores>\n";
			}
			aux+= "\t</pelicula>\n";
		}
		return aux;
	}
	
	public String getPrettyPrint() {
		String aux="";
		if(this.getTitulo()!=null && this.getFecha()!=null) {
			aux+= "* " + this.getTitulo() + "(" + this.getFecha().toString();
			if(this.getDirector()!=null && !this.getDirector().isBlank()) {
				aux+= ", dirigida por " + this.getDirector();
			}
			aux += ")\n";

			if(this.getActores()!=null && !this.getActores().isEmpty()) {
				aux+= " Reparto:\n";
				for(String s:actores) {
					aux+="\t - " + s + "\n";
				}
				aux+= "\n";
			}
		}
		return aux;
	}
	
}
