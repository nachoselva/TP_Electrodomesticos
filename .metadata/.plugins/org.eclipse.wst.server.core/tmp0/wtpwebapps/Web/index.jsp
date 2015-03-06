<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="Entities.*" %>
<%@ page import="Logica.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
</head>
<body>

	<% 
		ArrayList<Electrodomestico> listado = (ArrayList<Electrodomestico>)request.getAttribute("listado"); 
		for (int x =0; x < listado.size(); x++)
		{
			Electrodomestico item = listado.get(x);
			String cadena = new String();
			Logica_Electrodomestico adaptador_electrodomestico = new Logica_Electrodomestico();
			String _id = String.valueOf(item.getID());
			String _color = adaptador_electrodomestico.getColorDesc(item.getID());
			String _consumo = adaptador_electrodomestico.getConsumoDesc(item.getID());
			String _desc = item.getDescripcion();
			String _peso = String.valueOf(item.getPeso());
			cadena = "hola";
			cadena = String.format("ID:%s Color:%s Consumo:%s Desc:%s Peso:%s ", _id, _color, _consumo, _desc, _peso);
			if (item.getClass() == Lavarropas.class)
			{
				String _carga = String.valueOf(((Lavarropas)item).getCarga());
				cadena = String.format("%s Carga:%s", cadena, _carga);
			}
			else if (item.getClass() == Television.class)
			{
				String _resolucion = String.valueOf(((Television)item).getResolucion());
				String _sintonizador = String.valueOf(((Television)item).isSinTDT());
				cadena = String.format("%s Resolucion:%s Sintonizador:%s", cadena, _resolucion, _sintonizador);
			}
			
			%>
				<%= cadena%>
				</br>
			<%
		}
	%>
</body>
</html>