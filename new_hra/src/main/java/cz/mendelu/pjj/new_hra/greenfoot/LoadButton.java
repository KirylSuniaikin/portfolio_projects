package cz.mendelu.pjj.new_hra.greenfoot;

import cz.mendelu.pjj.new_hra.Game;
import greenfoot.Greenfoot;
/**
 * Metoda implementuje nacitani hry ze souboru
 *
 * @author xsuniaik
 * @version etapa 4
 */
public class LoadButton extends Buttons {


    public LoadButton() {
        super("load");
    }


    public void act(){
        chekMouse();
        if(Greenfoot.mouseClicked(this)){
            String name = Greenfoot.ask("Name of game: ");
            var game = Game.load(name);
            var world = new GameWorld(game);
            Greenfoot.setWorld(world);
        }
    }
}
