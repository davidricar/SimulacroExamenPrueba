package utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import clases.Alumno;
import clases.Asignatura;

public class Ficheros {
	public static ArrayList<Asignatura> cargarAsignaturas() {
		ArrayList<Asignatura> asignaturas = new ArrayList<>();
		try {
			FileReader fr = new FileReader("asignaturas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea != null) {
				String[] atributos = linea.split(";");
				asignaturas.add(new Asignatura(atributos[0]));
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return asignaturas;
	}
	public static ArrayList<Alumno> cargarAlumnos() {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		try {
			FileReader fr = new FileReader("alumnos.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea != null) {
				String[] atributos = linea.split(";");
				alumnos.add(new Alumno(atributos[0], atributos[1]));
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumnos;
	}
	public static ArrayList<Asignatura> cargarAsignaturasDeAlumno(Alumno alumno) {
		ArrayList<Asignatura> asignaturas = new ArrayList<>();
		try {
			FileReader fr = new FileReader(alumno.getRutaFichero());
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea != null) {
				String[] atributos = linea.split(";");
				asignaturas.add(new Asignatura(atributos[0]));
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return asignaturas;
	}
	public static void exportarAsignaturas(ArrayList<Asignatura> asignaturas) {
		try {
			FileWriter fw = new FileWriter("asignaturas.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			String contenido = "";
			for (int i = 0; i < asignaturas.size(); i++) {
				contenido += asignaturas.get(i).formatoFichero();
			}
			bw.write(contenido);
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void exportarAsignaturasDeAlumno(ArrayList<Asignatura> asignaturas, Alumno alumno) {
		try {
			FileWriter fw = new FileWriter(alumno.getRutaFichero());
			BufferedWriter bw = new BufferedWriter(fw);
			String contenido = "";
			for (int i = 0; i < asignaturas.size(); i++) {
				contenido += asignaturas.get(i).formatoFichero();
			}
			bw.write(contenido);
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
