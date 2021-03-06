package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet("/DB_AddCheckBL")
public class DB_AddCheckBL extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		ResultSet rs = null;
		// DB登録情報
		String db_number = request.getParameter("db_number");
		String db_name = request.getParameter("db_name");
		String password = request.getParameter("password");
		// フリガナ
		String kana = request.getParameter("kana");

		// 社員Noチェックのために使う変数
		String get_name = null;
		// エラーメッセージ
		String err_message = "";

		// テストデータ
		 List<String> noteNumber = new ArrayList<String>() {{add("1");}};
		 List<String> beginning = new ArrayList<String>() {{add("");}};
		 List<String> end = new ArrayList<String>() {{add("");}};
		 List<String> task = new ArrayList<String>() {{add("");}};

		 // フェーズ部分(本来二重構造)
		 List<String> requirement = new ArrayList<String>() {{add("");}};
		 List<String> basic = new ArrayList<String>() {{add("");}};
		 List<String> details = new ArrayList<String>() {{add("");}};
		 List<String> pg = new ArrayList<String>() {{add("");}};
		 List<String> single = new ArrayList<String>() {{add("");}};
		 List<String> join = new ArrayList<String>() {{add("");}};
		 List<String> customer = new ArrayList<String>() {{add(""); }};
		 List<String> environment = new ArrayList<String>() {{add("");}};


		 List<String> peopleNumber = new ArrayList<String>() {{add("");}};
		 List<String> development = new ArrayList<String>() {{add("");}};



		 HttpSession session = request.getSession();

		try {
			Connection con = Common.getConnection();
			String sql = "SELECT db_name FROM skillsheet WHERE db_number=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, db_number);
			rs = ps.executeQuery();
			while (rs.next()) {
			get_name = rs.getString("db_name");
			}

		}catch (SQLException e) {
			System.out.println("SQLException");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("db_number",db_number);
		request.setAttribute("db_name",db_name);
		request.setAttribute("kana",kana);
		request.setAttribute("password",password);
		session.setAttribute("noteNumber",noteNumber);
		session.setAttribute("beginning",beginning);
		session.setAttribute("end",end);
		session.setAttribute("task",task);
		session.setAttribute("requirement",requirement);
		session.setAttribute("basic",basic);
		session.setAttribute("details",details);
		session.setAttribute("pg",pg);
		session.setAttribute("single",single);
		session.setAttribute("join",join);
		session.setAttribute("customer",customer);
		session.setAttribute("environment",environment);
		session.setAttribute("peopleNumber",peopleNumber);
		session.setAttribute("development",development);


		if (get_name != null || db_number.isEmpty()) {	// get_nameがnullでなければ社員Noが重複している
			err_message += "社員番号が記入されていないか、既に使用されている社員番号です<br>";
		}

		if(kana.isEmpty()) {
			err_message += "フリガナを入力してください<br>";
		}

		if(db_name.isEmpty()) {
			err_message += "氏名を入力してください<br>";
		}

		if(password.isEmpty()) {
			err_message += "パスワードを入力してください<br>";
		}

		if (!(err_message.equals(""))) {
			request.setAttribute("err_message",err_message);
			request.setAttribute("return_flg","1");
			getServletContext().getRequestDispatcher("/jsp/DB_Add.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/jsp/Add.jsp").forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
