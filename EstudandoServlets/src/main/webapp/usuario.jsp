<!DOCTYPE html>
<%@page import="estudos.model.Usuario"%>
<%@page import="java.util.List"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de cliente</title>
<head>
<body>

	<form action="usuario" method="POST">
		<label id="nome">Nome</label> <input id="nome" type="text" name="nome"><br>
		<label id="email">Email</label> <input id="email" type="email" name="email"><br><br>
		<input type="submit" value="Enviar">
	</form>
	<br/>
	<% 
		//recuperando a lista enviada pelo req com o forward no dispatcher
		List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
	
		for(Usuario usuario: usuarios){
			
			out.print("Usuario: "+usuario.getNome() +" - Email: "+usuario.getEmail() +" <br/>");
			
		}
	%>
</body>
</html>