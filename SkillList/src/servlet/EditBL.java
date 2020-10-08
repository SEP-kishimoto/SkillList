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
 * Servlet implementation class EditBL
 */
@WebServlet("/EditBL")
public class EditBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");

	    InputStream is = null;
	    Workbook wb = null;

	    try {
	      //Excelファイルを読み込む
	      is = new FileInputStream("C:\\temp\\SkillSheetSample.xlsx");
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

	    String view = "/jsp/Edit.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");

	    //InputStream is = null;
	    //Workbook wb = null;

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


	    // FileOutputStream out = null;

	    // Profaile
	    request.setAttribute("kana", kana);
	    request.setAttribute("name", name);
	    request.setAttribute("address", address);
	    request.setAttribute("birthday", birthday);
	    request.setAttribute("age", age);
	    request.setAttribute("gender", gender);
	    request.setAttribute("background", background);
	    request.setAttribute("backgroundNumber", backgroundNumber);
	    request.setAttribute("nearestStation", nearestStation);
	    request.setAttribute("stationName", stationName);

	    // Skill Info読み込み
	    request.setAttribute("os", os);
	    request.setAttribute("skill", skill);
	    request.setAttribute("tool", tool);
	    request.setAttribute("db", db);
	    request.setAttribute("qualification", qualification);

	    String view = "/jsp/EditCheck.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	    /*
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
	    */
	}

}
