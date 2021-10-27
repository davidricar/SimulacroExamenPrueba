package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAsignaturas = new JButton("Asignaturas");
		btnAsignaturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame nuevaVentana = new Asignaturas();
				nuevaVentana.setVisible(true);
				dispose();
			}
		});
		btnAsignaturas.setBounds(181, 154, 117, 29);
		contentPane.add(btnAsignaturas);
		
		JButton btnAlumnos = new JButton("Alumnos");
		btnAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame nuevaVentana = new Alumnos();
				nuevaVentana.setVisible(true);
				dispose();
			}
		});
		btnAlumnos.setBounds(181, 196, 117, 29);
		contentPane.add(btnAlumnos);
		
		JLabel lblAcademia = new JLabel("Academia");
		lblAcademia.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAcademia.setBounds(192, 75, 95, 19);
		contentPane.add(lblAcademia);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(202, 276, 75, 29);
		contentPane.add(btnSalir);
	}

}
