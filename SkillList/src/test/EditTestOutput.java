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
 * Servlet implementation class EditTestOutput
 */
@SuppressWarnings("unchecked")
@WebServlet("/EditTestOutput")
public class EditTestOutput extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTestOutput() {
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

    	List<String> valueList = new ArrayList<>();
    	List<List<String>> checkList = new ArrayList<>();

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

	    skill = skill.replace("、", ",");	// 全角カンマから半角に置換

	    tool = tool.replace("、", ",");
	    if (!(skill.endsWith(","))) {
	    	if (!(skill.equals(""))) {
	    		skill += ",";
	    	}
	    }
	    if (!(tool.endsWith(","))) {
	    	if (!(tool.equals(""))) {
	    		tool += ",";
	    	}
	    }


	    // Background Noteに設定

	    HttpSession session = request.getSession();
	    noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");

	    for (int i = 0; i < noteNumber.size(); i++) {
	    	String backgroundValue = "beginning" + Integer.toString(i);
	    	String a = request.getParameter(backgroundValue);
	    	beginning.add(i, a);
	    	backgroundValue = "end" + Integer.toString(i);
	    	a = request.getParameter(backgroundValue);
	    	end.add(i, a);
	    	backgroundValue = "task" + Integer.toString(i);
	    	a = request.getParameter(backgroundValue);
	    	String[] konma = a.split(",", -1);
	    	for (int cnt = 0; cnt < konma.length; cnt++) {
	    		if (a.equals("")) {
	    			break;
	    		}
	    		if (cnt == konma.length - 1 && !(a.endsWith(","))) {
		    		a += ",";
		    		break;
		    	}
	    	}
	    	task.add(i, a.replaceAll("、", ",").replaceAll(" ", "").replaceAll("　", ""));


	    	valueList = new ArrayList<>();


	    	backgroundValue = "requirement" + Integer.toString(i);
		    a = request.getParameter(backgroundValue);
		    valueList.add(0, a);
	    	backgroundValue = "basic" + Integer.toString(i);
		    a = request.getParameter(backgroundValue);
		    valueList.add(1, a);
		    backgroundValue = "details" + Integer.toString(i);
		    a = request.getParameter(backgroundValue);
		    valueList.add(2, a);
		    backgroundValue = "pg" + Integer.toString(i);
		    a = request.getParameter(backgroundValue);
		    valueList.add(3, a);
		    backgroundValue = "single" + Integer.toString(i);
		    a = request.getParameter(backgroundValue);
		    valueList.add(4, a);
		    backgroundValue = "join" + Integer.toString(i);
		    a = request.getParameter(backgroundValue);
		    valueList.add(5, a);
		    backgroundValue = "customer" + Integer.toString(i);
		    a = request.getParameter(backgroundValue);
		    valueList.add(6, a);
		    backgroundValue = "environment" + Integer.toString(i);
		    a = request.getParameter(backgroundValue);
		    valueList.add(7, a);
	    	checkList.add(i, valueList);

	    	backgroundValue = "peopleNumber" + Integer.toString(i);
	    	a = request.getParameter(backgroundValue);
	    	peopleNumber.add(i, a);

	    	backgroundValue = "development" + Integer.toString(i);
	    	a = request.getParameter(backgroundValue);
	    	konma = a.split(",", -1);
	    	for (int cnt = 0; cnt < konma.length; cnt++) {
	    		if (a.equals("")) {
	    			break;
	    		}
	    		if (cnt == konma.length - 1 && !(a.endsWith(","))) {
		    		a += ",";
		    		break;
		    	}
	    	}
	    	development.add(i, a.replaceAll("、", ",").replaceAll(" ", "").replaceAll("　", ""));
	    }

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
	    System.out.println(checkList);
	    System.out.println(peopleNumber);
	    System.out.println(development);



	}

}
