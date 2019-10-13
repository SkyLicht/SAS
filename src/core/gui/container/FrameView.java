package core.gui.container;

import core.gui.CodeName;
import javafx.scene.Node;

public abstract class FrameView implements CodeName {

    public PaneView container;
    public FrameView(PaneView paneView){
        container = paneView;
        init();
        loadInfo();
        graphics();
    }

    public abstract void loadInfo();
    public abstract void graphics();
    public abstract void init();


    public PaneView getContainer() {
        return container;
    }

    public void setContainer(PaneView container) {
        this.container = container;
    }

    public void push(Node node){
        container.push(node);
    }
}
