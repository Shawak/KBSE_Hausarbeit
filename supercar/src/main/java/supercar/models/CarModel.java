/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Objects;
import static java.util.stream.Collectors.toList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;
import supercar.entities.Car;
import supercar.entities.Model;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("car")
@SessionScoped
public class CarModel extends IModel {

    private UploadedFile new_uploadFile;
    private UploadedFile change_uploadFile;

    private Collection<Car> cars;
    private Collection<Model> models;

    private Car new_car;
    private Car change_car;

    public Collection<Model> getModels() {
        return models;
    }

    public Collection<Car> getCars() {
        return cars;
    }

    public Car getNew_car() {
        return new_car;
    }

    public Car getChange_car() {
        return change_car;
    }

    public CarModel() {
        new_car = new Car();
    }

    @PostConstruct
    public void init() {
        //cars = new ArrayList<>();
        cars = Cars.getAll();
        models = Models.getAll();
        change_car = new Car();
    }

    public UploadedFile getChange_uploadFile() {
        return change_uploadFile;
    }

    public void setChange_uploadFile(UploadedFile change_uploadFile) {
        this.change_uploadFile = change_uploadFile;
    }

    public void deleteChangeFile() {
        this.change_uploadFile = null;
    }

    public UploadedFile getNew_uploadFile() {
        return new_uploadFile;
    }

    public void setNew_uploadFile(UploadedFile new_uploadFile) {
        this.new_uploadFile = new_uploadFile;

    }

    public void deleteNewFile() {
        this.new_uploadFile = null;
    }

    public void add() {
        try {
            if (new_uploadFile != null) {
                URL location;
                location = CarModel.class.getProtectionDomain().getCodeSource().getLocation();
                String path = location.getPath();
                path = path.substring(1, path.length() - 14);
                String uniqueFile = getUniqueFileName(path + "../../../../images/", new_uploadFile.getFileName());

                File file = new File(path + "../../../../images/" + uniqueFile);
                if (!file.exists()) {
                    file.createNewFile();
                }

                OutputStream outputFile;

                outputFile = new FileOutputStream(file);

                outputFile.write(new_uploadFile.getContents());
                outputFile.flush();
                outputFile.close();

                new_car.setPicture(new_uploadFile.getFileName());
            } else {
                new_car.setPicture("");
            }
            cars.add(Cars.add(new_car));
            new_car = new Car();
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_INFO, "Car add!", "Car add!"));
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:Car not add!", "Error:Car not add!"));
        }
    }

    public static String getUniqueFileName(String path, String fileName) {
        int num = 0;
        final String ext = getFileExtension(fileName);
        final String name = getFileName(fileName);
        File file = new File(path + fileName);
        while (file.exists()) {
            num++;
            file = new File(path + name + "_" + num + ext);

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

    public void change(Long id) {
        change_car = cars.stream().filter((Car o) -> o.getId().equals(id)).findFirst().get();
    }

    public void change() {
        try {
            if (change_uploadFile != null) {

                URL location;
                location = CarModel.class.getProtectionDomain().getCodeSource().getLocation();
                String path = location.getPath();
                path = path.substring(1, path.length() - 14);
                String uniqueFile = getUniqueFileName(path + "../../../../images/", change_uploadFile.getFileName());

                File file = new File(path + "../../../../images/" + uniqueFile);
                if (!file.exists()) {
                    file.createNewFile();
                }

                OutputStream outputFile;

                outputFile = new FileOutputStream(file);

                outputFile.write(change_uploadFile.getContents());
                outputFile.flush();
                outputFile.close();

                change_car.setPicture(change_uploadFile.getFileName());
            } else {

                //.setPicture(change_car.getPicture());
            }

            change_car = Cars.update(change_car);
            cars = cars.stream().map((Car o) -> Objects.equals(o.getId(), change_car.getId()) ? change_car : o).collect(toList());

            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_INFO, "Car change!", "Car change!"));
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:Car not change!", "Error:Car not change!"));
        }
    }

    public void deactivate(long id) {
        if (Lendings.getLendingCarById(id) == null) {
            //Car tmp = cars.stream().filter((Car o) -> o.getId().equals(id)).findFirst().get();
            Car tmp = Cars.get(id);
            tmp.setDeactivated(!tmp.isDeactivated());
            tmp = Cars.update(tmp);
            //cars=cars.stream().map((Car o) -> Objects.equals(o.getId(), tmp.getId())?tmp:o).collect(toList());
            cars = Cars.getAll();
        }
    }

    public void activate(long id) {
        //Car tmp = cars.stream().filter((Car o) -> o.getId().equals(id)).findFirst().get();
        Car tmp = Cars.get(id);
        tmp.setDeactivated(!tmp.isDeactivated());
        tmp = Cars.update(tmp);
        //cars=cars.stream().map((Car o) -> Objects.equals(o.getId(), tmp.getId())?tmp:o).collect(toList());
        cars = Cars.getAll();
    }

}
