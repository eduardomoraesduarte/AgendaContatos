package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contatos;
import model.DAO;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	Contatos contato = new Contatos();

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		}else if (action.equals("/insert")) {
			novoContato(request, response);
		} else {
			response.sendRedirect("agenda.jsp");
		}
	}

	// Listar Contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	List<Contatos> lista = dao.listarContatos();
		/** teste de recebimento
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getEmail());
			System.out.println(lista.get(i).getFone());
		}*/
		//encaminhar a lista ao fm agenda jsp
		//request.setAttribute("contatos", lista);
		//RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp")
		response.sendRedirect("agenda.jsp");

	}

	// Novo Contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** //teste de recebimentos dos dados do formulario
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("fone"));*/
		
		//setar as variaveis no Contato
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setFone(request.getParameter("fone"));

		//invocar o método inserirContato passando o obj contato
		dao.inserirContato(contato);
		//redirecionar para o documento agenda.jsp
		response.sendRedirect("main");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
