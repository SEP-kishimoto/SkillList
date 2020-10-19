package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditCheckBL
 */
@SuppressWarnings("unchecked")
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
	    // DB変数
	    String db_number = "";
	    String db_name = "";
	    String master_flg = "";
	    String filename = "";

	    // Profile変数
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

	    // スキル変数
	    String os = "";
	    String skill = "";
	    String tool = "";
	    String db = "";
	    String qualification = "";

	    // 履歴変数
	    List<String> noteNumber = new ArrayList<String>();
	    List<String> beginning = new ArrayList<String>();
	    List<String> end = new ArrayList<String>();
	    List<String> task = new ArrayList<String>();

    	List<String> valueList = new ArrayList<>();
    	List<List<String>> checkList = new ArrayList<>();

	    List<String> peopleNumber = new ArrayList<String>();
	    List<String> development = new ArrayList<String>();

	    // 変数に設定
	    db_number = request.getParameter("db_number");
	    db_name = request.getParameter("db_name");
	    master_flg = request.getParameter("master_flg");
	    filename = request.getParameter("filename");

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

	    HttpSession session = request.getSession();
	    noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");

	    int n = 0;
	    for (int i = 0; i < noteNumber.size(); i++) {
	    	String backgroundValue = "beginning" + Integer.toString(i);
	    	String a = request.getParameter(backgroundValue);
	    	beginning.add(i, a);
	    	backgroundValue = "end" + Integer.toString(i);
	    	a = request.getParameter(backgroundValue);
	    	end.add(i, a);
	    	backgroundValue = "task" + Integer.toString(i);
	    	a = request.getParameter(backgroundValue);
	    	task.add(i, a);


	    	valueList = new ArrayList<>();


	    	backgroundValue = "basic" + Integer.toString(n);
		    a = request.getParameter(backgroundValue);
		    valueList.add(0, a);
		    backgroundValue = "details" + Integer.toString(n);
		    a = request.getParameter(backgroundValue);
		    valueList.add(1, a);
		    backgroundValue = "pg" + Integer.toString(n);
		    a = request.getParameter(backgroundValue);
		    valueList.add(2, a);
		    backgroundValue = "single" + Integer.toString(n);
		    a = request.getParameter(backgroundValue);
		    valueList.add(3, a);
		    backgroundValue = "join" + Integer.toString(n);
		    a = request.getParameter(backgroundValue);
		    valueList.add(4, a);
		    backgroundValue = "customer" + Integer.toString(n);
		    a = request.getParameter(backgroundValue);
		    valueList.add(5, a);
		    backgroundValue = "development" + Integer.toString(n);
		    a = request.getParameter(backgroundValue);
		    valueList.add(6, a);
		    backgroundValue = "requirement" + Integer.toString(n);
		    a = request.getParameter(backgroundValue);
		    valueList.add(7, a);
	    	checkList.add(i, valueList);

	    	backgroundValue = "peopleNumber" + Integer.toString(i);
	    	a = request.getParameter(backgroundValue);
	    	peopleNumber.add(i, a);
	    	backgroundValue = "development" + Integer.toString(i);
	    	a = request.getParameter(backgroundValue);
	    	development.add(i, a);
	    }

	    // db
	    request.setAttribute("db_number", db_number);
	    request.setAttribute("db_name", db_name);
	    request.setAttribute("master_flg", master_flg);
	    request.setAttribute("filename", filename);

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

	    // Skill Info
	    request.setAttribute("os", os);
	    request.setAttribute("skill", skill);
	    request.setAttribute("tool", tool);
	    request.setAttribute("db", db);
	    request.setAttribute("qualification", qualification);

	    // BackgroundNote
	    request.setAttribute("noteNumber", noteNumber);
	    request.setAttribute("beginning", beginning);
	    request.setAttribute("end", end);
	    request.setAttribute("task", task);

	    request.setAttribute("requirement", checkList);
	    request.setAttribute("basic", checkList);
	    request.setAttribute("details", checkList);
	    request.setAttribute("pg", checkList);
	    request.setAttribute("single", checkList);
	    request.setAttribute("join", checkList);
	    request.setAttribute("customer", checkList);
	    request.setAttribute("environment", checkList);

	    request.setAttribute("peopleNumber", peopleNumber);
	    request.setAttribute("development", development);

	    String view = "/jsp/EditCheck.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);


	}

}
