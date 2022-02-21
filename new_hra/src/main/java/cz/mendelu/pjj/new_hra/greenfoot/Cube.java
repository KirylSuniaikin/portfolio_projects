package cz.mendelu.pjj.new_hra.greenfoot;

import cz.mendelu.pjj.new_hra.Game;
import cz.mendelu.pjj.new_hra.Player;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

/**
 * Metoda implementuje hru kostkou
 *
 * @author xsuniaik
 * @version etapa 4
 */
public class Cube extends Actor {

    public Cube(){
        drowCube(1);
    }

    private void drowCube(int a) {
        if(a==1) {
            var kubic = new GreenfootImage("Kostka1.jpeg");
            kubic.scale(60, 60);
            setImage(kubic);
        }if(a==2) {
            var kubic = new GreenfootImage("Kostka2.jpeg");
            kubic.scale(60, 60);
            setImage(kubic);
        }if(a==3) {
            var kubic = new GreenfootImage("Kostka3.jpeg");
            kubic.scale(60, 60);
            setImage(kubic);
        }if(a==4) {
            var kubic = new GreenfootImage("Kostka4.jpeg");
            kubic.scale(60, 60);
            setImage(kubic);
        }if(a==5) {
            var kubic = new GreenfootImage("Kostka5.jpeg");
            kubic.scale(60, 60);
            setImage(kubic);
        }if(a==6) {
            var kubic = new GreenfootImage("Kostka6.jpeg");
            kubic.scale(60, 60);
            setImage(kubic);
        }
        }

@Override
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            drowCube(Player.hodKostkamy());
        }
    }

}
