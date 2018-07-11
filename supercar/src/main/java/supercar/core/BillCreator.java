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
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.time.Duration;
import static java.time.temporal.ChronoUnit.MILLIS;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import supercar.entities.Account;
import supercar.entities.Lending;

/**
 *
 * @author Lukas
 */
public class BillCreator {

    public static StreamedContent createPDF(String dest, Account acc, Lending lending) {
        try {

            Document document = new Document();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            PdfWriter.getInstance(document, baos);
            document.open();
            Font bold = new Font(FontFamily.HELVETICA, 14, Font.BOLD);
            Font normalNormal = new Font(FontFamily.HELVETICA, 12, Font.UNDEFINED);
            Font normal = new Font(FontFamily.HELVETICA, 12, Font.NORMAL);
            Font boldS = new Font(FontFamily.HELVETICA, 12, Font.BOLD);

            Paragraph customerAdress = new Paragraph("" + acc.getFirstname() + " " + acc.getLastname() + "\n" + acc.getCity() + "\n" + acc.getPlz().toString() + "\n" + acc.getStreet());
            Paragraph companyAdress = new Paragraph("Supercar Confederation\nAlbrechtstraße 30\n49076 Osnabrück\nTel: 1-888-447-5594");
            Paragraph textCapital = new Paragraph("Invoice " + String.format("%08d", lending.getId()), bold);

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
            Chunk usageValue = new Chunk("" + String.format("%08d", lending.getId()), normalNormal);
            Paragraph usageEntry = new Paragraph(usage);
            usageEntry.setFont(normal);
            usageEntry.add(usageValue);

            Paragraph text = new Paragraph("Thanks for using our service, we appreciate every kind of feedback. If there have been any problems, please feel free to contact our customer Support. We will try to help as fast as possible. We hope that you will continue using our service in the future.", normal);
            Paragraph signature = new Paragraph("\nKind regards\n\nBerthold Sommer");

            companyAdress.setSpacingBefore(-70f);
            companyAdress.setSpacingAfter(100f);
            companyAdress.setAlignment(2);

            textCapital.setSpacingAfter(15f);
            text.setSpacingAfter(30f);

            PdfPCell cell;
            PdfPTable table = new PdfPTable(5);

            cell = new PdfPCell(new Phrase("License Plate", boldS));
            cell.setFixedHeight(25f);
            cell.setUseVariableBorders(true);
            cell.setBorderWidth(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Price/Day", boldS));
            cell.setBorderWidth(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Duration (DD:HH:MM): ", boldS));
            cell.setBorderWidth(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Charged Days: ", boldS));
            cell.setBorderWidth(0);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Price: ", boldS));
            cell.setBorderWidth(0);
            table.addCell(cell);

            cell.setPhrase(new Phrase("" + lending.getCar().getLicensePlate()));
            cell.setFixedHeight(25f);
            cell.setBorderWidthTop(2);
            cell.setBorderWidthBottom(2);
            table.addCell(cell);

            cell.setPhrase(new Phrase("$" + String.format("%.2f", lending.getCar().getPricePerDay())));
            table.addCell(cell);

            Duration dur = Duration.of(lending.getReturnDate() - lending.getRentDate(), SECONDS);
            long days = dur.toDays();
            long hours = dur.toHours() % 24;
            
            long minutes = dur.toMinutes() % 60;
            cell.setPhrase(new Phrase("" + String.format("%02d", days) + ":" + String.format("%02d", hours) + ":" + String.format("%02d", minutes)));
            table.addCell(cell);

            if(days >0 && (hours >0 || minutes >0)){
                days+=1;
            }
            else if(days == 0){
                days =1;
            }
            cell.setPhrase(new Phrase("" + days));
            table.addCell(cell);

            double price = (lending.getCar().getPricePerDay() * days) / 1.19;
            cell.setPhrase(new Phrase("$" + String.format("%.2f", (double) Math.round(price * 100) / 100)));
            table.addCell(cell);

            cell.setPhrase(new Phrase(""));
            cell.setBorder(0);
            table.addCell(cell);
            table.addCell(cell);

            cell.setPhrase(new Phrase("MWST"));
            table.addCell(cell);

            cell.setPhrase(new Phrase("19%"));
            table.addCell(cell);

            cell.setPhrase(new Phrase("$" + String.format("%.2f", (double) Math.round(price * 0.19 * 100) / 100)));
            table.addCell(cell);

            cell.setPhrase(new Phrase(""));
            cell.setBorderWidthTop(2);
            table.addCell(cell);
            table.addCell(cell);
            table.addCell(cell);

            cell.setPhrase(new Phrase("Summe"));
            table.addCell(cell);

            cell.setPhrase(new Phrase("$" + String.format("%.2f", price * 1.19)));
            table.addCell(cell);

            Chunk partOne = new Chunk("Please transfer ", normalNormal);
            Chunk partTwo = new Chunk("$" + String.format("%.2f", price * 1.19), bold);
            Chunk partThree = new Chunk(" to the following bank account:", normalNormal);
            // Paragraph transferText = new Paragraph("Please transfer $"+String.format("%.2f", price*1.19)+" to the following bank account:", normal);
            Paragraph transferText = new Paragraph(partOne);
            transferText.add(partTwo);
            transferText.add(partThree);
            transferText.setFont(normal);
            transferText.setSpacingBefore(10f);
            transferText.setSpacingAfter(20f);

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

            return new DefaultStreamedContent(new ByteArrayInputStream(baos.toByteArray()), "text/pdf", dest);
        } catch (DocumentException ex) {
            Logger.getLogger(BillCreator.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
