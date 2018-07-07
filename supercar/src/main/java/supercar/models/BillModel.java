/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.StreamedContent;
import supercar.core.BillCreator;
import supercar.entities.Account;
import supercar.entities.Lending;
import supercar.interfaces.IModel;

/**
 *
 * @author Lukas
 */
@Named("bill")
@RequestScoped
public class BillModel extends IModel {
    
    private Collection<Lending> lendings;

    public Collection<Lending> getLendings() {
        return lendings;
    }

    @PostConstruct
    public void init() {
        lendings = LoginHandler.getAccount().getLendings().stream().filter((Lending l) -> l.getReturnDate() != null).collect(Collectors.toList());
    }

    public void test() throws FileNotFoundException, DocumentException {
        URL location;
        location = BillModel.class.getProtectionDomain().getCodeSource().getLocation();
        String path = location.getPath();
        Account acc = LoginHandler.getAccount();
        //bill.createPDF(path+ "../../../../../../images/test.pdf", acc, 5);
    }

    public StreamedContent pdfGetFile(long id) {
        return BillCreator.createPDF("Rechnung" + String.format("%08d", id) + ".pdf", Accounts.get(Lendings.testQuery(id)), Lendings.get(id));
    }
}