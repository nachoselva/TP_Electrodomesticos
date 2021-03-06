package Logica;
import AccesoDatos.*;
import Entities.Electrodomestico;
import Entities.Lavarropas;

public class Logica_Lavarropas  extends Logica_Electrodomestico{

	public void actualizarLavarropas(int _Id, float _precio_base,float _peso , int _colorID, int _consumoID, String _descripcion, float _carga)
	{
		AccesoDatos_Lavarropas adaptador = new AccesoDatos_Lavarropas();
		Lavarropas lav = new Lavarropas(_Id,_precio_base, _peso, _colorID, _consumoID, _descripcion, _carga);
		adaptador.actualizarElectrodomestico(_Id, lav);
	}
	
	public int guardarLavarropas(String _precio_base_cadena,String _peso_cadena , int _colorID_valor, int _consumoID_valor, String _descripcion_cadena, String _carga_cadena)
	{
		AccesoDatos_Lavarropas adaptador = new AccesoDatos_Lavarropas();
		float _carga = 0;
		float _precioBase = 0;
		float _peso = 0;
		int _colorID = 0;
		int _consumoID = 0;
		String _descripcion = "";
		try
		{
			_precioBase = Float.parseFloat(_precio_base_cadena);
		}
		catch (Exception e)
		{
			_precioBase = Electrodomestico.precio_base_defecto;
		}
		try
		{
			_peso = Float.parseFloat(_peso_cadena);
		}
		catch (Exception e)
		{
			_peso = Electrodomestico.peso_defecto;
		}
		_colorID = _colorID_valor;
		_consumoID = _consumoID_valor;
		if(_descripcion_cadena.equals("") )
		{
			_descripcion = Electrodomestico.descripcion_defecto;
		}
		else
		{
			_descripcion = _descripcion_cadena;
		}
		try
		{
			_carga = Float.parseFloat(_carga_cadena);
		}
		catch (Exception e)
		{
			_carga = Lavarropas.carga_defecto;
		}
		Lavarropas lav = new Lavarropas(_precioBase, _peso, _colorID, _consumoID, _descripcion, _carga);
		return adaptador.GuardarElectrodomestico(lav);
	}
	
	public Lavarropas obtenerLavarropas(int ID)
	{
		AccesoDatos_Lavarropas adaptador = new AccesoDatos_Lavarropas();
		return adaptador.ObtenerLavarropas(ID);
	}
	
	public float getRecargoPorCarga(float carga)
	{
		float _precio = 0;
		if (carga > 30)
		{
			_precio = 50;
		}
		return _precio;
	}
	
	public float calcularPrecioFinal(int ID)
	{
		Lavarropas lav = this.obtenerLavarropas(ID);
		return lav.getPrecio_base()+this.getRecargoPorCarga(lav.getCarga())+ 
				this.getRecargoPorPeso(lav.getPeso()) + this.getRecargoPorConsumo(lav.getID());
	}
}
