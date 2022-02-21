package cz.mendelu.pjj.new_hra.greenfoot;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Trida pro zobrazeni textu daneho formatu
 *
 * @author xsuniaik
 * @version etapa 4
 */
public class LabelActor extends Actor {

    private String text;

    public LabelActor(String text) {
        this.setText(text);
    }

    public LabelActor() {
        setText(getClass().getSimpleName());
    }

    public void setText(String text) {
        if (!Objects.equals(this.text, text)) {
            this.text = text;
            var image = new GreenfootImage(text, 32, Color.BLACK, new Color(255,255,255,0));
            setImage(image);
        }
    }

    protected String updateText() {
        return null;
    }

    @Override
    public void act() {
        var newText = updateText();
        if (newText != null) {
            setText(newText);
        }
    }
}
