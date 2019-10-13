package core.gui.node.cell;

import core.gui.container.PaneView;
import core.gui.effect.transitions.Translate;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public  class Blank extends PaneView {

    private int idRow;
    private int idColumn;

    private Translate translate;
    private boolean verticalTransition= false;

    public Blank(double width, double height){
        super(width,height);
        mouseEvents();
        this.setMaxSize(width,height);
    }

    public void setPos(int row, int column){
        this.idRow = row;
        this.idColumn = column;
    }

    public void PrintId(){
        this.setOnMouseClicked(e ->{
            System.out.println("id: "+idRow+" , "+ idColumn);
        });
    }

    public void setLayout(double x, double y) {
        this.setLayoutX(x);this.setLayoutY(y);
    }

    public void setColorBorder(String color,int border){
        this.setStyle("-fx-border-color: "+color+" ; -fx-border-width: "+border+";");
    }

    public void setColorBackground(String color){
        this.setStyle("-fx-background-color: "+color+" ;");
    }

    public void setVerticalTransition(boolean b){
        verticalTransition = b;
    }

    public void mouseEvents(){
        this.setOnMouseEntered(event -> {
            if(verticalTransition){
                this.translate = new Translate();
                translate.verticalPixelMove(250,10);
                translate.setNode(this);
                translate.verticalPixelMoveUP();
                translate.play();
            }

        });

        this.setOnMouseExited(event -> {
            if(verticalTransition){
                this.translate = new Translate();
                translate.verticalPixelMove(250,10);
                translate.setNode(this);
                translate.verticalPixelMoveDOWN();
                translate.play();
            }

        });
    }
}
