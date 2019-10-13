package core.apps.vada.scr;

import core.apps.vada.Vada;
import core.apps.vada.scr.code.TableViewInfo;
import core.apps.vada.scr.ui.IconMesa;
import core.apps.vada.scr.ui.StatusView;
import core.gui.Color;
import core.gui.container.Grid;
import core.gui.container.HorizontalBar;
import core.gui.container.PaneView;
import core.gui.node.scroll.VerticalScroll;
import javafx.scene.control.Button;


import java.util.function.BinaryOperator;

public class Frame_1 {

    private BinaryOperator<Double> porsentaje = (x1 , y1) -> (x1/100)*y1;
    private PaneView container;
    protected Vada vada;
    private HorizontalBar hb ;
    private StatusView s;

    public Frame_1(Vada vada){
        this.vada = vada;
        this.container= vada.getPaneViewBar().getPanes().get(0);



        vada.getData().add(new TableViewInfo("pitzza",150.0 , 1.0));
        vada.getData().add(new TableViewInfo("burrito",15.0 , 1.0));
        vada.getData().add(new TableViewInfo("zanaoria",10.0 , 1.0));

        s = new StatusView(vada.getData());
        s.SET(
                porsentaje.apply(40.0,container.getPrefWidth()),
                porsentaje.apply(90.0,container.getPrefHeight()),
                porsentaje.apply(60.0,container.getPrefWidth()) -5,
                5);
        s.init();

        container.push(s.getTableView());
        container.push((s.getInfo()));

        hb = new HorizontalBar(2,"HORIZONTAL");
        hb.SET(
                porsentaje.apply(56.0,container.getPrefWidth()),
                porsentaje.apply(90.0,container.getPrefHeight()));
        hb.init();
        hb.getContainer().setLayout(5,5);
        container.push(hb.getContainer());

        loadMesa();
    }

    private int index = 0;

    private void loadMesa(){

        PaneView p = hb.getPaneViewBar().getPanes().get(0);
        Grid g = new Grid(p.getPrefWidth()-30,p.getPrefWidth(),10,5);
        g.setCell3();
        g.borderOn();
        g.getContainer().borderOn();
        VerticalScroll vs = new VerticalScroll(g.getContainer(),p.getPrefWidth(),p.getPrefHeight(),0,0);
        p.push(vs);


        for (int i = 0; i < vada.getManagerMesa().getMesas().size(); i++) {
            index = i;
            IconMesa im  = new IconMesa(
                    g.getCells().get(i),
                    vada.getManagerMesa().getMesas().get(i).getName(),
                    vada.getManagerMesa().getMesas().get(i).getID()
            );

            im.setImage();
            im.getBlank().setOnMouseClicked(mouseEvent ->{
                vada.iconMesaClick(im.getId());
                if(vada.getManagerMesa().getMesas().get(index).getStatus()){
                    im.getBlank().setColorBackground(Color.gt());
                }else {
                    im.getBlank().setStyle("-fx-background-color: transparent;");
                }
            });
        }



    }



    public void SET(){

    }

    public void init(){

    }
}
