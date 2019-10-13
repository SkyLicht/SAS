package core.gui.node.scroll;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class VerticalScroll extends ScrollPane {

    public VerticalScroll(Node node, double width, double height, double x , double y){
        this.setPrefSize(width, height);
        this.setLayoutX(x);
        this.setLayoutY(y);

        this.setContent(node);
        this.getStylesheets().add(getClass().getResource("css/ScrollVertical.css").toExternalForm());
    }


    public void setColorBorder(String color,int border){
        this.setStyle("-fx-border-color: "+color+" ; -fx-border-width: "+border+";");
    }

}
