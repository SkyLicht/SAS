package core.apps.vada;

import core.apps.App;
import core.apps.vada.scr.config.Config_Frame_3;
import core.gui.CodeNames;
import core.gui.container.Frame;
import core.gui.container.HorizontalBar;
import core.gui.container.PaneView;

public class VadaConfig implements App {

    private double FRAME_WIDTH;
    private double FRAME_HEIGHT;

    private HorizontalBar horizontalBar;
    private int LAYOUTS = 8;


    public VadaConfig(double width, double height) {
        this.FRAME_WIDTH = width;
        this.FRAME_HEIGHT = height;

        loadInfo();
        graphics();
        init();
    }


    @Override
    public void loadInfo() {

    }


    @Override
    public void graphics() {
        FRAME.SET(FRAME_WIDTH,FRAME_HEIGHT,"dark");
        horizontalBar = new HorizontalBar(LAYOUTS,NAMES.DARK_THEME());
        horizontalBar.SET(
                FRAME_WIDTH,
                FRAME_HEIGHT-FRAME.getTaskBar().getHEIGHT()
        );
        horizontalBar.getContainer().setLayout(0,FRAME.getTaskBar().getHEIGHT());
        horizontalBar.init();
        FRAME.push(horizontalBar.getContainer());

        Config_Frame_3 config_frame_3 = new Config_Frame_3(horizontalBar.getPaneViewByIndex(2));

    }

    @Override
    public void init() {
        FRAME.Show();
    }
}
