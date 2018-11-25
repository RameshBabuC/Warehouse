package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//download option with file name
		response.addHeader("Content-Disposition", "attachment;filename=ORDERMETHODS.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome");
		//Add to Doc
		document.add(p);
		//read data from map
		@SuppressWarnings("unchecked")
		List<OrderMethod> orderMethods=(List<OrderMethod>)model.get("orderMethods");
		//create table
		PdfPTable t=new PdfPTable(6);
		//add heading columns
		t.addCell("ID");     t.addCell("ORDER MODE");
		t.addCell("ORDER CODE");    t.addCell("ORDER METHOD");
		t.addCell("ORDER ACCEPT");      t.addCell("DESCRIPTION");
		//add db data to table
		for(OrderMethod o:orderMethods) {
			t.addCell(o.getOrdMethId().toString());
			t.addCell(o.getOrdMethMode());
			t.addCell(o.getOrdMethCode());
			t.addCell(o.getOrdMethMethod());
			t.addCell(o.getOrdMethAccept().toString());
			t.addCell(o.getOrdMethDsc());
		}
		//add to document
		document.add(t);
		//add date and time
		document.add(new Paragraph(new Date().toString()));
		
		
		
		
	}

}
