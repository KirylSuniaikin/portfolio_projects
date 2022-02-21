package cz.mendelu.pjj.new_hra;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    /**
     * @autor xsuniaik
     * @version etapa2
     */
    @Test
    void hodHry() {
        //when
        Mapa mapa = new Mapa();
        //then
        Assertions.assertNotNull(mapa);
        Assertions.assertTrue(Mapa.hasNeco(1, 1));
        Assertions.assertFalse(Mapa.hasNeco(1, 2));
    }
    /**
     * @autor xsuniaik
     * @version etapa2
     */
 //    @Test
 //   void createNewGame_duplicity() {
 //       var game_1=  Game.hodHry();
 //       var game_2=  Game.hodHry();
 //       assertNotSame(game_1, game_2);
 //   }
}