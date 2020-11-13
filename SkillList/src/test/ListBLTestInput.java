package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListBLTestInput
 */
@WebServlet("/ListBLTestInput")
public class ListBLTestInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBLTestInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * 期待すること
		 * 変数 db_number, db_name, master_flg, filenameがListBLに渡されていること
		 */

		String db_number = "9999";
		String db_name = "試験男";
		/*
		 * 管理者 1
		 * 一般 0
		 * 両方の場合でテストする際は、切り替える
		 */
		String master_flg = "1";
		//String master_flg = "0";
		String filename = "SkillSheet_9999_試験男.xlsx";

		request.setAttribute("db_number", db_number);
		request.setAttribute("db_name", db_name);
		request.setAttribute("master_flg", master_flg);
		request.setAttribute("filename", filename);

		getServletContext().getRequestDispatcher("/ListBL").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
