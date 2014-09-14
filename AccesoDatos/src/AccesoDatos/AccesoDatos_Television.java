package AccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Entidades.Television;

public class AccesoDatos_Television extends AccesoDatos_Electrodomestico{
	public int GuardarElectrodomestico(Television item)
	{
		String consulta = "insert into electrodomesticos(precio_base,peso, descripcion,idColor,idConsumo,resolucion,sintonizador,clase) values (?,?,?,?,?,?,?,?)";
		PreparedStatement  sentencia = null;
		ResultSet  rs = null;
		int ID = -1;
		try
		{
		sentencia = AdaptadorConeccion.getInstancia().getConn().prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
		sentencia.setDouble(1, item.getPrecio_base());
		sentencia.setDouble(2, item.getPeso());
		sentencia.setString(3, item.getDescripcion());
		sentencia.setInt(4, item.getColorID());
		sentencia.setInt(5, item.getConsumoID());
		sentencia.setInt(6, item.getResolucion());
		sentencia.setBoolean(7, item.isSinTDT());
		sentencia.setDouble(8, 2);
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
	
	public void actualizarElectrodomestico(int _Id, Television tel)
	{
		String consulta = "UPDATE electrodomesticos SET precio_base=?,peso=?,descripcion=?,idColor=?,idConsumo=?,resolucion=?, sintonizador=?, clase=2 WHERE idElectrodomestico=?";
		PreparedStatement  sentencia = null;
		try{
		sentencia = AdaptadorConeccion.getInstancia().getConn().prepareStatement(consulta);
		sentencia.setFloat(1, tel.getPrecio_base());
		sentencia.setFloat(2, tel.getPeso());
		sentencia.setString(3, tel.getDescripcion());
		sentencia.setInt(4, tel.getColorID());
		sentencia.setInt(5, tel.getConsumoID());
		sentencia.setInt(6, tel.getResolucion());
		sentencia.setBoolean(7, tel.isSinTDT());
		sentencia.setInt(8, _Id);
		sentencia.executeUpdate();
		}
		catch (Exception e)
		{
			
		}
	}

}
