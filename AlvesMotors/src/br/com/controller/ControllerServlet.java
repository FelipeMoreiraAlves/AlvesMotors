package br.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/sistema")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("acao");

		if ("Sair".equals(parametro)) {
			HttpSession session = request.getSession();
			session.setAttribute("sessaoEncerrada", true);
			response.sendRedirect("http://www.fiap.com.br");
		} else {
			String nomeDaClasse = "br.com.controller." + parametro;

			try {
				Class<?> classe = Class.forName(nomeDaClasse);
				Logica logica = (Logica) classe.newInstance();

				String pagina = logica.executa(request, response);

				request.getRequestDispatcher(pagina).forward(request, response);
			} catch (Exception e) {
				throw new ServletException("A lógica de negócios causou uma exceção", e);
			}
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
