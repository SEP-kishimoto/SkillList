package servlet;

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
@WebServlet("/AddCheckBL")
public class AddCheckBL extends HttpServlet {
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

		// 本来二重構造
		List<String> requirement = new ArrayList<String>();
		List<String> basic = new ArrayList<String>();
		List<String> details = new ArrayList<String>();
		List<String> pg = new ArrayList<String>();
		List<String> single = new ArrayList<String>();
		List<String> join = new ArrayList<String>();
		List<String> customer = new ArrayList<String>();
		List<String> environment = new ArrayList<String>();
		//    	List<String> valueList = new ArrayList<>();
		//    	List<List<String>> checkList = new ArrayList<>();

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

			// Profile
			String kana = request.getParameter("kana");
			String name = request.getParameter("db_name"); // db_nameと同じ
			String address = request.getParameter("address");
			String gender = request.getParameter("gender");
			String birthday = request.getParameter("birthday");
			String background = request.getParameter("background");
			String backgroundNumber = request.getParameter("backgroundNumber");
			String nearestStation = request.getParameter("nearestStation");
			String stationName = request.getParameter("stationName");

			String os = request.getParameter("os");
			String skill = request.getParameter("skill");
			String tool = request.getParameter("tool");
			String db = request.getParameter("db");
			String qualification = request.getParameter("qualification");

		    noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");

//			peopleNumber = request.getParameter("peopleNumber");
//			String development = request.getParameter("development");
			String errmsg = "";
			skill = skill.replace("、", ","); // 全角カンマから半角に置換
			skill = skill.replace("、", ",");

			skill += ",";
			// ','で改行
			int n = 0;
			int skill_charcount = 0; // スキル文字数カウント
			int tool_charcount = 0; // ツール文字数カウント
			String moji = "";
			int skill_over = 0; // スキル文字数オーバーフラグ
			int tool_over = 0; // ツール文字数オーバーフラグ
			int count = 0;
			int lastrow_flg = 0; // 最終行フラグ
			int task_over = 0; // 業務内容オーバーフラグ
			int development_over = 0; // 開発環境オーバーフラグ

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

