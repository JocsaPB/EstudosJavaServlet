package estudos.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/index", "/home"})
public class ExemploServlet extends HttpServlet {

	private final String utf8 = "UTF-8";
	private final String mensagem = "Chamou pelo método ";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Configurando a resposta para a codificação de caracteres UTF-8
		resp.setCharacterEncoding(utf8);
		resp.getWriter().print(mensagem + "GET");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding(utf8);
		resp.getWriter().print(mensagem + "POST");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding(utf8);
		resp.getWriter().print(mensagem + "PUT");
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding(utf8);
		resp.getWriter().println(mensagem + "DELETE");
	}
	
	
	
}
