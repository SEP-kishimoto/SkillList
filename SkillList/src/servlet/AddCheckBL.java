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
		String errmsg = "";



	      skill += ",";
	      // ','で改行
	      int n = 0;
	      int charcount = 0;	// 文字数カウント
	      String moji ="";
	      int over = 0;	// 文字数オーバーフラグ
	      int count = 0;



	      String[] skillList = skill.split(",", -1);
	      for (int i = 0; i < skillList.length;i++) {
	    	  if (i == skillList.length - 1) {
	    		  if(over == 1) {
	    			  System.out.println("a"+ charcount);
	    		  }

	    		  break;
	    	  }
	    	  if (moji.length() + skillList[n].length() + 1 > 33 && over == 0) {	// 行に設定する文字数 + これから設定しようとしている文字数 + カンマ分 > 行に入る文字数(全角)
	    		  charcount = 0;
	    		  count++;
	    	  }

	    	  if (charcount == 0) {
	    		  moji = skillList[n];
	    		  charcount = skillList[n].length();
	    	  } else {
	    		  moji += "," + skillList[n];
	    		  charcount += skillList[n].length() + 1;
	    		  if (over == 1) {
	    			  charcount--;
	    		  }
	    	  }

	    	  if (count <= 3) {
	    		  n++;
	    	  } else {
	    		  over = 1;
	    		  n++;
	    	  }

	      }
		if (os.length() > 60) {
			errmsg += "OSを60文字以内で入力してください<br>";
		}

		if (over == 1) {
			errmsg += "スキルの文字数が" + charcount + "文字超えています";
		}
//
//		if (tool.length() > 60) {
//			errmsg += "OSを60文字以内で入力してください";
//		}

		if (db.length() > 60) {
			errmsg += "DBを60文字以内で入力してください<br>";
		}

		if (qualification.length() > 60) {
			errmsg += "資格を60文字以内で入力してください<br>";
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
			getServletContext().getRequestDispatcher("/jsp/Add.jsp").forward(request, response);
		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
