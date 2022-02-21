package cz.mendelu.pjj.new_hra.greenfoot;

import cz.mendelu.pjj.new_hra.Game;
import greenfoot.Greenfoot;

public class FinishButton extends Buttons{

    public FinishButton() {
        super("Next move");
    }

    @Override
    public void act() {
        chekMouse();
        if(Greenfoot.mouseClicked(this)) {
            Game.changeCurrentPlayer();
        }
    }
}
