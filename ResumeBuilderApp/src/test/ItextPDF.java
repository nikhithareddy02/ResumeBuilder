package test;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPDF {
	public static void main(String[] args) {
		ItextPDF it = new ItextPDF();
		it.addImage();
	}
	public void addImage(){
		try {
			File file = new File("E:/HelloWorld-Table3.pdf");
			FileOutputStream pdfFileout = new FileOutputStream(file);
			Document doc = new Document();
			PdfWriter.getInstance(doc, pdfFileout);

			doc.addAuthor("QuicklyJava.com");
			doc.addTitle("This is title");
			doc.open();

			Paragraph para1 = new Paragraph();
			para1.add("This is paragraph 1");

			Paragraph para2 = new Paragraph();
			para2.add("This is paragraph 2");

			doc.add(para1);
			doc.add(para2);

			//adding a local image and aligned RIGHT
			String imageUrl = "E:/photos/Me/my pics/IMG_0869.JPG";
			Image image = Image.getInstance(imageUrl);
			image.scaleAbsolute(150f, 150f);
			image.setAlignment(Image.RIGHT);
			//image.setAbsolutePosition(450f, 500f);
			doc.add(image);


			doc.close();
			pdfFileout.close();

			System.out.println("Success!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}