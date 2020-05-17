package Controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import Bloc.Bois;
import Bloc.Charbon;
import Bloc.Diamant;
import Bloc.Eau;
import Bloc.Feuille;
import Bloc.Herbe;
import Bloc.Or;
import Bloc.Pierre;
import Bloc.Rubis;
import Bloc.Terre;
import Modele.Map;
import Modele.Gravity;
import Modele.Hammer;
import Modele.Mouvement;
import Modele.Pickaxe;
import Modele.Shovel;
import Modele.SpriteBase;
import Modele.Terrain;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Controller implements Initializable {

	@FXML
	private Pane grille;

	@FXML
	private Pane jeu;

	@FXML
	private GridPane inv;

	static Timeline gameLoop1;
	static Timeline gameLoop2;
	static boolean mouvement = false;
	static String[][] matrice = new String[56][100];
	static Map map;
	static int compteur = 0;
	static Mouvement move;
	static Gravity g;
	static ClickControl clicControl;
	static Image OnePiece = new Image("file:Tile/onepiece.png");

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// PAINT + BUILD OF THE MAP //
		Background fond = new Background(
				new BackgroundImage(new Image("file:Tile/fondfinal.jpg"), null, null, null, null));
		String csvFile = "Tile/map.csv";
		map = new Map(grille, matrice, csvFile);
		Terrain ter = new Terrain(map);
		grille.setBackground(fond);
		map.paintMap();
		ter.buildMap();
		////////////////////////////////////////////////////
		ImageView vx = new ImageView();
        vx.setImage(OnePiece);
        grille.getChildren().add(vx);
        vx.relocate(82 * 32, 50 * 32);
        vx.toBack();
		///////////////////////////////////////////////////////
		jeu.toFront();
		grille.toBack();
		
		// CREATION OF THE PLAYER //
		Image joueur = new Image("file:Tile/pepe.png");
		SpriteBase hero = new SpriteBase(joueur, 30, 17, 100, 10, 5, 1, 5);
		jeu.getChildren().add(hero.getView());
		hero.getView().relocate(960.0, 544.0);

		////////////////// INVENTORY ////////////////////
		Background invV = new Background(new BackgroundImage(new Image("file:Tile/black.jpg"), null, null, null, null));
		inv.setBackground(invV);
		inv.toFront();

		ImageView pic = new ImageView(new Image("file:Tile/craftPickaxe.png"));
		inv.getChildren().add(pic);
		GridPane.setColumnIndex(pic, 15);

		ImageView sho = new ImageView(new Image("file:Tile/craftShovel.png"));
		inv.getChildren().add(sho);
		GridPane.setColumnIndex(sho, 14);

		ImageView ham = new ImageView(new Image("file:Tile/craftHammer.png"));
		inv.getChildren().add(ham);
		GridPane.setColumnIndex(ham, 13);

		pic.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			Pickaxe p = new Pickaxe();
			boolean canCraft = p.PickaxeRecipe().verifInventory(hero, inv);
			if (canCraft) {
				hero.getInv().getList().add(p);
				ImageView v = new ImageView(p.getLink());
				inv.getChildren().add(v);
				GridPane.setColumnIndex(v, p.getIid());
				hero.getInv().getList().add(p);
			}
		});

		sho.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			Shovel s = new Shovel();
			boolean canCraft = s.ShovelRecipe().verifInventory(hero, inv);
			if (canCraft) {
				hero.getInv().getList().add(s);
				ImageView v = new ImageView(s.getLink());
				inv.getChildren().add(v);
				GridPane.setColumnIndex(v, s.getIid());
			}
		});

		ham.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			Hammer h = new Hammer();
			boolean canCraft = h.HammerRecipe().verifInventory(hero, inv);
			if (canCraft) {
				hero.getInv().getList().add(h);
				ImageView v = new ImageView(h.getLink());
				inv.getChildren().add(v);
				GridPane.setColumnIndex(v, h.getIid());
			}
		});
		
		
		inv.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			int x =(int) (event.getX()/50);		
			double hx=hero.getView().getLayoutX();
			double hy=hero.getView().getLayoutY();
			
			switch(x) {
			case 0:
				hero.setBlocA(new Terre(0));
				break;
			case 1:
				hero.setBlocA(new Pierre(0));
				break;
			case 2:
				hero.setBlocA(new Herbe(0));
				break;
			case 3:
				hero.setBlocA(new Eau(0));
				break;
			case 4:
				hero.setBlocA(new Bois(0));
				break;
			case 5:
				hero.setBlocA(new Charbon(0));
				break;
			case 6:
				hero.setBlocA(new Or(0));
				break;
			case 7:
				hero.setBlocA(new Rubis(0));
				break;
			case 8:
				hero.setBlocA(new Feuille(0));
				break;
			case 9:
				hero.setBlocA(new Diamant(0));
				break;
			case 10:
				hero.setWeapon(new Pickaxe());
				hero.setImageView(new ImageView(new Image("file:Tile/pepepioche.png")));
				jeu.getChildren().remove(0);
				jeu.getChildren().add(hero.getView());
				hero.getView().relocate(hx,hy);
				break;
			case 11:
				hero.setWeapon(new Shovel());
				hero.setImageView(new ImageView(new Image("file:Tile/pepepelle.png")));
				jeu.getChildren().remove(0);
				jeu.getChildren().add(hero.getView());
				hero.getView().relocate(hx,hy);
				break;
			case 12:
				hero.setWeapon(new Hammer());
				hero.setImageView(new ImageView(new Image("file:Tile/pepemarteau.png")));
				jeu.getChildren().remove(0);
				jeu.getChildren().add(hero.getView());
				hero.getView().relocate(hx,hy);
				break;
			}
		});

		// GRAVITY SETTINGS //
		g = new Gravity(map, hero, ter);
		gameLoop2 = new Timeline();
		gameLoop2.setCycleCount(Timeline.INDEFINITE);
		gameLoop2.getKeyFrames().add(g.getGrav());
		gameLoop2.play();

		// MOUVEMENT AND COLLISION MANAGEMENT //
		grille.setOnKeyReleased(ev3 -> {
			gameLoop1.stop();
			mouvement = false;
		});
		grille.setOnKeyPressed(ev -> {
			if (!mouvement) {
				gameLoop1 = new Timeline();
				gameLoop1.setCycleCount(Timeline.INDEFINITE);
				move = new Mouvement(ev, gameLoop1, gameLoop2, map.getM(), map.getGrille(), hero, jeu, ter);
				gameLoop1.getKeyFrames().add(move.getMove());
				gameLoop1.play();
				mouvement = true;
			}
		});

		// CLICK EVENT FOR MINING //
		clicControl = new ClickControl(map.getM(), map.getGrille(), hero, ter, inv);
		jeu.addEventHandler(MouseEvent.MOUSE_CLICKED, clicControl);
		
		//MUSIC//
		MediaPlayer player = new MediaPlayer( new Media(new File("Tile/megalovania.mp3").toURI().toString()));
		player.play();
	}
		
}


















