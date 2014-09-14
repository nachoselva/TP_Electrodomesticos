package Entidades;

public class Lavarropas extends Electrodomestico {
	private float carga;
	

	static final public float carga_defecto = 5;
	
	public Lavarropas(int _Id, float _precio_base,float _peso , int _colorID, int _consumoID, String _descripcion, float _carga)
	{
		super( _precio_base, _peso, _colorID, _consumoID, _descripcion);
		this.carga = _carga;
		this.setID(_Id);
	}
	public Lavarropas( float _precio_base,float _peso , int _colorID, int _consumoID, String _descripcion, float _carga)
	{
		super( _precio_base, _peso, _colorID, _consumoID, _descripcion);
		this.carga = _carga;
	}
	
	public Lavarropas( float _precio_base,float _peso, String _descripcion)
	{
		this( _precio_base, _peso, colorID_defecto, consumoID_defecto, _descripcion, carga_defecto);
	}
	
	public Lavarropas()
	{
		this(precio_base_defecto, peso_defecto, colorID_defecto, consumoID_defecto, descripcion_defecto , carga_defecto);
	}

	public float getCarga() {
		return carga;
	}

	public void setCarga(float carga) {
		this.carga = carga;
	}
	
	public float precioFinal()
	{
		if (this.carga > 30)
		{
			return super.precioFinal()+50;
		}
		else
		{
			return super.precioFinal();
		}
	}

}
