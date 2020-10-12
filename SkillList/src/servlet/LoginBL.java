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
		if (flg == null) {//ログインページ閲覧初回
			id = "";
			pass = "";
			request.setAttribute("id", id);
			request.setAttribute("password", pass);
			System.out.println("初回");
			getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
		} else {//ログインボタン押下
			if (id != null && pass != null) {//ID・Passがどちらも入っている
				try {
					Connection con = Common.getConnection();
					String sql = "SELECT * FROM kishimoto.skillsheet WHERE db_number=? AND password=?";
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
						RequestDispatcher dispatcher = sc.getRequestDispatcher("/ListBL");
						dispatcher.forward(request, response);
						}
					}catch (SQLException e) {
					System.out.println("SQLException"+ e.getMessage());
				} catch (ClassNotFoundException e) {
					System.out.println("ClassNotFoundException");
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
