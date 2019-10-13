package core.apps.vada.scr.code;

import java.util.List;

public class ManagerCuenta {

    private List<Cuenta> cunets;

    public ManagerCuenta(){

    }

    public void push(){
        Cuenta cuenta = new Cuenta();
        cuenta.printDate();
    }
}
