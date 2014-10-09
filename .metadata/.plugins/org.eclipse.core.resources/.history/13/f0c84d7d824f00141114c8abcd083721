package Logica;
import AccesoDatos.AccesoDatos_Lavarropas;
import AccesoDatos.AccesoDatos_Television;
import Entities.Electrodomestico;
import Entities.Lavarropas;
import Entities.Television;

public class Logica_Televisor  extends Logica_Electrodomestico{
	
	public int guardarTelevisor( float _precio_base,float _peso , int _colorID, int _consumoID, String _descripcion, int _resolucion, boolean _sinTDT)
	{
		AccesoDatos_Television adaptador = new AccesoDatos_Television();
		Television tel = new Television( _precio_base, _peso, _colorID, _consumoID, _descripcion, _resolucion, _sinTDT);
		return adaptador.GuardarElectrodomestico(tel);
	}
	
	public void actualizarTelevisor(int _Id, float _precio_base,float _peso , int _colorID, int _consumoID, String _descripcion, int _resolucion, boolean _sinTDT)
	{
		AccesoDatos_Television adaptador = new AccesoDatos_Television();
		Television tel = new Television( _precio_base, _peso, _colorID, _consumoID, _descripcion, _resolucion, _sinTDT);
		adaptador.actualizarElectrodomestico(_Id, tel);
	}
	
	public int guardarTelevision(String _precio_base_cadena,String _peso_cadena , int _colorID_valor, int _consumoID_valor, String _descripcion_cadena, String _resolucion_cadena, boolean _sintonizador_valor)
	{
		AccesoDatos_Television adaptador = new AccesoDatos_Television();
		float _precioBase = 0;
		float _peso = 0;
		int _colorID = 0;
		int _consumoID = 0;
		int _resolucion = 0;
		boolean _sintonizador = true;
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
		if(!_descripcion_cadena.equals(""))
		{
			_descripcion = _descripcion_cadena;
		}
		else
		{
			_descripcion = Electrodomestico.descripcion_defecto;
		}
		try
		{
			_resolucion = Integer.parseInt(_resolucion_cadena);
		}
		catch (Exception e)
		{
			_resolucion = Television.resolucion_defecto;
		}
		_sintonizador = _sintonizador_valor;
		Television lav = new Television(_precioBase, _peso, _colorID, _consumoID, _descripcion, _resolucion, _sintonizador);
		return adaptador.GuardarElectrodomestico(lav);
	}
	
	public Television obtenerTelevisor(int ID)
	{
		AccesoDatos_Television adaptador = new AccesoDatos_Television();
		return adaptador.ObtenerTelevision(ID);
	}
	
	public float getRecargoPorResolucionYSint(int res, boolean sint, float price)
	{
		float _precio = 0;
		if (res > 40)
		{
			_precio += price*(3/10);
		}
		if (sint)
		{
			_precio += 50;
		}
		return _precio;
	}
	
	public float calcularPrecioFinal(int ID)
	{
		Television tel = this.obtenerTelevisor(ID);
		return tel.getPrecio_base()+this.getRecargoPorResolucionYSint(tel.getResolucion(), tel.isSinTDT(), tel.getPrecio_base())+ 
				this.getRecargoPorPeso(tel.getPeso()) + this.getRecargoPorConsumo(tel.getID());
	}
}
