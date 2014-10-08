package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import Entities.Electrodomestico;
import Entities.Lavarropas;
import Entities.Television;
import Logica.CustomDataModel;
import Logica.Logica_Electrodomestico;
import Logica.Logica_Lavarropas;
import Logica.Logica_Televisor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JfrmLista{

	public JFrame frmElectrodomesticos;
	private JTable tblListado;
	private ArrayList<Electrodomestico> ListadoEntero = new Logica_Electrodomestico().ObtenerTodos();
	private ArrayList<Electrodomestico> ListadoParcial = new ArrayList<Electrodomestico>();
	private JTextField txtPrecioMin;
	private JTextField txtPrecioMax;
	private ArrayList<String> colores;
	private ArrayList<String> consumos;
	private JComboBox<String> cBoxConsumos;
	private JComboBox<String> cBoxColores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JfrmLista window = new JfrmLista();
					window.frmElectrodomesticos.setVisible(true);
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
		frmElectrodomesticos = new JFrame();
		frmElectrodomesticos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				recargarDatos();
			}
		});
		frmElectrodomesticos.setTitle("Electrodomesticos");
		frmElectrodomesticos.setBounds(100, 100, 736, 460);
		frmElectrodomesticos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmElectrodomesticos.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 139, 640, 234);
		frmElectrodomesticos.getContentPane().add(scrollPane);
		tblListado = new JTable();
		tblListado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(tblListado);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarLavarropas();
			}
		});
		btnModificar.setBounds(325, 387, 89, 23);
		frmElectrodomesticos.getContentPane().add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarElemento();
			}
		});
		btnBorrar.setBounds(576, 387, 89, 23);
		frmElectrodomesticos.getContentPane().add(btnBorrar);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JfrmAlta ventana = new JfrmAlta();
				ventana.frame.setVisible(true);
			}
		});
		btnAlta.setBounds(79, 387, 89, 23);
		frmElectrodomesticos.getContentPane().add(btnAlta);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recargarDatos();
			}
		});
		btnActualizar.setBounds(37, 33, 100, 28);
		frmElectrodomesticos.getContentPane().add(btnActualizar);
		
		JLabel lblPrecioMin = new JLabel("Precio Min");
		lblPrecioMin.setBounds(171, 11, 63, 14);
		frmElectrodomesticos.getContentPane().add(lblPrecioMin);
		
		JLabel lblPriceMax = new JLabel("Precio Max");
		lblPriceMax.setBounds(171, 40, 63, 14);
		frmElectrodomesticos.getContentPane().add(lblPriceMax);
		
		txtPrecioMin = new JTextField();
		txtPrecioMin.setBounds(244, 8, 86, 20);
		frmElectrodomesticos.getContentPane().add(txtPrecioMin);
		txtPrecioMin.setColumns(10);
		
		txtPrecioMax = new JTextField();
		txtPrecioMax.setBounds(244, 37, 86, 20);
		frmElectrodomesticos.getContentPane().add(txtPrecioMax);
		txtPrecioMax.setColumns(10);
		
		colores = new Logica_Electrodomestico().getTodosColores();
		colores.add(0, "sin filtro");
		consumos = new Logica_Electrodomestico().getTodosConsumos();
		consumos.add(0, "sin filtro");

		cBoxColores = new JComboBox<String>();
		String[] colores_array = colores.toArray(new String[colores.size()]);
		cBoxColores.setModel(new DefaultComboBoxModel<String>(colores_array));
		cBoxColores.setBounds(492, 37, 94, 20);
		frmElectrodomesticos.getContentPane().add(cBoxColores);
		
		
		cBoxConsumos = new JComboBox<String>();
		String[] consumos_array = consumos.toArray(new String[consumos.size()]);
		cBoxConsumos.setModel(new DefaultComboBoxModel<String>(consumos_array));
		cBoxConsumos.setBounds(492, 8, 94, 20);
		frmElectrodomesticos.getContentPane().add(cBoxConsumos);
		
		
		JLabel lblConsumo = new JLabel("Consumo");
		lblConsumo.setBounds(403, 11, 61, 14);
		frmElectrodomesticos.getContentPane().add(lblConsumo);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(403, 40, 61, 14);
		frmElectrodomesticos.getContentPane().add(lblColor);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recargarDatos();
				filtrarTabla();
				cargarTabla();
			}
		});
		btnFiltrar.setBounds(37, 72, 100, 37);
		frmElectrodomesticos.getContentPane().add(btnFiltrar);
	}
	
	private void cargarTabla()
	{
		CustomDataModel DataModel = new CustomDataModel();
		DataModel.setLista(ListadoParcial);
		tblListado.setModel(DataModel); 
	}
	
	private void filtrarTabla()
	{
		ListadoParcial = new ArrayList<Electrodomestico>();
		float precioMax = -1;
		if (!txtPrecioMax.getText().isEmpty())
		{
			precioMax = Float.parseFloat(txtPrecioMax.getText());
		}
		float precioMin = -1;
		if (!txtPrecioMin.getText().isEmpty())
		{
			precioMin = Float.parseFloat(txtPrecioMin.getText());
		}
		int colorID = colores.indexOf((String)this.cBoxColores.getSelectedItem()) + 1;
		int consID = consumos.indexOf((String)this.cBoxConsumos.getSelectedItem()) + 1;
		for(int x = 0; x < ListadoEntero.size(); x++)
		{
			Electrodomestico item = ListadoEntero.get(x);
			if (true)
			{
				if(item.getClass() == Lavarropas.class)
				{
					Logica_Lavarropas Adaptador = new Logica_Lavarropas();
					float precioFinal = Adaptador.calcularPrecioFinal(item.getID());
					if (precioMax == -1 || precioFinal < precioMax)
					{
						if  (precioMin == -1 || precioFinal > precioMin)
						{
							if(colorID == 1 || item.getColorID() == colorID - 1)
							{
								if(consID == 1 || item.getConsumoID() == consID - 1)
								{
									ListadoParcial.add(item);
								}
							}
						}
					}
				}
				else if (item.getClass() == Television.class)
				{
					Logica_Televisor AdaptadorTel = new Logica_Televisor();
					float precioFinalTel = AdaptadorTel.calcularPrecioFinal(item.getID());
					if (precioMax == -1 || precioFinalTel < precioMax)
					{
						if  (precioMin == -1 || precioFinalTel > precioMin)
						{
							if(colorID==1 || item.getColorID() == colorID - 1 )
							{
								if(consID == 1 || item.getConsumoID() == consID - 1)
								{
									ListadoParcial.add(item);
								}
							}
						}
					}
				
				}
			}
		}
	}
	
	private void borrarElemento() {
		Logica_Electrodomestico adaptador = new Logica_Electrodomestico();
		int _SelectedRow = tblListado.getSelectedRow();
		if(_SelectedRow != -1)
		{
		int _Id = (int)tblListado.getValueAt(_SelectedRow , 1);
		adaptador.borrarItem(_Id);
		this.recargarDatos();
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
		}
		
	}
	
	private void recargarDatos()
	{
		ListadoEntero = new Logica_Electrodomestico().ObtenerTodos();
		ListadoParcial = new ArrayList<Electrodomestico>();
		ListadoParcial.addAll(ListadoEntero);
		this.cargarTabla();
	}
}
