package core.gui.container;

import core.gui.node.buttons.StyleButton;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.awt.*;


public class TaskBar extends AnchorPane {

    private double WIDTH;
    private double  HEIGHT = 30;
    private StyleButton close;
    private Button max;
    private Button min;

    public TaskBar(double w){
        this.WIDTH = w;
        this.setPrefSize(WIDTH,HEIGHT);
        close = new StyleButton();
        max = new Button();
        min = new Button();

        close.setPrefSize(HEIGHT-6,HEIGHT-6);
        close.setLayoutX((WIDTH-3) - close.getPrefHeight());
        close.setLayoutY(2);
        close.Style_Close();

        close.setText("X");

        push(close);

        this.setStyle("-fx-border-color: linear-gradient(to bottom left  , #fe8c00 0%,#f83600 100%); -fx-border-width: 0 0 1 0;");
    }

    public void push(Node n){
        this.getChildren().add(n);
    }
    public Button getClose() {
        return close;
    }

    public void setClose(StyleButton close) {
        this.close = close;
    }

    public Button getMax() {
        return max;
    }

    public void setMax(Button max) {
        this.max = max;
    }

    public Button getMin() {
        return min;
    }

    public void setMin(Button min) {
        this.min = min;
    }

    public double getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(double HEIGHT) {
        this.HEIGHT = HEIGHT;
    }
}
