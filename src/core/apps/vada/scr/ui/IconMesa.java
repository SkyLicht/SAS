package core.apps.vada.scr.ui;

import core.gui.node.cell.Blank;
import core.gui.node.cell.Icon;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.function.BinaryOperator;

public class IconMesa implements Icon {
    private BinaryOperator<Double> porsentaje = (x1 , y1) -> (x1/100)*y1;
    private Blank blank;
    private String urlimage = "C:\\SAS\\APP\\vada\\image\\default\\restaurant.png";
    private Label text ;
    private int id;

    public IconMesa(Blank blank , String text, int id){
        this.id = id;
        this.blank = blank;
        this.text = new Label(text);
        this.text.setPrefSize(blank.getPrefWidth(),porsentaje.apply(15.0,blank.getPrefHeight()));
        this.text.setId("labelIconMesa");
        blank.setStyle("-fx-Background-color: #14375A;");
        blank.push(this.text);
    }

    @Override
    public void setImage() {

        try {
            FileInputStream input = new FileInputStream(urlimage);
            Image image = new Image(input);

            ImageView imageView = new ImageView(image);
            imageView.setLayoutX(((blank.getPrefWidth()-image.getWidth())/2)-1);
            imageView.setLayoutY(((blank.getPrefWidth()-(image.getWidth()+text.getPrefHeight()))/2)+text.getPrefHeight());
            blank.push(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean active(boolean active) {
        return active;
    }

    public Blank getBlank() {
        return blank;
    }

    public void setBlank(Blank blank) {
        this.blank = blank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
