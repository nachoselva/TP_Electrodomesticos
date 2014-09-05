package Logica;
import AccesoDatos.*;
import Entidades.Electrodomestico.Colores;
import Entidades.Electrodomestico.Tipos_Consumo;
import Entidades.Lavarropas;

public class Logica_Lavarropas  {

	public void guardarLavarropas(boolean _estado, float _precio_base,float _peso , Colores _color, Tipos_Consumo _consumo, String _descripcion, float _carga)
	{
		AccesoDatos_Electrodomestico adaptador = new AccesoDatos_Electrodomestico();
		Lavarropas lav = new Lavarropas(_estado, _precio_base, _peso, _color, _consumo, _descripcion, _carga);
		adaptador.GuardarElectrodomestico(lav);
	}
	
	public void actualizarLavarropas(int _Id, boolean _estado, float _precio_base,float _peso , Colores _color, Tipos_Consumo _consumo, String _descripcion, float _carga)
	{
		AccesoDatos_Electrodomestico adaptador = new AccesoDatos_Electrodomestico();
		Lavarropas lav = new Lavarropas(_Id, _estado, _precio_base, _peso, _color, _consumo, _descripcion, _carga);
		lav.setID(_Id);
		adaptador.GuardarElectrodomestico(lav);
	}
}