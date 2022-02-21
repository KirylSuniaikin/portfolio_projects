package cz.mendelu.pjj.new_hra.greenfoot;

import greenfoot.Greenfoot;
/**
 * Metoda implementuje skonceni a zavirani hry
 *
 * @author xsuniaik
 * @version etapa 4
 */
public class ExitButton extends Buttons {
    public ExitButton() {
        super("exit");
    }
    public void act(){
        chekMouse();
        if(Greenfoot.mouseClicked(this)){
           System.exit(0);
        }

    }

}
