package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//download option with file name
		response.addHeader("Content-Disposition", "attachment;filename=VENDOR.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome");
		//Add to Doc
		document.add(p);
		//read data from map
		@SuppressWarnings("unchecked")
		List<Vendor> vendors=(List<Vendor>)model.get("vendors");
		//create table
		PdfPTable t=new PdfPTable(6);
		//add heading columns
		t.addCell("ID");     t.addCell("VENDOR NAME");
		t.addCell("VENDOR CODE");    t.addCell("DESIGNATION");
		t.addCell("PRESERVE");
		//add db data to table
		for(Vendor v:vendors) {
			t.addCell(v.getVenId().toString());
			t.addCell(v.getVenName());
			t.addCell(v.getVenCode());
            t.addCell(v.getVenDesg());
            t.addCell(v.getVenPreserve().toString());
		}
		//add to document
		document.add(t);
		//add date and time
		document.add(new Paragraph(new Date().toString()));
		
		
	}


}
