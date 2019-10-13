package core.apps.vada;

import core.apps.vada.scr.Frame_1;
import core.apps.vada.scr.Frame_2;
import core.apps.vada.scr.code.ManagerCuenta;
import core.apps.vada.scr.code.ManagerMesa;
import core.apps.vada.scr.code.Mesa;
import core.apps.vada.scr.code.TableViewInfo;
import core.gui.container.Frame;
import core.gui.container.PaneViewBar;
import core.gui.node.buttons.FreshButton;
import core.xml.XmlElement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.function.BinaryOperator;


public class Vada {

    private BinaryOperator<Double> porsentaje = (x1 , y1) -> (x1/100)*y1;

    private Frame f ;
    private PaneViewBar paneViewBar;
    private Frame_1 frame_1;
    private Frame_2 frame_2;
    private int ventana_actual = 0;

    private double WIDTH;
    private double HEIGHT;

    private String url = "C:\\SAS\\APP\\vada\\";

    private FreshButton cancelar;
    private FreshButton esperar;
    private FreshButton terminar;

    private ManagerMesa managerMesa;
    private ManagerCuenta managerCuenta;

    private ObservableList<TableViewInfo> data = FXCollections.observableArrayList();

    public Vada(double w, double h) {
        this.WIDTH = w;
        this.HEIGHT = h;

        f = new Frame(WIDTH,HEIGHT);


        loadInfo();
        graphics();
        init();

    }

    private void loadInfo(){

        Mesa m1 = new Mesa(1,"Mesa 7");

        XmlElement element = new XmlElement("Mesa",String.valueOf(m1.getID()));
        element.push("nombre",m1.getName());
        element.push("ranking",String.valueOf(m1.getRanking()));
        element.push("status",String.valueOf(m1.getStatus()));
        element.push("porsentaje",String.valueOf(m1.getPercentage()));

        managerCuenta = new ManagerCuenta();
        managerMesa = new ManagerMesa();
        managerMesa.loadToXML();
        //managerMesa.addXML(element.getElement());
    }
    private void graphics(){

        paneViewBar = new PaneViewBar(3);
        paneViewBar.set(WIDTH,HEIGHT-f.getTaskBar().getHEIGHT());
        paneViewBar.setLayout(0,f.getTaskBar().getHEIGHT());
        paneViewBar.init();
        frame_1 = new Frame_1(this);
        frame_2 = new Frame_2(this);
        cancelar = new FreshButton("Cancelar");
        esperar = new FreshButton("Esperar");
        terminar = new FreshButton("terminar");

        setButtons();

        f.push(paneViewBar.getContainer());
        f.push(cancelar);
        f.push(esperar);
        f.push(terminar);

    }
    public void init(){

        f.Show();
    }

    private void setButtons(){
        cancelar.setSize(porsentaje.apply(30.0,porsentaje.apply(40.0,paneViewBar.getPaneView_Width())),50);
        esperar.setSize(porsentaje.apply(30.0,porsentaje.apply(40.0,paneViewBar.getPaneView_Width())),50);
        terminar.setSize(porsentaje.apply(40.0,porsentaje.apply(40.0,paneViewBar.getPaneView_Width())),50);

        cancelar.setLayout(porsentaje.apply(60.0,paneViewBar.getPaneView_Width())-1,porsentaje.apply(90.0,paneViewBar.getPaneView_Height())+f.getTaskBar().getHEIGHT()+15);
        esperar.setLayout(cancelar.getLayoutX()+cancelar.getPrefWidth(),porsentaje.apply(90.0,paneViewBar.getPaneView_Height())+f.getTaskBar().getHEIGHT()+15);
        terminar.setLayout(esperar.getLayoutX()+esperar.getPrefWidth(),porsentaje.apply(90.0,paneViewBar.getPaneView_Height())+f.getTaskBar().getHEIGHT()+15);


        cancelar.setOnAction(a->{
            System.out.println("Cancelar Pressed");
            paneViewBar.setIndexAnimated(0);
            ventana_actual = 0;
            paneViewBar.setLayoutActual(ventana_actual);
        });
    }

    public void iconMesaClick(int id){
        System.out.println("Class Vada icomMesaClick ---> Mesa ID : "  + id);
        System.out.println(managerMesa.getMesaByID(id).getName());

        if(managerMesa.getMesaByID(id).getStatus()){
            managerCuenta.push();
            moveToFrame_2();
            managerMesa.getMesaByID(id).setStatus(false);
        }



    }

    private void moveToFrame_2(){
        paneViewBar.setIndexAnimated(1);
        ventana_actual = 1;
        paneViewBar.setLayoutActual(ventana_actual);
    }
    public BinaryOperator<Double> getPorsentaje() {
        return porsentaje;
    }

    public Frame getF() {
        return f;
    }

    public PaneViewBar getPaneViewBar() {
        return paneViewBar;
    }

    public Frame_1 getFrame_1() {
        return frame_1;
    }

    public int getVentana_actual() {
        return ventana_actual;
    }

    public double getWIDTH() {
        return WIDTH;
    }

    public double getHEIGHT() {
        return HEIGHT;
    }

    public FreshButton getCancelar() {
        return cancelar;
    }

    public FreshButton getEsperar() {
        return esperar;
    }

    public FreshButton getTerminar() {
        return terminar;
    }

    public ObservableList<TableViewInfo> getData() {
        return data;
    }

    public ManagerMesa getManagerMesa() {
        return managerMesa;
    }

    public void setManagerMesa(ManagerMesa managerMesa) {
        this.managerMesa = managerMesa;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
