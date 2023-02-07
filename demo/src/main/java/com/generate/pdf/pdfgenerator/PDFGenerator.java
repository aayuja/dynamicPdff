package com.generate.pdf.pdfgenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Component("pdfGenerator")
public class PDFGenerator {

	
//	@Value("${pdfDirect}")
	private String pdfDirect="/home/ayushi/Documents/PdfReportRepo/";
	
//	@Value("${reportFileName}")
	private String reportFileName="Employee-Report";
	
//	@Value("${reportFileNameDateFormat}")
	private String reportFileNameDateFormat="dd_MMMM_yyyy";
	
//	@Value("${localDateFormat}")
	private String localDateFormat="dd MMMM yyyy HH:mm:ss";
	
//	@Value("${logoImgPath}")
	private String logoImgPath="D:/img_JTO_logo.jpg";
	
//	@Value("${logoImgScale}")
//	private Float[] logoImgScale;
	
//	@Value("${currencySymbol}")
	private String currencySymbol="$";
	
//	@Value("${table_noOfColumns}")
//	private int noOfColumns;
//	
//	@Value("${table.columnNames}")
//	private List<String> columnNames;
	
	
	private static Font COURIER = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
	private static Font COURIER_SMALL = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
	private static Font COURIER_SMALL_FOOTER = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
	
	
	public void generatePdfReport() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(getPdfNameWithDate()));
			document.open();
			addDocTitle(document);
			document.close();
			System.out.println("------------------Your PDF Report is ready!-------------------------");

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}

	}

	
	private static void leaveEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
	
	private void addDocTitle(Document document) throws DocumentException {
		String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(localDateFormat));
		Paragraph p1 = new Paragraph();
		leaveEmptyLine(p1, 1);
		p1.add(new Paragraph(reportFileName, COURIER));
		p1.setAlignment(Element.ALIGN_CENTER);
		leaveEmptyLine(p1, 1);
		p1.add(new Paragraph("Report generated on " + localDateString, COURIER_SMALL));

		document.add(p1);

	}
	
	private String getPdfNameWithDate() {
		String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(reportFileNameDateFormat));
		return pdfDirect+reportFileName+"-"+localDateString+".pdf";
	}
}
