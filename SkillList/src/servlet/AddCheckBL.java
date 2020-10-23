package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


	public static int calcAge(Date birthday, Date now) {	// 年齢計算処理
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    return (Integer.parseInt(sdf.format(now)) - Integer.parseInt(sdf.format(birthday))) / 10000;
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");

		// DB登録データ
		request.setAttribute("db_number",request.getParameter("db_number"));
		request.setAttribute("db_name",request.getParameter("db_name"));	// Profileの氏名も同じものを使用
		request.setAttribute("password",request.getParameter("password"));


		// Profile
		request.setAttribute("kana",request.getParameter("kana"));
		request.setAttribute("address",request.getParameter("address"));
		request.setAttribute("birthday",request.getParameter("birthday"));
		request.setAttribute("age",request.getParameter("age"));
		request.setAttribute("gender",request.getParameter("gender"));
		request.setAttribute("background",request.getParameter("background"));
		request.setAttribute("backgroundNumber",request.getParameter("backgroundNumber"));
		request.setAttribute("nearestStation",request.getParameter("nearestStation"));
		request.setAttribute("stationName",request.getParameter("stationName"));




		String os = request.getParameter("os");
		String skill = request.getParameter("skill");
		String tool = request.getParameter("tool");
		String db = request.getParameter("db");
		String qualification = request.getParameter("qualification");
		String task = request.getParameter("task");
		String peopleNumber = request.getParameter("peopleNumber");
		String development = request.getParameter("development");
		String errmsg = "";
		 skill = skill.replace("、", ",");	// 全角カンマから半角に置換



	      skill += ",";
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


	      /*
	       * スキル文字数チェック
	       *
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
	    		  moji += "," + skillList[n];
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

	      /*
	       * スキル文字数チェックここまで
	       *
	       */

	      /*
	       * ツール文字数チェック
	       *
	       */


	      String[] toolList = tool.split(",", -1);
	      for (int i = 0; i < toolList.length;i++) {
	    	  if (toolList[n].equals("")) {
	    		  break;
	    	  }
	    	  if (moji.length() + toolList[n].length() + 1 > 20 && lastrow_flg == 0) {	// 行に設定する文字数 + これから設定しようとしている文字数 + カンマ分 > 行に入る文字数(全角)
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

	    	  if (lastrow_flg == 1 && moji.length() > 20) {	// 最終行かつ20文字を超えるならフラグを立てる
	    		  tool_over = 1;
	    	  }

	    	  if (count <= 2) {
	    		  n++;
	    	  } else {
	    		  lastrow_flg = 1;	// 最終行フラグ
	    		  n++;
	    	  }


	    	  if (i == toolList.length - 1) {
	    		  if(tool_over == 1) {
	    			  tool_charcount = tool_charcount - 20;	// 文字数を何文字オーバーしているか
	    		  }

	    		  break;
	    	  }

	      }

	      /*
	       * ツール文字数チェックここまで
	       *
	       */


	      // 業務内容文字数チェック
	      task += ",";
	      n = 0;
	      String[] taskList = task.split(",", -1);
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
	      development += ",";
	      n = 0;
	      String[] developmentList = development.split(",", -1);
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

		if (taskList.length - 1 > 10) {
			errmsg += "業務内容は10項目以内で入力してください<br>";
		}


		if (developmentList.length - 1 > 10) {
			errmsg += "開発環境は10項目以内で入力してください<br>";
		}

		if (peopleNumber.length() >= 5) {
			errmsg += "人数を4文字以内で入力してください<br>";
		}

		if (development_over == 1) {
			errmsg += "開発環境は一つの項目に対して13文字以内で入力してくださいbr>";
		}



		// Skill Info
		request.setAttribute("os",request.getParameter("os"));
		request.setAttribute("skill",request.getParameter("skill"));
		request.setAttribute("tool",request.getParameter("tool"));
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


		// 年齢計算
		try {
            String strDate = "2000/01/01";

            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdFormat.parse(strDate);

         // 現在日時情報で初期化されたインスタンスの生成
   		 Date dateObj = new Date();

   		//System.out.println(calcAge(date, dateObj));	// 年齢表示
        } catch (ParseException e) {
            e.printStackTrace();
        }



		if(errmsg == "") {
			getServletContext().getRequestDispatcher("/jsp/AddCheck.jsp").forward(request, response);
		} else {
			System.out.println(errmsg);
			request.setAttribute("errmsg",errmsg);
			getServletContext().getRequestDispatcher("/jsp/Add.jsp").forward(request, response);
		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
