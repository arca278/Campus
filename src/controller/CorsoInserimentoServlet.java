package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CorsoDao;
import model.Corso;

/**
 * Servlet implementation class CorsoInserimentoServlet
 */
@WebServlet("/Corso")
public class CorsoInserimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorsoInserimentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CorsoDao dao = new CorsoDao();
		request.setAttribute("corsi", dao.getAll());
		request.getRequestDispatcher("corsoForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CorsoDao dao = new CorsoDao();
		Corso c = new Corso();
		
		c.setCorso(request.getParameter("corso"));
		
		dao.inserimento(c);
		
		response.sendRedirect("CorsiFacolta");
	}

}
