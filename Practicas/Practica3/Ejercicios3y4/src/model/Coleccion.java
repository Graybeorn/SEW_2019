package model;

import java.util.ArrayList;
import java.util.List;

public class Coleccion {
	
	List<Pelicula> peliculas;
	
	public Coleccion() {
		peliculas = new ArrayList<Pelicula>();
	}
	
	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	public List<Pelicula> getPeliculas(){
		return this.peliculas;
	}
	public void addPelicula(Pelicula pelicula) {
		peliculas.add(pelicula);
	}
	public void removePelicula(Pelicula pelicula) {
		peliculas.remove(pelicula);
	}
	public void removePelicula(int i) {
		peliculas.remove(i);
	}
	
	public String getXML() {
		String aux = "";
		aux+="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		aux+="<!DOCTYPE coleccion>\n";
		aux+="<coleccion>\n";
		if(this.getPeliculas() !=null) {
			for(Pelicula p:peliculas) {
				aux+=p.toXML();
			}
		}
		aux+="</coleccion>\n";
		return aux;
	}
	
	public String getPrettyPrint() {
		String aux = "";
		aux+= "-------------- Colección de películas --------------\n";
		if(this.getPeliculas() !=null) {
			for(Pelicula p:peliculas) {
				aux+=p.getPrettyPrint();
			}
		}
		
		return aux;
	}
}
