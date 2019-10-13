package core.gui.container;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class PaneViewBar {

    private PaneView container;
    private List<PaneView>  panes ;
    private int size;
    private TranslateTransition translate;
    private int layoutActual = 0;

    private double paneView_Width , paneView_Height;

    public PaneViewBar(int size){
        this.size = size;
        this.panes = new ArrayList<>(size);
        this.container = new PaneView();
    }


    public void set(double paneView_Width , double paneView_Height){
        this.paneView_Width = paneView_Width;
        this.paneView_Height = paneView_Height;
        this.container.setPrefSize(paneView_Width * size, paneView_Height);



    }

    public void init(){
        for (int i = 0; i < size; i++) {
            PaneView p = new PaneView();
            p.setPrefSize(paneView_Width,paneView_Height);
            p.setLayout(paneView_Width * i,0);
            //p.setColorBorder("#ffffff",1);
            panes.add(i,p);

            container.push(p);
        }
    }


    public void setIndex(int index){
        int countX = 0;                                            //(countX -index) el resultado me da las posiciones que faltan para llegar al
        for(PaneView pane:panes){                                         // index esperado.Cuando llegas al index, el resultado sera las posiciones despues del index
            pane.setLayout((countX -index) *pane.getPrefWidth(),0.0);// si countX -index es menor,los tabs recorreran una posicion hacia atras
            countX ++;                                             // si countX -index  es igual, la posicion sera 0
        }                                                          // si countX -index es mayor, los tabs recorreran una posicion hacia adelante
        layoutActual = index;
    }

    public void setIndexAnimated(int index){
        translate = new TranslateTransition(Duration.seconds(1),container);
        if(layoutActual != index){
            translate.setFromX(-layoutActual *panes.get(0).getPrefWidth());
            translate.setToX(-(index) *panes.get(0).getPrefWidth());
            translate.setCycleCount(1);
            translate.setAutoReverse(true);
            translate.play();
        }
    }

    public PaneView getContainer() {
        return container;
    }

    public void setContainer(PaneView container) {
        this.container = container;
    }

    public int getLayoutActual() {
        return layoutActual;
    }

    public void setLayoutActual(int layoutActual) {
        this.layoutActual = layoutActual;
    }

    public double getPaneView_Width() {
        return paneView_Width;
    }

    public void setPaneView_Width(double paneView_Width) {
        this.paneView_Width = paneView_Width;
    }

    public double getPaneView_Height() {
        return paneView_Height;
    }

    public void setPaneView_Height(double paneView_Height) {
        this.paneView_Height = paneView_Height;
    }

    public void setLayout(double x, double y){
        container.setLayout(x,y);
    }

    public List<PaneView> getPanes() {
        return panes;
    }

    public void setPanes(List<PaneView> panes) {
        this.panes = panes;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public TranslateTransition getTranslate() {
        return translate;
    }

    public void setTranslate(TranslateTransition translate) {
        this.translate = translate;
    }
}
