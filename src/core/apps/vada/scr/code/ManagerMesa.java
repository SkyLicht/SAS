package core.apps.vada.scr.code;

import core.xml.XmlRead;
import core.xml.XmlWrite;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManagerMesa {

    private List<Mesa> mesas;
    private String paht = "C:\\SAS\\APP\\vada\\confi\\Mesas.xml";

    public ManagerMesa() {
        mesas = new ArrayList<>();
    }




    public void loadToXML(){//carga la informacion de un documento xml | con la cual se instancian classes Mesa
        XmlRead x = new XmlRead();
        Element rootNode = x.getStAXParsedDocument(paht).getRootElement();
       // rootNode.getChildren().get(0).getChild("nombre").getText();
        rootNode.getChildren().forEach(element -> {
            readXML(element);
        });
        //System.out.println(rootNode.getChildren().get(0).getChild("nombre").getText());
    }

    private void readXML(Element employeeNode){
        Mesa mesa = new Mesa();
        mesa.setID(Integer.valueOf(employeeNode.getAttributeValue("id")));
        mesa.setName(employeeNode.getChildText("nombre"));
        mesa.setRanking(Double.valueOf(employeeNode.getChildText("ranking")));
        mesa.setStatus(Boolean.valueOf(employeeNode.getChildText("status")));
        mesa.setPercentage(Double.valueOf(employeeNode.getChild("porsentaje").getText()));

        mesas.add(mesa);
    }

    public Mesa getMesaByID(int id){

        for (Mesa mesa:mesas) {
            if(id == mesa.getID()){
                return mesa;
            }
        }
        return null;
    }

    public void printMesaInfo(){
        for (Mesa mesa : mesas) {
            mesa.print();
        }
    }
    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public String getPaht() {
        return paht;
    }

    public void setPaht(String paht) {
        this.paht = paht;
    }
}
