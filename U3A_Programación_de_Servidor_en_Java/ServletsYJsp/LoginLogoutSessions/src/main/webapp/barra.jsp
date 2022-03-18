
<%@ page import="org.iesalixar.servidor.model.Usuario" %>
<div class="d-flex justify-content-end">
	<h4>
	<%
		
		Usuario user = (Usuario) session.getAttribute("usuario");
	
		out.println(user.getNombre());
	%>
	</h4>
	<a href="Logout">Logout</a>
</div>
