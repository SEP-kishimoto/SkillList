package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommonTest
 */
@WebServlet("/CommonTest")
public class CommonTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		/*
		 * Commonが機能しているのか確認する
		 */
		try {
			Connection commst = Common.getConnection();
			Statement stmt = commst.createStatement();
			String sqlmst = "SELECT * FROM skillsheet";
			ResultSet rs = stmt.executeQuery(sqlmst);
			while (rs.next()) {
				String db_number = (String) rs.getString("db_number");
				String db_name = (String) rs.getString("db_name");
				String master_flg = (String) rs.getString("master_flg");
				String filename = (String) rs.getString("filename");

				System.out.println("ID :" + db_number);
				System.out.println("名前 :" + db_name);
				System.out.println("マスターフラグ :" + master_flg);
				System.out.println("スキルシート :" + filename);
			}
			System.out.println("テスト完了");
			System.out.println("");


		} catch (SQLException e) {
			System.out.println("SQLException" + e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
