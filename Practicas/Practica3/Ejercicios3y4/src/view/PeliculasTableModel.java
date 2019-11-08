package view;

import javax.swing.table.AbstractTableModel;

import controller.CollectionController;
import model.Pelicula;

public class PeliculasTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 2752935085172945719L;
	CollectionController c;
	String[] columnas = {"Titulo", "Año", "Director"};
	
	public PeliculasTableModel (CollectionController c) {
		this.c = c;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	@Override
	public int getRowCount() {
		return c.getColeccion().getPeliculas().size();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}
	
	@Override
	public String getColumnName(int i) {
		return columnas[i];
	}
	
	public Pelicula getPelicula(int i) {
		return c.getPelicula(i);
	}

	public void añadirPelicula(Pelicula p) {
		c.addPelicula(p);
		fireTableRowsUpdated(0, getRowCount());
	}
	
	public void eliminarPelicula(Pelicula p) {
		c.removePelicula(p);
		fireTableRowsUpdated(0, getRowCount());
	}
	
	public void eliminarPelicula(int i) {
		eliminarPelicula(getPelicula(i));
		fireTableRowsUpdated(0, getRowCount());
	}
	
	
	public void actualizarContenido() {
		fireTableRowsUpdated(0, getRowCount());
	}
	
	@Override
	public String getValueAt(int rowIndex, int columnIndex) {
		Pelicula p = c.getColeccion().getPeliculas().get(rowIndex);
		switch(columnIndex) {
		case 0:
			return p.getTitulo();
		case 1:
			return p.getFecha();
		case 2:
			return p.getDirector();
		default:
			return "";
		}
	}

}
