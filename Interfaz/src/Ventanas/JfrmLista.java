package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import Entidades.Electrodomestico;
import Logica.CustomDataModel;
import Logica.Logica_Electrodomestico;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class JfrmLista{

	public JFrame frame;
	private JTable tblListado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JfrmLista window = new JfrmLista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JfrmLista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 657, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 72, 567, 203);
		frame.getContentPane().add(scrollPane);
		tblListado = new JTable();
		tblListado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(tblListado);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarLavarropas();
			}
		});
		btnModificar.setBounds(254, 286, 89, 23);
		frame.getContentPane().add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarElemento();
			}
		});
		btnBorrar.setBounds(390, 286, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JfrmAlta ventana = new JfrmAlta();
				ventana.frame.setVisible(true);
			}
		});
		btnAlta.setBounds(110, 286, 89, 23);
		frame.getContentPane().add(btnAlta);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarTabla();
			}
		});
		btnActualizar.setBounds(37, 11, 100, 28);
		frame.getContentPane().add(btnActualizar);
	}
	
	private void cargarTabla()
	{
		CustomDataModel DataModel = new CustomDataModel();
		ArrayList<Electrodomestico> a = new Logica_Electrodomestico().ObtenerTodos();
		DataModel.setLista(a);
		tblListado.setModel(DataModel); 
	}
	
	private void borrarElemento() {
		Logica_Electrodomestico adaptador = new Logica_Electrodomestico();
		int _SelectedRow = tblListado.getSelectedRow();
		if(_SelectedRow != -1)
		{
		int _Id = (int)tblListado.getValueAt(_SelectedRow , 1);
		adaptador.borrarItem(_Id);
		this.cargarTabla();
		}
	}
	
	private void modificarLavarropas()
	{
		int _SelectedRow = tblListado.getSelectedRow();
		if(_SelectedRow != -1)
		{
		int _Id = (int)tblListado.getValueAt(_SelectedRow , 1);
		JfrmAlta ventana = new JfrmAlta(_Id);
		ventana.frame.setVisible(true);
		this.cargarTabla();
		}
		
	}
}
