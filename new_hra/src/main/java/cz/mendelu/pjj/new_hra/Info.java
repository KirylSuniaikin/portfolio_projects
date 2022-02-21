package cz.mendelu.pjj.new_hra;

import java.io.Serializable;

public class Info extends Lokace implements Serializable {
private int cisloInfo;
private Resurs resurs;


    public Info( TypLokace typ, int lokaceX, int lokaceY, int cisloInfo, Resurs resurs) {
        super(typ, lokaceX, lokaceY);
        this.cisloInfo=cisloInfo;
        this.resurs= resurs;
    }


    public int getCisloInfo() {
        return cisloInfo;
    }

    public Resurs getResurs() {
        return resurs;
    }
}
