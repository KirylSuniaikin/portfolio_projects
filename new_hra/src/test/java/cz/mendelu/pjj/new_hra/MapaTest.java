package cz.mendelu.pjj.new_hra;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MapaTest {

    /**
     * @autor xsuniaik
     * @version etapa2
     */
    @Test
    void addLokaceToMapa() {
        //setup
        var mapa = new Mapa();
        //when
        mapa.addLokaceToMapa(TypLokace.Road, "blue", 1,2);
        //then
        assertTrue(mapa.lokations.containsKey(mapa.key(1,2)));
        assertNotNull(mapa.getLokace(1,2));
        assertEquals(1, mapa.getLokace(1,2).getLokaceX());
        assertEquals(2, mapa.getLokace(1,2).getLokaceY());

    }

    /**
     * @autor xsuniaik
     * @version etapa2
     */
    @Test
    void getLokace() {
        //setup
        var mapa = new Mapa();
        //when+then
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> mapa.getLokace(3, 0));
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> mapa.getLokace(0, 2));
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> mapa.getLokace(22, 3));

    }
}
