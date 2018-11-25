package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;


import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//download option with file name
		response.addHeader("Content-Disposition", "attachment;filename=SHIPMENT TYPES.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome");
		//Add to Doc
		document.add(p);
		//read data from map
		@SuppressWarnings("unchecked")
		List<ShipmentType> shipmentTypes=(List<ShipmentType>)model.get("shipmentTypes");
		//create table
		PdfPTable t=new PdfPTable(6);
		//add heading columns
		t.addCell("ID");     t.addCell("SHIPMENT MODE");
		t.addCell("SHIPMENT CODE");    t.addCell("ENABLE SHIPMENT");
		t.addCell("SHIPMENT GRADE");      t.addCell("DESCRIPTION");
		//add db data to table
		for(ShipmentType s:shipmentTypes) {
			t.addCell(s.getShipTypId().toString());
			t.addCell(s.getShipTypMode());
			t.addCell(s.getShipTypCode());
			t.addCell(s.getShipTypEnabled());
			t.addCell(s.getShipTypGrade());
			t.addCell(s.getShipTypDsc());
		}
		//add to document
		document.add(t);
		//add date and time
		document.add(new Paragraph(new Date().toString()));
		
		
		
		
	}



}
