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

	public static Cell getCell(Sheet sheet, int rowPoint, int cellPoint) {
		Row row = sheet.getRow(rowPoint);
		Cell cell = row.getCell(cellPoint);

		return cell;
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
	    String master_flg = "";
	    String filename = "";

	    db_number = (String) request.getAttribute("db_number");
	    db_name = (String) request.getAttribute("db_name");
	    master_flg = (String) request.getAttribute("master_flg");
	    filename = (String) request.getAttribute("filename");

	    request.setAttribute("db_number", db_number);
	    request.setAttribute("db_name", db_name);
	    request.setAttribute("master_flg", master_flg);
	    request.setAttribute("filename", filename);

	    try {
	      //Excelファイルを読み込む
	      is = new FileInputStream("C:\\temp\\" + filename);
	      wb = WorkbookFactory.create(is);


	      Sheet sh = wb.getSheetAt(0); //シート番号で読み込みたい場合はこちら

	      // Profile読み込み
	      String value = getCell(sh, 3, 2).getStringCellValue();
	      request.setAttribute("kana", value);

	      value = getCell(sh, 4, 2).getStringCellValue();
	      request.setAttribute("name", value);

	      value = getCell(sh, 5, 2).getStringCellValue();
	      request.setAttribute("address", value);

	      value = getCell(sh, 3, 8).getStringCellValue();
	      request.setAttribute("birthday", value);

	      value = getCell(sh, 3, 12).getStringCellValue();
	      request.setAttribute("age", value);

	      value = getCell(sh, 4, 8).getStringCellValue();
	      request.setAttribute("gender", value);

	      value = getCell(sh, 4, 10).getStringCellValue();
	      request.setAttribute("background", value);

	      value = getCell(sh, 4, 12).getStringCellValue();
	      request.setAttribute("backgroundNumber", value);

	      value = getCell(sh, 5, 8).getStringCellValue();
	      request.setAttribute("nearestStation", value);

	      value = getCell(sh, 5, 10).getStringCellValue();
	      request.setAttribute("stationName", value);


	      // Skill Info読み込み
	      value = getCell(sh, 8, 2).getStringCellValue();
	      request.setAttribute("os", value);

	      value = "";
	      for (int i = 9; i <= 12; i++) {
	    	  if (getCell(sh, i, 9).getStringCellValue() == "") {
	    		  break;
	    	  }
	    	  value += getCell(sh, i, 2).getStringCellValue() + "|";
	      }
	      request.setAttribute("skill", value);

	      value = "";
	      for (int i = 9; i <= 12; i++) {
	    	  if (getCell(sh, i, 9).getStringCellValue() == "") {
	    		  break;
	    	  }
	    	  value += getCell(sh, i, 9).getStringCellValue() + "|";
	      }
	      request.setAttribute("tool", value);

	      value = getCell(sh, 12, 2).getStringCellValue();
	      request.setAttribute("db", value);

	      value = getCell(sh, 14, 2).getStringCellValue();
	      request.setAttribute("qualification", value);


	      // Background Note読み込み表示
	      value = Integer.toString((int)getCell(sh, 18, 0).getNumericCellValue());
	      request.setAttribute("noteNumber", value);


	      value = getCell(sh, 18, 2).getStringCellValue();
	      request.setAttribute("beginning", value);

	      /*
	      value = getCell(sh, 27, 2).getStringCellValue();
	      request.setAttribute("end", value);

	      value = getCell(sh, 18, 3).getStringCellValue();
	      request.setAttribute("task", value);

	      value = getCell(sh, 19, 9).getStringCellValue();
	      request.setAttribute("requirement", value);

	      value = getCell(sh, 20, 9).getStringCellValue();
	      request.setAttribute("basic", value);

	      value = getCell(sh, 21, 9).getStringCellValue();
	      request.setAttribute("details", value);

	      value = getCell(sh, 22, 9).getStringCellValue();
	      request.setAttribute("pg", value);

	      value = getCell(sh, 23, 9).getStringCellValue();
	      request.setAttribute("single", value);

	      value = getCell(sh, 24, 9).getStringCellValue();
	      request.setAttribute("join", value);

	      value = getCell(sh, 25, 9).getStringCellValue();
	      request.setAttribute("customer", value);

	      value = getCell(sh, 27, 9).getStringCellValue();
	      request.setAttribute("environment", value);

	      value = getCell(sh, 18, 10).getStringCellValue();
	      request.setAttribute("peopleNumber", value);

	      value = getCell(sh, 18, 11).getStringCellValue();
	      request.setAttribute("development", value);
	      */


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
