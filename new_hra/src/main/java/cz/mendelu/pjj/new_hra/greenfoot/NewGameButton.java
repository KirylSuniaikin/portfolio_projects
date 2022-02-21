package cz.mendelu.pjj.new_hra.greenfoot;

import greenfoot.Greenfoot;
/**
 * Metoda implementuje vytvareni nove hry, kdyz hrac natlaci na tohle tlacitko v menu
 *
 * @author xsuniaik
 * @version etapa 4
 */
public class NewGameButton extends Buttons {

   public  NewGameButton(){
     super("start");
    }

    public void act(){
        chekMouse();

        if(Greenfoot.mouseClicked(this)){
             Greenfoot.setWorld(new GameWorld());
        }
    }

}
