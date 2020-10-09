package servlet;

import java.io.FileInputStream;
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
 * Servlet implementation class AddCommit
 */
@WebServlet("/AddCommit")
public class AddCommit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommit() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// Profile
		String kana = request.getParameter("kana");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String background = request.getParameter("background");
		String backgroundNumber = request.getParameter("backgroundNumber");
		String nearestStation = request.getParameter("nearestStation");
		String stationName = request.getParameter("stationName");
		//HashMap<String, String> hashmap = new HashMap<String, String>();
        // 出力ファイル
        FileOutputStream outPutFile = null;
        // 出力ファイルパス
        String outPutFilePath = null;
        // 出力ファイル名
        String outPutFileName = null;



		 try {
	            //Excelのワークブックを読み込みます。
			 	FileInputStream fis = new FileInputStream("C:\\Users\\kuboshintaro1197\\Desktop\\テスト\\Skill_Sheet_xxxx(空).xlsx");

	            XSSFWorkbook wb = new XSSFWorkbook(fis);
	            //シートを読み込みます。
	            XSSFSheet sheet = wb.getSheet("Skill Sheet");
	            //3行目の値を読み込みます。
	            XSSFRow row = sheet.getRow(1);
	            //getStringCellValueにて文字列を読み込みます。
	            XSSFCell cell = row.getCell((short) 10);
	            cell.setCellValue("更新日");
	            row = sheet.getRow(3);
	            cell = row.getCell((short) 2);
	            cell.setCellValue(kana);
	            cell = row.getCell((short) 8);
	            cell.setCellValue(birthday);
	            row = sheet.getRow(4);
	            cell = row.getCell((short) 2);
	            cell.setCellValue(name);
	            cell = row.getCell((short) 8);
	            cell.setCellValue(gender);
	            cell = row.getCell((short) 10);
	            cell.setCellValue(background);
	            cell = row.getCell((short) 12);
	            cell.setCellValue(backgroundNumber);
	            row = sheet.getRow(5);
	            cell = row.getCell((short) 2);
	            cell.setCellValue(address);
	            cell = row.getCell((short) 8);
	            cell.setCellValue(nearestStation);
	            cell = row.getCell((short) 10);
	            cell.setCellValue(stationName);




	         // エクセルファイルを出力
	            try {

	                //ファイルパス・ファイル名の指定
	                outPutFilePath = "C:\\Users\\kuboshintaro1197\\Desktop\\テスト\\";
	                outPutFileName = "Skill_Sheet_社員番号_名前" +  ".xlsx";

	                // エクセルファイルを出力
	                outPutFile = new FileOutputStream(outPutFilePath + outPutFileName);
	                wb.write(outPutFile);

	                System.out.println("「" + outPutFilePath + outPutFileName + "」を出力しました。");
	                wb.close();

	            }catch(IOException e) {
	                System.out.println(e.toString());
	            }


	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("処理が失敗しました");
	        }

        getServletContext().getRequestDispatcher("/jsp/Add.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
