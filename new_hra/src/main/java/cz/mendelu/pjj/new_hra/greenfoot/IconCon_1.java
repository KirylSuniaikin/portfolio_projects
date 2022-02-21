package cz.mendelu.pjj.new_hra.greenfoot;

import cz.mendelu.pjj.new_hra.Game;
import cz.mendelu.pjj.new_hra.SelectIcon;
import cz.mendelu.pjj.new_hra.TypLokace;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class IconCon_1 extends Actor {
    private boolean mouseOver=false;
    private static int MAX_TRANS=255;

    IconCon_1(){
        drowImage();
    }

    private void drowImage() {
        var image = new GreenfootImage("Blue_town.png");
        image.scale(55, 55);
        setImage(image);
    }

    /**
     * Metoda zapomina icon, na ktery jsi natlavil
     *
     * @author xsuniaik
     * @version etapa 5
     */
    @Override
    public void act() {
        chekMouse();
        if(Greenfoot.mouseMoved(this)) {
            SelectIcon.setColor(Game.getCurentPl().getColor());
            SelectIcon.setType(TypLokace.Country);
        }
    }

    public void chekMouse(){
        if(Greenfoot.mouseMoved(null)){
            mouseOver= Greenfoot.mouseMoved(this);
        }

        if(mouseOver){
            adjTrans(MAX_TRANS/2);
        }else{
            adjTrans(MAX_TRANS);
        }
    }
    public void adjTrans(int adjust){
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(adjust);
        setImage(tempImage);
    }
}
