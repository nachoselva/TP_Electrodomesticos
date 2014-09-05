package Logica;

import java.util.ArrayList;

import AccesoDatos.AccesoDatos_Electrodomestico;
import Entidades.Electrodomestico;

public class Logica_Electrodomestico {
	
	public ArrayList<Electrodomestico> ObtenerTodos()
	{
		AccesoDatos_Electrodomestico adaptador = new AccesoDatos_Electrodomestico();
		return adaptador.ObtenerTodos();
	}
	
	public void borrarItem(int _Id)
	{
		AccesoDatos_Electrodomestico adaptador = new AccesoDatos_Electrodomestico();
		adaptador.borrarItem(_Id);
	}

}
