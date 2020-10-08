package servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
 * Servlet implementation class EditCheckBL
 */
@WebServlet("/EditCheckBL")
public class EditCheckBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCheckBL() {
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

	    // 変数を宣言
	    String kana = "";
	    String name = "";
	    String address = "";
	    String birthday = "";
	    String age = "";
	    String gender = "";
	    String background = "";
	    String backgroundNumber = "";
	    String nearestStation = "";
	    String stationName = "";

	    String os = "";
	    String skill = "";
	    String tool = "";
	    String db = "";
	    String qualification = "";

	    // 変数に設定
	    kana = request.getParameter("kana");
	    name = request.getParameter("name");
	    address = request.getParameter("address");
	    birthday = request.getParameter("birthday");
	    age = request.getParameter("age");
	    gender = request.getParameter("gender");
	    background = request.getParameter("background");
	    backgroundNumber = request.getParameter("backgroundNumber");
	    nearestStation = request.getParameter("nearestStation");
	    stationName = request.getParameter("stationName");


	    os = request.getParameter("os");
	    skill = request.getParameter("skill");
	    tool = request.getParameter("tool");
	    db = request.getParameter("db");
	    qualification = request.getParameter("qualification");

	    FileOutputStream out = null;

		try {

		      //Excelファイルを読み込む
		      is = new FileInputStream("C:\\temp\\SkillSheetSample.xlsx");
		      wb = WorkbookFactory.create(is);

		      Sheet sh = wb.getSheetAt(0);
		      Row row = sh.getRow(3);
		      Cell cell = row.getCell(2);
		      cell.setCellValue(kana);

		      row = sh.getRow(4);
		      cell = row.getCell(2);
		      cell.setCellValue(name);

		      row = sh.getRow(5);
		      cell = row.getCell(2);
		      cell.setCellValue(address);

		      row = sh.getRow(3);
		      cell = row.getCell(8);
		      cell.setCellValue(birthday);

		      row = sh.getRow(3);
		      cell = row.getCell(12);
		      cell.setCellValue(age);

		      row = sh.getRow(4);
		      cell = row.getCell(8);
		      cell.setCellValue(gender);

		      row = sh.getRow(4);
		      cell = row.getCell(10);
		      cell.setCellValue(background);

		      row = sh.getRow(4);
		      cell = row.getCell(12);
		      cell.setCellValue(backgroundNumber);

		      row = sh.getRow(5);
		      cell = row.getCell(8);
		      cell.setCellValue(nearestStation);

		      row = sh.getRow(5);
		      cell = row.getCell(10);
		      cell.setCellValue(stationName);


		      row = sh.getRow(10);
		      cell = row.getCell(2);
		      cell.setCellValue(os);

		      row = sh.getRow(11);
		      cell = row.getCell(2);
		      cell.setCellValue(skill);

		      row = sh.getRow(11);
		      cell = row.getCell(9);
		      cell.setCellValue(tool);

		      row = sh.getRow(13);
		      cell = row.getCell(2);
		      cell.setCellValue(db);

		      row = sh.getRow(14);
		      cell = row.getCell(2);
		      cell.setCellValue(qualification);


		      out = new FileOutputStream("C:\\temp\\sampleskill.xlsx");

		      wb.write(out);




		    } catch (Exception ex) {
		      ex.printStackTrace();

		    } finally {
		      try {
		        // wb.close();
		      } catch (Exception ex2) {
		        ex2.printStackTrace();
		      }
		    }
	}

}
