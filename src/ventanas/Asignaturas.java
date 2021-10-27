package ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Asignatura;
import utilidades.Ficheros;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Asignaturas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<Asignatura> asignaturas;

	/**
	 * Create the frame.
	 */
	public Asignaturas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		
		textField.setBounds(25, 16, 178, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.setBounds(215, 16, 117, 29);
		contentPane.add(btnAnadir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 95, 300, 327);
		contentPane.add(scrollPane);
		
		asignaturas = Ficheros.cargarAsignaturas();
		DefaultListModel model = new DefaultListModel<>();
		for (int i = 0; i < asignaturas.size(); i++) {
			model.add(i, asignaturas.get(i));
		}
		
		JList list = new JList(model);
		
		scrollPane.setViewportView(list);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = list.getSelectedIndex();
				asignaturas.remove(i);
				//Actualizo el JList
				DefaultListModel model = new DefaultListModel<>();
				for (int j = 0; j < asignaturas.size(); j++) {
					model.add(j, asignaturas.get(j));
				}
				list.setModel(model);
				//Guardo los cambios en el fichero
				Ficheros.exportarAsignaturas(asignaturas);
				btnEliminar.setEnabled(false);
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(215, 57, 117, 29);
		contentPane.add(btnEliminar);
		
		JLabel lblAsignaturas = new JLabel("Asignaturas");
		lblAsignaturas.setBounds(25, 67, 101, 16);
		contentPane.add(lblAsignaturas);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnEliminar.setEnabled(true);
			}
		});
		
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String asignatura = textField.getText();
				if(asignatura.equals("")) {
					JOptionPane.showMessageDialog(Asignaturas.this, "Rellene el campo");
				} else {
					asignaturas.add(new Asignatura(asignatura));
					DefaultListModel model = new DefaultListModel<>();
					for (int i = 0; i < asignaturas.size(); i++) {
						model.add(i, asignaturas.get(i));
					}
					list.setModel(model);
					Ficheros.exportarAsignaturas(asignaturas);
					textField.setText("");
				}
			}
		});
	}
}
