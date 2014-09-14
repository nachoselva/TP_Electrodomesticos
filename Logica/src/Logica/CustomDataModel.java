package Logica;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import Entidades.*;

public class CustomDataModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Electrodomestico> Lista;
	
	public void setLista(ArrayList<Electrodomestico> lista) {
		Lista = lista;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 11;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return Lista.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Electrodomestico item = Lista.get(arg0);
		Object campo;
		switch(arg1)
		{
		case 0: {
				campo = item.getClass();
				if (item.getClass() == Television.class)
				{
					campo = "Television";
				}
				if (item.getClass() == Lavarropas.class)
				{
					campo = "Lavarropas";
				}
				}
				break;
		case 1: campo = item.getID();
				break;
		case 2: campo = item.getDescripcion();
				break;
		case 3: campo = item.getPrecio_base();
				break;
		case 4: campo = item.getConsumoID();
				break;
		case 5: campo = item.getColorID();
				break;
		case 6: campo = item.getPeso();
				break;
		case 7: if(item.getClass() == Lavarropas.class)
				{
					campo =((Lavarropas)item).getCarga();
				}
				else
				{
					campo = null;
				}
						
				break;
		case 8: if(item.getClass() == Television.class)
				{
				campo = ((Television)item).getResolucion();
				}
				else
				{
					campo = null;
				}
				break;
		case 9: if(item.getClass() == Television.class)
				{
					campo = ((Television)item).isSinTDT();
				}
				else
				{
					campo = null;
				}
				break;
		case 10: campo = item.getEstado();
				break;
		default: campo = null;
				break;
		}
		return campo;
	}
	
	@Override
	public String getColumnName(int columna) {
		String name = "";
		switch(columna)
		{
		case 0: name = "Clase";
				break;
		case 1: name = "ID";
				break;
		case 2: name = "Descripcion";
				break;
		case 3: name = "Precio Base";
				break;
		case 4: name = "ConsumoID";
				break;
		case 5: name = "ColorID";
				break;
		case 6: name = "Peso";
				break;
		case 7: name = "Carga";
				break;
		case 8: name = "Resolucion";
				break;
		case 9: name = "Sintonizador";
				break;
		case 10: name = "estado";
				break;
		default: name = null;
				break;
		}
		return name;
	}

}
