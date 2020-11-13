package servlet;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Common {
	static Connection getConnection() throws Exception {//DB接続関数
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/SkillSheetDB?characterEncoding=UTF-8&serverTimezone=JST";
		Class.forName("com.mysql.cj.jdbc.Driver");//ドライバのロード
		Connection con = DriverManager.getConnection(url, user, password);

		/*
		 * DriverManagerがnullではないことを確認する
		 */
		return con;

	}
   static XSSFSheet getSheet(XSSFWorkbook wb){

		// シート作成
		XSSFSheet sheet = wb.createSheet("SkillSheet");
//罫線の変数
			XSSFCellStyle style = wb.createCellStyle();
			style.setBorderTop(BorderStyle.THIN);
			style.setBorderBottom(BorderStyle.THIN);
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);

//中央寄せ・罫線の変数
		XSSFCellStyle style2 = wb.createCellStyle();
		style2.setAlignment(HorizontalAlignment.CENTER);
		style2.setVerticalAlignment(VerticalAlignment.CENTER);
		style2.setBorderTop(BorderStyle.THIN);
		style2.setBorderBottom(BorderStyle.THIN);
		style2.setBorderLeft(BorderStyle.THIN);
		style2.setBorderRight(BorderStyle.THIN);

//セルの結合
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 4, 9));//SkillSheet
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 10, 12));//更新日
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 12));//ProFile
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 1));//フリガナ項目
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 2, 6));//フリガナ
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 8, 11));//生年月日
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 1));//氏名項目
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 2, 6));//氏名
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 10, 11));//最終学歴
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 2, 6));//現住所項目
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 8, 9));//最寄り線
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 10, 12));//最寄り駅
		sheet.addMergedRegion(new CellRangeAddress(7, 7, 0, 12));//SkillInfo
		sheet.addMergedRegion(new CellRangeAddress(8, 8, 0, 1));//OS項目
		sheet.addMergedRegion(new CellRangeAddress(8, 8, 2, 12));//OS
		sheet.addMergedRegion(new CellRangeAddress(9, 12, 0, 1));//スキル項目
		sheet.addMergedRegion(new CellRangeAddress(9, 9, 2, 7));//スキル１
		sheet.addMergedRegion(new CellRangeAddress(10, 10, 2, 7));//スキル２
		sheet.addMergedRegion(new CellRangeAddress(11, 11, 2, 7));//スキル３
		sheet.addMergedRegion(new CellRangeAddress(12, 12, 2, 7));//スキル４
		sheet.addMergedRegion(new CellRangeAddress(9, 12, 8, 8));//ツール項目
		sheet.addMergedRegion(new CellRangeAddress(9, 9, 9, 12));//ツール１
		sheet.addMergedRegion(new CellRangeAddress(10, 10, 9, 12));//ツール２
		sheet.addMergedRegion(new CellRangeAddress(11, 11, 9, 12));//ツール３
		sheet.addMergedRegion(new CellRangeAddress(12, 12, 9, 12));//ツール４
		sheet.addMergedRegion(new CellRangeAddress(13, 13, 0, 1));//データ項目
		sheet.addMergedRegion(new CellRangeAddress(13, 13, 2, 12));//データ
		sheet.addMergedRegion(new CellRangeAddress(14, 14, 0, 1));//資格項目
		sheet.addMergedRegion(new CellRangeAddress(14, 14, 2, 12));//資格
		sheet.addMergedRegion(new CellRangeAddress(16, 16, 0, 12));//BackGroundNote
		sheet.addMergedRegion(new CellRangeAddress(17, 17, 1, 2));//期間項目
		sheet.addMergedRegion(new CellRangeAddress(17, 17, 3, 7));//業務内容項目
		sheet.addMergedRegion(new CellRangeAddress(17, 17, 8, 9));//フェーズ項目
		sheet.addMergedRegion(new CellRangeAddress(17, 17, 11, 12));//開発環境項目
		sheet.addMergedRegion(new CellRangeAddress(18, 27, 0, 0));//No1
		sheet.addMergedRegion(new CellRangeAddress(28, 37, 0, 0));//No2
		sheet.addMergedRegion(new CellRangeAddress(38, 47, 0, 0));//No3
		sheet.addMergedRegion(new CellRangeAddress(48, 57, 0, 0));//No4
		sheet.addMergedRegion(new CellRangeAddress(58, 67, 0, 0));//No5
		sheet.addMergedRegion(new CellRangeAddress(19, 26, 1, 2));//期間合計1
		sheet.addMergedRegion(new CellRangeAddress(29, 36, 1, 2));//期間合計2
		sheet.addMergedRegion(new CellRangeAddress(39, 46, 1, 2));//期間合計3
		sheet.addMergedRegion(new CellRangeAddress(49, 56, 1, 2));//期間合計4
		sheet.addMergedRegion(new CellRangeAddress(59, 66, 1, 2));//期間合計5

		for(int i =18; i <= 67; i++) {
			sheet.addMergedRegion(new CellRangeAddress(i, i, 3, 7));//業務内容一覧
			sheet.addMergedRegion(new CellRangeAddress(i, i, 11, 12));//開発環境一覧
		}
		sheet.addMergedRegion(new CellRangeAddress(18, 27, 10, 10));//人数1
		sheet.addMergedRegion(new CellRangeAddress(28, 37, 10, 10));//人数2
		sheet.addMergedRegion(new CellRangeAddress(38, 47, 10, 10));//人数3
		sheet.addMergedRegion(new CellRangeAddress(48, 57, 10, 10));//人数4
		sheet.addMergedRegion(new CellRangeAddress(58, 67, 10, 10));//人数5

