
	package com.app.view;
	import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView  extends AbstractXlsxView {

		@SuppressWarnings("unchecked")
		@Override
		protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			//file name change
			response.addHeader("Content-Disposition","attachment;filename=SHIPMENT TYPE.xlsx");
			//create sheet with name
			Sheet sheet=workbook.createSheet("SHIPMENT TYPES");
			//create Head
			setHead(sheet);
			//read data
			List<ShipmentType> shipmentTypes=(List<ShipmentType>)model.get("shipmentTypes");
			//set body
			setBody(sheet, shipmentTypes );
		}

			public void setHead(Sheet sheet) {
				Row row=sheet.createRow(0);
				row.createCell(0).setCellValue("ID");
				row.createCell(1).setCellValue("SHIPMENT MODE");
				row.createCell(2).setCellValue("SHIPMENT CODE");
				row.createCell(3).setCellValue("ENABLE SHIPMENT");
				row.createCell(4).setCellValue("SHIPMENT GRADE");
				row.createCell(5).setCellValue("DESCRIPTION");
		}
		      public void setBody(Sheet sheet,List<ShipmentType> shipmentTypes) {
		    	 int rowNum=1;
		    	 for(ShipmentType s:shipmentTypes) {
		    		 Row row=sheet.createRow(rowNum++);
		    		 row.createCell(0).setCellValue(s.getShipTypId());
		    		 row.createCell(1).setCellValue(s.getShipTypMode());
		    		 row.createCell(2).setCellValue(s.getShipTypCode());
		    		 row.createCell(3).setCellValue(s.getShipTypEnabled());
		    		 row.createCell(4).setCellValue(s.getShipTypGrade());
		    		 row.createCell(5).setCellValue(s.getShipTypDsc());
		    	 }
		   }      
		}
		




