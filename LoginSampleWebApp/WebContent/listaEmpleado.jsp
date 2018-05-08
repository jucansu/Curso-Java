<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="Avante.domain.Persona"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	List<Persona> lista = (List<Persona>) request.getAttribute("listaPersona");
	for (Persona p : lista) {
%>
<li><%=p.getNombre()%></li>
<%
	}
%>
<%
	Map map = request.getParameterMap();
	Enumeration headers = request.getHeaderNames();
	int kh = 0;
	while (headers.hasMoreElements()) {
		String hName = (String) headers.nextElement();
		out.println("------- " + hName);
		Enumeration hValues = request.getHeaders(hName);
		while (hValues.hasMoreElements()) {
			out.println("<br/>&nbsp;&nbsp;&nbsp;" + hValues.nextElement());
		}
		out.println("<br/>");
	}
%>
<body>

</body>
</html>