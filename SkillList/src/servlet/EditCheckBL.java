package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditCheckBL
 */
@WebServlet("/EditCheckBL")
public class EditCheckBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCheckBL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");

	    // 変数を宣言
	    String db_number = "";
	    String db_name = "";

	    String kana = "";
	    String name = "";
	    String address = "";
	    String birthday = "";
	    String age = "";
	    String gender = "";
	    String background = "";
	    String backgroundNumber = "";
	    String nearestStation = "";
	    String stationName = "";

	    String os = "";
	    String skill = "";
	    String tool = "";
	    String db = "";
	    String qualification = "";

	    // 変数に設定
	    db_number = request.getParameter("db_number");
	    db_name = request.getParameter("db_name");

	    kana = request.getParameter("kana");
	    name = request.getParameter("name");
	    address = request.getParameter("address");
	    birthday = request.getParameter("birthday");
	    age = request.getParameter("age");
	    gender = request.getParameter("gender");
	    background = request.getParameter("background");
	    backgroundNumber = request.getParameter("backgroundNumber");
	    nearestStation = request.getParameter("nearestStation");
	    stationName = request.getParameter("stationName");


	    os = request.getParameter("os");
	    skill = request.getParameter("skill");
	    tool = request.getParameter("tool");
	    db = request.getParameter("db");
	    qualification = request.getParameter("qualification");

	    // db
	    request.setAttribute("db_number", db_number);
	    request.setAttribute("db_name", db_name);

	    // Profaile
	    request.setAttribute("kana", kana);
	    request.setAttribute("name", name);
	    request.setAttribute("address", address);
	    request.setAttribute("birthday", birthday);
	    request.setAttribute("age", age);
	    request.setAttribute("gender", gender);
	    request.setAttribute("background", background);
	    request.setAttribute("backgroundNumber", backgroundNumber);
	    request.setAttribute("nearestStation", nearestStation);
	    request.setAttribute("stationName", stationName);

	    // Skill Info読み込み
	    request.setAttribute("os", os);
	    request.setAttribute("skill", skill);
	    request.setAttribute("tool", tool);
	    request.setAttribute("db", db);
	    request.setAttribute("qualification", qualification);

	    String view = "/jsp/EditCheck.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);


	}

}
