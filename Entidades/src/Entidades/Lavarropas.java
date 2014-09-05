package Entidades;

public class Lavarropas extends Electrodomestico {
	private float carga;
	static final float carga_defecto = 5;
	
	public Lavarropas(int _Id, boolean _estado, float _precio_base,float _peso , Colores _color, Tipos_Consumo _consumo, String _descripcion, float _carga)
	{
		super(_estado, _precio_base, _peso, _color, _consumo, _descripcion);
		this.carga = _carga;
		this.setID(_Id);
	}
	public Lavarropas(boolean _estado, float _precio_base,float _peso , Colores _color, Tipos_Consumo _consumo, String _descripcion, float _carga)
	{
		super(_estado, _precio_base, _peso, _color, _consumo, _descripcion);
		this.carga = _carga;
	}
	
	public Lavarropas(boolean _estado, float _precio_base,float _peso, String _descripcion)
	{
		this(_estado, _precio_base, _peso, color_defecto, consumo_defecto, _descripcion, carga_defecto);
	}
	
	public Lavarropas()
	{
		this(estado_defecto, precio_base_defecto, peso_defecto, color_defecto, consumo_defecto, descripcion_defecto , carga_defecto);
	}

	public float getCarga() {
		return carga;
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
