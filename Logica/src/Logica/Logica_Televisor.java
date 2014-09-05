package Logica;

import AccesoDatos.AccesoDatos_Electrodomestico;
import Entidades.Electrodomestico.*;
import Entidades.Television;

public class Logica_Televisor  {
	
	public void guardarTelevisor(boolean _estado, float _precio_base,float _peso , Colores _color, Tipos_Consumo _consumo, String _descripcion, int _resolucion, boolean _sinTDT)
	{
		AccesoDatos_Electrodomestico adaptador = new AccesoDatos_Electrodomestico();
		Television tel = new Television(_estado, _precio_base, _peso, _color, _consumo, _descripcion, _resolucion, _sinTDT);
		adaptador.GuardarElectrodomestico(tel);
	}
	
	public void actualizarTelevisor(int _Id, boolean _estado, float _precio_base,float _peso , Colores _color, Tipos_Consumo _consumo, String _descripcion, int _resolucion, boolean _sinTDT)
	{
		AccesoDatos_Electrodomestico adaptador = new AccesoDatos_Electrodomestico();
		Television tel = new Television(_estado, _precio_base, _peso, _color, _consumo, _descripcion, _resolucion, _sinTDT);
		tel.setID(_Id);
		adaptador.GuardarElectrodomestico(tel);
	}
}
