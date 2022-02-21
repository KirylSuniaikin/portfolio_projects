package cz.mendelu.pjj.new_hra;

import cz.mendelu.pjj.new_hra.greenfoot.LokaceActor;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Mapa implements Serializable {
    public final static int maxCol = 9;
    public final static int maxRow = 7;
    // tag::Map[]
    public static Map<String, Lokace> lokations;

    static String key(int sizeX, int sizeY) {
        return String.format("%s%d", sizeX, sizeY);
    }

    Mapa() {
        this.lokations = new LinkedHashMap<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<7; j++){
                var lokace= new Lokace(i,j);
                this.lokations.put(key(i,j), lokace);
            }
        }
        Lokace lokaceInfo_1 = new Info(TypLokace.Info, 1, 1, 2, Resurs.Pineapple);
        this.lokations.put(key(1, 1), lokaceInfo_1);
        Lokace lokaceInfo_2 = new Info(TypLokace.Info, 3, 1, 1, Resurs.Wool);
        this.lokations.put(key(3, 1), lokaceInfo_2);
        Lokace lokaceInfo_3 = new Info(TypLokace.Info, 5, 1, 2, Resurs.Wood);
        this.lokations.put(key(5, 1), lokaceInfo_3);
        Lokace lokaceInfo_4 = new Info(TypLokace.Info, 7, 1, 1, Resurs.Saber);
        this.lokations.put(key(7, 1), lokaceInfo_4);
        Lokace lokaceInfo_5 = new Info(TypLokace.Info, 1, 3, 5, Resurs.Wool);
        this.lokations.put(key(1, 3), lokaceInfo_5);
        Lokace lokaceInfo_6 = new Info(TypLokace.Info, 3, 3, 3, Resurs.Millet);
        this.lokations.put(key(3, 3), lokaceInfo_6);
        Lokace lokaceInfo_7 = new Info(TypLokace.Info, 5, 3, 5, Resurs.Millet);
        this.lokations.put(key(5, 3), lokaceInfo_7);
        Lokace lokaceInfo_8 = new Info(TypLokace.Info, 7, 3, 3, Resurs.Wood);
        this.lokations.put(key(7, 3), lokaceInfo_8);
        Lokace lokaceInfo_9 = new Info(TypLokace.Info, 1, 5, 4, Resurs.Pineapple);
        this.lokations.put(key(1, 5), lokaceInfo_9);
        Lokace lokaceInfo_10 = new Info(TypLokace.Info, 3, 5, 2, Resurs.Wool);
        this.lokations.put(key(3, 5), lokaceInfo_10);
        Lokace lokaceInfo_11 = new Info(TypLokace.Info, 5, 5, 1, Resurs.Wood);
        this.lokations.put(key(5, 5), lokaceInfo_11);
        Lokace lokaceInfo_12 = new Info(TypLokace.Info, 7, 5, 4, Resurs.Saber);
        this.lokations.put(key(7, 5), lokaceInfo_12);
    }


    public static Lokace getLokace(int row, int col) {
        String key = key(row, col);
       if (!lokations.containsKey(key)) {
           throw new IndexOutOfBoundsException(String.format("Square [%s,%d] not found.", row, col));
       }
        return lokations.get(key);
    }


    public static boolean hasNeco(int pozX, int pozY) {

        return lokations.containsKey(key(pozX, pozY));
    }


    /**
     * Metoda pridava novou lokaci do mapy
     *
     * @autor xsuniaik
     * @version etapa2(pro ni jsem vytvarel test)
     * @version etapt3
     */
    public static void addLokaceToMapa(TypLokace type, String color, int pozX, int pozY){
        Lokace lokace = new Aktiva(type, pozX, pozY, color);
        lokations.put(key(pozX,pozY), lokace);
    }

}