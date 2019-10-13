package core.gui.node.buttons;

import core.gui.CodeName;
import core.gui.CodeNames;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class ButtonStyle extends Button implements CodeName {

    private int ID;

    public ButtonStyle(){
        this.getStylesheets().add(getClass().getResource("css/button.css").toExternalForm());
    }

    public void setSize(double width, double height){
        this.setPrefSize(width,height);
    }
    public void setLayout(double x, double y){
        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    public void setImage(String url){
        try {
            FileInputStream input = new FileInputStream(url);
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);

            this.setGraphic(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
    public void style_image_button(){ this.setId("Style_button_image");
    }
}
