
	
	package com.app.view;

	import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;

	public class UomExcelView extends AbstractXlsxView {

		@SuppressWarnings("unchecked")
		@Override
		protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			//file name change
			response.addHeader("Content-Disposition","attachment;filename=UOMS.xlsx");
			//create sheet with name
			Sheet sheet=workbook.createSheet("UOMS");
			//create Head
			setHead(sheet);
			//read data
			List<Uom> uoms=(List<Uom>)model.get("uoms");
			//set body
			setBody(sheet, uoms );
		}

			public void setHead(Sheet sheet) {
				Row row=sheet.createRow(0);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("UOM TYPE");
				row.createCell(2).setCellValue("UOM MODEL");
				row.createCell(3).setCellValue("DESCRIPTION");
		}
		      public void setBody(Sheet sheet,List<Uom> uoms) {
		    	 int rowNum=1;
		    	 for(Uom u:uoms) {
		    		 Row row=sheet.createRow(rowNum++);
		    		 row.createCell(0).setCellValue(u.getUmId());
		    		 row.createCell(1).setCellValue(u.getUmType());
		    		 row.createCell(2).setCellValue(u.getUmModel());
		    		 row.createCell(3).setCellValue(u.getUmDsc());
		    		 
		    	 }

		   }      
		}
		


