package Entidades;

public abstract class Electrodomestico {
	
	private float precio_base;


	private int colorID;
	private int consumoID;
	private float peso;
	private String descripcion;
	private int ID;
	
	static final public int colorID_defecto = 1;
	static final public String colorDesc_defecto = "blanco";
	static final public float precio_base_defecto = 100;
	static final public int consumoID_defecto = 1;
	static final public float peso_defecto = 5;
	static final public String descripcion_defecto = "sin descripcion";
	
	public Electrodomestico (float _precio_base,float _peso , int _colorID, int _consumoID, String _descripcion)
	{
		this.precio_base = _precio_base;
		this.colorID = _colorID;
		this.consumoID = _consumoID;
		this.peso = _peso;
		this.descripcion = _descripcion;
		
	}
	
	
	public Electrodomestico () 
	{
		this( precio_base_defecto, peso_defecto, colorID_defecto, consumoID_defecto, descripcion_defecto);
		
	}
	
	public Electrodomestico (float _precio_base, float _peso) 
	{
		this( _precio_base, _peso, colorID_defecto, consumoID_defecto, descripcion_defecto);
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public float getPrecio_base() {
		return precio_base;
	}
	public int getColorID() {
		return colorID;
	}
	public int getConsumoID() {
		return consumoID;
	}
	public float getPeso() {
		return peso;
	}
	
	public void setPrecio_base(float precio_base) {
		this.precio_base = precio_base;
	}


	public void setColorID(int colorID) {
		this.colorID = colorID;
	}


	public void setConsumoID(int consumoID) {
		this.consumoID = consumoID;
	}


	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public float precioFinal()
	{
		float acumulador = this.precio_base;
		/*switch(this.consumo.toString().charAt(0))
		{
		case 'A':
			acumulador += 100;
			break;
		case 'B':
			acumulador += 80;
			break;
		case 'C':
			acumulador += 60;
			break;
		case 'D':
			acumulador += 50;
			break;
		case 'E':
			acumulador += 30;
			break;
		case 'F':
			acumulador += 10;
			break;
		default: 
			break;
		}
		if (this.peso < 20)
		{
			acumulador += 10;
		} else if (this.peso < 50)
		{
			acumulador += 50;
		} else if (this.peso < 80)
		{
			acumulador += 80;
		}
		else
		{
			acumulador += 100;
		}*/
		
		return this.precio_base + acumulador;
	}
	

}
