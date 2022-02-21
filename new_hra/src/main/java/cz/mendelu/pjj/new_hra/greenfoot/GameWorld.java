package cz.mendelu.pjj.new_hra.greenfoot;

import cz.mendelu.pjj.new_hra.Game;
import cz.mendelu.pjj.new_hra.Lokace;
import cz.mendelu.pjj.new_hra.Mapa;
import cz.mendelu.pjj.new_hra.Server;
import greenfoot.World;
/**
 * Tato trida vytvari pole hry a to co v ni ma byt
 * +Server
 *
 * @author xsuniaik
 * @version etapa 4
 * @version etapa 5
 */
public class GameWorld extends World {

    private  Game game;

    public GameWorld() {
        this(Game.createNewGame());
    }

    public GameWorld(Game game) {
        super(900, 600, 1);
        this.game = game;
        setBackground("goodpisok.jpeg");
        new Server(this).start();

        for(int i=0; i<9; i++){
            for(int j=0; j<7; j++){
              var lokace = game.mapa.getLokace(i,j);
              var pa = new LokaceActor(lokace);
                int x =250 + (lokace.getLokaceX() * 50);
                int y = 120 + (lokace.getLokaceY() * 50);
                addObject(pa, x, y);

            }
        }
        //tlacitko pro nacitani
        addObject(new LoadButton(),830,470);
        //tlacitko pro ukladani
        addObject(new SaveButton(this.game), 830, 510);
        // tlacitko pro skonceni hry(exit)
        addObject(new ExitButton(), 830, 550);
        //vytvari hralni kostku
        addObject(new Cube(),600, 510 );

        addObject(new LabelActor("Player 1:"), 80, 45);
        addObject(new LabelActor("Player 2:"), 690, 45);

       addObject(new LabelActor("wood: "+ this.game.getCurentPl().getPocetWood()), 80, 120);
        addObject(new LabelActor("wool: "+ this.game.getCurentPl().getPocetWool()), 80, 150);
        addObject(new LabelActor("saber: "+ this.game.getCurentPl().getPocetSaber()), 80, 180);
        addObject(new LabelActor("millet: "+ this.game.getCurentPl().getPocetMillet()), 80, 210);
        addObject(new LabelActor("pineapple: "+ this.game.getCurentPl().getPocetPineapple()), 110, 240);
        addObject(new LabelActor("body: "+ this.game.getCurentPl().getPocetBodu()), 80, 270);

        addObject(new LabelActor("wood: "+ this.game.getCurentPl().getPocetWood()), 800, 120);
        addObject(new LabelActor("wool: "+ this.game.getCurentPl().getPocetWool()), 800, 150);
        addObject(new LabelActor("saber: "+ this.game.getCurentPl().getPocetSaber()), 800, 180);
        addObject(new LabelActor("millet: "+ this.game.getCurentPl().getPocetMillet()), 800, 210);
        addObject(new LabelActor("pineapple: "+ this.game.getCurentPl().getPocetPineapple()), 795, 240);
        addObject(new LabelActor("body: "+ this.game.getCurentPl().getPocetBodu()), 800, 270);

        addObject(new IconCon_1(), 175, 45);
        addObject(new IconR_1(), 240, 45);

        addObject(new IconCon_2(), 785, 45);
        addObject(new IconR_2(), 850, 45);

        addObject(new FinishButton(), 450, 45);

        addObject(new Price(), 330,510);

    }
    public Game getGame() {
        return game;
    }



}


