package servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
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



	private static void copyRow(Workbook workbook, Sheet worksheet, int sourceRowNum, int destinationRowNum) {	// ワークブック,ワークシート,コピー元の行,コピー先の行
	  Row newRow = worksheet.getRow(destinationRowNum);
	  Row sourceRow = worksheet.getRow(sourceRowNum);


	    //行を作成
	    newRow = worksheet.createRow(destinationRowNum);



	  // セルの型、スタイル、値などをすべてコピーする
	  for (int i = 0; i < sourceRow.getLastCellNum(); i++) {

	    Cell oldCell = sourceRow.getCell(i);
	    Cell newCell = newRow.createCell(i);

	    // コピー元の行が存在しない場合、処理を中断
	    if (oldCell == null) {
	      newCell = null;
	      continue;
	    }

	    //スタイルのコピー
	    CellStyle newCellStyle = workbook.createCellStyle();
	    newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
	    newCell.setCellStyle(newCellStyle);

	    //コメントのコピー
	    if (oldCell.getCellComment() != null) {
	      newCell.setCellComment(oldCell.getCellComment());
	    }


	    //セルの文字コピー
	    try {
	    	newCell.setCellValue(oldCell.getStringCellValue());
	    } catch(IllegalStateException e) {

	    }






	    newRow.setHeightInPoints((float)13.5);	// 行の高さ設定
	  }
	  //セル結合
	  worksheet.addMergedRegion(new CellRangeAddress(destinationRowNum,destinationRowNum, 3, 7));
	  worksheet.addMergedRegion(new CellRangeAddress(destinationRowNum,destinationRowNum, 11, 12));
	  if(sourceRowNum == 27) {
		  worksheet.addMergedRegion(new CellRangeAddress(destinationRowNum-9,destinationRowNum,0,0));
		  worksheet.addMergedRegion(new CellRangeAddress(destinationRowNum - 8,destinationRowNum -1,1,2));
		  worksheet.addMergedRegion(new CellRangeAddress(destinationRowNum - 9,destinationRowNum,10,10));


	  }
	}




	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		ResultSet rs = null;
		// Profile
		String kana = request.getParameter("kana");
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
		// Background Note	1つだけ出力
