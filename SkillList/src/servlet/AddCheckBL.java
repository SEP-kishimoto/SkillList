package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCheckBL
 */
@WebServlet("/AddCheckBL")
public class AddCheckBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCheckBL() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");


		// Profile
		request.setAttribute("kana",request.getParameter("kana"));
		request.setAttribute("name",request.getParameter("name"));
		request.setAttribute("address",request.getParameter("address"));
		request.setAttribute("birthday",request.getParameter("birthday"));
		request.setAttribute("age",request.getParameter("age"));
		request.setAttribute("gender",request.getParameter("gender"));
		request.setAttribute("background",request.getParameter("background"));
		request.setAttribute("backgroundNumber",request.getParameter("backgroundNumber"));
		request.setAttribute("nearestStation",request.getParameter("nearestStation"));
		request.setAttribute("stationName",request.getParameter("stationName"));
		System.out.println(request.getParameter("kana"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("address"));
		System.out.println(request.getParameter("birthday"));
		System.out.println(request.getParameter("age"));
		System.out.println(request.getParameter("gender"));
		System.out.println(request.getParameter("background"));
		System.out.println(request.getParameter("backgroundNumber"));
		System.out.println(request.getParameter("nearestStation"));
		System.out.println(request.getParameter("stationName"));


		getServletContext().getRequestDispatcher("/jsp/AddCheck.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
