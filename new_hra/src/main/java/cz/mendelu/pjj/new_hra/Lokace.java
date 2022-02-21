package cz.mendelu.pjj.new_hra;

import java.io.Serializable;
import java.util.Objects;

public class Lokace implements Serializable {


    protected TypLokace typ;
    private int lokaceX;
    private int lokaceY;
    protected int cisloInfo;
    protected Resurs resurs;
    protected String color;

    public  Lokace(int lokaceX, int lokaceY){
        this.typ= null;
        this.lokaceX=lokaceX;
        this.lokaceY=lokaceY;
    }
    public Lokace( TypLokace typ, int lokaceX, int lokaceY) {
        this.typ=typ;
        this.lokaceX=lokaceX;
        this.lokaceY=lokaceY;
    }
    public int getCisloInfo() {
        return cisloInfo;
    }
    public Resurs getResurs() {
        return resurs;
    }
    public TypLokace getTyp() {
        return typ;
    }
// tag::equals[]
    /**
     * @author xsuniaik
     * @version etapa 3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lokace)) return false;
        Lokace lokace = (Lokace) o;
        return lokaceX == lokace.lokaceX && lokaceY == lokace.lokaceY && typ == lokace.typ;
    }
    // end::equals[]
    public int getLokaceX() {
        return lokaceX;
    }

    public int getLokaceY() {
        return lokaceY;
    }
    public String getColor(){
        return color;
    }

    // tag::hashCode[]
    /**
     * @author xsuniaik
     * @version etapa 3
     */
    @Override
    public int hashCode() {
        return Objects.hash(typ, lokaceX, lokaceY);
    }


    // end::hashCode[]

}
