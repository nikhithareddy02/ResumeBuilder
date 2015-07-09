package test;


import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextTableImage {
	public static void main(String[] args) {
		Document.compress = false;
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("AddingImageToTableCellPDFA.pdf"));

			document.open();

			Image img = Image.getInstance("E:\\photos\\Me\\my pics\\IMG_0869.JPG");
			img.scalePercent(10);

			PdfPTable table = new PdfPTable(6);
			table.getDefaultCell().setBorder(0);
	
			PdfPCell cell = new PdfPCell();
			cell.setColspan(4);
			cell.setFixedHeight(75);
			cell.addElement(new Chunk(img, 25, -50));
			cell.setBorder(Rectangle.NO_BORDER);
			
			Phrase para=new Phrase();
            para.add("Nikhitha\n+919494268894");
            
            PdfPCell cell1 = new PdfPCell(para);
            cell1.setColspan(2);
        	cell1.setBorder(Rectangle.NO_BORDER);
        	cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell1.setHorizontalAlignment(Element.ALIGN_MIDDLE);
			
			table.addCell(cell1);
			table.addCell(cell);
		
			document.add(table);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		document.close();
	}
}

