package cz.mendelu.pjj.new_hra;

import java.io.Serializable;
import java.util.*;

public class Player implements Serializable {
    int pocetBodu;
    String color;
    int pocetWood;
    int pocetSaber;
    int pocetMillet;
    int pocetWool;
    int pocetPineapple;
    Set<Aktiva> seznamAktivov;
    List<Lokace> seznamDevelopedFields;


    public Player( String color) {
        this.color = color;
        this.pocetWood = 10;
        this.pocetSaber = 10;
        this.pocetMillet = 10;
        this.pocetWool = 10;
        this.pocetPineapple = 10;
        this.pocetBodu = 0;
        this.seznamAktivov= new HashSet<>();
        this.seznamDevelopedFields= new ArrayList<>();
    }

    public int getPocetBodu() {
        return pocetBodu;
    }

    public String getColor() {
        return color;
    }

    public int getPocetWood() {
        return pocetWood;
    }

    public int getPocetSaber() {
        return pocetSaber;
    }

    public int getPocetMillet() {
        return pocetMillet;
    }

    public  int getPocetWool() {
        return pocetWool;
    }

    public int getPocetPineapple() {
        return pocetPineapple;
    }


    /**
     * metoda pro určení náhodného čísla, když hráč hodí kostkou
     *
     * @autor xsuniaik
     * @version etapa 2 (pro ni jsem vytvoril test)
     * @version etapa 3
     */
   public static int hodKostkamy() {
        int a = (int)( Math.random()*6+1);
        return a;
    }

    /**
     * Metoda na sebirani resuru z aktiv.
     * Jako parametr jsem predal cislo z kosty.
     * Tady bude poravnavat tjhle cislo a cisloInfo
     *
     * @autor xsuniaik
     */
    public void prepisResursy(int cislo){
        for(Lokace el : seznamDevelopedFields){
            if(el.getCisloInfo()==cislo){
                switch (el.getResurs()){
                    case Wood:
                        pocetWood++;
                        break;
                    case Millet:
                        pocetMillet++;
                        break;
                    case Saber:
                        pocetWood++;
                        break;
                    case Wool:
                        pocetWool++;
                        break;
                    case Pineapple:
                        pocetPineapple++;
                        break;
                }
            }
        }
    }
    /**
     * Metoda na vytvoření nové lokace
     * zadaneho typu na konkrétní pozici
     *
     * @autor xsuniaik
     * @version etapa 2(pro ni jsem vytvarel testy)
     * @version etepa 3
     */
    public void buildLokace( TypLokace type, String color, int pozX, int pozY){
        int pocetChyb=0;
        if (Mapa.getLokace(pozX, pozY).getTyp() != null) pocetChyb++;
            if(type== TypLokace.Road) {
                if (getPocetWood() == 0 || getPocetWool() == 0)
                    pocetChyb++;
            }
                if(type==TypLokace.Country){
                    if(getPocetWood()==0 || getPocetWool()==0 || getPocetSaber()==0 || getPocetPineapple()==0)
                        pocetChyb++;
            }
            if( type == TypLokace.Country ) {
                int pocetMimo=0;
              for(Aktiva a: seznamAktivov){
                  if(!(a.getTyp()==TypLokace.Road && a.getLokaceX()==pozX-1 && a.getLokaceX()==pozY)){
                      pocetMimo++;
                  }
                  if(!(a.getTyp()==TypLokace.Road && a.getLokaceX()==pozX && a.getLokaceX()==pozY+1)){
                      pocetMimo++;
                  }
                  if (!(a.getTyp()==TypLokace.Road && a.getLokaceX()==pozX+1 && a.getLokaceX()==pozY)){
                      pocetMimo++;
                  }
                  if(!(a.getTyp()==TypLokace.Road && a.getLokaceX()==pozX && a.getLokaceX()==pozY-1)){
                      pocetMimo++;
                  }
              }
              if(pocetMimo==seznamAktivov.size()*4)
                    pocetChyb++;
            }
            if(pocetChyb==0) {
                Aktiva lok= new Aktiva(type, pozX, pozY, color);
                seznamAktivov.add(lok);
                Mapa.addLokaceToMapa(type, color, pozX, pozY);
               if( type==TypLokace.Country) {
                  pocetWood--;
                  pocetWool--;
                  pocetPineapple--;
                  pocetSaber--;
                 // seznamDevelopedFields.add(Mapa.getLokace(pozX--, pozY--));
                 // seznamDevelopedFields.add(Mapa.getLokace(pozX--, pozY++));
                 // seznamDevelopedFields.add(Mapa.getLokace(pozX++, pozY--));
                 // seznamDevelopedFields.add(Mapa.getLokace(pozX++, pozY++));
                }
                if(type==TypLokace.Road){
                    pocetWood--;
                    pocetWool--;
                }
            }
        }




    // tag::equals[]
    /**
     * @author xsuniaik
     * @version etapa 3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return  color.equals(player.color) && seznamAktivov.equals(player.seznamAktivov);
    }

    // end::equals[]

    // tag::hashCode[]
    /**
     * @author xsuniaik
     * @version etapa 3
     */
    @Override
    public int hashCode() {
        return Objects.hash(color, seznamAktivov);
    }
    // end::hashCode[]

    // tag::toString[]
    /**
     * @author xsuniaik
     * @version etapa 3
     */
    @Override
    public String toString() {
        return "Player{" +
                " pocetBodu=" + pocetBodu +
                ", color='" + color + '\'' +
                ", pocetWood=" + pocetWood +
                ", pocetSaber=" + pocetSaber +
                ", pocetMillet=" + pocetMillet +
                ", pocetWool=" + pocetWool +
                ", pocetPineapple=" + pocetPineapple +
                ", seznamAktivov=" + seznamAktivov +
                '}';
    }
    // end::toString[]

}
