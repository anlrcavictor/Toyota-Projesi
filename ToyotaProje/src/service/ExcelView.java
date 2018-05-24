package service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import domain.Seyahat;

@SuppressWarnings("deprecation")
public class ExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Seyahat> travelList=(List<Seyahat>)model.get("travels");
		
		HSSFSheet sheet=workbook.createSheet("Seyahatler");
		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Bölümü");
		header.createCell(1).setCellValue("Müdürü");
		header.createCell(2).setCellValue("Seyahat Eden");
		header.createCell(3).setCellValue("Seyahat Baþlangýcý");
		header.createCell(4).setCellValue("Seyahat Sonu");
		header.createCell(5).setCellValue("Seyahat Yeri");
		header.createCell(6).setCellValue("Gidiþ Amacý");
		header.createCell(7).setCellValue("ProjeKodu");
		
		int rowNum=1;
		for(Seyahat s:travelList) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(s.getKullanici().getBolum());
			row.createCell(1).setCellValue(s.getKullanici().getMudurAdi());
			row.createCell(2).setCellValue(s.getKullanici().getKullaniciAdi());
			row.createCell(3).setCellValue(s.getTransBaslangic());
			row.createCell(4).setCellValue(s.getTransBitis());
			row.createCell(5).setCellValue(s.getSeyahatYeri());
			row.createCell(6).setCellValue(s.getGidisAmaci());
			row.createCell(7).setCellValue(s.getProjeKodu());
		
	}

	}
}
