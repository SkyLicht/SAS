package core.gui.container;


import core.gui.node.cell.Blank;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private PaneView container;
    private int row , column;
    private double cell_width , cell_height;

    private List<Blank> cells;
    private double padding = 4;

    /****************************************************************************/
    /*Constructor que toma como parmetros la contidad de filas y columnas para
    * generar un grid de blank, tomando la cantidad y tamano para posicionar los
    * blans*/
    public Grid(int row, int column, double cell_width, double cell_height ){
        this.row = row;
        this.column = column;
        this.cell_width = cell_width;
        this.cell_height = cell_height;
        container = new PaneView(
                ((column *cell_width )+ column *padding) - padding,
                ((row *cell_height )+row *padding) - padding);
        container.setOpacity(false);
        cells = new ArrayList<>(row *column);
    }

    /*Los blanks de almacenan en una lista con un id, el cual los identifica
    * por fila y columna simulando un vector 2d */
    public void setCells(){
        int count = 0;
        for(int i = 0; i < row; i++){// Y = i
            for(int j = 0; j < column; ++j){// X = j
                cells.add(new Blank(cell_width,cell_height));
                //cells.get(count).setColorBackground("#4b6cb7");
                cells.get(count).setPos(i,j);
                //cells.get(count).PrintId();
                cells.get(count).setLayout(
                        ((j *cell_width) + (j *padding)) + container.getLayoutX() ,
                        ((i *cell_height) + (i *padding)) + container.getLayoutY());
                add(cells.get(count));
                count ++;

            }
        }
    }

    public Grid(double width, double height , int row, int column){
        this.row = row;
        this.column = column;
        container = new PaneView(
                width,
                height);
        container.setOpacity(false);
        cells = new ArrayList<>(row *column);
    }
    public void setCell2(){
        this.cell_width = (this.container.getPrefWidth() -( padding * (column - 1))) / column;
        this.cell_height = (this.container.getPrefHeight() -( padding * (row - 1))) / row;
        int count = 0;
        for(int i = 0; i < row; i++){// Y = i
            for(int j = 0; j < column; ++j){// X = j
                cells.add(new Blank(cell_width,cell_height));
                //cells.get(count).setColorBackground("#4b6cb7");
                cells.get(count).setPos(i,j);
                //cells.get(count).PrintId();
                cells.get(count).setLayout(
                        ((j *cell_width) + (j *padding)) + container.getLayoutX() ,
                        ((i *cell_height) + (i *padding)) + container.getLayoutY());
                add(cells.get(count));
                count ++;

            }
        }
    }

    public void setCell3(){
        this.cell_width = (this.container.getPrefWidth() -( padding * (column - 1))) / column;
        this.cell_height = (this.container.getPrefWidth() -( padding * (column - 1))) / column;
        int count = 0;
        for(int i = 0; i < row; i++){// Y = i
            for(int j = 0; j < column; ++j){// X = j
                cells.add(new Blank(cell_width,cell_height));
                //cells.get(count).setColorBackground("#4b6cb7");
                cells.get(count).setPos(i,j);
                //cells.get(count).PrintId();
                cells.get(count).setLayout(
                        ((j *cell_width) + (j *padding)) + container.getLayoutX() ,
                        ((i *cell_height) + (i *padding)) + container.getLayoutY());
                add(cells.get(count));
                count ++;

            }
        }
    }
    /******************************************************************************/

    private void add(Blank blank){
        container.getChildren().add(blank);
    }

    public PaneView getContainer() {
        return container;
    }

    public List<Blank> getCells(){
        return cells;
    }

    public void traslateOff(){
        for (Blank action : cells) {
            action.setVerticalTransition(true);
        }
    }

    public void setBorder(String color, int width){
        for (Blank action : cells) {
            action.setColorBorder(color, width);
        }
    }

    public void borderOn(){
        for (Blank action : cells) {
            action.setColorBorder("#ffffff", 0);
        }
    }

    public void setBlockStyle(String style){
        for (Blank action : cells) {
            action.setStyle(style);
        }
    }

    public double getPadding() {
        return padding;
    }

    public void setPadding(double padding) {
        this.padding = padding;
    }
}
