package servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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

	public static Cell getCell(Sheet sheet, int rowPoint, int cellPoint) {
		Row row = sheet.getRow(rowPoint);
		Cell cell = row.getCell(cellPoint);

		return cell;
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
		// Skill Info
		String os = request.getParameter("os");
		String skill = request.getParameter("skill");
		String tool = request.getParameter("tool");
		String db = request.getParameter("db");
		String qualification = request.getParameter("qualification");
		// Background Note
		String noteNumber = request.getParameter("noteNumber");
		String beginning = request.getParameter("beginning");
		String end = request.getParameter("end");
		String task = request.getParameter("task");
		String requirement = request.getParameter("requirement");
		String basic = request.getParameter("basic");
		String details = request.getParameter("details");
		String pg = request.getParameter("pg");
		String single = request.getParameter("single");
		String join = request.getParameter("join");
		String customer = request.getParameter("customer");
		String environment = request.getParameter("environment");
		String peopleNumber = request.getParameter("peopleNumber");
		String development = request.getParameter("development");

		// db
		String db_number = request.getParameter("db_number");
	    String db_name = request.getParameter("db_name");

	    // 仮データ
	    db_number = "0011";
	    db_name = "江戸川湖南";

        // 出力ファイル
        FileOutputStream outPutFile = null;
        // 出力ファイルパス
        String outPutFilePath = null;
        // 出力ファイル名
        String outPutFileName = null;


        birthday = birthday.replace("年", "/").replace("月", "/").replace("日", "");
		 try {
	            //Excelのワークブックを読み込みます。
			 	FileInputStream fis = new FileInputStream("C:\\Users\\kuboshintaro1197\\Desktop\\テスト\\SkillSheet_xxxx(空).xlsx");

	            XSSFWorkbook wb = new XSSFWorkbook(fis);
	            //シートを読み込みます。
	           //XSSFSheet sheet = wb.getSheet("Skill Sheet");
//	            //1行目の値を読み込みます。
//	            XSSFRow row = sheet.getRow(1);
//	            //getStringCellValueにて文字列を読み込みます。
//	            XSSFCell cell = row.getCell((short) 10);


	            LocalDateTime date1 = LocalDateTime.now();
	            DateTimeFormatter dtformat3 =
	        			DateTimeFormatter.ofPattern("yyyy/MM/dd");
	        				String fdate3 = dtformat3.format(date1);

	              getCell(wb.getSheetAt(0), 1, 10).setCellValue(fdate3);	// 更新日
	              getCell(wb.getSheetAt(0), 3, 2).setCellValue(kana);
			      getCell(wb.getSheetAt(0), 4, 2).setCellValue(name);
			      getCell(wb.getSheetAt(0), 5, 2).setCellValue(address);
			      getCell(wb.getSheetAt(0), 3, 8).setCellValue(birthday);
			      getCell(wb.getSheetAt(0), 3, 12).setCellValue(age + "歳");
			      getCell(wb.getSheetAt(0), 4, 8).setCellValue(gender);
			      getCell(wb.getSheetAt(0), 4, 10).setCellValue(background);
			      getCell(wb.getSheetAt(0), 4, 12).setCellValue(backgroundNumber);
			      getCell(wb.getSheetAt(0), 5, 8).setCellValue(nearestStation);
			      getCell(wb.getSheetAt(0), 5, 10).setCellValue(stationName);

			   // ここからSkill Info
			      getCell(wb.getSheetAt(0), 8, 2).setCellValue(os);
//			      getCell(wb.getSheetAt(0), 9, 2).setCellValue(skill);
//			      getCell(wb.getSheetAt(0), 9, 9).setCellValue(tool);


			      skill += "｜";
			      // ','で改行
			      int n = 0;
			      String[] skillList = skill.split("｜", -1);
			      for (int i = 9; i <= 12; i++) {
			    	  getCell(wb.getSheetAt(0), i, 2).setCellValue(skillList[n]);
			    	  if (skillList[n].equals("")) {
			    		  break;
			    	  }
			    	  n++;
			      }

			      tool += "｜";
			      n = 0;
			      String[] toolList = tool.split("｜", -1);
			      for (int i = 9; i <= 12; i++) {
			    	  getCell(wb.getSheetAt(0), i, 9).setCellValue(toolList[n]);
			    	  if (toolList[n].equals("")) {
			    		  break;
			    	  }
			    	  n++;
			      }

			      getCell(wb.getSheetAt(0), 13, 2).setCellValue(db);
			      getCell(wb.getSheetAt(0), 14, 2).setCellValue(qualification);




			      // ここからBackground Note
			      getCell(wb.getSheetAt(0), 18, 0).setCellValue(noteNumber);
	              getCell(wb.getSheetAt(0), 18, 2).setCellValue(beginning);
			      getCell(wb.getSheetAt(0), 27, 2).setCellValue(end);
			      getCell(wb.getSheetAt(0), 18, 3).setCellValue(task);
			      getCell(wb.getSheetAt(0), 19, 9).setCellValue(requirement);
			      getCell(wb.getSheetAt(0), 20, 9).setCellValue(basic);
			      getCell(wb.getSheetAt(0), 21, 9).setCellValue(details);
			      getCell(wb.getSheetAt(0), 22, 9).setCellValue(pg);
			      getCell(wb.getSheetAt(0), 23, 9).setCellValue(single);
			      getCell(wb.getSheetAt(0), 24, 9).setCellValue(join);
			      getCell(wb.getSheetAt(0), 25, 9).setCellValue(customer);
			      getCell(wb.getSheetAt(0), 26, 9).setCellValue(environment);
			      getCell(wb.getSheetAt(0), 18, 10).setCellValue(peopleNumber);
			      getCell(wb.getSheetAt(0), 18, 11).setCellValue(development);









	         // エクセルファイルを出力
	            try {

	                //ファイルパス・ファイル名の指定
	                outPutFilePath = "C:\\Users\\kuboshintaro1197\\Desktop\\テスト\\";
	                outPutFileName = "SkillSheet_"  + db_number + "_" + db_name +  ".xlsx";

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
