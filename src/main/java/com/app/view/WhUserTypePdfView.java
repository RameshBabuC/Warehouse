package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//download option with file name
		response.addHeader("Content-Disposition", "attachment;filename=	WHUSER TYPES.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome");
		//Add to Doc
		document.add(p);
		//read data from map
		@SuppressWarnings("unchecked")
		List<WhUserType> whUserTypes=(List<WhUserType>)model.get("whUserTypes");
		//create table
		PdfPTable t=new PdfPTable(6);
		//add heading columns
		t.addCell("ID");     t.addCell("USERTYPE");
		t.addCell("USER CODE");    t.addCell("USER FOR");
		t.addCell("USER EMAIL");      t.addCell("USER CONTACT");
		t.addCell("USER ID TYPE");       t.addCell("IF OTHER");
		t.addCell("ID NUMBER"); 
		//add db data to table
		for(WhUserType s:whUserTypes) {
			t.addCell(s.getWhUsrTypId().toString());
			t.addCell(s.getWhUsrTypType());
			t.addCell(s.getWhUsrTypCode());
			t.addCell(s.getWhUrsTypForType());
			t.addCell(s.getWhUsrTypEmail());
			t.addCell(s.getWhUsrTypContact());
			t.addCell(s.getWhUsrTypIdType());
			t.addCell(s.getWhUsrTypIfOther());
			t.addCell(s.getWhUsrTypIdNum());
		}
		//add to document
		document.add(t);
		//add date and time
		document.add(new Paragraph(new Date().toString()));
		
		
		
		
	}




}
