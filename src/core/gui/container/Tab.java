package core.gui.container;

import core.gui.Color;

import core.gui.node.buttons.ButtonStyle;
import core.gui.node.buttons.ButtonTab;

import java.util.ArrayList;
import java.util.List;

public class Tab {

    private Grid grid;
    private int size;
    private String type;
    private List<ButtonStyle> buttons;
    private double padding = 4;

    private double cell_width , cell_height;
    private double width , height;

    private int indexSelected = 0;

    public Tab (String type,int size){
        this.size = size;
        this.buttons = new ArrayList<>(size);
        this.type = type;

    }

    public void init(){
        switch (type){
            case "VERTICAL":
                Vertical();
                break;
            case "HORIZONTAL":
            default:
                Horizontal();
                break;

        }


        for (int i = 0; i < size; i++) {

            ButtonTab bt = new ButtonTab("Layout "+ i,i);
            bt.Style_4();
            bt.setSize(grid.getCells().get(i).getPrefWidth(),grid.getCells().get(i).getPrefHeight());
            bt.setOnAction(action -> {

                indexSelected = bt.getID();

               buttons.forEach(bs ->{
                    if(bs.getID() == indexSelected){
                        bs.setStyle("-fx-border-width: 0 0 2 0;");
                    }else{  bs.setStyle("-fx-border-width: 0 0 0 0;");}
                });


            });

            buttons.add(i,bt);

           grid.getCells().get(i).getChildren().add(bt);

        }

    }
    public void setCellSize( double cell_width ,double cell_height){
        this.cell_width = cell_width;
        this.cell_height = cell_height;

    }

    public void setSize(double width ,double height){
        this.width = width;
        this.height = height;
    }
    private void Horizontal(){
        grid = new Grid(width,height,1,size);
        grid.getContainer().setLayout(0,0);
        grid.setPadding(padding);
        grid.setCell2();
        grid.borderOn();

        grid.getContainer().setStyle("-fx-border-color: #ff6363;  -fx-border-width: 0 0 0 0 ;");
       // grid.getContainer().setStyle(Color.Noir());

    }

    private void Vertical(){
        /*grid = new Grid(size,1,70,50);
        grid.getContainer().setLayout(100,100);
        grid.setPadding(4);
        grid.setCells();
        //grid.BorderOn();

        grid.getContainer().setStyle(Color.Noir());*/
    }

    public Grid getGrid(){
        return grid;
    }

    public List<ButtonStyle> getButtons() {
        return buttons;
    }

    public void setButtons(List<ButtonStyle> buttons) {
        this.buttons = buttons;
    }

    public double getCell_width() {
        return cell_width;
    }

    public void setCell_width(double cell_width) {
        this.cell_width = cell_width;
    }

    public double getCell_height() {
        return cell_height;
    }

    public void setCell_height(double cell_height) {
        this.cell_height = cell_height;
    }
}
