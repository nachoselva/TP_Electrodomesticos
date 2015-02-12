package AccesoDatos;

import java.sql.*;
import java.util.ArrayList;

import Entities.*;;

public class AccesoDatos_Electrodomestico {
static protected ArrayList<Electrodomestico> ListaElectrodomesticos;
	
	public String getColorDesc(int ID)
	{
		String consulta = "select descripcion from colores where idcolor ="+String.valueOf(ID);
		PreparedStatement  sentencia = null;
		ResultSet  rs = null;
		String _desc = null;
		try{
		sentencia = AdaptadorConeccion.getInstancia().getConn().prepareStatement(consulta);
//		sentencia.setInt(1, ID);
		rs = sentencia.executeQuery(consulta);
		if(rs.next())
			{
			_desc = rs.getString("descripcion");
			}
		}
		catch (Exception e)
		{
			
		}
		return _desc;
	}
	
	
	
	public ArrayList<String> getTodosConsumos()
	{
		ArrayList<String> lista = new ArrayList<String>();
		String consulta = "select descripcion from consumos where !(estado = 0)";
		Statement  sentencia = null;
		ResultSet  rs = null;
		try
		{
		sentencia = AdaptadorConeccion.getInstancia().getConn().prepareStatement(consulta);
		rs = sentencia.executeQuery(consulta);
		while(rs.next())
			{
				lista.add(rs.getString("descripcion"));
			}
		}
		catch (Exception e)
		{
			
		}
		return lista;
	}
	
	
	
	public ArrayList<Electrodomestico> ObtenerTodos() 
	{
		ArrayList<Electrodomestico> listado = new ArrayList<Electrodomestico>();
		String consulta = "select * from electrodomesticos ";
		Statement  sentencia = null;
		ResultSet  rs = null;
		try{
		sentencia = AdaptadorConeccion.getInstancia().getConn().createStatement();
		rs = sentencia.executeQuery(consulta);
		while(rs.next())
			{
				if(rs.getInt("clase") == 1)
				{
					Lavarropas lav = new Lavarropas();
					lav.setID(rs.getInt("idElectrodomestico"));
					lav.setDescripcion(rs.getString("descripcion"));
					lav.setPrecio_base(rs.getFloat("precio_base"));
					lav.setPeso(rs.getFloat("peso"));
					lav.setColorID(rs.getInt("idColor"));
					lav.setConsumoID(rs.getInt("idConsumo"));
					lav.setCarga(rs.getFloat("carga"));
					listado.add(lav);
				}
				else if(rs.getInt("clase") == 2)
				{
					Television tel = new Television();
					tel.setID(rs.getInt("idElectrodomestico"));
					tel.setDescripcion(rs.getString("descripcion"));
					tel.setPrecio_base(rs.getFloat("precio_base"));
					tel.setPeso(rs.getFloat("peso"));
					tel.setColorID(rs.getInt("idColor"));
					tel.setConsumoID(rs.getInt("idConsumo"));
					tel.setSinTDT(rs.getBoolean("sintonizador"));
					tel.setResolucion(rs.getInt("resolucion"));
					listado.add(tel);
				}
			}
		}
		catch (SQLException a)
		{
			
		}
		//AdaptadorConeccion.getInstancia().CloseConn();
		return listado;
		
	}
	public Lavarropas ObtenerLavarropas(int ID) 
	{
		String consulta = "select * from electrodomesticos where idElectrodomestico ="+String.valueOf(ID);
		Statement  sentencia = null;
		ResultSet  rs = null;
		Lavarropas lav = new Lavarropas();
		try{
		sentencia = AdaptadorConeccion.getInstancia().getConn().createStatement();
		rs = sentencia.executeQuery(consulta);
		if(rs.next())
			{
					lav.setID(rs.getInt("idElectrodomestico"));
					lav.setDescripcion(rs.getString("descripcion"));
					lav.setPrecio_base(rs.getFloat("precio_base"));
					lav.setPeso(rs.getFloat("peso"));
					lav.setColorID(rs.getInt("idColor"));
					lav.setConsumoID(rs.getInt("idConsumo"));
					lav.setCarga(rs.getFloat("carga"));
			}
		}
		catch (SQLException a)
		{
			
		}
		//AdaptadorConeccion.getInstancia().CloseConn();
		return lav;
	}
	

	
	public Television ObtenerTelevision(int ID) 
	{
		String consulta = "select * from electrodomesticos where idElectrodomestico ="+String.valueOf(ID);
		Statement  sentencia = null;
		ResultSet  rs = null;	
		Television tel = new Television();
		try{
		sentencia = AdaptadorConeccion.getInstancia().getConn().createStatement();
		rs = sentencia.executeQuery(consulta);
		if(rs.next())
			{
			tel.setID(rs.getInt("idElectrodomestico"));
			tel.setDescripcion(rs.getString("descripcion"));
			tel.setPrecio_base(rs.getFloat("precio_base"));
			tel.setPeso(rs.getFloat("peso"));
			tel.setColorID(rs.getInt("idColor"));
			tel.setConsumoID(rs.getInt("idConsumo"));
			tel.setSinTDT(rs.getBoolean("sintonizador"));
			tel.setResolucion(rs.getInt("resolucion"));
			}
		}
		catch (SQLException a)
		{
			
		}
		//AdaptadorConeccion.getInstancia().CloseConn();
		return tel;
	}
	public int obtenerID()
	{
		return ListaElectrodomesticos.size();
	}
	
