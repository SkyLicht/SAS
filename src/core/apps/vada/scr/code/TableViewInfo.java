package core.apps.vada.scr.code;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableViewInfo {

    private SimpleStringProperty nombre;
    private SimpleDoubleProperty precio;
    private SimpleDoubleProperty cantidad;
    private SimpleDoubleProperty total;


    public TableViewInfo(String nombre, double precio, double cantidad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleDoubleProperty(precio);
        this.cantidad = new SimpleDoubleProperty(cantidad);

        this.total = new SimpleDoubleProperty(cantidad*precio);
    }


    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public double getPrecio() {
        return precio.get();
    }

    public SimpleDoubleProperty precioProperty() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio.set(precio);
    }

    public double getCantidad() {
        return cantidad.get();
    }

    public SimpleDoubleProperty cantidadProperty() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad.set(cantidad);
    }

    public double getTotal() {
        return total.get();
    }

    public SimpleDoubleProperty totalProperty() {
        return total;
    }

    public void setTotal(double total) {
        this.total.set(total);
    }
}
