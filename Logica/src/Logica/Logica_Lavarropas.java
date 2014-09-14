package Logica;
import AccesoDatos.*;
import Entidades.Lavarropas;

public class Logica_Lavarropas  {

	public int guardarLavarropas(boolean _estado, float _precio_base,float _peso , int _colorID, int _consumoID, String _descripcion, float _carga)
	{
		AccesoDatos_Lavarropas adaptador = new AccesoDatos_Lavarropas();
		Lavarropas lav = new Lavarropas(_estado, _precio_base, _peso, _colorID, _consumoID, _descripcion, _carga);
		return adaptador.GuardarElectrodomestico(lav);
	}
	
	public void actualizarLavarropas(int _Id, boolean _estado, float _precio_base,float _peso , int _colorID, int _consumoID, String _descripcion, float _carga)
	{
		AccesoDatos_Lavarropas adaptador = new AccesoDatos_Lavarropas();
		Lavarropas lav = new Lavarropas(_Id, _estado, _precio_base, _peso, _colorID, _consumoID, _descripcion, _carga);
		adaptador.actualizarElectrodomestico(_Id, lav);
	}
}
