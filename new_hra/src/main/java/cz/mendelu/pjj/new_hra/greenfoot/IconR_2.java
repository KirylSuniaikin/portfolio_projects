package cz.mendelu.pjj.new_hra.greenfoot;

import cz.mendelu.pjj.new_hra.Game;
import cz.mendelu.pjj.new_hra.SelectIcon;
import cz.mendelu.pjj.new_hra.TypLokace;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class IconR_2 extends Actor {

    private boolean mouseOver=false;
    private static int MAX_TRANS=255;

    IconR_2(){
        drowImage();
    }

    private void drowImage() {
        var image = new GreenfootImage("Yellow_road.png");
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
        if(Greenfoot.mouseClicked(this)) {
            SelectIcon.setColor(Game.getCurentPl().getColor());
            SelectIcon.setType(TypLokace.Road);
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
