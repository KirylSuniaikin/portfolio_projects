package cz.mendelu.pjj.new_hra;

import java.io.Serializable;

public class Aktiva extends Lokace implements Serializable {
    String color;

    public Aktiva( TypLokace typ, int lokaceX, int lokaceY, String color) {
        super(typ, lokaceX, lokaceY);
        this.color= color;
    }

    public String getColor() {
        return color;
    }
}
