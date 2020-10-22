package servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteBL
 */
@WebServlet("/DeleteBL")
public class DeleteBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String db_number=request.getParameter("db_number");
	    String db_name = request.getParameter("db_name");
	    String filename=request.getParameter("filename");
	    HttpSession session = request.getSession();
	    String master_flg=(String)session.getAttribute("master_flg");

	    try {//DBからユーザーを物理削除
			Connection con = Common.getConnection();
			String sql = "DELETE FROM skillsheet WHERE db_number = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, db_number);
			int delete_num= ps.executeUpdate();
			System.out.println(delete_num);
	    }catch (SQLException e) {
			System.out.println("SQLException"  + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException" + e.getMessage());
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	    File file = new File("C:\\temp\\" + filename);
	    if (file.exists()){//ファイルの存在を判定
	        System.out.println("C:\\temp\\" + filename + "ファイルの存在を確認、削除します。");
	        File delete_file = new File("C:\\temp\\" + filename);
	        delete_file.delete();//deleteメソッドを使用してファイルを削除する

	        //画面遷移先
	        if(master_flg.equals("1")) {
	        	request.setAttribute("master_flg", master_flg);
	        	ServletContext sc = getServletContext();
	    		RequestDispatcher dispatcher = sc.getRequestDispatcher("/ListBL");
	    		dispatcher.forward(request, response);
	        }else {
	        	ServletContext sc = getServletContext();
	    		RequestDispatcher dispatcher = sc.getRequestDispatcher("/LoginBL");
	    		dispatcher.forward(request, response);
	        }
	    }else{
	        System.out.println("ファイルは存在しません");
	        if(master_flg.equals("1")) {
	        	request.setAttribute("master_flg", master_flg);
	        	ServletContext sc = getServletContext();
	    		RequestDispatcher dispatcher = sc.getRequestDispatcher("/ListBL");
	    		dispatcher.forward(request, response);
	        }else {
	        	ServletContext sc = getServletContext();
	    		RequestDispatcher dispatcher = sc.getRequestDispatcher("/LoginBL");
	    		dispatcher.forward(request, response);
	        }
	    }

		// TODO Auto-generated method stub
		doGet(request, response);
	}
	}
