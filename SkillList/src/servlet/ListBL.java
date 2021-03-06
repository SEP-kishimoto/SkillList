package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListBL
 */
@WebServlet("/ListBL")
public class ListBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListBL() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");

		String db_number = (String) request.getAttribute("db_number");
		String db_name = (String) request.getAttribute("db_name");
		String master_flg = (String) request.getAttribute("master_flg");
		String filename = (String) request.getAttribute("filename");

		if(master_flg==null) {//管理者がSkill.jspから戻るボタンを押下した際の処理
		    master_flg = request.getParameter("master_flg2");
	    }

		HttpSession session = request.getSession();
		session.setAttribute("master_flg",master_flg);

		/*
		 * ブレークポイント1
		 * 変数 db_number, db_name, master_flg, filename
		 * 変数を確認する
		 * master_flgで分岐
		 */
		if (master_flg.equals("1")) {//管理者ログインの場合
			try {
				Connection commst = Common.getConnection();
				Statement stmt = commst.createStatement();
				String sqlmst = "SELECT * FROM skillsheet";
				ResultSet rs = stmt.executeQuery(sqlmst);
				request.setAttribute("ResultSet", rs);
				System.out.println("管理者です");

				// debug用の処理------------------------------
				/*String debugmsg = "管理者じゃけぇ";
				request.setAttribute("debugmsg", debugmsg);
				getServletContext().getRequestDispatcher("/test/ListBLTestOutput.jsp").forward(request, response);
				/* debug用の処理------------------------------ */

				/*
				 * ブレークポイント2
				 * 管理者ログインの場合
				 * DBの変数rsが入っているかチェックする
				 * テスト用の分岐先で、管理者と表示されている*/


				getServletContext().getRequestDispatcher("/jsp/List.jsp").forward(request, response);
			} catch (SQLException e) {
				System.out.println("SQLException" + e);
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException");
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		} else {
			request.setAttribute("db_number", db_number);
			request.setAttribute("db_name", db_name);
			request.setAttribute("master_flg", master_flg);
			request.setAttribute("filename", filename);
			System.out.println("一般です");
			ServletContext sc = getServletContext();

			// debug用の処理------------------------------
			/*String debugmsg = "一般人じゃけぇ";
			request.setAttribute("debugmsg", debugmsg);
			RequestDispatcher dispatcher = sc.getRequestDispatcher("/test/ListBLTestOutput.jsp");
			/* debug用の処理------------------------------ */

			/*
			 * ブレークポイント3
			 * 一般ログインの場合
			 * テスト用の分岐先で一般と表示されている
			 **/

			RequestDispatcher dispatcher = sc.getRequestDispatcher("/SkillBL");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}