	public Electrodomestico obtenerItem(int _Id)
	{
		Electrodomestico item = null;
		String consulta = "select * from electrodomesticos where idElectrodomestico = ?";
		PreparedStatement  sentencia = null;
		ResultSet  rs = null;
		try{
		sentencia = AdaptadorConeccion.getInstancia().getConn().prepareStatement(consulta);
		sentencia.setInt(1, _Id);
		rs = sentencia.executeQuery();
		if(rs.next())
		{
			if(rs.getInt("clase") == 1)
			{
				Lavarropas lav = new Lavarropas();
				lav.setID(rs.getInt("idElectrodomestico"));
				lav.setDescripcion(rs.getString("descripcion"));
				lav.setPrecio_base(rs.getFloat("precio_base"));
				lav.setPeso(rs.getFloat("peso"));
				lav.setColorID(rs.getInt("idColor"));
				lav.setConsumoID(rs.getInt("idConsumo"));
				lav.setCarga(rs.getFloat("carga"));
				item = lav;
			}
			else if(rs.getInt("clase") == 2)
			{
				Television tel = new Television();
				tel.setID(rs.getInt("idElectrodomestico"));
				tel.setDescripcion(rs.getString("descripcion"));
				tel.setPrecio_base(rs.getFloat("precio_base"));
				tel.setPeso(rs.getFloat("peso"));
				tel.setColorID(rs.getInt("idColor"));
				tel.setConsumoID(rs.getInt("idConsumo"));
				tel.setSinTDT(rs.getBoolean("sintonizador"));
				tel.setResolucion(rs.getInt("resolucion"));
				item = tel;
			}
			else
			{
				item = null;
			}
		}
		}
		catch (Exception e)
		{
			item = null;
		}
		return item;
		
		
	}
	
	public void borrarItem(int _Id)
	{
		String consulta = "delete from electrodomesticos where idElectrodomestico = ?";
		PreparedStatement sentencia = null;
		try{
		sentencia = AdaptadorConeccion.getInstancia().getConn().prepareStatement(consulta);
		sentencia.setInt(1, _Id);
		sentencia.execute();
		}
		catch (Exception e)
		{
			
		}
	}

	public ArrayList<String> getTodosColores() {
		ArrayList<String> lista = new ArrayList<String>();
		String consulta = "select descripcion from colores where !(estado = 0)";
		Statement  sentencia = null;
		ResultSet  rs = null;
		try
		{
		sentencia = AdaptadorConeccion.getInstancia().getConn().prepareStatement(consulta);
		rs = sentencia.executeQuery(consulta);
		while(rs.next())
			{
				lista.add(rs.getString("descripcion"));
			}
		}
		catch (Exception e)
		{
			
		}
		return lista;
	}

	public float getRecargoPorConsumo(int ID) {
		String consulta = "SELECT Cons.valor_recargo FROM electrodomesticos Elec INNER JOIN consumos Cons ON (Elec.idConsumo=Cons.idConsumo) WHERE Elec.idElectrodomestico ="+ String.valueOf(ID);
		PreparedStatement  sentencia = null;
		ResultSet  rs = null;
		float rec = 0;
		try{
		sentencia = AdaptadorConeccion.getInstancia().getConn().prepareStatement(consulta);
		rs = sentencia.executeQuery(consulta);
		if(rs.next())
			{
			rec = rs.getFloat("valor_recargo");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rec;
	}



	public String getConsumoDesc(int consumoID) 
	{
			String consulta = "select descripcion from consumos where idConsumo ="+String.valueOf(consumoID);
			PreparedStatement  sentencia = null;
			ResultSet  rs = null;
			String cons = "error";
			try{
			sentencia = AdaptadorConeccion.getInstancia().getConn().prepareStatement(consulta);
			//sentencia.setInt(1, ID);
			rs = sentencia.executeQuery(consulta);
			if(rs.next())
				{
				cons = rs.getString("descripcion");
				}
			}
			catch (Exception e)
			{
				
			}
			return cons;
	}

	
	
	
}
