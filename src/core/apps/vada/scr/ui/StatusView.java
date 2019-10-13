package core.apps.vada.scr.ui;

import core.apps.vada.scr.code.TableViewInfo;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.function.BinaryOperator;

public class StatusView {

    private TableView tableView;
    private Label info;
    private ObservableList<TableViewInfo> data;

    private BinaryOperator<Double> porsentaje = (x1 , y1) -> (x1/100)*y1;

    private TableColumn<String, TableViewInfo> nombre;
    private TableColumn<Double, TableViewInfo> cantidad;
    private TableColumn<Double, TableViewInfo> precio;
    private TableColumn<Double, TableViewInfo> total;

    private double info_total = 0;

    public StatusView(ObservableList<TableViewInfo> data){
        this.data = data;
        tableView = new TableView();
        info = new Label();
        nombre = new TableColumn<>("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombre.setSortable(false);

        cantidad = new TableColumn<>("Cantidad");
        cantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        cantidad.setSortable(false);
        cantidad.setStyle("-fx-alignment: center;");
        cantidad.getStyleClass().add("cantidad-column");

        precio = new TableColumn<>("Precio");
        precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        precio.setSortable(false);
        precio.setStyle("-fx-alignment: center;");
        precio.getStyleClass().add("precio-column");

        total = new TableColumn<>("Total");
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        total.setSortable(false);
        total.getStyleClass().add("name-column");
        total.setStyle("-fx-alignment: center-right;");

        tableView.setItems(this.data);

        setInfo();

    }

    public void SET(double width, double height, double x , double y){
        tableView.setLayoutX(x);
        tableView.setLayoutY(y);
        tableView.setPrefSize(width,porsentaje.apply(95.0,height));

        nombre.setPrefWidth(porsentaje.apply(40.0,width));
        cantidad.setPrefWidth(porsentaje.apply(20.0,width));
        precio.setPrefWidth(porsentaje.apply(20.0,width));
        total.setPrefWidth(porsentaje.apply(17.0,width));

        info.setPrefSize(width,porsentaje.apply(5.0,height));
        info.setLayoutX(x);
        info.setLayoutY(porsentaje.apply(95.0,height)+5);
        info.setStyle("-fx-alignment: center-left;");
    }

    public void init(){

        tableView.getColumns().add(nombre);
        tableView.getColumns().add(cantidad);
        tableView.getColumns().add(precio);
        tableView.getColumns().add(total);
    }

    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }

    public void setInfo(){
        data.forEach(data ->{
            info_total += data.getTotal();
        });

        info.setText("Total :  "+String.valueOf(info_total));
    }

    public Label getInfo() {
        return info;
    }

    public void setInfo(Label info) {
        this.info = info;
    }
}
