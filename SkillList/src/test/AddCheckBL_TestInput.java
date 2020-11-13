package test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCheckBL
 */
@WebServlet("/AddCheckBL_test")
public class AddCheckBL_TestInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static int calcAge(Date birthday, Date now) { // 年齢計算処理
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return (Integer.parseInt(sdf.format(now)) - Integer.parseInt(sdf.format(birthday))) / 10000;
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// DB登録データ
		request.setAttribute("db_number", request.getParameter("db_number"));
		request.setAttribute("db_name", request.getParameter("db_name")); // Profileの氏名も同じものを使用
		request.setAttribute("password", request.getParameter("password"));

		// Profile
		request.setAttribute("kana", request.getParameter("kana"));
		request.setAttribute("address", request.getParameter("address"));
		request.setAttribute("birthday", request.getParameter("birthday"));

		request.setAttribute("gender", request.getParameter("gender"));
		request.setAttribute("background", request.getParameter("background"));
		request.setAttribute("backgroundNumber", request.getParameter("backgroundNumber"));
		request.setAttribute("nearestStation", request.getParameter("nearestStation"));
		request.setAttribute("stationName", request.getParameter("stationName"));

		// Skill Info
		request.setAttribute("os", request.getParameter("os"));
		request.setAttribute("skill", request.getParameter("skill"));
		request.setAttribute("tool", request.getParameter("tool"));
		request.setAttribute("db", request.getParameter("db"));
		request.setAttribute("qualification", request.getParameter("qualification"));

		request.setAttribute("entry_flg", "1"); // Add.jspに戻ったことを判定するフラグ

		// 履歴変数
		List<String> noteNumber = new ArrayList<String>();
		List<String> beginning = new ArrayList<String>();
		List<String> end = new ArrayList<String>();
		List<String> task = new ArrayList<String>();


		List<String> peopleNumber = new ArrayList<String>();
		List<String> development = new ArrayList<String>();

		// 再構成リスト
		List<String> beginning_new = new ArrayList<String>();
		List<String> end_new = new ArrayList<String>();
		List<String> task_new = new ArrayList<String>();

		// 本来二重構造
		List<String> requirement_new = new ArrayList<String>();
		List<String> basic_new = new ArrayList<String>();
		List<String> details_new = new ArrayList<String>();
		List<String> pg_new = new ArrayList<String>();
		List<String> single_new = new ArrayList<String>();
		List<String> join_new = new ArrayList<String>();
		List<String> customer_new = new ArrayList<String>();
		List<String> environment_new = new ArrayList<String>();

		List<String> peopleNumber_new = new ArrayList<String>();
		List<String> development_new = new ArrayList<String>();

		HttpSession session = request.getSession();
		int addition_flg = Integer.parseInt(request.getParameter("addition_flg"));

