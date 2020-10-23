package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		if (get_name != null || db_number.isEmpty()) {	// get_nameがnullでなければ社員Noが重複している
			err_message = "すでに使われている社員Noまたは社員Noが入力されていません";
			request.setAttribute("err_message",err_message);
			getServletContext().getRequestDispatcher("/jsp/DB_Add.jsp").forward(request, response);
		} else {

			getServletContext().getRequestDispatcher("/jsp/Add.jsp").forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
