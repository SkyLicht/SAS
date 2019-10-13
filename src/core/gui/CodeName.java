package core.gui;

import java.util.function.BinaryOperator;

public interface CodeName {

    String URL_IMAGE_DEFAULT = "APP\\vada\\image\\default\\";
    BinaryOperator<Double> percentage = (x1 , y1) -> (x1/100)*y1;
}
