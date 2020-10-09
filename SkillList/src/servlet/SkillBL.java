package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Servlet implementation class SkillBL
 */
@WebServlet("/SkillBL")
public class SkillBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkillBL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");

	    InputStream is = null;
	    Workbook wb = null;

	    String db_number = "";
	    String db_name = "";

	    db_number = request.getParameter("db_number");
	    db_name = request.getParameter("db_name");

	    request.setAttribute("db_number", db_number);
	    request.setAttribute("db_name", db_name);

	    try {
	      //Excelファイルを読み込む
	      is = new FileInputStream("C:\\temp\\SkillSheet_" + db_number + "_" + db_name +  ".xlsx");
	      wb = WorkbookFactory.create(is);

	      // Profile読み込み
	      Sheet sh = wb.getSheetAt(0); //シート番号で読み込みたい場合はこちら
	      Row row = sh.getRow(3);              //1行目を読み込む
	      Cell cell = row.getCell(2);          //1セル目を読み込む
	      String value = cell.getStringCellValue();  //セルの値をString値として読み込む
	      request.setAttribute("kana", value);

	      row = sh.getRow(4);
	      cell = row.getCell(2);
	      value = cell.getStringCellValue();
	      request.setAttribute("name", value);

	      row = sh.getRow(5);
	      cell = row.getCell(2);
	      value = cell.getStringCellValue();
	      request.setAttribute("address", value);

	      row = sh.getRow(3);
	      cell = row.getCell(8);
	      value = cell.getStringCellValue();
	      request.setAttribute("birthday", value);

	      row = sh.getRow(3);
	      cell = row.getCell(12);
	      value = cell.getStringCellValue();
	      request.setAttribute("age", value);

	      row = sh.getRow(4);
	      cell = row.getCell(8);
	      value = cell.getStringCellValue();
	      request.setAttribute("gender", value);

	      row = sh.getRow(4);
	      cell = row.getCell(10);
	      value = cell.getStringCellValue();
	      request.setAttribute("background", value);

	      row = sh.getRow(4);
	      cell = row.getCell(12);
	      value = cell.getStringCellValue();
	      request.setAttribute("backgroundNumber", value);

	      row = sh.getRow(5);
	      cell = row.getCell(8);
	      value = cell.getStringCellValue();
	      request.setAttribute("nearestStation", value);

	      row = sh.getRow(5);
	      cell = row.getCell(10);
	      value = cell.getStringCellValue();
	      request.setAttribute("stationName", value);


	      // Skill Info読み込み
	      row = sh.getRow(8);
	      cell = row.getCell(2);
	      value = cell.getStringCellValue();
	      request.setAttribute("os", value);

	      row = sh.getRow(9);
	      cell = row.getCell(2);
	      value = cell.getStringCellValue();
	      request.setAttribute("skill", value);

	      row = sh.getRow(9);
	      cell = row.getCell(9);
	      value = cell.getStringCellValue();
	      request.setAttribute("tool", value);

	      row = sh.getRow(12);
	      cell = row.getCell(2);
	      value = cell.getStringCellValue();
	      request.setAttribute("db", value);

	      row = sh.getRow(14);
	      cell = row.getCell(2);
	      value = cell.getStringCellValue();
	      request.setAttribute("qualification", value);

	    } catch (Exception ex) {
	      ex.printStackTrace();

	    } finally {
	      try {
	        wb.close();
	      } catch (Exception ex2) {
	        ex2.printStackTrace();
	      }
	    }

	    String view = "/jsp/Skill.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
