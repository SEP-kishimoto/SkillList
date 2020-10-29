package servlet;

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

	    HttpSession session = request.getSession();
	    noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");

	    String errmsg = "";

	    // ','で改行
	    int n = 0;
	    int skill_charcount = 0;	// スキル文字数カウント
	    int tool_charcount = 0;		// ツール文字数カウント
	    String moji ="";
	    int skill_over = 0;	// スキル文字数オーバーフラグ
	    int tool_over = 0;	// ツール文字数オーバーフラグ
	    int count = 0;
	    int lastrow_flg = 0;	// 最終行フラグ
	    int task_over = 0;	// 業務内容オーバーフラグ
	    int development_over = 0;	// 開発環境オーバーフラグ

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



	    /*
	     * Profileチェック
	     * kana, name, address, birthday, age, gender,
	     * background, backgroundNumber, nearestStation, stationName
	     */
	    String[] profileList = {kana, name, address, birthday, gender, background, backgroundNumber, nearestStation, stationName};
	    for (int num = 0; num < profileList.length; num++) {
	    	if (profileList[num].equals("")) {
	    		errmsg += "Profileの項目を全て記入してください<br>";
	    		break;
	    	}
	    }

	    /*
	     * Profile 生年月日形式
	     */
	    String regex = "\\d{4}\\/\\d{2}\\/\\d{2}$";
	    if (!(birthday.matches(regex))) {
	    	errmsg += "生年月日は「0000/00/00」の形式で入力してください";
	    }

	    /*
	     * 文字数チェック
	     */

	    /*
	     * スキル文字数チェック
	     */
	    String[] skillList = skill.split(",", -1);
	    for (int i = 0; i < skillList.length;i++) {
	    	if (skillList[n].equals("")) {
	    		  break;
	    	}
	    	System.out.println("ループ回数" + i + " 文字数" + skill_charcount);
	    	if (moji.length() + skillList[n].length() + 1 > 33 && lastrow_flg == 0) {	// 行に設定する文字数 + これから設定しようとしている文字数 + カンマ分 > 行に入る文字数(全角)
	    		skill_charcount = 0;
	    		count++;
	    	}

	    	if (skill_charcount == 0) {
	    		moji = skillList[n];
	    		skill_charcount = skillList[n].length();
	    	} else {
	    		moji += skillList[n];
	    		skill_charcount += skillList[n].length() + 1;
	    	}

	    	if (lastrow_flg == 1 && moji.length() > 33) {	// 最終行かつ33文字を超えるならフラグを立てる
	    		skill_over = 1;
	    	}

	    	if (count <= 2) {
	    		n++;
	    	} else {
	    		lastrow_flg = 1;	// 最終行フラグ
	    		 n++;
	    	}

	    	if (i == skillList.length - 1) {
	    		if(skill_over == 1) {
	    			skill_charcount = skill_charcount - 33;	// 文字数を何文字オーバーしているか
	    		}
	    		break;
	    	}
	    }



	    n = 0;
	    String[] toolList = tool.split(",", -1);
	    for (int i = 0; i < toolList.length; i++) {
	    	if (toolList[n].equals("")) {
	    		break;
	    	}
	    	System.out.println("ループ回数" + i + "文字数" + tool_charcount);
	    	if (moji.length() + toolList[n].length() + 1 > 20 && lastrow_flg == 0) {
	    		tool_charcount = 0;
	    		count++;
	    	}
	    	if (tool_charcount == 0) {
	    		moji = toolList[n];
	    		tool_charcount = toolList[n].length();
	    	} else {
	    		moji += "," + toolList[n];
	    		tool_charcount += toolList[n].length() + 1;
	    	}
	    	if (lastrow_flg == 1 && moji.length() > 20) {
	    		tool_over = 1;
	    	}
	    	if (count <= 2) {
	    		n++;
	    	} else {
	    		lastrow_flg = 1;
	    		n++;
	    	}
	    	if (i == toolList.length - 1) {
	    		if (tool_over == 1) {
	    			tool_charcount = tool_charcount - 20;
	    		}
	    		break;
	    	}
	    }


	    /*
	     * エラーメッセージの追加
	     * 変数名 errmsg
	     */

	    if (os.length() > 60) {
			errmsg += "OSを60文字以内で入力してください<br>";
		}

		if (skill_over == 1) {
			errmsg += "スキルの文字数が" + skill_charcount + "文字超えています<br>";
		}
//
		if (tool.length() > 60) {
			errmsg += "ツールの文字数が" + tool_charcount + "文字超えています<br>";
		}

		if (db.length() > 60) {
			errmsg += "DBを60文字以内で入力してください<br>";
		}

		if (qualification.length() > 60) {
			errmsg += "資格を60文字以内で入力してください<br>";
		}

	    // 業務内容文字数チェック
	    n = 0;
	    for (int s = 0; s < noteNumber.size(); s++) {
	    	n = 0;
	    	String[] taskList = task.get(s).split(",", -1);
		    for (int i = 0; i < taskList.length;i++) {
		    	if (taskList[n].length() >= 25) {
		    		task_over = 1;
		    		break;
		    	}
		    	if (taskList[n].equals("")) {
		    		break;
		    	}
		    	n++;
		    }
		    // 開発環境文字数チェック
		    n = 0;
		    String[] developmentList = development.get(s).replaceAll("、", ",").replaceAll(" ", "").replaceAll("　", "").split(",", -1);
		    for (int i = 0; i < developmentList.length;i++) {
		    	if (developmentList[n].length() > 14) {
		    		development_over = 1;
		    		break;
		    	}
		    	if (developmentList[n].equals("")) {
		    		break;
		    	}
		    	n++;

		    }

		    if (taskList.length - 1 > 10) {
				errmsg += "業務内容は10項目以内で入力してください" + "(No." + (s + 1) + ")<br>";
				break;
			}
		    if (task_over == 1) {
				errmsg += "業務内容は一つの項目に対して24文字以内で入力してください" + "(No." + (s + 1) + ")<br>";
				break;
			}
			if (developmentList.length - 1 > 10) {
				errmsg += "開発環境は10項目以内で入力してください" + "(No." + (s + 1) + ")<br>";
				break;
			}
			if (development_over == 1) {
				errmsg += "開発環境は一つの項目に対して13文字以内で入力してください" + "(No." + (s + 1) + ")<br>";
			}
	    }

		for (int i = 0; i < noteNumber.size(); i++) {
			if (peopleNumber.get(i).length() >= 5) {
				errmsg += "人数を4文字以内で入力してください<br>" + "(No." + (i + 1) + ")<br>";
				break;
			}
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

	    if(errmsg == "") {
			getServletContext().getRequestDispatcher("/jsp/EditCheck.jsp").forward(request, response);
		} else {
			System.out.println(errmsg);
			request.setAttribute("errmsg",errmsg);
			getServletContext().getRequestDispatcher("/jsp/Edit.jsp").forward(request, response);
		}


	}

}
