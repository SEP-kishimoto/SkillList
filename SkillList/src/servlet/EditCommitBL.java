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
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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
	    String master_flg = "";
	    String filename = "";

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

		      // Profile 書き込み設定
		      getCell(sh, 3, 2).setCellValue(kana);
		      getCell(sh, 4, 2).setCellValue(name);
		      getCell(sh, 5, 2).setCellValue(address);
		      getCell(sh, 3, 8).setCellValue(birthday);
		      getCell(sh, 3, 12).setCellValue(age);
		      getCell(sh, 4, 8).setCellValue(gender);
		      getCell(sh, 4, 10).setCellValue(background);
		      getCell(sh, 4, 12).setCellValue(backgroundNumber);
		      getCell(sh, 5, 8).setCellValue(nearestStation);
		      getCell(sh, 5, 10).setCellValue(stationName);

		      // Skill Info 書き込み設定
		      getCell(sh, 10, 2).setCellValue(os);

		      int n = 0;
		      String[] skillList = skill.split("[\\|]", -1);
		      for (int i = 9; i <= 12; i++) {
		    	  getCell(sh, i, 2).setCellValue(skillList[n]);
		    	  if (skillList[n].equals("")) {
		    		  break;
		    	  }
		    	  n++;
		      }

		      n = 0;
		      String[] toolList = tool.split("[\\|]", -1);
		      for (int i = 9; i <= 12; i++) {
		    	  getCell(sh, i, 9).setCellValue(toolList[n]);
		    	  if (toolList[n].equals("")) {
		    		  break;
		    	  }
		    	  n++;
		      }
		      getCell(sh, 13, 2).setCellValue(db);
		      getCell(sh, 14, 2).setCellValue(qualification);

		      n = 0;
		      // Background Note 書き込み設定
		      for (int i = 0; i < noteNumber.size();i++) {
		    	  Date date = null;
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

		    	  String[] taskList = task.get(i).split("[\\|]", -1);
		    	  for (int s = 0; s < 10; s++) {
		    		  getCell(sh, 18 + n + s, 3).setCellValue(taskList[s]);
		    		  if (taskList[s].equals("")) {
		    			  break;
		    		  }
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

		    	  for (int s = 0; s < 10; s++) {
		    		  String[] developmentList = development.get(i).split("[\\|]", -1);
		    		  getCell(sh, 18 + n + s, 11).setCellValue(developmentList[s]);
		    		  if (developmentList[s].equals("")) {
		    			  break;
		    		  }
		    	  }
		    	  n = n + 10;
		      }


		      // Excelファイルに書き込む
		      out = new FileOutputStream("C:\\temp\\" + filename);
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

		// データベースに投げる情報
		request.setAttribute("db_number", db_number);
		request.setAttribute("db_name", db_name);
		request.setAttribute("master_flg", master_flg);
		request.setAttribute("filename", filename);

		String view = "";
		if (master_flg == "1") {
			view = "/ListBL";
		} else {
			view = "/SkillBL";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
