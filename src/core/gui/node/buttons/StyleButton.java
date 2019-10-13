package core.gui.node.buttons;

import javafx.scene.control.Button;

public class StyleButton extends Button {

    private boolean selected = false;
    private int ID;

    public StyleButton(){
        this.getStylesheets().add(getClass().getResource("css/button.css").toExternalForm());
        mouseEvent();
    }

    public StyleButton(String text, int id){
        this.setText(text);
        this.ID = id;
        this.getStylesheets().add(getClass().getResource("css/button.css").toExternalForm());
        mouseEvent();
    }

    public StyleButton (double w, double h, double x, double y){
        this.setPrefSize(w,h);
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
        mouseEvent();
    }


    private void mouseEvent(){
        this.setOnMousePressed(event ->{

        });

        this.setOnMouseReleased(event -> {

        });
        this.setOnMouseClicked(event -> {

        });
        this.setOnAction(event -> {
            selected = true;
        });
    }


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void Style_1(){
        this.setId("Style_1");
    }
    public void Style_2(){
        this.setId("Style_2");
    }
    public void Style_3(){
        this.setId("Style_3");
    }
    public void Style_4(){
        this.setId("Style_4");
    }
    public void Style_Cancelar(){
        this.setId("Style_Cancelar");
    }
    public void Style_Close(){
        this.setId("Style_Close");
    }
    public void Style_Seguir(){
        this.setId("Style_Seguir");
    }
    public void Style_Esperar(){
        this.setId("Style_Esperar");
    }
    public void setFontsize(int fontsize){
        this.setStyle("-fx-font-size: "+ fontsize+"px ;");
    }
    public void setFontFamily(String fontfamily){
        this.setStyle("-fx-font-family: "+fontfamily+";");
    }
    public void setBorderColor(String color){
        this.setStyle("-fx-border-color: "+color+" ;");
    }
    public void setTextfill(String color){
        this.setStyle("-fx-text-fill: "+color+" ;");
    }
    public void setBackgroundColor(String color){ this.setStyle("-fx-background-color:"+color+" ;");}
}
