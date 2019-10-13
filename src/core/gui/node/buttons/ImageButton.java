package core.gui.node.buttons;

import core.gui.CodeNames;
import core.gui.container.PaneView;
import core.gui.node.buttons.ButtonStyle;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;

import java.awt.event.MouseEvent;

public class ImageButton extends ButtonStyle {

    private Label headerText;
    public ImageButton (String name){
        this.style_image_button();
        this.setImage(CodeNames.ROOT()+URL_IMAGE_DEFAULT+name);
    }

    public void setHeaderText (PaneView container,String text){
        headerText = new Label();
        headerText.setId("LabelPopUp");
        headerText.setText(text);
        headerText.setPrefHeight(20);
        headerText.setPrefWidth(this.getPrefWidth());
        headerText.setLayoutX(this.getLayoutX());
        headerText.setLayoutY(this.getLayoutY()-22);
        headerText.setVisible(false);
        container.push(headerText);

        this.setOnMouseEntered(event ->{
            headerText.setVisible(true);
        });
        this.setOnMouseExited(event ->{
            headerText.setVisible(false);
        });
    }
}
