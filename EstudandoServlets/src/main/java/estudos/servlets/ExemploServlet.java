package estudos.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns={"/index", "/home"})
public class ExemploServlet extends HttpServlet {

	private final String utf8 = "UTF-8";
	private final String mensagem = "Chamou pelo método ";
	
	//Primeiro método a ser chamado no servlet
	public ExemploServlet(){
		System.out.println("Criando servlet...");
	}
	
	//Depois do método construtor da classe, é chamado o método init
	@Override
	public void init() throws ServletException {
		System.out.println("Inicializando servlet...");
		super.init();
	}
	
	/* O Service interpreta através do super.service qual a requisiçao solicitada e redireciona para o método correto
	 * seja GET, POST, PUT, ETC.*/
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Iniciando o service");
		super.service(req, res);
	}
	
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
	
	/* Um servlet é capaz de atender a várias requisições sem ser destruído.
	 * desta forma o método destroy é o último método da classe servlet a ser chamado */ 
	@Override
	public void destroy() {
		System.out.println("Servlet será destruído.");
		super.destroy();
	}
	
	
	
}
