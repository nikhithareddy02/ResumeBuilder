package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TextWithImage {
	public static void main(String[] args) throws IOException, DocumentException {
		TextWithImage ti = new TextWithImage();
		ti.createPdf();
	}
	public void createPdf() throws IOException, DocumentException {
		File file = new File("E:/HelloWorld-Table.pdf");
		FileOutputStream pdfFileout = new FileOutputStream(file);
		Document document = new Document();
		PdfWriter.getInstance(document, pdfFileout);
		document.open();
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.setWidths(new int[]{1, 2});
		table.addCell(createTextCell("This picture was taken at Java One.\nIt shows the iText crew at Java One in 2013."));
		table.addCell(createImageCell("E:/photos/Me/my pics/IMG_0869.JPG"));
		document.add(table);
		document.close();
		System.out.println("Success!");
	}	
	public static PdfPCell createImageCell(String path) throws DocumentException, IOException {
		Image img = Image.getInstance(path);
		System.out.println(img.getAbsoluteX());
		System.out.println(img.getAbsoluteY());
		//img.scaleToFit(100, 100);
		////img.scaleAbsolute(50f,50f);
		PdfPCell cell = new PdfPCell(img, true);
		return cell;
	}

	public static PdfPCell createTextCell(String text) throws DocumentException, IOException {
		PdfPCell cell = new PdfPCell();
		Paragraph p = new Paragraph(text);
		p.setAlignment(Element.ALIGN_RIGHT);
		cell.addElement(p);
		cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
		cell.setBorder(Rectangle.NO_BORDER);
		return cell;
	}
}
