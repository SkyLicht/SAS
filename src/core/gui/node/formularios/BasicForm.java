package core.gui.node.formularios;

import core.gui.container.PaneView;
import core.gui.node.buttons.ImageButton;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.util.Stack;
import java.util.function.BinaryOperator;

public class BasicForm {

    private BinaryOperator<Double> percentage = (x1 , y1) -> (x1/100)*y1;
    private PaneView container;
    private Stack<Label> labels;
    private Stack<TextField> textFields;
    private Label title;
    private ImageButton add;
    private ImageButton edit;
    private ImageButton dealt;
    private boolean titleShow = true;
    private int size;
    private double WIDTH;
    private double HEIGHT;


    public BasicForm(int size){
        this.size = size;
        labels = new Stack<>();
        textFields = new Stack<>();
        container = new PaneView();
    }

    public void setSize(double width, double height){
        this.WIDTH = width;
        this.HEIGHT = height;
    }


    public void init(){
        set();
    }

    private void set(){

        for (int i = 0; i < size; i++) {
            if(titleShow && i == 0){
                title = new Label("title");
                title.setPrefSize(WIDTH,HEIGHT);
                title.setLayoutX(0);
                title.setLayoutY(0);
                container.push(title);
                i+=1;
                size+=1;

            }
            Label l = new Label("Label : "+i);
            l.setPrefSize(percentage.apply(40d,WIDTH),HEIGHT);
            l.setLayoutX(0);
            l.setLayoutY((i*HEIGHT)+(i*5));
            l.setId("labelForm");
            labels.push(l);
            container.push(l);
            TextField tf = new TextField();
            tf.setPrefSize(percentage.apply(60d,WIDTH),HEIGHT);            tf.setLayoutX(percentage.apply(40d,WIDTH)+5);
            tf.setLayoutY((i*HEIGHT)+(i*5));
            tf.setId("TextFieldForm");
            textFields.push(tf);
            container.push(tf);
        }

        add = new ImageButton("plus.png");
        add.setPrefSize(85,85);
        add.setLayoutY(labels.lastElement().getLayoutY()+HEIGHT +10);

        add.setHeaderText(container,"Agregar");
        container.push(add);

        edit = new ImageButton("edit.png");
        edit.setPrefSize(85,85);
        edit.setLayout(
                add.getPrefWidth() + 40,
                labels.lastElement().getLayoutY()+HEIGHT+10
                );

        edit.setHeaderText(container,"Editar");
        container.push(edit);

        dealt = new ImageButton("delete-photo.png");
        dealt.setPrefSize(85,85);
        dealt.setLayoutY(labels.lastElement().getLayoutY()+HEIGHT);
        dealt.setLayout(
                WIDTH-dealt.getPrefWidth(),
                labels.lastElement().getLayoutY()+HEIGHT+10
        );

        dealt.setHeaderText(container, "Eliminar");
        container.push(dealt);

    }

    public void setLayout(double x, double y){
        container.setLayoutX(x);
        container.setLayoutY(y);
    }
    public PaneView getContainer() {
        return container;
    }

    public void setContainer(PaneView container) {
        this.container = container;
    }

    public boolean isTitleShow() {
        return titleShow;
    }

    public void setTitleShow(boolean titleShow) {
        this.titleShow = titleShow;
    }

    public Label getLabelByIndex(int index){
        return labels.get(index);
    }

    public TextField getTextFieldByIndex(int index){
        return textFields.get(index);
    }
    public void setLabelTextByIndex(int index, String text){
        labels.get(index).setText(text);
    }
    public void setTextFieldTextByIndex(int index, String text){
        textFields.get(index).setText(text);
    }
}




















