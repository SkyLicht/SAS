package core.apps.vada.scr.code;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cuenta {

    private ObservableList<TableViewInfo> data;

    private int orderId;
    private int id;
    private LocalDateTime time;
    private String Clint;
    private String Owner;
    private String place;
    private boolean open = true;

    public Cuenta(){
        this.data = FXCollections.observableArrayList();
        this.time = LocalDateTime.now();

    }

    public void printDate(){
        DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String now = this.time.format(DATE_FORMAT);

        System.out.println(now);
    }
    public ObservableList<TableViewInfo> getData() {
        return data;
    }

    public void setData(ObservableList<TableViewInfo> data) {
        this.data = data;
    }

    public int getID() {
        return orderId;
    }

    public void setID(int ID) {
        this.orderId = ID;
    }


    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getClint() {
        return Clint;
    }

    public void setClint(String clint) {
        Clint = clint;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
