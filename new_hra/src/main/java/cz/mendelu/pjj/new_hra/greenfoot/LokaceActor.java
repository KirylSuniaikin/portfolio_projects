package cz.mendelu.pjj.new_hra.greenfoot;

import cz.mendelu.pjj.new_hra.*;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
/**
 * Trida zobrazi kazdou lokace
 * Vypis vytvorenych lokaci
 *
 * @author xsuniaik
 * @version etapa 4
 * @version etapa 5
 */
public class LokaceActor extends Actor {

    private Lokace lokace;

    public LokaceActor(Lokace lokace){
        this.lokace=lokace;
        drawLokace();
    }

    private void drawLokace() {

        if(this.lokace.getTyp()==null){
            var image = new GreenfootImage("kolo.png");
            image.scale(25, 25);
            setImage(image);
        }
        if(this.lokace.getTyp()== TypLokace.Info && this.lokace.getLokaceX()==1 && this.lokace.getLokaceY()==1){
            var image = new GreenfootImage("1.1.png");
            image.scale(50, 60);
            setImage(image);
        }
        if(this.lokace.getTyp()== TypLokace.Info && this.lokace.getLokaceX()==3 && this.lokace.getLokaceY()==1){
            var image = new GreenfootImage("1.3.png");
            image.scale(50, 60);
            setImage(image);
        }
        if(this.lokace.getTyp()== TypLokace.Info && this.lokace.getLokaceX()==5 && this.lokace.getLokaceY()==1){
            var image = new GreenfootImage("1.5.png");
            image.scale(50, 60);
            setImage(image);
        }
        if(this.lokace.getTyp()== TypLokace.Info && this.lokace.getLokaceX()==7 && this.lokace.getLokaceY()==1){
            var image = new GreenfootImage("1.7.png");
            image.scale(50, 60);
            setImage(image);
        }
        if(this.lokace.getTyp()== TypLokace.Info && this.lokace.getLokaceX()==1 && this.lokace.getLokaceY()==3){
            var image = new GreenfootImage("3.1.png");
            image.scale(50, 60);
            setImage(image);
        }
        if(this.lokace.getTyp()== TypLokace.Info && this.lokace.getLokaceX()==3 && this.lokace.getLokaceY()==3){
            var image = new GreenfootImage("3.3.png");
            image.scale(50, 60);
            setImage(image);
        }
        if(this.lokace.getTyp()== TypLokace.Info && this.lokace.getLokaceX()==5 && this.lokace.getLokaceY()==3){
            var image = new GreenfootImage("3.5.png");
            image.scale(50, 60);
            setImage(image);
        }
        if(this.lokace.getTyp()== TypLokace.Info && this.lokace.getLokaceX()==7 && this.lokace.getLokaceY()==3){
            var image = new GreenfootImage("3.7.png");
            image.scale(50, 60);
            setImage(image);
        }
        if(this.lokace.getTyp()== TypLokace.Info && this.lokace.getLokaceX()==1 && this.lokace.getLokaceY()==5){
            var image = new GreenfootImage("5.1.png");
            image.scale(50, 60);
            setImage(image);
        }
        if(this.lokace.getTyp()== TypLokace.Info && this.lokace.getLokaceX()==3 && this.lokace.getLokaceY()==5){
            var image = new GreenfootImage("5.3.png");
            image.scale(50, 60);
            setImage(image);
        }
        if(this.lokace.getTyp()== TypLokace.Info && this.lokace.getLokaceX()==5 && this.lokace.getLokaceY()==5){
            var image = new GreenfootImage("5.5.png");
            image.scale(50, 60);
            setImage(image);
        }
        if(this.lokace.getTyp()== TypLokace.Info && this.lokace.getLokaceX()==7 && this.lokace.getLokaceY()==5){
            var image = new GreenfootImage("5.7.png");
            image.scale(50, 60);
            setImage(image);
        }
      if(Mapa.getLokace(this.lokace.getLokaceX(), this.lokace.getLokaceY()).getTyp() != null &&
              Mapa.getLokace(this.lokace.getLokaceX(), this.lokace.getLokaceY()).getTyp() != TypLokace.Info){

          if(Mapa.getLokace(this.lokace.getLokaceX(), this.lokace.getLokaceY()).getTyp()==TypLokace.Country &&
                  Mapa.getLokace(this.lokace.getLokaceX(), this.lokace.getLokaceY()).getColor()=="Blue") {
              var image = new GreenfootImage("Blue_town.png");
              image.scale(50, 60);
              setImage(image);
          }

          if(Mapa.getLokace(this.lokace.getLokaceX(), this.lokace.getLokaceY()).getTyp()==TypLokace.Road &&
                  Mapa.getLokace(this.lokace.getLokaceX(), this.lokace.getLokaceY()).getColor()=="Blue") {
              var image = new GreenfootImage("Blue_road.png");
              image.scale(50, 60);
              setImage(image);
          }

          if(Mapa.getLokace(this.lokace.getLokaceX(), this.lokace.getLokaceY()).getTyp()==TypLokace.Country &&
                  Mapa.getLokace(this.lokace.getLokaceX(), this.lokace.getLokaceY()).getColor()=="Yellow") {
              var image = new GreenfootImage("Yellow_town.png");
              image.scale(50, 60);
              setImage(image);
          }

          if(Mapa.getLokace(this.lokace.getLokaceX(), this.lokace.getLokaceY()).getTyp()==TypLokace.Road &&
                  Mapa.getLokace(this.lokace.getLokaceX(), this.lokace.getLokaceY()).getColor()=="Yellow") {
              var image = new GreenfootImage("Yellow_road.png");
              image.scale(50, 60);
              setImage(image);
          }

      }


    }

    @Override
    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            Game.getCurentPl().buildLokace(SelectIcon.getType(), SelectIcon.getColor(), lokace.getLokaceX(), lokace.getLokaceY());
            drawLokace();
            SelectIcon.setType(null);
            SelectIcon.setColor(null);
        }
    }
}
