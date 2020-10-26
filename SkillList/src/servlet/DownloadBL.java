package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.URLEncoder;
//
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Servlet implementation class DownloadBL
 */
@WebServlet("/DownloadBL")
public class DownloadBL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int BYTES__DOWNLOAD = 1024;
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
		// リクエストの文字コードをUTF-8に変換する。
        request.setCharacterEncoding("UTF-8");

        // リクエストクエリを取得する。
        String filename = request.getParameter("filename");
        String filepath = "C:\\temp\\";

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        String encodedFilename = URLEncoder.encode(filename, "UTF-8");//ファイル名に全角使用の為エンコード
        response.setHeader("Content-Disposition",String.format("attachment; filename=\"%s\"", encodedFilename));
        java.io.FileInputStream fileInputStream=new java.io.FileInputStream(filepath + filename);
        OutputStream os = response.getOutputStream();
        int i;
        while ((i=fileInputStream.read()) != -1) {
          os.write(i);
         }
        fileInputStream.close();
    }}