		if (addition_flg == 0) { // 追加処理ではない場合


		    noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");
		    String birthday = request.getParameter("birthday");


//			peopleNumber = request.getParameter("peopleNumber");
//			String development = request.getParameter("development");



			List<String> valueList = new ArrayList<>();
	    	List<List<String>> checkList = new ArrayList<>();


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




			// 年齢のチェック
				SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
				String a = birthday.replace("/", "");
				Date date;
				Date now = new Date();
				/*
				* Profile 生年月日形式
				*/
				String regex = "\\d{4}\\/\\d{2}\\/\\d{2}$";
				if (!(birthday.matches(regex))) {
				} else {
					try {
						date = sdFormat.parse(a);
						int ageValue = (Integer.parseInt(sdFormat.format(now)) - Integer.parseInt(sdFormat.format(date)))
								/ 10000;
						String str = Integer.toString(ageValue);
						request.setAttribute("age", str); // 年齢を自動判定
					} catch (ParseException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

				}






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

				// リスト再構成
				for (int i = 0; i < noteNumber.size(); i++) {

					beginning_new.add(request.getParameter("beginning" + i));
					end_new.add(request.getParameter("end" + i));
					task_new.add(request.getParameter("task" + i));
					requirement_new.add(request.getParameter("requirement" + i));
					basic_new.add(request.getParameter("basic" + i));
					details_new.add(request.getParameter("details" + i));
					pg_new.add(request.getParameter("pg" + i));
					single_new.add(request.getParameter("single" + i));
					join_new.add(request.getParameter("join" + i));
					customer_new.add(request.getParameter("customer" + i));
					environment_new.add(request.getParameter("environment" + i));
					peopleNumber_new.add(request.getParameter("peopleNumber" + i));
					development_new.add(request.getParameter("development" + i));
				}

				session.setAttribute("noteNumber", noteNumber);
				session.setAttribute("beginning", beginning_new);
				session.setAttribute("end", end_new);
				session.setAttribute("task", task_new);
				session.setAttribute("requirement", requirement_new);
				session.setAttribute("basic", basic_new);
				session.setAttribute("details", details_new);
				session.setAttribute("pg", pg_new);
				session.setAttribute("single", single_new);
				session.setAttribute("join", join_new);
				session.setAttribute("customer", customer_new);
				session.setAttribute("environment", environment_new);
				session.setAttribute("peopleNumber", peopleNumber_new);
				session.setAttribute("development", development_new);

				getServletContext().getRequestDispatcher("/jsp/AddCheck.jsp").forward(request, response);

		}else { // 追加処理の場合(ItemAddBLと同じ処理)
					//			System.out.println(addition_flg);
					//			request.setAttribute("noteNumber",String.valueOf(Integer.parseInt(request.getParameter("noteNumber")) + 1));	// noteNumberに1をプラスする

					// Background Note ループ処理

					noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");
					beginning = (ArrayList<String>) session.getAttribute("beginning");
					end = (ArrayList<String>) session.getAttribute("end");
					task = (ArrayList<String>) session.getAttribute("task");
					peopleNumber = (ArrayList<String>) session.getAttribute("peopleNumber");
					development = (ArrayList<String>) session.getAttribute("development");

					// リスト再構成
					for (int i = 0; i < noteNumber.size(); i++) {

						beginning_new.add(request.getParameter("beginning" + i));
						end_new.add(request.getParameter("end" + i));
						task_new.add(request.getParameter("task" + i));
						requirement_new.add(request.getParameter("requirement" + i));
						basic_new.add(request.getParameter("basic" + i));
						details_new.add(request.getParameter("details" + i));
						pg_new.add(request.getParameter("pg" + i));
						single_new.add(request.getParameter("single" + i));
						join_new.add(request.getParameter("join" + i));
						customer_new.add(request.getParameter("customer" + i));
						environment_new.add(request.getParameter("environment" + i));
						peopleNumber_new.add(request.getParameter("peopleNumber" + i));
						development_new.add(request.getParameter("development" + i));
					}

					noteNumber.add(String.valueOf(noteNumber.size() + 1)); // noteNumber + 1
					// 空欄追加
					beginning_new.add("");
					end_new.add("");
					task_new.add("");
					requirement_new.add("");
					basic_new.add("");
					details_new.add("");
					pg_new.add("");
					single_new.add("");
					join_new.add("");
					customer_new.add("");
					environment_new.add("");
					peopleNumber_new.add("");
					development_new.add("");
					session.setAttribute("noteNumber", noteNumber);
					session.setAttribute("beginning", beginning_new);
					session.setAttribute("end", end_new);
					session.setAttribute("task", task_new);
					session.setAttribute("requirement", requirement_new);
					session.setAttribute("basic", basic_new);
					session.setAttribute("details", details_new);
					session.setAttribute("pg", pg_new);
					session.setAttribute("single", single_new);
					session.setAttribute("join", join_new);
					session.setAttribute("customer", customer_new);
					session.setAttribute("environment", environment_new);
					session.setAttribute("peopleNumber", peopleNumber_new);
					session.setAttribute("development", development_new);

					getServletContext().getRequestDispatcher("/jsp/AddCheck_test_Add.jsp").forward(request, response);
				}


		}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
