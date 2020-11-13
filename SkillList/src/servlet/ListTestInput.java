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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListTestInput
 */
@WebServlet("/ListTestInput")
public class ListTestInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTestInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		session.setAttribute("master_flg", "1"); //テストによって書き換える
		try {
			Connection commst = Common.getConnection();
			Statement stmt = commst.createStatement();
			String sqlmst = "SELECT * FROM skillsheet";
			ResultSet rs = stmt.executeQuery(sqlmst);
			request.setAttribute("ResultSet", rs);

			/*
			 * ブレークポイント
			 * 変数 rsに値が入っているのを確認する
			 * 期待する結果
			 * List.jspにて一覧が表示されていること
			 */
			getServletContext().getRequestDispatcher("/jsp/List.jsp").forward(request, response);
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
