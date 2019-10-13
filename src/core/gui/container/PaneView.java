package core.gui.container;

import core.gui.Color;
import core.gui.effect.transitions.Translate;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class PaneView extends AnchorPane {

    private boolean opacity = true;
    private boolean dragged = false;
    private double dragged_bound_Right;
    private double dragged_bound_Bott;
    private double dragged_bound_up;
    private double dragged_bound_left;
    private boolean pressed = false;



    public PaneView(double width, double height){
        this.setPrefSize(width,height);
        setColorBorder(Color.WITHE(),1);
        mouseEvent();

    }

    public PaneView() {

    }



    public void setColorBorder(String color,int border){
        this.setStyle("-fx-border-color: "+color+" ; -fx-border-width: "+border+";");
    }

    public void borderOn(){
        this.setStyle("-fx-border-color: #ffff; -fx-border-width: 0 ;");
    }

    public void setLayout(double x, double y){
        this.setLayoutX(x);
        this.setLayoutY(y);
    }
    /*Metodo push */
    public void push(Node n){
        this.getChildren().add(n);
    }

    /*Eventos mouse Click del pane*/
    private void mouseEvent(){
        final double[] dragg = new double[2];//almacena las posiciones relativs del pane en X y Y
        this.setOnMouseReleased(action ->
                {
                    if(opacity){
                        this.setOpacity(1.0);
                    }
                    pressed = false;

                }
        );
        this.setOnMousePressed(action ->
                {
                    if(opacity){
                        this.setOpacity(0.5);
                    }
                    if(dragged){
                        /*Regresa la posicion relativa del pane, con la finalidad de evitar el popeo del panel
                        * mientras se arrastra */
                        dragg[0] = this.getLayoutX() - action.getSceneX();
                        dragg[1] = this.getLayoutY() - action.getSceneY();
                    }
                    pressed = true;
                }
        );

        this.setOnMouseDragged(action ->{

            /**/
            if(dragged){
                this.setLayoutX(action.getSceneX() +dragg[0]);
                if(this.getLayoutX() < dragged_bound_left ){
                    this.setLayoutX(dragged_bound_left);
                }
                if(this.getLayoutX() > dragged_bound_Right - this.getPrefWidth()){
                    this.setLayoutX(dragged_bound_Right - this.getPrefWidth());
                }
                this.setLayoutY(action.getSceneY() + dragg[1]);
                if(this.getLayoutY() < dragged_bound_up ){
                    this.setLayoutY(dragged_bound_up);
                }
                if(this.getLayoutY() > dragged_bound_Bott - this.getPrefHeight()){
                    this.setLayoutY(dragged_bound_Bott - this.getPrefHeight());
                }

            }


        });





    }
    /*Activa la funcion opacidad en el fondo del pane*/
    public void setOpacity(boolean opacity) {
        this.opacity = opacity;
    }
    /*********************************************/
    /*Las funciones OffDragged y OnDragged activan la traslacion del panel*/
    /*Los parametros bound establecen los limites, a los cuales la el pane se puede mover*/
    /*********************************************/
    public void setOffDragged(double bound_right, double bound_bott, double bound_up, double bound_left){
        this.dragged_bound_Right = bound_right;
        this.dragged_bound_Bott = bound_bott;
        this.dragged_bound_up = bound_up;
        this.dragged_bound_left = bound_left;
        dragged = true;
    }
    public void DraggedOn(){
        dragged = false;
    }
    public void DraggedOff(){
        dragged = true;
    }

    public boolean getPressed() {
        return pressed;
    }

    public PaneView getRoot(){
        return this;
    }
}
