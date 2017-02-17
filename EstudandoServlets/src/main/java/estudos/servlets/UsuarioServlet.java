package estudos.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import estudos.model.Usuario;


@WebServlet(urlPatterns="/usuario")
public class UsuarioServlet extends HttpServlet {

	private final String utf8 = "UTF-8";
	
	List<Usuario> usuarios = new ArrayList<>();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//através do dispatcher podemos redirecionar, para a página informada no construtor, com o forward passando a requisição e a resposta.
		RequestDispatcher dispatcher = req.getRequestDispatcher("usuario.jsp");	
		
		//setando atributos com chave e valor para ser recuperado na página JSP
		req.setAttribute("usuarios", usuarios);
		
		dispatcher.forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario user = new Usuario();
		
		user.setNome(req.getParameter("nome"));
		user.setEmail(req.getParameter("email"));
		
		usuarios.add(user);

		doGet(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding(utf8);
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding(utf8);
	}
	
	
}
