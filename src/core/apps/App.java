package core.apps;

import core.gui.CodeNames;
import core.gui.container.Frame;

import java.util.function.BinaryOperator;

public interface App {

    CodeNames NAMES = new CodeNames();
    Frame FRAME = new Frame();


    void loadInfo();
    void graphics();
    void init();
}