			/*
			 * Profileチェック
			 * kana, name, address, birthday, age, gender,
			 * background, backgroundNumber, nearestStation, stationName
			 */
			String[] profileList = { kana, name, address, birthday, gender, background, backgroundNumber,
					nearestStation, stationName };
			for (int num = 0; num < profileList.length; num++) {
				if (profileList[num].equals("")) {
					errmsg += "Profileの項目を全て記入してください<br>";
					break;
				}
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
				errmsg += "生年月日は「0000/00/00」の形式で入力してください<br>";
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

			/*
			 * スキル文字数チェック
			 *
			 */

			String[] skillList = skill.split(",", -1);
			for (int i = 0; i < skillList.length; i++) {
				if (skillList[n].equals("")) {
					break;
				}
				System.out.println("ループ回数" + i + " 文字数" + skill_charcount);
				if (moji.length() + skillList[n].length() + 1 > 33 && lastrow_flg == 0) { // 行に設定する文字数 + これから設定しようとしている文字数 + カンマ分 > 行に入る文字数(全角)
					skill_charcount = 0;
					count++;
				}

				if (skill_charcount == 0) {
					moji = skillList[n];
					skill_charcount = skillList[n].length();
				} else {
					moji += "," + skillList[n];
					skill_charcount += skillList[n].length() + 1;
				}

				if (lastrow_flg == 1 && moji.length() > 33) { // 最終行かつ33文字を超えるならフラグを立てる
					skill_over = 1;
				}

				if (count <= 2) {
					n++;
				} else {
					lastrow_flg = 1; // 最終行フラグ
					n++;
				}

				if (i == skillList.length - 1) {
					if (skill_over == 1) {
						skill_charcount = skill_charcount - 33; // 文字数を何文字オーバーしているか
					}

					break;
				}

			}

			/*
			 * スキル文字数チェックここまで
			 *
			 */

			/*
			 * ツール文字数チェック
			 *
			 */
			n = 0;
			tool += ",";
			String[] toolList = tool.split(",", -1);
			for (int i = 0; i < toolList.length; i++) {
				if (toolList[n].equals("")) {
					break;
				}
				if (moji.length() + toolList[n].length() + 1 > 20 && lastrow_flg == 0) { // 行に設定する文字数 + これから設定しようとしている文字数 + カンマ分 > 行に入る文字数(全角)
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

				if (lastrow_flg == 1 && moji.length() > 20) { // 最終行かつ20文字を超えるならフラグを立てる
					tool_over = 1;
				}

				if (count <= 2) {
					n++;
				} else {
					lastrow_flg = 1; // 最終行フラグ
					n++;
				}

				if (i == toolList.length - 1) {
					if (tool_over == 1) {
						tool_charcount = tool_charcount - 20; // 文字数を何文字オーバーしているか
					}

					break;
				}

			}

			/*
			 * ツール文字数チェックここまで
			 *
			 */


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
			    	if (developmentList[n].length() > 13) {
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
				}
			    if (task_over == 1) {
					errmsg += "業務内容は一つの項目に対して24文字以内で入力してください" + "(No." + (s + 1) + ")<br>";
					task_over = 0;
				}
				if (developmentList.length - 1 > 10) {
					errmsg += "開発環境は10項目以内で入力してください" + "(No." + (s + 1) + ")<br>";
				}
				if (development_over == 1) {
					errmsg += "開発環境は一つの項目に対して13文字以内で入力してください" + "(No." + (s + 1) + ")<br>";
					development_over = 0;
				}
		    }

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

			if (task_over == 1) {
				errmsg += "業務内容は一つの項目に対して24文字以内で入力してください<br>";
			}

			for (int i = 0; i < peopleNumber.size(); i++) {
				if (peopleNumber.get(i).length() >= 5) {
					errmsg += "人数を4文字以内で入力してください<br>";
				}
			}

			if (development_over == 1) {
				errmsg += "開発環境は一つの項目に対して13文字以内で入力してくださいbr>";
			}

			if (errmsg == "") { // エラーがない場合確認画面に遷移

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
			} else { // エラーがある場合登録画面に戻る

				// Background Note ループ処理

				noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");
				beginning = (ArrayList<String>) session.getAttribute("beginning");
				end = (ArrayList<String>) session.getAttribute("end");
				task = (ArrayList<String>) session.getAttribute("task");
				requirement = (ArrayList<String>) session.getAttribute("requirement");
				basic = (ArrayList<String>) session.getAttribute("basic");
				details = (ArrayList<String>) session.getAttribute("details");
				pg = (ArrayList<String>) session.getAttribute("pg");
				single = (ArrayList<String>) session.getAttribute("single");
				join = (ArrayList<String>) session.getAttribute("join");
				customer = (ArrayList<String>) session.getAttribute("customer");
				environment = (ArrayList<String>) session.getAttribute("environment");
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

				request.setAttribute("errmsg", errmsg);
				getServletContext().getRequestDispatcher("/jsp/Add.jsp").forward(request, response);
			}

		} else { // 追加処理の場合(ItemAddBLと同じ処理)
			//			System.out.println(addition_flg);
			//			request.setAttribute("noteNumber",String.valueOf(Integer.parseInt(request.getParameter("noteNumber")) + 1));	// noteNumberに1をプラスする

			// Background Note ループ処理

			noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");
			beginning = (ArrayList<String>) session.getAttribute("beginning");
			end = (ArrayList<String>) session.getAttribute("end");
			task = (ArrayList<String>) session.getAttribute("task");
			requirement = (ArrayList<String>) session.getAttribute("requirement");
			basic = (ArrayList<String>) session.getAttribute("basic");
			details = (ArrayList<String>) session.getAttribute("details");
			pg = (ArrayList<String>) session.getAttribute("pg");
			single = (ArrayList<String>) session.getAttribute("single");
			join = (ArrayList<String>) session.getAttribute("join");
			customer = (ArrayList<String>) session.getAttribute("customer");
			environment = (ArrayList<String>) session.getAttribute("environment");
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

			getServletContext().getRequestDispatcher("/jsp/Add.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
