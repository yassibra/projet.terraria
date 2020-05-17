package Modele;

import javafx.animation.KeyFrame;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Jump {

    private KeyFrame jump;
   
    public Jump (String[][] m,Pane g, SpriteBase hero) {
    
    this.jump = new KeyFrame(Duration.seconds(0.025), ev3 -> {
    	if (m[(int) (hero.getY() - 0.1875)][(int) hero.getX()].equals("-1")
                || m[(int) (hero.getY() - 0.1875)][(int) hero.getX()].equals("3")) {
            for (int o = 0; o < g.getChildren().size(); o++) {
                g.getChildren().get(o).setLayoutY(g.getChildren().get(o).getLayoutY() + 6);
            }
            hero.setY(hero.getY() - 0.1875);
        }
    });
    
    }
    public KeyFrame getJump () {
        return this.jump;
    }
}

 