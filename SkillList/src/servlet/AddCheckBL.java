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


		// Skill Info
		request.setAttribute("os",request.getParameter("os"));
		String skill = request.getParameter("skill");
		skill = skill.replace(",", "｜");
		request.setAttribute("skill",skill);
		String tool = request.getParameter("tool");
		tool = tool.replace(",", "｜");
		request.setAttribute("tool",tool);
		request.setAttribute("db",request.getParameter("db"));
		request.setAttribute("qualification",request.getParameter("qualification"));


		// Background Note
		request.setAttribute("noteNumber",request.getParameter("noteNumber"));
		request.setAttribute("beginning",request.getParameter("beginning"));
		request.setAttribute("end",request.getParameter("end"));
		request.setAttribute("task",request.getParameter("task"));
		request.setAttribute("requirement",request.getParameter("requirement"));
		request.setAttribute("basic",request.getParameter("basic"));
		request.setAttribute("details",request.getParameter("details"));
		request.setAttribute("pg",request.getParameter("pg"));
		request.setAttribute("single",request.getParameter("single"));
		request.setAttribute("join",request.getParameter("join"));
		request.setAttribute("customer",request.getParameter("customer"));
		request.setAttribute("environment",request.getParameter("environment"));
		request.setAttribute("peopleNumber",request.getParameter("peopleNumber"));
		request.setAttribute("development",request.getParameter("development"));





		getServletContext().getRequestDispatcher("/jsp/AddCheck.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
