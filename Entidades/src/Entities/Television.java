package Entities;

public class Television extends Electrodomestico {
	private int resolucion;
	private boolean sinTDT;
	
	static final public int resolucion_defecto = 20;
	static final public boolean sinTDT_defecto = false;
	
	public Television( float _precio_base,float _peso , int _colorID, int _consumoID, String _descripcion, int _resolucion, boolean _sinTDT)
	{
		super( _precio_base, _peso, _colorID, _consumoID, _descripcion);
		this.resolucion = _resolucion;
		this.sinTDT = _sinTDT;
	}
	
	public Television(float _precio_base,float _peso, String _descripcion)
	{
		this( _precio_base, _peso, colorID_defecto, consumoID_defecto,descripcion_defecto, resolucion_defecto, sinTDT_defecto);
	}
	
	public Television()
	{
		this(precio_base_defecto, peso_defecto, colorID_defecto, 
				consumoID_defecto, descripcion_defecto, resolucion_defecto, sinTDT_defecto );
	}
	
	public int getResolucion() {
		return resolucion;
	}

	public boolean isSinTDT() {
		return sinTDT;
	}
	
	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}

	public void setSinTDT(boolean sinTDT) {
		this.sinTDT = sinTDT;
	}
	


}
