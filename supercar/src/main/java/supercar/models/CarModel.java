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
import javax.persistence.Transient;
import org.primefaces.model.UploadedFile;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("car")
@SessionScoped
public class CarModel extends IModel{
    @Transient
    private UploadedFile uploadFile;
    
    public UploadedFile getUploadFile() {
        return uploadFile;
    }
 
    public void setUploadFile(UploadedFile uploadFile) {
        this.uploadFile = uploadFile;
        
    }
    
    public void add(){
        URL location;
        location = CarModel.class.getProtectionDomain().getCodeSource().getLocation();
        String path = location.getPath();
        path = path.substring(1, path.length()-14);
        String uniqueFile = getUniqueFileName(path+"../../../../images/", uploadFile.getFileName());
        try{
            
            System.out.println(uniqueFile);
            File file = new File(path+"../../../../images/"+uniqueFile);
            if(!file.exists()){
                file.createNewFile();
            }

            OutputStream outputFile;
        
            outputFile = new FileOutputStream(file);
            
            outputFile.write(uploadFile.getContents());
            outputFile.flush();
            outputFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getUniqueFileName(String path, String fileName) {
        int num = 0;
        final String ext = getFileExtension(fileName);
        final String name = getFileName(fileName);
        File file = new File(path+fileName);
        while (file.exists()) {
            num++;
            file = new File(path +name + "_" + num + ext);
            
        }
        return file.getName();
   }

   public static String getFileExtension(final String path) {
        if (path != null && path.lastIndexOf('.') != -1) {
            return path.substring(path.lastIndexOf('.'));
        }
        return null;
   }

   public static String getFileName(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf('.'));
   }
     
}
