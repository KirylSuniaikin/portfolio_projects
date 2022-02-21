package cz.mendelu.pjj.new_hra.greenfoot;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Price extends Actor {
    Price(){
        drowPrice();
    }

    private void drowPrice() {
        var image = new GreenfootImage("price.jpeg");
        image.scale(280, 120);
        setImage(image);
    }
}
