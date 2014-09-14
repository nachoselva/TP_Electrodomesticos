package AccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Entidades.Lavarropas;

public class AccesoDatos_Lavarropas extends AccesoDatos_Electrodomestico{
	public int GuardarElectrodomestico(Lavarropas item)
	{
		String consulta = "insert into electrodomesticos(precio_base,peso, descripcion,idColor,idConsumo,carga,clase) values (?,?,?,?,?,?,?)";
		PreparedStatement  sentencia = null;
		ResultSet  rs = null;
		int ID = -5;
		try
		{
		sentencia = AdaptadorConeccion.getInstancia().getConn().prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
		sentencia.setDouble(1, item.getPrecio_base());
		sentencia.setDouble(2, item.getPeso());
		sentencia.setString(3, item.getDescripcion());
		sentencia.setInt(4, item.getColorID());
		sentencia.setInt(5, item.getConsumoID());
		sentencia.setDouble(6, item.getCarga());
		sentencia.setDouble(7, 1);
		sentencia.execute();
		rs = sentencia.getGeneratedKeys();
		if(rs.next())
			ID = rs.getInt(1);
		}
		catch (Exception e)
		{
			
		}
		return ID;
	}
	
	public void actualizarElectrodomestico(int _Id, Lavarropas lav)
	{
		String consulta = "UPDATE electrodomesticos SET precio_base=?,peso=?,descripcion=?,idColor=?,idConsumo=?,carga=?, clase=1 WHERE idElectrodomestico=?";
		PreparedStatement  sentencia = null;
		try{
		sentencia = AdaptadorConeccion.getInstancia().getConn().prepareStatement(consulta);
		sentencia.setFloat(1, lav.getPrecio_base());
		sentencia.setFloat(2, lav.getPeso());
		sentencia.setString(3, lav.getDescripcion());
		sentencia.setInt(4, lav.getColorID());
		sentencia.setInt(5, lav.getConsumoID());
		sentencia.setFloat(6, lav.getCarga());
		sentencia.setInt(7, _Id);
		sentencia.executeUpdate();
		}
		catch (Exception e)
		{
			
		}
	}

}
