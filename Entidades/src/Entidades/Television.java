package Entidades;

public class Television extends Electrodomestico {
	private int resolucion;
	private boolean sinTDT;
	
	static final int resolucion_defecto = 20;
	static final boolean sinTDT_defecto = false;
	
	public Television(boolean _estado, float _precio_base,float _peso , Colores _color, Tipos_Consumo _consumo, String _descripcion, int _resolucion, boolean _sinTDT)
	{
		super(_estado, _precio_base, _peso, _color, _consumo, _descripcion);
		this.resolucion = _resolucion;
		this.sinTDT = _sinTDT;
	}
	
	public Television(float _precio_base,float _peso, String _descripcion)
	{
		this(estado_defecto, _precio_base, _peso, color_defecto, consumo_defecto,descripcion_defecto, resolucion_defecto, sinTDT_defecto);
	}
	
	public Television()
	{
		this( estado_defecto, precio_base_defecto, peso_defecto, color_defecto, 
				consumo_defecto, descripcion_defecto, resolucion_defecto, sinTDT_defecto );
	}
	
	public int getResolucion() {
		return resolucion;
	}

	public boolean isSinTDT() {
		return sinTDT;
	}
	
	public float precioFinal()
	{
		float precio = super.precioFinal();
		if (this.resolucion > 40)
		{
			precio += precio*30/100;
		}
		if(this.sinTDT)
		{
			precio += 50;
		}
		
		return precio;
	}


}
