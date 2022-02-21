package cz.mendelu.pjj.new_hra;

public class SelectIcon {
    static private String color=null;
    static private TypLokace type=null;


    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        SelectIcon.color = color;
    }

    public static TypLokace getType() {
        return type;
    }

    public static void setType(TypLokace type) {
        SelectIcon.type = type;
    }
}
