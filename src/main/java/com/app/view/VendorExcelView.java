package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;
import com.app.model.Vendor;

public class VendorExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//file name change
		response.addHeader("Content-Disposition","attachment;filename=VENDORS.xlsx");
		//create sheet with name
		Sheet sheet=workbook.createSheet("VENDORS");
		//create Head
		setHead(sheet);
		//read data
		List<Vendor> vendors=(List<Vendor>)model.get("vendors");
		//set body
		setBody(sheet, vendors );
	}

		public void setHead(Sheet sheet) {
			Row row=sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("VENDOR NAME");
			row.createCell(2).setCellValue("VENDOR CODE");
			row.createCell(3).setCellValue("DESIGNATION");
			row.createCell(3).setCellValue("PRESERVE");
	}
	      public void setBody(Sheet sheet,List<Vendor> vendors) {
	    	 int rowNum=1;
	    	 for(Vendor v:vendors) {
	    		 Row row=sheet.createRow(rowNum++);
	    		 row.createCell(0).setCellValue(v.getVenId());
	    		 row.createCell(1).setCellValue(v.getVenName());
	    		 row.createCell(2).setCellValue(v.getVenCode());
	    		 row.createCell(3).setCellValue(v.getVenDesg());
	    		 row.createCell(3).setCellValue(v.getVenPreserve().toString()); 
	    	 }

	   }      

}
