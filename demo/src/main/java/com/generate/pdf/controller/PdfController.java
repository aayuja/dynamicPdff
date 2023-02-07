package com.generate.pdf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generate.pdf.pdfgenerator.PDFGenerator;

@RestController
public class PdfController {
	
	@Autowired
	private PDFGenerator pdfGenerator;
	
	
	@PostMapping("/generatePdf")
	public void generatePdf() {
		pdfGenerator.generatePdfReport();
	}
}
