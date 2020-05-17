package Controller;

import Bloc.Air;
import Bloc.Eau;
import Bloc.Pierre;
import Modele.SpriteBase;
import Modele.Terrain;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ClickControl implements EventHandler<MouseEvent> {

	private String[][] m;
	private Pane g;
	private SpriteBase hero;
	private Terrain t;
	private GridPane grid;

	public ClickControl(String[][] m, Pane g, SpriteBase hero, Terrain t, GridPane gg) {
		this.m = m;
		this.g = g;
		this.hero = hero;
		this.t = t;
		this.grid = gg;
	}

	public void handle(MouseEvent e) {
		if (e.getButton() == MouseButton.PRIMARY) {
			this.effacerTile(e, this.grid);
		}
		if (e.getButton() == MouseButton.SECONDARY) {
			ImageView p1 = new ImageView();
			p1.setImage(new Image(hero.getBlocA().getLink()));
			this.ajouterTile(e, p1);
		}
	}

	public void effacerTile(MouseEvent e, GridPane inv) {

		int d;
		int c;

		try {
			if (hero.getX() < 33) {
				d = (int) (e.getSceneX() - (e.getSceneX() % 32)) / 32;
				c = (int) (((int) (e.getSceneY() - (e.getSceneY() % 32)) / 32) + ((int) hero.getY() - 17));
			}

			else {
				d = (int) (((int) (e.getSceneX() - (e.getSceneX() % 32)) / 32) + ((int) hero.getX() - 33));
				c = (int) (((int) (e.getSceneY() - (e.getSceneY() % 32)) / 32) + ((int) hero.getY() - 17));
			}
			if (hero.getWeapon().checkifBlocThere(t.getTerrain()[c][d].getId())) {
				if (t.getTerrain()[c][d].estRecoltable()) {
					hero.getInv().addItem(t.getTerrain()[c][d], inv, hero);

				}
				if (t.getTerrain()[c][d].estCassable()) {

					this.m[c][d] = "-1";
					this.t.getTerrain()[c][d] = new Air(0);

					this.g.getChildren()
							.removeIf(img -> img.getLayoutY() >= e.getY() - 32 && img.getLayoutY() < e.getY()
									&& img.getLayoutX() >= e.getX() - 32 && img.getLayoutX() < e.getX());

					if (t.getTerrain()[c][d - 1].jesuisEau() || t.getTerrain()[c][d + 1].jesuisEau()
							|| t.getTerrain()[c - 1][d].jesuisEau() || t.getTerrain()[c - 1][d + 1].jesuisEau()
							|| t.getTerrain()[c - 1][d - 1].jesuisEau()) {
						ImageView v = new ImageView(new Image("file:Tile/Spritesheet(4)(1).png"));

						this.g.getChildren().add(v);
						v.relocate(e.getX() - (e.getX() % 32), e.getY() - (e.getY() % 32));
						this.t.getTerrain()[c][d] = new Eau(0);
					}

				}
			}
		} catch (ArrayIndexOutOfBoundsException exception) {
		}
	}

	public void ajouterTile(MouseEvent e, ImageView v) {

		int d;
		int c;
		try {
			if (hero.getX() < 33) {
				d = (int) (e.getSceneX() - (e.getSceneX() % 32)) / 32;
				c = (int) (((int) (e.getSceneY() - (e.getSceneY() % 32)) / 32) + ((int) hero.getY() - 17));
			}

			else {
				d = (int) (((int) (e.getSceneX() - (e.getSceneX() % 32)) / 32) + ((int) hero.getX() - 33));
				c = (int) (((int) (e.getSceneY() - (e.getSceneY() % 32)) / 32) + ((int) hero.getY() - 17));
			}
			if (this.m[c][d] == "-1") {
				this.m[c][d] = "2";
				this.t.getTerrain()[c][d] = new Pierre(1);
				this.g.getChildren().add(v);
				v.relocate(e.getX() - (e.getX() % 32), e.getY() - (e.getY() % 32));
			}
		} catch (ArrayIndexOutOfBoundsException exception) {
		}
	}

	public String[][] getMatrice() {
		return this.m;
	}
}