//		String noteNumber = request.getParameter("noteNumber");
//		String beginning = request.getParameter("beginning");
//		String end = request.getParameter("end");
//		String task = request.getParameter("task");
//		String requirement = request.getParameter("requirement");
//		String basic = request.getParameter("basic");
//		String details = request.getParameter("details");
//		String pg = request.getParameter("pg");
//		String single = request.getParameter("single");
//		String join = request.getParameter("join");
//		String customer = request.getParameter("customer");
//		String environment = request.getParameter("environment");
//		String peopleNumber = request.getParameter("peopleNumber");
//		String development = request.getParameter("development");

		// DB登録情報
		String db_number = request.getParameter("db_number");
	    String db_name = request.getParameter("db_name");
	    String password = request.getParameter("password");



	    // Background Note
	    List<String> noteNumber = new ArrayList<String>();
	    List<String> beginning = new ArrayList<String>();
	    List<String> end = new ArrayList<String>();
	    List<String> task = new ArrayList<String>();

	    // フェーズ
	    List<String> requirement = new ArrayList<String>();
	    List<String> basic = new ArrayList<String>();
	    List<String> details = new ArrayList<String>();
	    List<String> pg = new ArrayList<String>();
	    List<String> single = new ArrayList<String>();
	    List<String> join = new ArrayList<String>();
	    List<String> customer = new ArrayList<String>();
	    List<String> environment = new ArrayList<String>();
	    // フェーズここまで

	    List<String> peopleNumber = new ArrayList<String>();
	    List<String> development = new ArrayList<String>();





	    HttpSession session = request.getSession();
	    noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");
	    beginning = (ArrayList<String>) session.getAttribute("beginning");
	    end = (ArrayList<String>) session.getAttribute("end");
	    task = (ArrayList<String>) session.getAttribute("task");
	    requirement = (ArrayList<String>) session.getAttribute("requirement");
	    basic = (ArrayList<String>) session.getAttribute("basic");
	    details = (ArrayList<String>) session.getAttribute("details");
	    pg = (ArrayList<String>) session.getAttribute("pg");
	    single = (ArrayList<String>) session.getAttribute("single");
	    join = (ArrayList<String>) session.getAttribute("join");
	    customer = (ArrayList<String>) session.getAttribute("customer");
	    environment = (ArrayList<String>) session.getAttribute("environment");
	    peopleNumber = (ArrayList<String>) session.getAttribute("peopleNumber");
	    development = (ArrayList<String>) session.getAttribute("development");



        // 出力ファイル
        FileOutputStream outPutFile = null;
        // 出力ファイルパス
        String outPutFilePath = null;
        // 出力ファイル名
        String outPutFileName = null;

        skill = skill.replace("、", ",");	// 全角カンマから半角に置換
        birthday = birthday.replace("年", "/").replace("月", "/").replace("日", "");
		 try {
	            //Excelのワークブックを読み込みます。
			 	FileInputStream fis = new FileInputStream("C:\\temp\\SkillSheet_xxxx(空).xlsx");

	            XSSFWorkbook wb = new XSSFWorkbook(fis);
	            //シートを読み込みます。
	           //XSSFSheet sheet = wb.getSheet("Skill Sheet");
//	            //1行目の値を読み込みます。
//	            XSSFRow row = sheet.getRow(1);
//	            //getStringCellValueにて文字列を読み込みます。
//	            XSSFCell cell = row.getCell((short) 10);

	            int roop = noteNumber.size() - 5;		// コピーするBackground Noteの数

	            if (roop >= 1) {
	            	 for (int p = 0;p < roop;p++) { // Background Note追加数分ループ

	 	            	for (int i = 0;i < 10;i++) {	// Background Note追加処理
	 		            	copyRow(wb,wb.getSheetAt(0),18 + i,68 + i + (p * 10));
	 		            }

	 	            }
	            }




	            LocalDateTime date1 = LocalDateTime.now();
	            DateTimeFormatter dtformat3 =
	        			DateTimeFormatter.ofPattern("yyyy/MM/dd");
	        				String fdate3 = dtformat3.format(date1);

	              getCell(wb.getSheetAt(0), 1, 10).setCellValue(fdate3);	// 更新日
	              getCell(wb.getSheetAt(0), 3, 2).setCellValue(kana);
			      getCell(wb.getSheetAt(0), 4, 2).setCellValue(db_name);
			      getCell(wb.getSheetAt(0), 5, 2).setCellValue(address);
			      Date date = DateUtil.parseYYYYMMDDDate(birthday);
			      getCell(wb.getSheetAt(0), 3, 8).setCellValue(date);

			      //getCell(wb.getSheetAt(0), 3, 12).setCellValue(age + "歳");
			      getCell(wb.getSheetAt(0), 4, 8).setCellValue(gender);
			      getCell(wb.getSheetAt(0), 4, 10).setCellValue(background);
			      getCell(wb.getSheetAt(0), 4, 12).setCellValue(backgroundNumber);
			      getCell(wb.getSheetAt(0), 5, 8).setCellValue(nearestStation);
			      getCell(wb.getSheetAt(0), 5, 10).setCellValue(stationName);

			   // ここからSkill Info
			      getCell(wb.getSheetAt(0), 8, 2).setCellValue(os);
//			      getCell(wb.getSheetAt(0), 9, 2).setCellValue(skill);
//			      getCell(wb.getSheetAt(0), 9, 9).setCellValue(tool);




			      skill += ",";
			      // ','で改行
			      int n = 0;
			      int charcount = 0;	// 文字数カウント
			      String moji ="";



			      String[] skillList = skill.split(",", -1);
			      int p = 9;
			      for (int i = 0; i < skillList.length;i++) {
			    	  if (i == skillList.length - 1) {
			    		  getCell(wb.getSheetAt(0), p, 2).setCellValue(moji);
			    		  break;
			    	  }
			    	  if (moji.length() + skillList[n].length() + 1 > 33) {	// 行に設定する文字数 + これから設定しようとしている文字数 + カンマ分 > 行に入る文字数(全角)
			    		  System.out.println(moji);
			    		  getCell(wb.getSheetAt(0), p, 2).setCellValue(moji);
			    		  p++;
			    		  charcount = 0;
			    	  }

			    	  if (charcount == 0) {
			    		  moji = skillList[n];
			    		  charcount = skillList[n].length();
			    	  } else {
			    		  moji += "," + skillList[n];
			    		  charcount += skillList[n].length() + 1;
			    	  }

			    	  if (n <= 12) {
			    		  n++;
			    	  } else {
			    		  break;
			    	  }

			      }


			      tool += ",";
			      n = 0;
			      String[] toolList = tool.split(",", -1);
			      for (int i = 9; i <= 12; i++) {
			    	  getCell(wb.getSheetAt(0), i, 9).setCellValue(toolList[n]);
			    	  if (toolList[n].equals("")) {
			    		  break;
			    	  }
			    	  n++;
			      }

			      getCell(wb.getSheetAt(0), 13, 2).setCellValue(db);
			      getCell(wb.getSheetAt(0), 14, 2).setCellValue(qualification);



			      n = 0;
			      // Background Note 書き込み設定
			      for (int i = 0; i < noteNumber.size();i++) {
			    	  date = null;
			    	  if (beginning.get(i) == "") {
			    		  getCell(wb.getSheetAt(0), 18 + n, 2).setCellValue("");
			    	  } else {
			    		  date = DateUtil.parseYYYYMMDDDate(beginning.get(i));
			    	  }
			    	  getCell(wb.getSheetAt(0), 18 + n, 2).setCellValue(date);

			    	  if (end.get(i) == "") {
			    		  getCell(wb.getSheetAt(0), 27 + n, 2).setCellValue("");
			    	  } else {
			    		  date = DateUtil.parseYYYYMMDDDate(end.get(i));
			    	  }
			    	  getCell(wb.getSheetAt(0), 27 + n, 2).setCellValue(date);

			    	  task.set(i,task.get(i) + ",");
			    	  String[] taskList = task.get(i).split(",", -1);
			    	  for (int s = 0; s < 10; s++) {
			    		  getCell(wb.getSheetAt(0), 18 + n + s, 3).setCellValue(taskList[s]);
			    		  if (taskList[s].equals("")) {
			    			  break;
			    		  }
			    	  }
			    	  for (int s = 0; s < 8; s ++) {
			    		  getCell(wb.getSheetAt(0), 19 + n + s, 9).setCellValue(requirement.get(i));
				    	  getCell(wb.getSheetAt(0), 19 + n + s, 9).setCellValue(basic.get(i));
				    	  getCell(wb.getSheetAt(0), 19 + n + s, 9).setCellValue(details.get(i));
				    	  getCell(wb.getSheetAt(0), 19 + n + s, 9).setCellValue(pg.get(i));
				    	  getCell(wb.getSheetAt(0), 19 + n + s, 9).setCellValue(single.get(i));
				    	  getCell(wb.getSheetAt(0), 19 + n + s, 9).setCellValue(join.get(i));
				    	  getCell(wb.getSheetAt(0), 19 + n + s, 9).setCellValue(customer.get(i));
				    	  getCell(wb.getSheetAt(0), 19 + n + s, 9).setCellValue(environment.get(i));
			    	  }
			    	  getCell(wb.getSheetAt(0), 18 + n, 10).setCellValue(peopleNumber.get(i));
			    	  development.set(i,development.get(i) + ",");
			    	  for (int s = 0; s < 10; s++) {
			    		  String[] developmentList = development.get(i).split(",", -1);
			    		  getCell(wb.getSheetAt(0), 18 + n + s, 11).setCellValue(developmentList[s]);
			    		  if (developmentList[s].equals("")) {
			    			  break;
			    		  }
			    	  }
			    	  n = n + 10;
			      }

			      wb.getSheetAt(0).setForceFormulaRecalculation(true);	// 関数を使えるようにする
			      // 再計算
			      wb.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(getCell(wb.getSheetAt(0), 3, 8));
	         // エクセルファイルを出力
	            try {

	                //ファイルパス・ファイル名の指定
	                outPutFilePath = "C:\\temp\\";
	                outPutFileName = "SkillSheet_"  + db_number + "_" + db_name +  ".xlsx";

	                wb.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(getCell(wb.getSheetAt(0), 3, 8));
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


		 // DB登録処理
		 try {
				Connection con = Common.getConnection();
				String sql = "INSERT INTO skillsheet(db_number,db_name,password,master_flg,filename) VALUES (?,?,?,0,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, db_number);
				ps.setString(2, db_name);
				ps.setString(3, password);
				ps.setString(4, outPutFileName);
				ps.executeUpdate();

			}catch (SQLException e) {
				System.out.println("SQLException");
			} catch (Exception e) {
				e.printStackTrace();
			}



		 request.setAttribute("master_flg","1");
        getServletContext().getRequestDispatcher("/ListBL").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
