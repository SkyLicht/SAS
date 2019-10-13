package core.gui.container;

import core.gui.Color;
import core.gui.node.buttons.ButtonStyle;
import javafx.scene.control.ScrollPane;

import java.util.Stack;

public class HorizontalBar {

    private PaneView container;
    private Tab tab;
    private int size;
    private String type;
    private PaneViewBar paneViewBar;

    private double tab_padding = 5;
    private double tab_height = 30;

    private ScrollPane scrollPane;

    private int layoutActual = 0;

    public HorizontalBar( int size,String type){
        this.size = size;
        this.type = type;
        this.container = new PaneView();
        this.paneViewBar = new PaneViewBar(this.size);
        this.tab = new Tab(this.type,this.size);


    }

    public void SET(double width, double height){
        this.container.setPrefSize(width,height);
        //this.container.setColorBorder("ffff", 1);
        //this.getContainer().setStyle(Color.sky());
        this.paneViewBar.getContainer().setLayout(0,0);
        this.paneViewBar.set(width,height - tab_height - tab_padding -2);
    }
    public void init(){

        tab.setSize(this.getContainer().getPrefWidth(),tab_height);
        tab.setCellSize(((this.container.getPrefWidth())/ size) ,tab_height);
        tab.init();
        for (ButtonStyle buttonStyle : tab.getButtons()) {
            buttonStyle.setOnMouseClicked(event -> {
                this.paneViewBar.setIndexAnimated(buttonStyle.getID());
                this.paneViewBar.setLayoutActual(buttonStyle.getID());
            });

        }

        container.push(tab.getGrid().getContainer());

        paneViewBar.init();

        scrollPane = new ScrollPane();
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent;");
        scrollPane.setPrefSize(paneViewBar.getPaneView_Width(), paneViewBar.getPaneView_Height() +2);
        scrollPane.setLayoutX(0);
        scrollPane.setLayoutY(tab_height + tab_padding);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);



        for (int i = 0; i < size; i++) {
            scrollPane.setContent(paneViewBar.getContainer());
        }


        this.container.push(scrollPane);

    }

    public void setTabsName(Stack<String> names){
        if(names.size()==this.size){
            for (int i = 0; i < size; i++) {
                tab.getButtons().get(i).setText(names.get(i));
            }
        }else {
            System.out.println("stack size isn't equals to tab size");
        }

    }

    public PaneView getPaneViewByIndex(int index){
        return paneViewBar.getPanes().get(index);
    }
    public PaneView getContainer() {
        return container;
    }

    public void setContainer(PaneView container) {
        this.container = container;
    }

    public Tab getTab() {
        return tab;
    }

    public void setTab(Tab tab) {
        this.tab = tab;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PaneViewBar getPaneViewBar() {
        return paneViewBar;
    }

    public void setPaneViewBar(PaneViewBar paneViewBar) {
        this.paneViewBar = paneViewBar;
    }

    public double getTab_padding() {
        return tab_padding;
    }

    public void setTab_padding(double tab_padding) {
        this.tab_padding = tab_padding;
    }

    public double getTab_height() {
        return tab_height;
    }

    public void setTab_height(double tab_height) {
        this.tab_height = tab_height;
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(ScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public int getLayoutActual() {
        return layoutActual;
    }

    public void setLayoutActual(int layoutActual) {
        this.layoutActual = layoutActual;
    }


}
