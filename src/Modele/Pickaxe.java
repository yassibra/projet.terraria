
package Modele;

import java.util.ArrayList;

import Bloc.Bois;
import Bloc.Eau;
import Bloc.Feuille;
import Bloc.Herbe;
import Bloc.Pierre;
import Bloc.Terre;
import javafx.scene.image.Image;

public class Pickaxe extends Weapon {

	private static  ArrayList<Bloc> listeblocs = new ArrayList<Bloc>();
	
	public Pickaxe() {
		
		super(1, 80, 10,"file:Tile/pickaxe.png", listeblocs, 1);
		initializeWeapon();
	}

	public void initializeWeapon() {
		listeblocs.add(new Terre(0));
		listeblocs.add(new Herbe(0));
		listeblocs.add(new Pierre(0));
		listeblocs.add(new Bois(0));
		listeblocs.add(new Feuille(0));
		listeblocs.add(new Eau(0));
	}
	
	public Recipe PickaxeRecipe() {
		Recipe pickaxe;
		ArrayList<Bloc> lst = new ArrayList<>();
		lst.add(new Bois(1));
		lst.add(new Terre(1));
		pickaxe = new Recipe(lst, this);
		pickaxe.noCraft();
		return pickaxe;

	}

	public String toString() {
		return "Pickaxe | " + this.id;
	}
	public ArrayList<Bloc> getList() {
		return this.listeblocs;
	}
}




