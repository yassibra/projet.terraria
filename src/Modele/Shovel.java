package Modele;

import java.util.ArrayList;

import Bloc.Bois;
import Bloc.Eau;
import Bloc.Feuille;
import Bloc.Herbe;
import Bloc.Terre;
import javafx.scene.image.Image;

public class Shovel extends Weapon {
	private static  ArrayList<Bloc> listeblocs = new ArrayList<Bloc>();
	public Shovel() {
		super(1, 82, 11,"file:Tile/shovel.png", listeblocs, 4);
		initializeWeapon();
	}


	public void initializeWeapon() {
		listeblocs.add(new Terre(0));
		listeblocs.add(new Herbe(0));
		listeblocs.add(new Bois(0));
		listeblocs.add(new Feuille(0));
		listeblocs.add(new Eau(0));
	}
	
	
	
	
	public Recipe ShovelRecipe() {
		Recipe shovel;
		ArrayList<Bloc> lst = new ArrayList<>();
		lst.add(new Bois(1));
		lst.add(new Bois(1));
		shovel = new Recipe(lst, this);
		shovel.noCraft();
		return shovel;
	}

	public String toString() {
		return "Shovel | " + this.id;
	}

}