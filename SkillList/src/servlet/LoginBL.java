package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginBL
 */
@WebServlet("/LoginBL")
public class LoginBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginBL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		String id = request.getParameter("id");//ログインID
		String pass = request.getParameter("password");//ログインパスワード
		String flg = request.getParameter("flg");//初回起動フラグ
		System.out.println("値受け取り");

		// debug用の処理------------------------------
		if (id == "") {
			id = null;
		}
		if(pass == "") {
			pass = null;
		}
		if (flg == "") {
			flg = null;
		}
		/* debug用の処理------------------------------ */

		/*
		 * ブレークポイント1
		 * 変数 id, pass, flg
		 * flgで分岐する
		 */
		if (flg == null) {//ログインページ閲覧初回
			id = "";
			pass = "";
			request.setAttribute("id", id);
			request.setAttribute("password", pass);
			System.out.println("初回");


			//test/LoginBLTestOutput.jsp 元のデータ /jsp/Login.jsp

			getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
		} else {//ログインボタン押下

			/*
			 * ブレークポイント2
			 * id, passで分岐する
			 */
			if (id != null && pass != null) {//ID・Passがどちらも入っている
				try {
					Connection con = Common.getConnection();
					String sql = "SELECT * FROM skillsheet WHERE db_number=? AND password=?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, id);
					ps.setString(2, pass);
					rs = ps.executeQuery();
					rs.last();//SQL結果の最後の行へ
					int number_of_row = rs.getRow();//SQL結果の行数を取得
					rs.beforeFirst(); //最初に戻る

					if (number_of_row != 1) {//ID・Passが一致しない場合かID・Passが複数ある場合
						String errmsg = "IDもしくはパスワードが間違っているか入力されていません。";
						request.setAttribute("errmsg", errmsg);
						request.setAttribute("id", id);
						request.setAttribute("password", pass);
						System.out.println("ID・PASS該当なし、または複数該当");


						//test/LoginBLTestOutput.jsp 元のデータ /jsp/Login.jsp


						/*
						 * ブレークポイント3
						 * ID・Passが一致しない場合かID・Passが複数ある場合
						 * errmsgが発生しているか確認する
						 */
						getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
					} else {//ID・Passの該当が一件の場合
						rs.next();
						String db_number = rs.getString("db_number");
						String db_name = rs.getString("db_name");
						String master_flg = rs.getString("master_flg");
						String filename = rs.getString("filename");
						request.setAttribute("db_number", db_number);
						request.setAttribute("db_name", db_name);
						request.setAttribute("master_flg", master_flg);
						request.setAttribute("filename", filename);
						System.out.println("ID・パス該当あり");
						ServletContext sc = getServletContext();


						//test/LoginBLTestOutput.jsp 元のデータ /ListBL


						/*
						 * ブレークポイント4
						 * ID・Passの該当が一件の場合
						 * 変数 db_number, db_name, master_flg, filename
						 */
						RequestDispatcher dispatcher = sc.getRequestDispatcher("/ListBL");
						dispatcher.forward(request, response);
						}
					}catch (SQLException e) {
					System.out.println("SQLException");
				} catch (ClassNotFoundException e) {
					System.out.println("ClassNotFoundException" + e);
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

			} else {//ID・Passが入っていない

				String errmsg = "IDもしくはパスワードが間違っているか入力されていません。";
				request.setAttribute("errmsg", errmsg);
				request.setAttribute("id", id);
				request.setAttribute("password", pass);
				System.out.println("ID・Pass不足");


				//test/LoginBLTestOutput.jsp 元のデータ /jsp/Login.jsp


				/*
				 * ブレークポイント5
				 * ID・Passが入っていない
				 * errmsgが発生しているか確認する
				 */
				getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
			}
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