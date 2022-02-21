package cz.mendelu.pjj.new_hra.greenfoot;

import cz.mendelu.pjj.new_hra.Game;
import greenfoot.Greenfoot;
/**
 * Metoda implementuje ukladni hry do souboru
 *
 * @author xsuniaik
 * @version etapa 4
 */
public class SaveButton extends Buttons {

private final Game game;

    public SaveButton(final Game game) {
        super("save");
        this.game=game;
    }

    public void act(){
        chekMouse();
        if(Greenfoot.mouseClicked(this)){
            String name = Greenfoot.ask("Name of game: ");
            Game.save(this.game, name);
        }
    }
}
