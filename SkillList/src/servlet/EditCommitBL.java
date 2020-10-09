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
 * Servlet implementation class EditCmmit
 */
@WebServlet("/EditCommitBL")
public class EditCommitBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCommitBL() {
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

	    // 変数を宣言
	    String db_number = "";
	    String db_name = "";

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
	    db_number = request.getParameter("db_number");
	    db_name = request.getParameter("db_name");

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
		      is = new FileInputStream("C:\\temp\\SkillSheet_" + db_number + "_" + db_name + ".xlsx");
		      wb = WorkbookFactory.create(is);

		      // Sheet sh = wb.getSheetAt(0);

		      getCell(wb.getSheetAt(0), 3, 2).setCellValue(kana);
		      getCell(wb.getSheetAt(0), 4, 2).setCellValue(name);
		      getCell(wb.getSheetAt(0), 5, 2).setCellValue(address);
		      getCell(wb.getSheetAt(0), 3, 8).setCellValue(birthday);
		      getCell(wb.getSheetAt(0), 3, 12).setCellValue(age);
		      getCell(wb.getSheetAt(0), 4, 8).setCellValue(gender);
		      getCell(wb.getSheetAt(0), 4, 10).setCellValue(background);
		      getCell(wb.getSheetAt(0), 4, 12).setCellValue(backgroundNumber);
		      getCell(wb.getSheetAt(0), 5, 8).setCellValue(nearestStation);
		      getCell(wb.getSheetAt(0), 5, 10).setCellValue(stationName);

		      getCell(wb.getSheetAt(0), 10, 2).setCellValue(os);
		      getCell(wb.getSheetAt(0), 11, 2).setCellValue(skill);
		      getCell(wb.getSheetAt(0), 11, 9).setCellValue(tool);
		      getCell(wb.getSheetAt(0), 13, 2).setCellValue(db);
		      getCell(wb.getSheetAt(0), 14, 2).setCellValue(qualification);


		      // Excelファイルに書き込む
		      out = new FileOutputStream("C:\\temp\\sampleskill_" + db_number + "_" + db_name + ".xlsx");
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
