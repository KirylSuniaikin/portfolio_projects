package cz.mendelu.pjj.new_hra.greenfoot;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public abstract class Buttons extends LabelActor {

      private boolean mouseOver=false;
      private static int MAX_TRANS=255;
      public abstract void act();
      public Buttons(String text) {
            super(text);
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
