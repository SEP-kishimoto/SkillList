package servlet;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Servlet implementation class DownloadBL
 */
@WebServlet("/DownloadBL")
public class DownloadBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadBL() {
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
		String filename = request.getParameter("filename");
		System.out.println(filename);
		// ワークブック作成
		XSSFWorkbook book = new XSSFWorkbook();

		filename = "C:\\temp\\"+"SkillSheetダウンロードテスト.xlsx";
		System.out.println(filename);
		// シート作成
		XSSFSheet sheet = book.createSheet("SkillSheet");
//項目名
		XSSFRow row = sheet.createRow(0);//各項目作成
		XSSFCell cell = row.createCell((short) 4);// セル作成
		cell.setCellValue("Skill Sheet");//見出し
		row = sheet.createRow(1);
		cell = row.createCell((short) 9);
		cell.setCellValue("更新日");
		row = sheet.createRow(2);
		cell = row.createCell((short) 0);
		cell.setCellValue("⇒ProFile");
		row = sheet.createRow(3);
		cell = row.createCell((short) 0);
		cell.setCellValue("フリガナ");
		cell = row.createCell((short) 7);
		cell.setCellValue("生年月日");
		row = sheet.createRow(4);
		cell = row.createCell((short) 0);
		cell.setCellValue("氏名");
		cell = row.createCell((short) 7);
		cell.setCellValue("性別");
		cell = row.createCell((short) 9);
		cell.setCellValue("最終学歴");
		row = sheet.createRow(5);
		cell = row.createCell((short) 0);
		cell.setCellValue("現住所");
		cell = row.createCell((short) 7);
		cell.setCellValue("最寄り駅");
		row = sheet.createRow(7);
		cell = row.createCell((short) 0);
		cell.setCellValue("⇒SkillInfo");
		row = sheet.createRow(8);
		cell = row.createCell((short) 0);
		cell.setCellValue("OS");
		row = sheet.createRow(9);
		cell = row.createCell((short) 0);
		cell.setCellValue("スキル");
		cell = row.createCell((short) 8);
		cell.setCellValue("ツール");
		row = sheet.createRow(13);
		cell = row.createCell((short) 0);
		cell.setCellValue("データベース");
		row = sheet.createRow(14);
		cell = row.createCell((short) 0);
		cell.setCellValue("資格");
		row = sheet.createRow(16);
		cell = row.createCell((short) 0);
		cell.setCellValue("⇒BackGroundNote");
		row = sheet.createRow(14);
		cell = row.createCell((short) 0);
		cell.setCellValue("資格");
		row = sheet.createRow(17);
		cell = row.createCell((short) 0);
		cell.setCellValue("No");
		cell = row.createCell((short) 1);
		cell.setCellValue("期間");
		cell = row.createCell((short) 3);
		cell.setCellValue("業務内容");
		cell = row.createCell((short) 8);
		cell.setCellValue("フェーズ");
		cell = row.createCell((short) 10);
		cell.setCellValue("人数");
		cell = row.createCell((short) 11);
		cell.setCellValue("開発環境");
		row = sheet.createRow(18);
		cell = row.createCell((short) 1);
		cell.setCellValue("始");
		row = sheet.createRow(19);
		cell = row.createCell((short) 1);
		cell.setCellValue("");
		row = sheet.createRow(27);
		cell = row.createCell((short) 1);
		cell.setCellValue("終");

//各情報



		try (FileOutputStream out = new FileOutputStream(filename);) {
			book.write(out);
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

//	    ServletContext sc = getServletContext();
//		RequestDispatcher dispatcher = sc.getRequestDispatcher("/LoginBL");
//		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
