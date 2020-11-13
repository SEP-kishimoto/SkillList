package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditCheckTestOutput
 */
@SuppressWarnings("unchecked")
@WebServlet("/EditCheckTestOutput")
public class EditCheckTestOutput extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCheckTestOutput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字コードの設定
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");

		// Background Note変数
	    List<String> noteNumber = new ArrayList<String>();
	    List<String> beginning = new ArrayList<String>();
	    List<String> end = new ArrayList<String>();
	    List<String> task = new ArrayList<String>();

	    ArrayList<List<String>> requirement = new ArrayList<>();
	    ArrayList<List<String>> basic = new ArrayList<>();
	    ArrayList<List<String>> details = new ArrayList<>();
	    ArrayList<List<String>> pg = new ArrayList<>();
	    ArrayList<List<String>> single = new ArrayList<>();
	    ArrayList<List<String>> join = new ArrayList<>();
	    ArrayList<List<String>> customer = new ArrayList<>();
	    ArrayList<List<String>> environment = new ArrayList<>();

	    List<String> peopleNumber = new ArrayList<String>();
	    List<String> development = new ArrayList<String>();

	    // 変数に設定
	    // DB
	    String db_number = request.getParameter("db_number");
	    String db_name = request.getParameter("db_name");
	    String master_flg = request.getParameter("master_flg");
	    String filename = request.getParameter("filename");

	    // Profileに設定
	    String kana = request.getParameter("kana");
	    String name = request.getParameter("name");
	    String  address = request.getParameter("address");
	    String  birthday = request.getParameter("birthday");
	    String gender = request.getParameter("gender");
	    String background = request.getParameter("background");
	    String backgroundNumber = request.getParameter("backgroundNumber");
	    String nearestStation = request.getParameter("nearestStation");
	    String stationName = request.getParameter("stationName");

	    // Skill Infoに設定
	    String os = request.getParameter("os");
	    String skill = request.getParameter("skill");
	    String  tool = request.getParameter("tool");
	    String db = request.getParameter("db");
	    String qualification = request.getParameter("qualification");

	    HttpSession session = request.getSession();
	    noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");
	    beginning = (ArrayList<String>) session.getAttribute("beginning");
	    end = (ArrayList<String>) session.getAttribute("end");
	    task = (ArrayList<String>) session.getAttribute("task");

	    requirement = (ArrayList<List<String>>) session.getAttribute("requirement");
	    basic = (ArrayList<List<String>>) session.getAttribute("basic");
	    details = (ArrayList<List<String>>) session.getAttribute("details");
	    pg = (ArrayList<List<String>>) session.getAttribute("pg");
	    single = (ArrayList<List<String>>) session.getAttribute("single");
	    join = (ArrayList<List<String>>) session.getAttribute("join");
	    customer = (ArrayList<List<String>>) session.getAttribute("customer");
	    environment = (ArrayList<List<String>>) session.getAttribute("environment");

	    peopleNumber = (ArrayList<String>) session.getAttribute("peopleNumber");
	    development = (ArrayList<String>) session.getAttribute("development");

	    System.out.println("DB");
	    System.out.println(db_number);
	    System.out.println(db_name);
	    System.out.println(master_flg);
	    System.out.println(filename);

	    System.out.println("--------------------");

	    System.out.println("Profile");
	    System.out.println(kana);
	    System.out.println(name);
	    System.out.println(address);
	    System.out.println(birthday);
	    System.out.println(gender);
	    System.out.println(background);
	    System.out.println(backgroundNumber);
	    System.out.println(nearestStation);
	    System.out.println(stationName);

	    System.out.println("--------------------");
	    System.out.println("Skill Info");

	    System.out.println(os);
	    System.out.println(skill);
	    System.out.println(tool);
	    System.out.println(db);
	    System.out.println(qualification);

	    System.out.println("--------------------");
	    System.out.println("Background Note");

	    System.out.println(noteNumber);
	    System.out.println(beginning);
	    System.out.println(end);
	    System.out.println(task);

	    System.out.println(requirement);
	    System.out.println(basic);
	    System.out.println(details);
	    System.out.println(pg);
	    System.out.println(single);
	    System.out.println(join);
	    System.out.println(customer);
	    System.out.println(environment);

	    System.out.println(peopleNumber);
	    System.out.println(development);



	}

}
