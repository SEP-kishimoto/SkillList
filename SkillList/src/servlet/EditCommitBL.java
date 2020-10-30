package servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * Servlet implementation class EditCmmit
 */
@SuppressWarnings("unchecked")
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
		if (row == null) {
			return null;
		}
		Cell cell = row.getCell(cellPoint);

		return cell;

	}
	public static Cell createCell(Sheet sheet, int rowPoint, int cellPoint) {
		Row row = sheet.createRow(rowPoint);
		Cell cell = row.createCell(cellPoint);

		return cell;

	}

	private static void copyRow(Workbook workbook, Sheet worksheet, int sourceRowNum, int destinationRowNum) {
		  Row newRow = worksheet.getRow(destinationRowNum);
		  Row sourceRow = worksheet.getRow(sourceRowNum);

		  if (newRow != null) {
		    //コピー先に行が既に存在する場合、１行下にずらす
		    worksheet.shiftRows(destinationRowNum, worksheet.getLastRowNum(), 1);
		    newRow = worksheet.createRow(destinationRowNum);
		    newRow.setHeight(sourceRow.getHeight());
		  } else {
		    //存在しない場合は作成
		    newRow = worksheet.createRow(destinationRowNum);
		    newRow.setHeight(sourceRow.getHeight());
		  }

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
		  }

		  //セル結合のコピー
		  for (int i = 0; i < worksheet.getNumMergedRegions(); i++) {
		    CellRangeAddress cellRangeAddress = worksheet.getMergedRegion(i);
		    if (cellRangeAddress.getFirstRow() == sourceRow.getRowNum()) {
		      CellRangeAddress newCellRangeAddress = new CellRangeAddress(newRow.getRowNum(),
		          (newRow.getRowNum() + (cellRangeAddress.getLastRow() - cellRangeAddress.getFirstRow())),
		          cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn());
		      worksheet.addMergedRegion(newCellRangeAddress);
		    }
		  }
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
	    String master_flg = "";
	    String filename = "";

	    String kana = "";
	    String name = "";
	    String address = "";
	    String birthday = "";
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

	    // Background Note変数
	    List<String> noteNumber = new ArrayList<String>();
	    List<String> beginning = new ArrayList<String>();
	    List<String> end = new ArrayList<String>();
	    List<String> task = new ArrayList<String>();

	    ArrayList<List<String>> requirement = new ArrayList<>();
	    ArrayList<List<String>> basic = new ArrayList<>();
	    ArrayList<List<String>> details = new ArrayList<>();
	    ArrayList<List<String>> pg = new ArrayList<>();
	    ArrayList<List<String>> single = new ArrayList<>();
	    ArrayList<List<String>> join = new ArrayList<>();
	    ArrayList<List<String>> customer = new ArrayList<>();
	    ArrayList<List<String>> environment = new ArrayList<>();

	    List<String> peopleNumber = new ArrayList<String>();
	    List<String> development = new ArrayList<String>();

	    // 変数に設定
	    db_number = request.getParameter("db_number");
	    db_name = request.getParameter("db_name");
	    master_flg = request.getParameter("master_flg");
	    filename = request.getParameter("filename");

	    kana = request.getParameter("kana");
	    name = request.getParameter("name");
	    address = request.getParameter("address");
	    birthday = request.getParameter("birthday");
	    gender = request.getParameter("gender");
	    background = request.getParameter("background");
	    backgroundNumber = request.getParameter("backgroundNumber");
	    nearestStation = request.getParameter("nearestStation");
	    stationName = request.getParameter("stationName");

	    os = request.getParameter("os");
	    skill = request.getParameter("skill");
	    skill = skill.replace("、", ",");	// 全角カンマから半角に置換
	    tool = request.getParameter("tool");
	    db = request.getParameter("db");
	    qualification = request.getParameter("qualification");

	    HttpSession session = request.getSession();
	    noteNumber = (ArrayList<String>) session.getAttribute("noteNumber");
	    beginning = (ArrayList<String>) session.getAttribute("beginning");
	    end = (ArrayList<String>) session.getAttribute("end");
	    task = (ArrayList<String>) session.getAttribute("task");

	    requirement = (ArrayList<List<String>>) session.getAttribute("requirement");
	    basic = (ArrayList<List<String>>) session.getAttribute("basic");
	    details = (ArrayList<List<String>>) session.getAttribute("details");
	    pg = (ArrayList<List<String>>) session.getAttribute("pg");
	    single = (ArrayList<List<String>>) session.getAttribute("single");
	    join = (ArrayList<List<String>>) session.getAttribute("join");
	    customer = (ArrayList<List<String>>) session.getAttribute("customer");
	    environment = (ArrayList<List<String>>) session.getAttribute("environment");

	    peopleNumber = (ArrayList<String>) session.getAttribute("peopleNumber");
	    development = (ArrayList<String>) session.getAttribute("development");

	    FileOutputStream out = null;

		try {

		      //Excelファイルを読み込む
		      is = new FileInputStream("C:\\temp\\" + filename);
		      wb = WorkbookFactory.create(is);

		      Sheet sh = wb.getSheetAt(0);
		      sh.setForceFormulaRecalculation(true);

		      birthday = birthday.replace("年", "/").replace("月", "/").replace("日", "");
		      Date date = DateUtil.parseYYYYMMDDDate(birthday);

		      // Profile 書き込み設定
		      getCell(sh, 3, 2).setCellValue(kana);
		      getCell(sh, 4, 2).setCellValue(name);
		      getCell(sh, 5, 2).setCellValue(address);
		      getCell(sh, 3, 8).setCellValue(date);
		      getCell(sh, 4, 8).setCellValue(gender);
		      getCell(sh, 4, 10).setCellValue(background);
		      getCell(sh, 4, 12).setCellValue(backgroundNumber);
		      getCell(sh, 5, 8).setCellValue(nearestStation);
		      getCell(sh, 5, 10).setCellValue(stationName);


		      // Skill Info 書き込み設定
		      getCell(sh, 8, 2).setCellValue(os);

		      // ','で改行
		      int n = 0;
		      int charcount = 0;	// 文字数カウントs
		      String moji ="";
		      int p = 9;
		      String[] skillList = skill.split(",", -1);
		      for (int i = 0; i < skillList.length; i++) {
		    	  if (i == skillList.length - 1) {
		    		  getCell(sh, p, 2).setCellValue(moji);
		    		  if (skillList[n].equals("")) {
			    		  for (int brank = 0; brank <= 12 - p - 1; brank++) {
			    			  getCell(sh, brank + p + 1, 2).setCellValue("");
			    		  }
			    	  }
		    		  break;
		    	  }
		    	  if (moji.length() + skillList[n].length() + 1 > 33) {
		    		  getCell(sh, p, 2).setCellValue(moji);
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

		    	  if (p <= 12) {
		    		  n++;
		    	  } else {
		    		  break;
		    	  }
		      }

		      n = 0;
		      String[] toolList = tool.split(",", -1);
		      for (int i = 9; i <= 12; i++) {
		    	  getCell(sh, i, 9).setCellValue(toolList[n]);
		    	  if (toolList[n].equals("")) {
		    		  for (int brank = 0; brank <= 12 - i; brank++) {
		    			  getCell(sh, brank + i, 9).setCellValue("");
		    		  }
		    		  break;
		    	  }
		    	  n++;
		      }
		      getCell(sh, 13, 2).setCellValue(db);
		      getCell(sh, 14, 2).setCellValue(qualification);


		      // Background Note 項目を生成
		      n = 0;
		      for (int i = 0; i < noteNumber.size(); i++) {
		    	  if (getCell(sh, 18 + n, 0) == null) {
		    		  for (int s = 0; s < 10; s++) {
		    			  copyRow(wb, sh, 18 + s, 18 + n + s);
		    		  }
		    		  getCell(sh, 18 + n, 0).setCellFormula(("A" + (18 + n - 9)) + "+1");
		    		  getCell(sh, 18 + n, 1).setCellValue("始");
		    		  getCell(sh, 27 + n, 1).setCellValue("終");
		    		  getCell(sh, 19 + n, 1).setCellFormula("IF(AND(C" + (19 + n) + "<>\"\",C" + (28 + n) + "<>\"\"),(DATEDIF(C" + (19 + n) + ",C" + (28 + n) +  ",\"M\")+1)&\"ヶ月\",\"\")");
		    		  wb.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(getCell(sh, 19 + n, 1));
		    		  getCell(sh, 19 + n, 8).setCellValue("要件定義");
		    		  getCell(sh, 20 + n, 8).setCellValue("基本設計");
		    		  getCell(sh, 21 + n, 8).setCellValue("詳細設計");
		    		  getCell(sh, 22 + n, 8).setCellValue("PG製造");
		    		  getCell(sh, 23 + n, 8).setCellValue("単体試験");
		    		  getCell(sh, 24 + n, 8).setCellValue("結合試験");
		    		  getCell(sh, 25 + n, 8).setCellValue("客先試験");
		    		  getCell(sh, 26 + n, 8).setCellValue("環境設定");
		    	  }
		    	  n = n + 10;
		      }

		      // Background Note 書き込み設定
		      n = 0;
		      for (int i = 0; i < noteNumber.size();i++) {
		    	  date = null;
		    	  if (beginning.get(i) == "") {
		    		  getCell(sh, 18 + n, 2).setCellValue("");
		    	  } else {
		    		  date = DateUtil.parseYYYYMMDDDate(beginning.get(i));
		    	  }
		    	  getCell(sh, 18 + n, 2).setCellValue(date);

		    	  if (end.get(i) == "") {
		    		  getCell(sh, 27 + n, 2).setCellValue("");
		    	  } else {
		    		  date = DateUtil.parseYYYYMMDDDate(end.get(i));
		    	  }
		    	  getCell(sh, 27 + n, 2).setCellValue(date);

		    	  String[] taskList = task.get(i).split(",", -1);
		    	  for (int s = 0; s < 10; s++) {
		    		  if (taskList[s].equals("")) {
		    			  for (int brank = 0; brank < 10 - s; brank++) {
			    			  getCell(sh, 18 + n + s + brank, 3).setCellValue("");
			    		  }
		    			  break;
		    		  }
		    		  getCell(sh, 18 + n + s, 3).setCellValue(taskList[s]);
		    	  }

		    	  for (int s = 0; s < 8; s ++) {
		    		  getCell(sh, 19 + n + s, 9).setCellValue(requirement.get(i).get(s));
			    	  getCell(sh, 19 + n + s, 9).setCellValue(basic.get(i).get(s));
			    	  getCell(sh, 19 + n + s, 9).setCellValue(details.get(i).get(s));
			    	  getCell(sh, 19 + n + s, 9).setCellValue(pg.get(i).get(s));
			    	  getCell(sh, 19 + n + s, 9).setCellValue(single.get(i).get(s));
			    	  getCell(sh, 19 + n + s, 9).setCellValue(join.get(i).get(s));
			    	  getCell(sh, 19 + n + s, 9).setCellValue(customer.get(i).get(s));
			    	  getCell(sh, 19 + n + s, 9).setCellValue(environment.get(i).get(s));
		    	  }

		    	  getCell(sh, 18 + n, 10).setCellValue(peopleNumber.get(i));

		    	  String[] developmentList = development.get(i).split(",", -1);
		    	  for (int s = 0; s < 10; s++) {
		    		  if (developmentList[s].equals("")) {
		    			  for (int brank = 0; brank < 10 - s; brank++) {
			    			  getCell(sh, 18 + n + s + brank, 11).setCellValue("");
			    		  }
		    			  break;
		    		  }
		    		  getCell(sh, 18 + n + s, 11).setCellValue(developmentList[s]);
		    	  }
		    	  n = n + 10;
		      }


		      // 再計算
		      wb.getCreationHelper().createFormulaEvaluator().evaluateFormulaCell(getCell(sh, 3, 8));

		      // Excelファイルに書き込む
		      out = new FileOutputStream("C:\\temp\\" + filename);
		      wb.write(out);


		    } catch (Exception ex) {
		      ex.printStackTrace();

		    } finally {
		      try {
		        wb.close();
		      } catch (Exception ex2) {
		        ex2.printStackTrace();
		      }
		}

		// 投げる情報
		request.setAttribute("db_number", db_number);
		request.setAttribute("db_name", db_name);
		request.setAttribute("master_flg", master_flg);
		request.setAttribute("filename", filename);


		String view = "";
		view = "/SkillBL";

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);


	}

}
