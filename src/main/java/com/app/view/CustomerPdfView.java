package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Customer;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CustomerPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//download option with file name
		response.addHeader("Content-Disposition", "attachment;filename=CUSTOMER.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome");
		//Add to Doc
		document.add(p);
		//read data from map
		@SuppressWarnings("unchecked")
		List<Customer> customers=(List<Customer>)model.get("customers");
		//create table
		PdfPTable t=new PdfPTable(6);
		//add heading columns
		t.addCell("ID");     t.addCell("CUSTOMER CODE");
		t.addCell("UOM MODEL");    t.addCell("DESCRIPTION");
		t.addCell("ID");   t.addCell("ID");
		t.addCell("ID");
		//add db data to table
		for(Customer c:customers) {
			t.addCell(c.getCustId().toString());
			t.addCell(c.getCustCode());
			t.addCell(c.getCustAddr());
			t.addCell(c.getCustLocs().toString());
			t.addCell(c.getCustEnabled());
			t.addCell(c.getCustEmail());
			t.addCell(c.getCustContact());
		}
		//add to document
		document.add(t);
		//add date and time
		document.add(new Paragraph(new Date().toString()));
		
		
		
		
	}


}
