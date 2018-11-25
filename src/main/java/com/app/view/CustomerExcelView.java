package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Customer;

public class CustomerExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//file name change
		response.addHeader("Content-Disposition","attachment;filename=CUSTOMERS.xlsx");
		//create sheet with name
		Sheet sheet=workbook.createSheet("CUSTOMERS");
		//create Head
		setHead(sheet);
		//read data
		List<Customer> customers=(List<Customer>)model.get("customers");
		//set body
		setBody(sheet, customers );
	}

		public void setHead(Sheet sheet) {
			Row row=sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("CUSTOMER CODE");
			row.createCell(2).setCellValue("ADDRESS");
			row.createCell(3).setCellValue("LOCATIONS");
			row.createCell(4).setCellValue("ENABLE CUSTOMER");
			row.createCell(5).setCellValue("CUSTOMER EMAIL");
			row.createCell(6).setCellValue("CUSTOMER CONTACT");	
	}
	      public void setBody(Sheet sheet,List<Customer> customers) {
	    	 int rowNum=1;
	    	 for(Customer c:customers) {
	    		 Row row=sheet.createRow(rowNum++);
	    		 row.createCell(0).setCellValue(c.getCustId());
	    		 row.createCell(1).setCellValue(c.getCustCode());
	    		 row.createCell(2).setCellValue(c.getCustAddr());
	    		 row.createCell(3).setCellValue(c.getCustLocs().toString());
	    		 row.createCell(4).setCellValue(c.getCustEnabled());
	    		 row.createCell(5).setCellValue(c.getCustEmail());
	    		 row.createCell(6).setCellValue(c.getCustContact());
	    	 }

	   }      


}