//項目名
		XSSFRow row = sheet.createRow(0);//各項目作成
		XSSFCell cell = row.createCell(0);// セル作成

//全体に罫線
		for(int n =0;n<=67;n++) {
			row = sheet.createRow(n);
//			cell = row.createCell(0);
//			cell.setCellStyle(style);
//			sheet.createRow(n).createCell(0).setCellStyle(style);
//			sheet.createRow(n).createCell(1).setCellStyle(style);
//			sheet.createRow(n).createCell(2).setCellStyle(style);
//			sheet.createRow(n).createCell(3).setCellStyle(style);
//			sheet.createRow(n).createCell(4).setCellStyle(style);
//			sheet.createRow(n).createCell(5).setCellStyle(style);
//			sheet.createRow(n).createCell(6).setCellStyle(style);
//			sheet.createRow(n).createCell(7).setCellStyle(style);
//			sheet.createRow(n).createCell(8).setCellStyle(style);
//			sheet.createRow(n).createCell(9).setCellStyle(style);
//			sheet.createRow(n).createCell(10).setCellStyle(style);
//			sheet.createRow(n).createCell(11).setCellStyle(style);
//			sheet.createRow(n).createCell(12).setCellStyle(style);
//			cell = row.createCell(0);
//			cell = row.createCell(1);
			cell = row.createCell((short) 0);
			cell.setCellStyle(style);
			cell = row.createCell((short) 1);
			cell.setCellStyle(style);
			cell = row.createCell((short) 2);
			cell.setCellStyle(style);
			cell = row.createCell((short) 3);
			cell.setCellStyle(style);
			cell = row.createCell((short) 4);
			cell.setCellStyle(style);
			cell = row.createCell((short) 5);
			cell.setCellStyle(style);
			cell = row.createCell((short) 6);
			cell.setCellStyle(style);
			cell = row.createCell((short) 7);
			cell.setCellStyle(style);
			cell = row.createCell((short) 8);
			cell.setCellStyle(style);
			cell = row.createCell((short) 9);
			cell.setCellStyle(style);
			cell = row.createCell((short) 10);
			cell.setCellStyle(style);
			cell = row.createCell((short) 11);
			cell.setCellStyle(style);
			cell = row.createCell((short) 12);
			cell.setCellStyle(style);
			}

		row = sheet.createRow(0);
		cell = row.createCell((short) 4);
		cell.setCellStyle(style2);//中央寄せにする
		cell.setCellValue("Skill Sheet");//見出し
		row = sheet.createRow(1);
		cell = row.createCell((short) 9);
		cell.setCellStyle(style2);
		cell.setCellValue("更新日");
		row = sheet.createRow(2);
		cell = row.createCell((short) 0);
		cell.setCellValue("⇒ProFile");
		row = sheet.createRow(3);
		cell = row.createCell((short) 0);
		cell.setCellStyle(style2);
		cell.setCellValue("フリガナ");
		cell = row.createCell((short) 7);
		cell.setCellStyle(style2);
		cell.setCellValue("生年月日");
		row = sheet.createRow(4);
		cell = row.createCell((short) 0);
		cell.setCellStyle(style2);
		cell.setCellValue("氏名");
		cell = row.createCell((short) 7);
		cell.setCellStyle(style2);
		cell.setCellValue("性別");
		cell = row.createCell((short) 9);
		cell.setCellStyle(style2);
		cell.setCellValue("最終学歴");
		row = sheet.createRow(5);
		cell = row.createCell((short) 0);
		cell.setCellStyle(style2);
		cell.setCellValue("現住所");
		cell = row.createCell((short) 7);
		cell.setCellStyle(style2);
		cell.setCellValue("最寄り駅");
		row = sheet.createRow(7);
		cell = row.createCell((short) 0);
		cell.setCellValue("⇒SkillInfo");
		row = sheet.createRow(8);
		cell = row.createCell((short) 0);
		cell.setCellStyle(style2);
		cell.setCellValue("OS");
		row = sheet.createRow(9);
		cell = row.createCell((short) 0);
		cell.setCellStyle(style2);
		cell.setCellValue("スキル");
		cell = row.createCell((short) 8);
		cell.setCellStyle(style2);
		cell.setCellValue("ツール");
		row = sheet.createRow(13);
		cell = row.createCell((short) 0);
		cell.setCellStyle(style2);
		cell.setCellValue("データベース");
		row = sheet.createRow(14);
		cell = row.createCell((short) 0);
		cell.setCellStyle(style2);
		cell.setCellValue("資格");
		row = sheet.createRow(16);
		cell = row.createCell((short) 0);
		cell.setCellValue("⇒BackGroundNote");
		row = sheet.createRow(14);
		cell = row.createCell((short) 0);
		cell.setCellStyle(style2);
		cell.setCellValue("資格");
		row = sheet.createRow(17);
		cell = row.createCell((short) 0);
		cell.setCellStyle(style2);
		cell.setCellValue("No");
		cell = row.createCell((short) 1);
		cell.setCellStyle(style2);
		cell.setCellValue("期間");
		cell = row.createCell((short) 3);
		cell.setCellStyle(style2);
		cell.setCellValue("業務内容");
		cell = row.createCell((short) 8);
		cell.setCellStyle(style2);
		cell.setCellValue("フェーズ");
		cell = row.createCell((short) 10);
		cell.setCellStyle(style2);
		cell.setCellValue("人数");
		cell = row.createCell((short) 11);
		cell.setCellStyle(style2);
		cell.setCellValue("開発環境");
		row = sheet.createRow(18);
		cell = row.createCell((short) 1);
		cell.setCellStyle(style2);
		cell.setCellValue("始");
		row = sheet.createRow(19);
		cell = row.createCell((short) 1);
		cell.setCellStyle(style2);
		cell.setCellValue("");
		row = sheet.createRow(27);
		cell = row.createCell((short) 1);
		cell.setCellStyle(style2);
		cell.setCellValue("終");


		return sheet;
   }
}
