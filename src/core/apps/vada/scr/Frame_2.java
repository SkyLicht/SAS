package core.apps.vada.scr;

import core.apps.vada.Vada;
import core.apps.vada.scr.code.Producto;
import core.apps.vada.scr.ui.IconMesa;
import core.apps.vada.scr.ui.StatusView;

import core.gui.Color;
import core.gui.container.Grid;
import core.gui.container.HorizontalBar;
import core.gui.container.PaneView;
import core.gui.node.scroll.VerticalScroll;
import core.xml.XmlRead;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

import java.util.Stack;

public class Frame_2 {

    private Vada vada;
    private PaneView container;
    private HorizontalBar hb ;
    private StatusView s;
    private int layouts = 0;
    private Stack<String> layoutsNames;
    private Stack<Producto> product;

    public Frame_2(Vada vada){
        this.vada = vada;
        this.container = vada.getPaneViewBar().getPanes().get(1);
        layoutsNames = new Stack<>();
        product = new Stack<>();
        loadInfo();
        graphics();
    }

    public void graphics(){
        hb = new HorizontalBar(layouts,"HORIZONTAL");
        hb.SET(
                vada.getPorsentaje().apply(56.0,container.getPrefWidth()),
                vada.getPorsentaje().apply(90.0,container.getPrefHeight())
        );
        hb.getContainer().setLayout(5,5);
        hb.init();
        hb.setTabsName(layoutsNames);
        container.push(hb.getContainer());


        loadProductos();

    }

    private void loadInfo(){
        XmlRead x = new XmlRead();
        Element rootNode = x.getStAXParsedDocument(vada.getUrl()+"confi\\Frame_confi.xml").getRootElement();
        rootNode.getChildren().forEach(element ->{
            getConf(element,3);
        });
    }

    private void getConf(Element element, int index){
        try {
            if(element.getAttribute("id").getIntValue()==index){
                element.getChild("layouts").getChildren().forEach(element1 -> {
                    getLayouts(element1);
                });
            }

        }catch (DataConversionException data){
            data.getMessage();
        }

    }
    private void getLayouts(Element element){
        System.out.println(element.getText());
        layouts ++;
        layoutsNames.push(element.getText());
    }

    private void loadProductos(){
        PaneView p = hb.getPaneViewBar().getPanes().get(0);
        Grid g = new Grid(p.getPrefWidth()-30,p.getPrefWidth(),10,5);
        g.setCell3();
        //g.borderOn();
        g.getContainer().borderOn();
        /*Vertical Scroll contains the grid*/
        VerticalScroll vs = new VerticalScroll(g.getContainer(),p.getPrefWidth(),p.getPrefHeight(),0,0);
        p.push(vs);
    }


}
