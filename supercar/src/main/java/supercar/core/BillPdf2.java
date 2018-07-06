/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.core;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import supercar.entities.Account;
/**
 *
 * @author Lukas
 */
@Stateless
public class BillPdf2 {

    private StreamedContent files;
    
    public void createPDF(String dest, Account acc) throws FileNotFoundException, DocumentException
    {
        File file = new File(dest);
        file.getParentFile().mkdirs();
   
        Document document = new Document();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        PdfWriter.getInstance(document, baos);
        document.open();
        Font bold = new Font(FontFamily.HELVETICA, 14, Font.BOLD);
        Font normalNormal = new Font(FontFamily.HELVETICA, 12, Font.UNDEFINED);
        Font normal = new Font(FontFamily.HELVETICA, 12, Font.NORMAL); 
        
        Paragraph customerAdress = new Paragraph(""+acc.getFirstname()+" "+acc.getLastname()+"\n"+acc.getCity()+"\n"+acc.getPlz().toString()+"\n"+acc.getStreet());
        Paragraph companyAdress = new Paragraph("Supercar Confederation\nAlbrechtstraße 30\n49076 Osnabrück\nTel: 1-888-447-5594");  
        Paragraph textCapital = new Paragraph("Invoice", bold);
        
        Paragraph transferText = new Paragraph("Please transfer the amount of money to the following bank account.", normal);
        transferText.setSpacingBefore(10f);
        transferText.setSpacingAfter(20f);
        
        Chunk accountOwner = new Chunk("Account Owner: ", bold);
        Chunk accountOwnerValue = new Chunk("Supercar Confederation", normalNormal);
        Paragraph accountOwnerEntry = new Paragraph(accountOwner);
        accountOwnerEntry.setFont(normal);
        accountOwnerEntry.add(accountOwnerValue); 
        
        Chunk bank = new Chunk("Bank: ", bold);
        Chunk bankValue = new Chunk("Super Money Bank", normalNormal);
        Paragraph bankEntry = new Paragraph(bank);
        bankEntry.setFont(normal);
        bankEntry.add(bankValue);
        
        Chunk IBAN = new Chunk("IBAN: ", bold);
        Chunk IBANValue = new Chunk("DE53403510600123456700", normalNormal);
        Paragraph IBANEntry = new Paragraph(IBAN);
        IBANEntry.setFont(normal);
        IBANEntry.add(IBANValue);
        
        Chunk BIC = new Chunk("BIC: ", bold);
        Chunk BICValue = new Chunk("WELADED1STF", normalNormal);
        Paragraph BICEntry = new Paragraph(BIC);
        BICEntry.setFont(normal);
        BICEntry.add(BICValue);
        
        Chunk usage = new Chunk("Usage: ", bold);
        Chunk usageValue = new Chunk("hierkommtwathhin", normalNormal);
        Paragraph usageEntry = new Paragraph(usage);
        usageEntry.setFont(normal);
        usageEntry.add(usageValue);
        
        Paragraph text = new Paragraph("Thanks for using our service, we appreciate every kind of feedback. If there have been any problems, please feel free to contact our customer Support. We will try to help as fast as possible. We hope that you will continue using our service in the future.", normal);
        Paragraph signature = new Paragraph("\nKind regards\n\nDeine Mudda");
        
        companyAdress.setSpacingBefore(-70f);
        companyAdress.setSpacingAfter(100f);
        companyAdress.setAlignment(2);
        
        textCapital.setSpacingAfter(15f);
        text.setSpacingAfter(30f);
        
        PdfPTable table = new PdfPTable(5);
        for(int aw = 0; aw < 10; aw++){
            table.addCell("hi");
            table.addCell("");
        }
        table.setSpacingAfter(15f);
        
        document.add(customerAdress);
        document.add(companyAdress);
        
        document.add(textCapital);
        document.add(text);
        
        document.add(table);
        
        document.add(transferText);
        document.add(accountOwnerEntry);
        document.add(bankEntry);      
        document.add(IBANEntry);
        document.add(BICEntry);
        document.add(usageEntry);

        document.add(signature);
        document.close();
        
        try {
            baos.writeTo(new FileOutputStream(dest));
            baos.flush();
            baos.close();
        } catch (IOException ex) {
            Logger.getLogger(BillPdf2.class.getName()).log(Level.SEVERE, null, ex);
        }
       //files = new DefaultStreamedContent(new ByteArrayInputStream(baos.toByteArray()),"text/pdf", "Bill.pdf");
    }
}
