package clases;

public class Alumno {
	private String nombre;
	private String apellido;
	
	public Alumno(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getRutaFichero() {
		return nombre.toLowerCase() + "_" + apellido.toLowerCase() + ".txt";
	}

	@Override
	public String toString() {
		return nombre + " " + apellido;
	}
	
	
}
