package core.gui.container;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Frame {

    private Stage stage;
    private Pane root;
    private Scene scene;

    private double WIDTH;
    private double HEIGHT;

    private String title;
    private String them;

    private TaskBar taskBar;

    public Frame(double w, double h){
        this.WIDTH = w;
        this.HEIGHT = h;

        stage = new Stage();
        root = new Pane();
        scene = new Scene(root,WIDTH,HEIGHT);
        root.setPrefSize(WIDTH, HEIGHT);

        setThem("dark");

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);

        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);

        taskBar = new TaskBar(this.WIDTH);
        root.getChildren().add(taskBar);
        taskBar.getClose().setOnAction(action ->
        {
            Close();
        });
    }

    public Frame(){

    }

    public void SET(double w, double h,String them){
        this.WIDTH = w;
        this.HEIGHT = h;

        stage = new Stage();
        root = new Pane();
        scene = new Scene(root,WIDTH,HEIGHT);
        root.setPrefSize(WIDTH, HEIGHT);

        setThem(them);

        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);

        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);

        taskBar = new TaskBar(this.WIDTH);
        root.getChildren().add(taskBar);

        taskBar.getClose().setOnAction(action ->
        {
            Close();
        });
    }

    private void Close(){
        stage.close();
    }

    public void push(Node n){
        this.root.getChildren().add(n);
    }

    public void setTitle(String title) {
        this.title = title;
        stage.setTitle(this.title);
    }


    public void setThem(String them) {
        switch (them){
            case "dark":
                scene.getStylesheets().add(getClass().getResource("/css/dark.css").toExternalForm());
                break;
        }
    }

    public void Show(){
        stage.show();
    }


    public TaskBar getTaskBar() {
        return taskBar;
    }

    public void setTaskBar(TaskBar taskBar) {
        this.taskBar = taskBar;
    }
}
