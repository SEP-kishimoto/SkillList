package test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SkillTestInput
 */
@WebServlet("/SkillTestInputData")
public class SkillTestInputData extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkillTestInputData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字コードの設定
	    request.setCharacterEncoding("UTF-8");

		//DB
		String db_number = "9999";
		String db_name = "試験男";
		String master_flg = "0";
		String filename = "SkillSheet_9999_試験男.xlsx";

		//Profile
		String kana = "エドガワコナン";
		String name = "江戸川湖南";
		String address = "東京都新宿区";
		String birthday = "2000/01/01";
		try {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
	      String b = birthday.replace("/", "");
	      Date date;
	      Date now = new Date();
	      date = sdFormat.parse(b);
	      int ageValue = (Integer.parseInt(sdFormat.format(now)) - Integer.parseInt(sdFormat.format(date))) / 10000;
	      String age = Integer.toString(ageValue);
	      request.setAttribute("age", age);
		} catch (Exception ex) {
		      ex.printStackTrace();
		}
		String gender = "男";
		String background = "大学卒";
		String backgroundNumber = "2020年";
		String nearestStation = "総武";
		String stationName = "新小岩";

		//Skill Info
		String os = "Windows10";
		String skill = "Java,HTML,CSS";
		String tool = "Eclipse,Springboot";
		String db = "MySQL";
		String qualification = "情報処理";

		//Background Note
		List<String> noteNumber = new ArrayList<String>();
		for (int i = 1; i <= 5; i++ ) {
			noteNumber.add(Integer.toString(i));
		}
		List<String> beginning = new ArrayList<String>();
		List<String> end = new ArrayList<String>();
		List<String> task = new ArrayList<String>();

		List<String> valueList = new ArrayList<String>();
		ArrayList<List<String>> checkList = new ArrayList<>();

		List<String> peopleNumber = new ArrayList<String>();
		List<String> development = new ArrayList<String>();

		for (int i = 0; i < noteNumber.size(); i++) {

			beginning.add("2018/01/01");
			end.add("2020/01/01");
			task.add("ビジネスマナー研修,プログラム研修,Javaの基本");

			valueList = new ArrayList<String>();
			for (int s = 0; s < 8; s++) {
				valueList.add("◎");
			}

			checkList.add(valueList);

			peopleNumber.add("3");
			development.add("Windows10,Linux");
		}

		request.setAttribute("db_number", db_number);
		request.setAttribute("db_name", db_name);
		request.setAttribute("master_flg", master_flg);
		request.setAttribute("filename", filename);

		request.setAttribute("kana", kana);
		request.setAttribute("name", name);
		request.setAttribute("address", address);
		request.setAttribute("birthday", birthday);

		request.setAttribute("gender", gender);
		request.setAttribute("background", background);
		request.setAttribute("backgroundNumber", backgroundNumber);
		request.setAttribute("nearestStation", nearestStation);
		request.setAttribute("stationName", stationName);

		request.setAttribute("os", os);
		request.setAttribute("skill", skill);
		request.setAttribute("tool", tool);
		request.setAttribute("db", db);
		request.setAttribute("qualification", qualification);

		request.setAttribute("noteNumber", noteNumber);
		request.setAttribute("beginning", beginning);
		request.setAttribute("end", end);
		request.setAttribute("task", task);

		request.setAttribute("requirement", checkList);
		request.setAttribute("basic", checkList);
		request.setAttribute("details", checkList);
		request.setAttribute("pg", checkList);
		request.setAttribute("single", checkList);
		request.setAttribute("join", checkList );
		request.setAttribute("customer", checkList);
		request.setAttribute("environment", checkList);

		request.setAttribute("peopleNumber", peopleNumber);
		request.setAttribute("development", development);

		HttpSession session = request.getSession();
		master_flg = "0"; // 0の場合も見る
		//master_flg = "1"; // 1の場合も見る
	    session.setAttribute("master_flg", master_flg);

		String view = "/jsp/Skill.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
