package model;

import java.awt.*;

public class ColorChanger {

    public ColorChanger() { }

    //changes color to the selected color
    public Color COLORS (ShapeColor newcolor) {
        Color finalcolor = null;
        switch (newcolor.toString()) {
            case "BLACK" : finalcolor =  Color.black; break;
            case "BLUE": finalcolor = Color.blue; break;
            case "CYAN" :finalcolor = Color.cyan; break;
            case "MAGENTA" :finalcolor = Color.magenta; break;
            case "ORANGE" :finalcolor = Color.orange; break;
            case "PINK" :finalcolor = Color.pink; break;
            case "RED" :finalcolor = Color.red; break;
            case "WHITE" :finalcolor = Color.white; break;
            case "YELLOW" :finalcolor = Color.yellow; break;
            case "DARK_GRAY" :finalcolor = Color.darkGray; break;
            case "GRAY" :finalcolor = Color.gray ; break;
            case "GREEN" :finalcolor = Color.green; break;
            case "LIGHT_GRAY" :finalcolor = Color.lightGray; break;
        }

        return finalcolor;
    }

}
