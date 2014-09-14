package Logica;

import AccesoDatos.AccesoDatos_Electrodomestico;
import AccesoDatos.AccesoDatos_Television;
import Entidades.Television;

public class Logica_Televisor  {
	
	public int guardarTelevisor(boolean _estado, float _precio_base,float _peso , int _colorID, int _consumoID, String _descripcion, int _resolucion, boolean _sinTDT)
	{
		AccesoDatos_Television adaptador = new AccesoDatos_Television();
		Television tel = new Television(_estado, _precio_base, _peso, _colorID, _consumoID, _descripcion, _resolucion, _sinTDT);
		return adaptador.GuardarElectrodomestico(tel);
	}
	
	public int actualizarTelevisor(int _Id, boolean _estado, float _precio_base,float _peso , int _colorID, int _consumoID, String _descripcion, int _resolucion, boolean _sinTDT)
	{
		AccesoDatos_Electrodomestico adaptador = new AccesoDatos_Electrodomestico();
		Television tel = new Television(_estado, _precio_base, _peso, _colorID, _consumoID, _descripcion, _resolucion, _sinTDT);
		tel.setID(_Id);
		return 0;
	}
}
