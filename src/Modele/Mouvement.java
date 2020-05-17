
package Modele;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Mouvement {

	private KeyFrame move;
	private String[][] m;

	public Mouvement(KeyEvent ev, Timeline gl1, Timeline gl2, String[][] matrice, Pane g, SpriteBase hero, Pane jeu,
			Terrain ter) {

		this.m = matrice;
		this.move = new KeyFrame(Duration.seconds(0.02), (ev2 -> {
			switch (ev.getCode()) {

			case UP:
				if ((ter.getTerrain()[(int) hero.getY() + 1][(int) hero.getX()].estBlocable())) {
					gl2.pause();
					Timeline gl3 = new Timeline();
					gl3.setCycleCount(16);
					Jump moves = new Jump(m, g, hero);
					gl3.getKeyFrames().add(moves.getJump());
					gl3.play();
					gl3.setOnFinished(retomber -> {
						gl2.play();
					});
				}
				break;

			case LEFT:
				if (hero.getX() > 0
						&& !ter.getTerrain()[(int) hero.getY()][(int) (hero.getX() - 0.1875)].estBlocable()) {
					if (hero.getX() < 33) {
						jeu.getChildren().get(0).setLayoutX((jeu.getChildren().get(0).getLayoutX()) - 6);
						hero.setX(hero.getX() - 0.1875);
					} else {
						for (int o = 0; o < g.getChildren().size(); o++) {
							g.getChildren().get(o).setLayoutX(g.getChildren().get(o).getLayoutX() + 6);
						}
						hero.setX(hero.getX() - 0.1875);
					}
				} else {
					gl1.stop();
				}
				break;

			case RIGHT:
				if (hero.getX() < 99) {
					if (!ter.getTerrain()[(int) hero.getY()][(int) hero.getX() + 1].estBlocable()

					) {
						if (hero.getX() < 33) {
							jeu.getChildren().get(0).setLayoutX((jeu.getChildren().get(0).getLayoutX()) + 6);
							hero.setX(hero.getX() + 0.1875);
						} else {
							for (int o = 0; o < g.getChildren().size(); o++) {
								g.getChildren().get(o).setLayoutX(g.getChildren().get(o).getLayoutX() - 6);
							}
							hero.setX(hero.getX() + 0.1875);
						}
					}
				} else {
					gl1.stop();
				}
				break;

			default:

				break;

			}
		}));
	}

	public KeyFrame getMove() {
		return this.move;
	}

	public void setMatrice(String[][] m) {
		this.m = m;
	}

}




























