package core.apps.vada.scr.config;

import core.gui.container.FrameView;
import core.gui.container.PaneView;
import core.gui.node.formularios.BasicForm;
import core.xml.XmlElement;
import core.xml.XmlRead;
import core.xml.XmlWrite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import org.jdom2.DataConversionException;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.Stack;

public class Config_Frame_3 extends FrameView {

    private BasicForm basicForm;
    private ListView<String> categoryProductsListView;
    private ObservableList<String> categoryNames;
    private int layouts = 0;

    public Config_Frame_3(PaneView paneView){
        super(paneView);
        addToXML();
    }

    @Override
    public void loadInfo() {
        XmlRead x = new XmlRead();
        Element rootNode = x.getStAXParsedDocument("C:\\SAS\\APP\\vada\\confi\\Frame_confi.xml").getRootElement();
        rootNode.getChildren().forEach(element ->{
            getConf(element,3);
        });
    }

    @Override
    public void graphics() {
        /*ObservableList<String> options =
                FXCollections.observableArrayList(layoutsNames);
         ComboBox comboBox = new ComboBox(options);
         push(comboBox);*/

        categoryProductsListView.setOrientation(Orientation.VERTICAL);
        categoryProductsListView.setPrefSize(200,500);

        basicForm.setSize(400,37);
        basicForm.setLayout(300,0);
        basicForm.setTitleShow(false);
        basicForm.init();

        basicForm.setLabelTextByIndex(0,"Id");
        basicForm.setLabelTextByIndex(1,"Categoría");


        push(basicForm.getContainer());
        push(categoryProductsListView);
    }

    @Override
    public void init() {
        basicForm = new BasicForm(2);
        categoryNames = FXCollections.observableArrayList();
        categoryProductsListView = new ListView<>(categoryNames);
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
        layouts ++;
        categoryNames.add(element.getText());
    }


    private void addToXML(){

        XmlRead read = new XmlRead();
        Element element =read.getStAXParsedDocument("C:\\SAS\\APP\\vada\\confi\\Frame_confi.xml").getRootElement();

        Element config = element.getChild("conf");
        config.getChildren().get(1).getChildren().get(0).setText("sfssfsf");
        System.out.println(config.getChildren().get(1).getChildren().get(0).getText());



        read.getElementByName(read.getElementByIndex(element,1),"layouts");
        System.out.println(read.getElementByIndex(element,3).getChildren().get(0).getChildren().get(1).getText());
        /*XmlElement element = new XmlElement("confi","24");
        element.push("nombre","fsfsfsf");

        try {

            XmlWrite add = new XmlWrite("C:\\SAS\\APP\\vada\\confi\\Frame_confi.xml");
            add.addContent(element.getElement());
            add.write();

        }catch (JDOMException jdom){

        }catch (IOException ioe){

        }*/
    }
}
