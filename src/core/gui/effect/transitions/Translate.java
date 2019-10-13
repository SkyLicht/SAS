package core.gui.effect.transitions;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;

import java.time.Duration;

public class Translate {

    private TranslateTransition translateTransition;
    private Node node;
    private double millis;
    private double fromY;
    private double toY;
    private double pixelMove;
    private int cycleCount;

    private boolean mouseEntred;
    private boolean mouseExite;

    public Translate(){
        translateTransition = new TranslateTransition();
    }

    public void Horizontal(Node node,double millis, double setFromX, double setToX){

    }
    public void Vertical(Node node,double millis, double setFromY, double setToY,int setCycleCount){
        translateTransition.setDuration(javafx.util.Duration.millis(millis));
        translateTransition.setNode(node);
        translateTransition.setFromY(setFromY);
        translateTransition.setToY(setToY);
        translateTransition.setCycleCount(setCycleCount);
        translateTransition.setAutoReverse(true);

    }

    public void verticalPixelMove(double millis,double pixelMove){
        this.millis = millis;
        translateTransition.setDuration(javafx.util.Duration.millis(this.millis));
        this.pixelMove = pixelMove;

    }
    public void verticalPixelMoveUP(){
        fromY = this.node.getLayoutY();
        toY = this.node.getLayoutY()-pixelMove;
        cycleCount = 1;
    }

    public void verticalPixelMoveDOWN(){
        fromY = this.node.getLayoutY()  -pixelMove;
        toY = this.node.getLayoutY() ;
        cycleCount = 1;
    }



    public void setNode(Node node) {
        this.node = node;
        translateTransition.setNode(this.node);
    }
    public void set(){
        translateTransition.setFromY(fromY);
        translateTransition.setToY(toY);
        translateTransition.setCycleCount(cycleCount);
        translateTransition.setAutoReverse(true);
    }
    public void play(){
        if(mouseEntred){
            verticalPixelMoveUP();
        }
        if(mouseExite){
            verticalPixelMoveDOWN();
        }
        set();
        translateTransition.play();
    }

    public void setTranslateTransition(TranslateTransition translateTransition) {
        this.translateTransition = translateTransition;
    }

    public Node getNode() {
        return node;
    }

    public void setMouseEntred(boolean mouseEntred) {
        this.mouseEntred = mouseEntred;
        this.mouseExite = false;
    }

    public void setMouseExite(boolean mouseExite) {
        this.mouseExite = mouseExite;
        this.mouseEntred = false;
    }
}
