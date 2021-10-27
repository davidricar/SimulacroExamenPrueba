package clases;

import interfaces.I_FormatoFichero;

public class Asignatura implements I_FormatoFichero {
	private String nombre;

	public Asignatura(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String formatoFichero() {
		return nombre + "\n";
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
}
