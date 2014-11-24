package Ventanas;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import Entities.Electrodomestico;
import Entities.Lavarropas;
import Entities.Television;
import Logica.Logica_Electrodomestico;
import Logica.Logica_Lavarropas;
import Logica.Logica_Televisor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.JTextPane;

public class JfrmAlta {

	public JFrame frame;
	private JTextField txtPrecioBase;
	private JTextField txtPeso;
	private JTextField txtCarga;
	private JTextField txtResolucion;
	private JCheckBox chbSintonizadorTDT;
	private JComboBox<String> cboxColores;
	private JComboBox<String> cboxConsEner;
	private JRadioButton rbtnLavarropas;
	private JRadioButton rbtnTelevision;
	private JButton btnAlta;
	private JTextPane txtpDescrpcion;
	private JButton btnActualizar;
	private JTextField txtID;
	private JLabel lblID;
	private ArrayList<String> colores = new Logica_Electrodomestico().getTodosColores();
	private ArrayList<String> consumos = new Logica_Electrodomestico().getTodosConsumos();

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	/**
		 * @wbp.parser.constructor
		 */

	public JfrmAlta() {
		
		initialize();
		this.frame.setTitle("Alta");
		btnAlta = new JButton("Alta");
		btnAlta.setEnabled(false);
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarElectrodomestico();
			}
		});
		btnAlta.setBounds(10, 353, 89, 23);
		frame.getContentPane().add(btnAlta);
		this.btnAlta.setEnabled(true);
	}


	
	public JfrmAlta(int _Id) {
		
		initialize();
		this.frame.setTitle("Modificacion");
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setEditable(false);
		txtID.setBounds(304, 8, 86, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		lblID = new JLabel("ID");
		lblID.setBounds(283, 11, 11, 14);
		frame.getContentPane().add(lblID);
		this.txtID.setText(Integer.toString(_Id));
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarElectrodomestico();
			}
		});
		btnActualizar.setEnabled(true);
		btnActualizar.setBounds(10, 353, 100, 23);
		frame.getContentPane().add(btnActualizar);
		Electrodomestico item = new Logica_Electrodomestico().obtenerItem(_Id);
		this.txtPrecioBase.setText(String.valueOf(item.getPrecio_base()));
		this.txtPeso.setText(String.valueOf(item.getPeso()));
		this.cboxColores.setSelectedIndex(item.getColorID()-1);
		this.cboxConsEner.setSelectedIndex(item.getConsumoID()-1);
		this.txtpDescrpcion.setText(item.getDescripcion());
		if(item.getClass() == Television.class)
		{
			this.txtResolucion.setText(String.valueOf(((Television)item).getResolucion()));
			this.chbSintonizadorTDT.setSelected((((Television)item).isSinTDT()));
			this.rbtnLavarropas.setSelected(false);
			this.rbtnTelevision.setSelected(true);
			this.rbtnTelevision.setEnabled(false);
			this.rbtnLavarropas.setEnabled(false);
		}
		else if (item.getClass() == Lavarropas.class)
		{
			this.txtCarga.setText(String.valueOf(((Lavarropas)item).getCarga()));
			this.rbtnLavarropas.setSelected(true);
			this.rbtnTelevision.setSelected(false);
			this.rbtnTelevision.setEnabled(false);
			this.rbtnLavarropas.setEnabled(false);
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 447, 426);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ButtonGroup grupoTiposElectrodomesticos = new ButtonGroup();
		
		rbtnLavarropas = new JRadioButton("Lavarropas");
		rbtnLavarropas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (rbtnLavarropas.isSelected())
				{
					activarElementosLavarropas();
				}
			}

			
		});
		rbtnLavarropas.setBounds(29, 7, 109, 23);
		frame.getContentPane().add(rbtnLavarropas);
		
		rbtnTelevision = new JRadioButton("Television");
		rbtnTelevision.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rbtnTelevision.isSelected())
				{
					activarElementosTelevisor();
				}
			}
		});
		rbtnTelevision.setBounds(165, 7, 109, 23);
		frame.getContentPane().add(rbtnTelevision);
		
		grupoTiposElectrodomesticos.add(rbtnLavarropas);
		grupoTiposElectrodomesticos.add(rbtnTelevision);
		
		
		txtPrecioBase = new JTextField();
		txtPrecioBase.setEnabled(false);
		txtPrecioBase.setBounds(107, 81, 86, 20);
		frame.getContentPane().add(txtPrecioBase);
		txtPrecioBase.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setEnabled(false);
		txtPeso.setBounds(107, 148, 86, 20);
		frame.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		txtCarga = new JTextField();
		txtCarga.setEnabled(false);
		txtCarga.setBounds(304, 81, 86, 20);
		frame.getContentPane().add(txtCarga);
		txtCarga.setColumns(10);
		
		txtResolucion = new JTextField();
		txtResolucion.setEnabled(false);
		txtResolucion.setBounds(304, 148, 86, 20);
		frame.getContentPane().add(txtResolucion);
		txtResolucion.setColumns(10);
		
		chbSintonizadorTDT = new JCheckBox("Sintonizador TDT");
		chbSintonizadorTDT.setEnabled(false);
		chbSintonizadorTDT.setBounds(263, 175, 127, 23);
		frame.getContentPane().add(chbSintonizadorTDT);
		
		
		
		cboxColores = new JComboBox<String>();
		cboxColores.setEnabled(false);
		String[] colores_array = colores.toArray(new String[colores.size()]);
		cboxColores.setModel(new DefaultComboBoxModel<String>(colores_array));
		cboxColores.setBounds(107, 202, 86, 23);
		frame.getContentPane().add(cboxColores);
		
		
		cboxConsEner = new JComboBox<String>();
		cboxConsEner.setEnabled(false);
		String[] consumos_array = consumos.toArray(new String[consumos.size()]);
		cboxConsEner.setModel(new DefaultComboBoxModel<String>(consumos_array));
		cboxConsEner.setBounds(138, 257, 55, 20);
		frame.getContentPane().add(cboxConsEner);
		
		JLabel lblPrecioBase = new JLabel("Precio Base");
		lblPrecioBase.setBounds(10, 84, 87, 14);
		frame.getContentPane().add(lblPrecioBase);
		
		JLabel lblNewLabel_3 = new JLabel("Peso");
		lblNewLabel_3.setBounds(10, 151, 87, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(10, 206, 87, 14);
		frame.getContentPane().add(lblColor);
		
		JLabel lblConsumo = new JLabel("Consumo");
		lblConsumo.setBounds(10, 260, 87, 14);
		frame.getContentPane().add(lblConsumo);
		
		JLabel lblResolucion = new JLabel("Resolucion");
		lblResolucion.setBounds(219, 151, 75, 14);
		frame.getContentPane().add(lblResolucion);
		
		JLabel lblCarga = new JLabel("Carga");
		lblCarga.setBounds(219, 81, 75, 14);
		frame.getContentPane().add(lblCarga);
		
		txtpDescrpcion = new JTextPane();
		txtpDescrpcion.setEnabled(false);
		txtpDescrpcion.setBounds(219, 257, 202, 80);
		frame.getContentPane().add(txtpDescrpcion);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(219, 232, 60, 14);
		frame.getContentPane().add(lblDescripcion);
		
	}
	
	private void guardarLavarropas()
	{
		Logica_Lavarropas adaptador = new Logica_Lavarropas();
		String _precioBase = this.txtPrecioBase.getText();
		String _peso = this.txtPeso.getText();
		int _colorID = colores.indexOf((String)this.cboxColores.getSelectedItem()) + 1;
		int _consumoID = consumos.indexOf((String)this.cboxConsEner.getSelectedItem()) + 1;
		String _descripcion = this.txtpDescrpcion.getText();
		String _carga = this.txtCarga.getText();
		if (_precioBase.equals("") || _peso.equals("") || _descripcion.equals("") || _carga.equals(""))
		{
			int a = JOptionPane.showConfirmDialog(this.frame, "Desea Autocompletar campos vacios con valores por defecto?","Autocompletar", JOptionPane.YES_NO_OPTION);
			if(a == 0)
			{
				if (this.verificarFormato())
				{
				confirmarLavarropas(adaptador, _precioBase, _peso, _colorID,
						_consumoID, _descripcion, _carga);
				}
			}
		}
		else
		{	if (this.verificarFormato())
			{
			confirmarLavarropas(adaptador, _precioBase, _peso, _colorID,
					_consumoID, _descripcion, _carga);
			}
		}
	}

	private void confirmarLavarropas(Logica_Lavarropas adaptador,
			String _precioBase, String _peso, int _colorID, int _consumoID,
			String _descripcion, String _carga) {
			int _id = adaptador.guardarLavarropas(_precioBase, _peso, _colorID, _consumoID, _descripcion, _carga);
			Electrodomestico lav = adaptador.obtenerItem(_id);
			String mensaje = String.format("Item Correctamente Cargado \n%s\nID: %s \nDescripcion: %s \n"
					+ "Precio Base: %s \nPeso: %s \nColor: %s \nConsumo: %s\n"
					+ "Carga: %s \n", 
					"Television", lav.getID(), lav.getDescripcion(), lav.getPrecio_base(), lav.getPeso(), colores.get(lav.getColorID()-1) , consumos.get(lav.getConsumoID()-1), ((Lavarropas)lav).getCarga());
			JOptionPane.showMessageDialog(this.frame, mensaje, "Titulo", 1);
			this.frame.setVisible(false);
	}
	
	private void guardarTelevision()
	{
		Logica_Televisor adaptador = new Logica_Televisor();
		String _precioBase = this.txtPrecioBase.getText();
		String _peso = this.txtPeso.getText();
		int _colorID = colores.indexOf((String)this.cboxColores.getSelectedItem()) + 1;
		int _consumoID = consumos.indexOf((String)this.cboxConsEner.getSelectedItem()) + 1;
		String _descripcion = this.txtpDescrpcion.getText();
		String _resolucion = this.txtResolucion.getText();
		boolean _sinTDT = this.chbSintonizadorTDT.isSelected();
		if (_precioBase.equals("") || _peso.equals("") || _descripcion.equals("") || _resolucion.equals(""))
		{
			int a = JOptionPane.showConfirmDialog(this.frame, "Desea Autocompletar campos vacios con valores por defecto?","Autocompletar", JOptionPane.YES_NO_OPTION);
			if(a == 0)
			{
				if (this.verificarFormato())
				{
				confirmarTelevision(adaptador, _precioBase, _peso, _colorID,
						_consumoID, _descripcion, _resolucion, _sinTDT);
				}
			}
		}
		else
			{
				if (this.verificarFormato())
				{
				confirmarTelevision(adaptador, _precioBase, _peso, _colorID,
						_consumoID, _descripcion, _resolucion, _sinTDT);
				}
			}
	}

	private void confirmarTelevision(Logica_Televisor adaptador,
			String _precioBase, String _peso, int _colorID, int _consumoID,
			String _descripcion, String _resolucion, boolean _sinTDT) {
		int _id = adaptador.guardarTelevision(_precioBase, _peso, _colorID, _consumoID, _descripcion, _resolucion, _sinTDT);
		Electrodomestico tel = adaptador.obtenerItem(_id);
		String mensaje = String.format("Item Correctamente Cargado \n%s\nID: %s \nDescripcion: %s \n"
				+ "Precio Base: %s \nPeso: %s \nColor: %s \nConsumo: %s\n"
				+ "Resolucion: %s \nSintonizador: %s\n", 
				"Television", tel.getID(), tel.getDescripcion(), tel.getPrecio_base(), tel.getPeso(), colores.get(tel.getColorID()-1) , consumos.get(tel.getConsumoID()-1), ((Television)tel).getResolucion(), ((Television)tel).isSinTDT());
		JOptionPane.showMessageDialog(this.frame, mensaje, "Titulo", 1);
		this.frame.setVisible(false);
	}
	
	private void guardarElectrodomestico()
	{
		if(this.rbtnLavarropas.isSelected())
			this.guardarLavarropas();
		if(this.rbtnTelevision.isSelected())
			this.guardarTelevision();
	}
	
	private boolean verificarFormato()
	{
		boolean bandera;
		try
		{
			if(!this.txtPrecioBase.getText().isEmpty())
			{
				Float.parseFloat(this.txtPrecioBase.getText());
			}
			if(!this.txtPeso.getText().isEmpty())
			{
				Float.parseFloat(this.txtPeso.getText());
			}
			if (this.rbtnTelevision.isSelected())
			{
				if (!this.txtResolucion.getText().isEmpty())
					{
					Integer.parseInt(this.txtResolucion.getText());
					}
			}
			else if (this.rbtnLavarropas.isSelected())
			{
				if(!this.txtCarga.getText().isEmpty())
				{
					Float.parseFloat(this.txtCarga.getText());
				}
			}
			bandera = true;
		}
		catch (Exception e)
		{
			bandera = false;
			JOptionPane.showMessageDialog(this.frame, "Verificar Formatos de Entrada", "ERROR", 2 );
		}
		return bandera;
	}
	private void activarElementosLavarropas() {
		activarElementosElectrodomesticos();
		desactivarElementosParticulares();
		this.txtCarga.setEnabled(true);
	}
	
	private void activarElementosTelevisor() {
		activarElementosElectrodomesticos();
		desactivarElementosParticulares();
		this.chbSintonizadorTDT.setEnabled(true);
		this.txtResolucion.setEnabled(true);
	}

	private void activarElementosElectrodomesticos() {
		this.txtPrecioBase.setEnabled(true);
		this.txtPeso.setEnabled(true);
		this.cboxColores.setEnabled(true);
		this.cboxConsEner.setEnabled(true);
		this.txtpDescrpcion.setEnabled(true);
	}
	
	private void desactivarElementosParticulares()
	{
		this.chbSintonizadorTDT.setEnabled(false);
		this.txtResolucion.setEnabled(false);
		this.txtCarga.setEnabled(false);
	}
	
	private void actualizarElectrodomestico() {
		if(this.rbtnLavarropas.isSelected())
			this.actualizarLavarropas();
		if(this.rbtnTelevision.isSelected())
			this.actualizarTelevisor();
	}

	private void actualizarTelevisor() {
		if (this.verificarFormato())
		{
			Logica_Televisor adaptador = new Logica_Televisor();
			int _Id = Integer.parseInt(this.txtID.getText());
			float _precioBase = Float.parseFloat(this.txtPrecioBase.getText());
			float _peso = Float.parseFloat(this.txtPeso.getText());
			int _colorID = colores.indexOf((String)this.cboxColores.getSelectedItem()) + 1;
			int _consumoID = consumos.indexOf((String)this.cboxConsEner.getSelectedItem()) + 1;
			String _descripcion = this.txtpDescrpcion.getText();
			int _resolucion = Integer.parseInt(this.txtResolucion.getText());
			boolean _sinTDT = this.chbSintonizadorTDT.isSelected();
			adaptador.actualizarTelevisor(_Id, _precioBase, _peso, _colorID, _consumoID, _descripcion, _resolucion, _sinTDT);
			this.frame.setVisible(false);
		}
	}

	private void actualizarLavarropas() {
		{
		if (this.verificarFormato())
		{
			Logica_Lavarropas adaptador = new Logica_Lavarropas();
			int _Id = Integer.parseInt(this.txtID.getText());
			float _precioBase = Float.parseFloat(this.txtPrecioBase.getText());
			float _peso = Float.parseFloat(this.txtPeso.getText());
			int _colorID = colores.indexOf((String)this.cboxColores.getSelectedItem()) + 1;
			int _consumoID = consumos.indexOf((String)this.cboxConsEner.getSelectedItem()) + 1;
			String _descripcion = this.txtpDescrpcion.getText();
			float _carga = Float.parseFloat(this.txtCarga.getText());
			if (this.verificarFormato())
			adaptador.actualizarLavarropas(_Id, _precioBase, _peso, _colorID, _consumoID, _descripcion, _carga);
			this.frame.setVisible(false);
		}
		}
	}
}
