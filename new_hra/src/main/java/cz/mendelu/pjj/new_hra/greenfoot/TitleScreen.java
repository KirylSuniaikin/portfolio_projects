package cz.mendelu.pjj.new_hra.greenfoot;

import greenfoot.GreenfootImage;
import greenfoot.World;


/**
 * Tato trida vytvari menu hry a vsychni potrebna tlacitka
 *
 * @author xsuniaik
 * @version etapa 4
 */
public class TitleScreen extends World {


    public TitleScreen() {
        super(900,600,1);
        var image = new GreenfootImage("menu.jpg");
        image.scale(900, 600);
        setBackground(image);
        addObject(new NewGameButton(),465,210);

        addObject(new ExitButton(), 465, 250);
    }
}
