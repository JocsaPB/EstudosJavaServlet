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
		
		//setando atributos com chave e valor para ser recuperado na página JSP e setando o enconding
		req.setAttribute("usuarios", usuarios);
		req.setCharacterEncoding(utf8);
		
		//redirecionamento do tipo foward que envia uma nova página ao browser
		dispatcher.forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario user = new Usuario();
		
		user.setNome(req.getParameter("nome"));
		user.setEmail(req.getParameter("email"));
		
		usuarios.add(user);
		
		/* Foi utilizado neste caso pois foi necessário retornar uma nova página com novos dados. 
		 * No caso do redirect não é o mais adequado pois seu objetivo é pedir ao browser que faça uma nova 
		 * requisição ao servidor */
		RequestDispatcher dispatcher = req.getRequestDispatcher("usuario.jsp");
		
		req.setAttribute("mensagem", "Usuario "+user.getNome()+" cadastrado com sucesso!");
		req.setAttribute("usuarios", usuarios);
		req.setCharacterEncoding(utf8);
		
		dispatcher.forward(req, resp);

		/* redirecionamento do tipo redirect. Este tipo solicita ao brower que faça uma nova requisição GET 
		 * chamando pela url informada pelo parâmetro, neste caso o usuario
		 * 
		resp.sendRedirect("usuario"); */
	}
	
}
