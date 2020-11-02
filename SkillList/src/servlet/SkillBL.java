package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
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

		if (row != null) {
			Cell cell = row.getCell(cellPoint);
			if (Objects.equals(cell.getStringCellValue(), null)) {
				return null;
			}
			return cell;
		}
		return null;
	}

	public static Cell getCellNum(Sheet sheet, int rowPoint, int cellPoint) {
		Row row = sheet.getRow(rowPoint);
		Cell cell = row.getCell(cellPoint);

		return cell;
	}

	public static Cell getCellDate(Sheet sheet, int rowPoint, int cellPoint) {
		Row row = sheet.getRow(rowPoint);

		if (row != null) {
			Cell cell = row.getCell(cellPoint);
			if (Objects.equals(cell.getDateCellValue(), null)) {
				return null;
			}
			return cell;
		}
		return null;
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
	    if(db_number==null) {
		    db_number = request.getParameter("db_number");
		    db_name = request.getParameter("db_name");
		    master_flg = request.getParameter("master_flg");
		    filename = request.getParameter("filename");
	    }

	    request.setAttribute("db_number", db_number);
	    request.setAttribute("db_name", db_name);
	    request.setAttribute("master_flg", master_flg);
	    request.setAttribute("filename", filename);

	    try {
	      //Excelファイルを読み込む
	      is = new FileInputStream("C:\\temp\\" + filename);
	      wb = WorkbookFactory.create(is);


	      Sheet sh = wb.getSheetAt(0); //シート番号で読み込みたい場合はこちら

	      int wonderland = sh.getLastRowNum() - 17;

	      // Profile読み込み
	      String value = getCell(sh, 3, 2).getStringCellValue();
	      request.setAttribute("kana", value);

	      value = getCell(sh, 4, 2).getStringCellValue();
	      request.setAttribute("name", value);

	      value = getCell(sh, 5, 2).getStringCellValue();
	      request.setAttribute("address", value);

	      //value = getCell(sh, 3, 8).getStringCellValue();
	      double birthVal = getCellNum(sh, 3, 8).getNumericCellValue();
	      Date a = DateUtil.getJavaDate(birthVal);
	      String birthStr = new SimpleDateFormat("yyyy/MM/dd").format(a);
	      value = birthStr;
	      request.setAttribute("birthday", value);

	      SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
	      String b = value.replace("/", "");
	      Date date;
	      Date now = new Date();
	      date = sdFormat.parse(b);
	      int ageValue = (Integer.parseInt(sdFormat.format(now)) - Integer.parseInt(sdFormat.format(date))) / 10000;
	      String str = Integer.toString(ageValue);
	      request.setAttribute("age", str);

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
	    	  if (getCell(sh, i, 2).getStringCellValue() == "") {
	    		  break;
	    	  }
	    	  value += getCell(sh, i, 2).getStringCellValue() + ",";
	      }
	      request.setAttribute("skill", value);

	      value = "";
	      for (int i = 9; i <= 12; i++) {
	    	  if (getCell(sh, i, 9).getStringCellValue() == "") {
	    		  break;
	    	  }
	    	  value += getCell(sh, i, 9).getStringCellValue() + ",";
	      }
	      request.setAttribute("tool", value);

	      value = getCell(sh, 12, 2).getStringCellValue();
	      request.setAttribute("db", value);

	      value = getCell(sh, 14, 2).getStringCellValue();
	      request.setAttribute("qualification", value);


	      // Background Note読み込み表示

	      // noteNumber
	      value = "";
	      List<String> valueList = new ArrayList<String>();
	      int n = 18;
	      for (int i = 0; i < wonderland / 10; i++) {
	    	  DataFormatter formatter = new DataFormatter();
	    	  value = formatter.formatCellValue(wb.getCreationHelper().createFormulaEvaluator().evaluateInCell(getCellDate(sh, n, 0)));
	    	  valueList.add(i, value);
	    	  n = n + 10;
	      }
	      request.setAttribute("noteNumber", valueList);

	      // beginning
	      value = "";
	      valueList = new ArrayList<String>();
	      n = 18;
	      for (int i = 0; i < wonderland / 10; i++) {
	    	  try {
	    		  if (Objects.equals(getCellDate(sh, n, 2), null)) {
	    			  value = "";
	    		  } else {
	    			  String dateStr = new SimpleDateFormat("yyyy/MM/dd").format(getCellNum(sh, n, 2).getDateCellValue());
	    			  value = dateStr;
	    		  }
	    		  if (value != null) {
	    			  valueList.add(i, value);
	    		  } else {
	    			  throw new NullPointerException();
	    		  }
	    	  } catch (NullPointerException e) {
	    		  e.printStackTrace();
	    	  }
	    	  n = n + 10;
	      }
	      request.setAttribute("beginning", valueList);

	      // end
	      value = "";
	      valueList = new ArrayList<String>();
	      n = 27;
	      for (int i = 0; i < wonderland / 10; i++) {
	    	  try {
	    		  if (Objects.equals(getCellDate(sh, n, 2), null)) {
	    			  value = "";
	    		  } else {
	    			  String dateStr = new SimpleDateFormat("yyyy/MM/dd").format(getCellDate(sh, n, 2).getDateCellValue());
		    		  value = dateStr;
	    		  }
	    		  if (value != null) {
	    			  valueList.add(i, value);
	    		  } else {
	    			  throw new NullPointerException();
	    		  }

	    	  } catch(NullPointerException e) {
	    		  e.printStackTrace();
	    	  }
	    	  n = n + 10;
	      }
	      request.setAttribute("end", valueList);

	      // 業務内容の処理
	      value = "";
	      valueList = new ArrayList<String>();
	      n = 18;
	      for (int i = 0; i < wonderland / 10; i++) {
	    	  if (Objects.equals(getCell(sh, n, 3), null)) {
	    		  value = "";
	    		  valueList.add(i, value);
	    	  } else {
	    		  value = "";
	    		  for (int s = n; s <= n + 9; s++) {
	    	    	  if (getCell(sh, s, 3).getStringCellValue() == "") {
	    	    		  break;
	    	    	  }
	    	    	  value += getCell(sh, s, 3).getStringCellValue() + ",";
	    	      }
	    		  valueList.add(i, value);
	    	  }
	    	  n = n + 10;
	      }
	      request.setAttribute("task", valueList);

	      // フェーズの表示部分を記述しています
	      n = 19;
	      valueList = new ArrayList<String>();
    	  List<List<String>> checkList = new ArrayList<>();
	      for (int i = 0; i < wonderland / 10; i++) {
	    	  valueList = new ArrayList<String>();
	    	  if (Objects.equals(getCell(sh, n, 9), null)) {
	    		  value = "";
	    		  valueList.add(i, value);
	    	  } else {
	    		  for (int s = 0; s < 8; s++) {
	    			  if (Objects.equals(getCell(sh, n, 9), null)) {
	    				  value = "";
	    				  valueList.add(s, value);
	    			  } else {
	    				  value = getCell(sh, n, 9).getStringCellValue();
	    				  valueList.add(s, value);
	    			  }
	    			  n = n + 1;
	    		  }
	    		  n = n + 2;
	    	  }
	    	  checkList.add(i, valueList);
	      }
	      request.setAttribute("requirement", checkList);
	      request.setAttribute("basic", checkList);
	      request.setAttribute("details", checkList);
	      request.setAttribute("pg", checkList);
	      request.setAttribute("single", checkList);
	      request.setAttribute("join", checkList);
	      request.setAttribute("customer", checkList);
	      request.setAttribute("environment", checkList);


	      // 人数部分の表示処理
	      value = "";
	      valueList = new ArrayList<String>();
	      n = 18;
	      for (int i = 0; i < wonderland / 10; i++) {
	    	  if (Objects.equals(getCell(sh, n, 10), null)) {
    			  value = "";
    			  valueList.add(i, value);
    		  } else {
    			  value = getCell(sh, n, 10).getStringCellValue();
    			  valueList.add(i, value);
    		  }
	    	  n = n + 10;
	      }
	      request.setAttribute("peopleNumber", valueList);

	      // 開発環境の表示処理
	      value = "";
	      valueList = new ArrayList<String>();
	      n = 18;
	      for (int i = 0; i < wonderland / 10; i++) {
	    	  if (Objects.equals(getCell(sh, n, 11), null)) {
	    		  value = "";
	    		  valueList.add(i, value);
	    	  } else {
	    		  value = "";
	    		  for (int s = n; s <= n + 9; s++) {
	    	    	  if (getCell(sh, s, 11).getStringCellValue() == "") {
	    	    		  break;
	    	    	  }
	    	    	  value += getCell(sh, s,11).getStringCellValue() + ",";
	    	      }
	    		  valueList.add(i, value);
	    	  }
	    	  n = n + 10;
	      }
	      request.setAttribute("development", valueList);

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
