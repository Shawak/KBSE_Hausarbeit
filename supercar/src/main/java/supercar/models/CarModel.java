/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import org.primefaces.model.UploadedFile;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("car")
@SessionScoped
public class CarModel extends IModel{
    private UploadedFile file;
    
    
    
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
        
    }
     
    public void upload() {
        if(file != null) {
            
                /*System.out.println(file.getFileName());
                byte[] contents = file.getContents();
                try {
                try (FileOutputStream outputStream = new FileOutputStream("../generated/jsp/supercar/test2.jpg")) {
                outputStream.write(contents);
                }
                } catch (FileNotFoundException ex) {
                Logger.getLogger(CarModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                Logger.getLogger(CarModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                file.write("test3.jpg");
                } catch (Exception ex) {
                Logger.getLogger(CarModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
                
                URL location;
                location = CarModel.class.getProtectionDomain().getCodeSource().getLocation();
                System.out.println(location.getFile());*/
                URL location;
                location = CarModel.class.getProtectionDomain().getCodeSource().getLocation();
                String path = location.getPath();
                
                
                System.out.println(path.substring(1, path.length() - 14));
                
            try {
                
                File t = new File(path.substring(1, path.length() - 14)+"../../../../images/output.jpg");

                    try (FileOutputStream out = new FileOutputStream(t)) {
                        if(!t.exists()){
                            t.createNewFile();
                        }
                        out.write(file.getContents());
                        out.flush();
                    }
            } catch (IOException ex) {
                Logger.getLogger(CarModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(CarModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
