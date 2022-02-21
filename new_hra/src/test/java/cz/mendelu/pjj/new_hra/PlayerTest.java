package cz.mendelu.pjj.new_hra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    /**
     * @autor xsuniaik
     * @version etapa2
     */
    @Test
    void hodKostkamy() {
        //setup
        Player pl = new Player( "color");
        //when+than
        assertTrue(pl.hodKostkamy() == 1 || pl.hodKostkamy() == 2 || pl.hodKostkamy() == 3 || pl.hodKostkamy() == 4 || pl.hodKostkamy() == 5 || pl.hodKostkamy() == 6);
        assertFalse(pl.hodKostkamy() > 6 || pl.hodKostkamy() < 0);
    }
    /**
     * @autor xsuniaik
     * @version etapa2
     */
    @Test
    void buildLokace(){
        //setup
        var lokace= new Aktiva( TypLokace.Road, 2 ,3, "blue");
        //when+then
        assertTrue(lokace.getTyp()==TypLokace.Road|| lokace.getTyp()==TypLokace.Country|| lokace.getTyp()==TypLokace.Info);
    }
    /**
     * @autor xsuniaik
     * @version etapa2
     */
    @Test
    void buildLokaceColor(){
        //setup
        var pl1= new Player( "green");
        var lokace= new Aktiva( TypLokace.Road,  2 ,3, "green");
        //when+then
        assertSame(pl1.getColor(),lokace.getColor());
    }
    /**
     * @autor xsuniaik
     * @version etapa2
     */
    @Test
    void buildLokacePosition() {
        //setup
        var field = new Mapa();
        //when
        var lokace= new Lokace( TypLokace.Road, 6 ,2);
        //then
        assertTrue(lokace.getLokaceX()<= field.maxRow
                && lokace.getLokaceX()>=0
                && lokace.getLokaceY()>=0
                && lokace.getLokaceY()<= field.maxCol);
        assertFalse(lokace.getLokaceX()>= field.maxRow
                && lokace.getLokaceX()<0
                && lokace.getLokaceY()<0
                && lokace.getLokaceY()>=field.maxCol);
    }

}