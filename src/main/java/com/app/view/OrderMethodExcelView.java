
	
	package com.app.view;

	import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

	public class OrderMethodExcelView extends AbstractXlsxView {

		@SuppressWarnings("unchecked")
		@Override
		protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			//file name change
			response.addHeader("Content-Disposition","attachment;filename=ORDER METHODS.xlsx");
			//create sheet with name
			Sheet sheet=workbook.createSheet("ORDER METHODS");
			//create Head
			setHead(sheet);
			//read data
			List<OrderMethod> orderMethods=(List<OrderMethod>)model.get("orderMethods");
			//set body
			setBody(sheet, orderMethods );
		}

			public void setHead(Sheet sheet) {
				Row row=sheet.createRow(0);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("ORDER MODE");
				row.createCell(2).setCellValue("ORDER CODE");
				row.createCell(3).setCellValue("ORDER METHOD");
				row.createCell(4).setCellValue("ORDER ACCEPT");
				row.createCell(5).setCellValue("DESCRIPTION");
		}
		      public void setBody(Sheet sheet,List<OrderMethod> orderMethods) {
		    	 int rowNum=1;
		    	 for(OrderMethod o:orderMethods) {
		    		 Row row=sheet.createRow(rowNum++);
		    		 row.createCell(0).setCellValue(o.getOrdMethId());
		    		 row.createCell(1).setCellValue(o.getOrdMethMode());
		    		 row.createCell(2).setCellValue(o.getOrdMethCode());
		    		 row.createCell(3).setCellValue(o.getOrdMethMethod());
		    		 row.createCell(4).setCellValue(o.getOrdMethAccept().toString());
		    		 row.createCell(5).setCellValue(o.getOrdMethDsc());
		    	 }

		   }      
		}
		


