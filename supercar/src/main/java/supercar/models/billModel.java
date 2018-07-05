/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.net.URL;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import supercar.core.BillPdf2;
import supercar.entities.Account;
import supercar.interfaces.IModel;

/**
 *
 * @author Lukas
 */
@Named("bill")
@SessionScoped
public class billModel extends IModel {
    @Inject
    BillPdf2 bill;
    
    public void test() throws FileNotFoundException, DocumentException
    {
        URL location;
        location = billModel.class.getProtectionDomain().getCodeSource().getLocation();
        String path = location.getPath();
        Account acc = LoginHandler.getAccount();
        bill.createPDF(path+ "../../../../../../images/test.pdf", acc);
    }
}
