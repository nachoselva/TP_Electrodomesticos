package Entidades;

public abstract class Electrodomestico {
	
	private float precio_base;
	private Colores color;
	private Tipos_Consumo consumo;
	private float peso;
	private String descripcion;
	private int ID;
	private boolean estado;
	
	static public int siguienteID;
	static final Colores color_defecto = Colores.blanco;
	static final float precio_base_defecto = 100;
	static final Tipos_Consumo consumo_defecto = Tipos_Consumo.A;
	static final float peso_defecto = 5;
	static final boolean estado_defecto = true;
	static final String descripcion_defecto = "sin descripcion";
	
	public enum Colores { blanco, negro, rojo, azul, gris}
	public enum Tipos_Consumo { A, B, C, D, E, F}
	
	public Electrodomestico (boolean _estado, float _precio_base,float _peso , Colores _color, Tipos_Consumo _consumo, String _descripcion)
	{
		this.precio_base = _precio_base;
		this.color = _color;
		this.consumo = _consumo;
		this.peso = _peso;
		this.ID = Electrodomestico.siguienteID;
		this.descripcion = _descripcion;
		this.estado = _estado;
		
	}
	
	
	public Electrodomestico () 
	{
		this(estado_defecto, precio_base_defecto, peso_defecto, color_defecto, consumo_defecto, descripcion_defecto);
		
	}
	
	public Electrodomestico (float _precio_base, float _peso) 
	{
		this(estado_defecto, _precio_base, _peso, color_defecto, consumo_defecto, descripcion_defecto);
	}
	

	public boolean getEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
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
	public Colores getColor() {
		return color;
	}
	public Tipos_Consumo getConsumo() {
		return consumo;
	}
	public float getPeso() {
		return peso;
	}
	
	public float precioFinal()
	{
		float acumulador = this.precio_base;
		switch(this.consumo.toString().charAt(0))
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
		}
		
		return this.precio_base + acumulador;
	}
	

}
