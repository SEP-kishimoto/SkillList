package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// リクエストの文字コードをUTF-8に変換する。
        request.setCharacterEncoding("UTF-8");

        // リクエストクエリを取得する。
        String filename = request.getParameter("filename");

        // レスポンスヘッダを設定する。
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        String encodedFilename = URLEncoder.encode(filename, "UTF-8");//ファイル名に全角使用の為エンコード
        response.setHeader("Content-Disposition",String.format("attachment; filename=\"%s\"", encodedFilename));

        // ワークブックとバイトストリーム(レスポンス)を生成する。
        // このふたつはcloseが必ず必要 => try-with-resource文を活用する、
        try (XSSFWorkbook wb = new XSSFWorkbook();
             OutputStream outputStream = response.getOutputStream()) {
        	XSSFSheet sheet = Common.getSheet(wb);

            // ワークブックをレスポンスに出力する。
            wb.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}