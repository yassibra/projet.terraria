

 package Modele;

import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class Gravity {

    private KeyFrame gravitation;
    private Map map;
    private Terrain ter;
    public Gravity (Map m, SpriteBase hero, Terrain ter) {
    	this.map=m;
    	this.ter = ter;
        this.gravitation = new KeyFrame(Duration.seconds(0.015), ev3 -> {
        
        if (!ter.getTerrain()[(int) hero.getY() + 1][(int) hero.getX()].estBlocable()
               ) {
            for (int o = 0; o < map.getGrille().getChildren().size(); o++) {
                map.getGrille().getChildren().get(o).setLayoutY(map.getGrille().getChildren().get(o).getLayoutY() - 8);
            }
            hero.setY(hero.getY() + 0.25);
        } 
        });
    }
    
    
    public KeyFrame getGrav()  {
        return this.gravitation;
    }
    
    public void setMatrice(String[][] m) {
    	this.map.setM(m);
    }
}



 