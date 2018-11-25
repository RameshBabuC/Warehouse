package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView  extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//file name change
		response.addHeader("Content-Disposition","attachment;filename=WHUSER TYPE.xlsx");
		//create sheet with name
		Sheet sheet=workbook.createSheet("WHUSER TYPES");
		//create Head
		setHead(sheet);
		//read data
		List<WhUserType> whUserTypes=(List<WhUserType>)model.get("whUserTypes");
		//set body
		setBody(sheet, whUserTypes );
	}

		public void setHead(Sheet sheet) {
			Row row=sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("USERTYPE");
			row.createCell(2).setCellValue("USER CODE");
			row.createCell(3).setCellValue("USER FOR");
			row.createCell(4).setCellValue("USER EMAIL");
			row.createCell(5).setCellValue("USER CONTACT");
			row.createCell(0).setCellValue("USER ID TYPE");
			row.createCell(0).setCellValue("IF OTHER");
			row.createCell(0).setCellValue("ID NUMBER");	
	}
	      public void setBody(Sheet sheet,List<WhUserType> whUserTypes) {
	    	 int rowNum=1;
	    	 for(WhUserType u:whUserTypes) {
	    		 Row row=sheet.createRow(rowNum++);
	    		 row.createCell(0).setCellValue(u.getWhUsrTypId());
	    		 row.createCell(1).setCellValue(u.getWhUsrTypType());
	    		 row.createCell(2).setCellValue(u.getWhUsrTypCode());
	    		 row.createCell(3).setCellValue(u.getWhUrsTypForType());
	    		 row.createCell(4).setCellValue(u.getWhUsrTypEmail());
	    		 row.createCell(5).setCellValue(u.getWhUsrTypContact());
	    		 row.createCell(0).setCellValue(u.getWhUsrTypIdType());
	    		 row.createCell(0).setCellValue(u.getWhUsrTypIfOther());
	    		 row.createCell(0).setCellValue(u.getWhUsrTypIdNum());

	    		 
	    	 }
	   }      


}
