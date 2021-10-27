package ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Alumno;
import clases.Asignatura;
import utilidades.Ficheros;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alumnos extends JFrame {

	private JPanel contentPane;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Asignatura> asignaturas;
	private ArrayList<Asignatura> asignaturas_alumno;
	

	/**
	 * Create the frame.
	 */
	public Alumnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 69, 160, 263);
		contentPane.add(scrollPane);
		
		alumnos = Ficheros.cargarAlumnos();
		DefaultListModel model = new DefaultListModel<>();
		for (int i = 0; i < alumnos.size(); i++) {
			model.add(i, alumnos.get(i));
		}
		
		JList list = new JList(model);
		
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(238, 69, 160, 263);
		contentPane.add(scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblAlumnos = new JLabel("Alumnos");
		lblAlumnos.setBounds(37, 41, 61, 16);
		contentPane.add(lblAlumnos);
		
		JLabel lblAsignaturas = new JLabel("Asignaturas");
		lblAsignaturas.setBounds(238, 41, 84, 16);
		contentPane.add(lblAsignaturas);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(430, 67, 160, 27);
		contentPane.add(comboBox);
		asignaturas = Ficheros.cargarAsignaturas();
		for (int i = 0; i < asignaturas.size(); i++) {
			comboBox.addItem(asignaturas.get(i));
		}
		
		JButton btnAnadirAsignatura = new JButton("Añadir Asignatura");
		btnAnadirAsignatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignaturas_alumno.add((Asignatura) comboBox.getSelectedItem());
				//Actualizo el JList
				DefaultListModel model = new DefaultListModel<>();
				for (int j = 0; j < asignaturas_alumno.size(); j++) {
					model.add(j, asignaturas_alumno.get(j));
				}
				list_1.setModel(model);
				//Actualizar el fichero
				Ficheros.exportarAsignaturasDeAlumno(asignaturas_alumno, (Alumno) list.getSelectedValue());
			}
		});
		btnAnadirAsignatura.setEnabled(false);
		btnAnadirAsignatura.setBounds(430, 101, 160, 29);
		contentPane.add(btnAnadirAsignatura);
		
		JButton btnEliminarAsignatura = new JButton("Eliminar Asignatura");
		btnEliminarAsignatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignaturas_alumno.remove(list_1.getSelectedIndex());
				//Actualizo el JList
				DefaultListModel model = new DefaultListModel<>();
				for (int j = 0; j < asignaturas_alumno.size(); j++) {
					model.add(j, asignaturas_alumno.get(j));
				}
				list_1.setModel(model);
				//Actualizar el fichero
				Ficheros.exportarAsignaturasDeAlumno(asignaturas_alumno, (Alumno) list.getSelectedValue());
			}
		});
		btnEliminarAsignatura.setEnabled(false);
		btnEliminarAsignatura.setBounds(430, 167, 160, 29);
		contentPane.add(btnEliminarAsignatura);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnAnadirAsignatura.setEnabled(true);
				btnEliminarAsignatura.setEnabled(false);
				asignaturas_alumno = Ficheros.cargarAsignaturasDeAlumno((Alumno) list.getSelectedValue());
				//Actualizo el JList
				DefaultListModel model = new DefaultListModel<>();
				for (int j = 0; j < asignaturas_alumno.size(); j++) {
					model.add(j, asignaturas_alumno.get(j));
				}
				list_1.setModel(model);
			}
		});
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnEliminarAsignatura.setEnabled(true);
			}
		});
	}
}
