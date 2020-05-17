package Modele;

import java.util.ArrayList;

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
import javafx.scene.image.Image;

public  class Hammer extends Weapon{
	private static  ArrayList<Bloc> listeblocs = new ArrayList<Bloc>();
	public Hammer() {
		super(1,81, 12, "file:Tile/hammer.png", listeblocs,6);
		initializeWeapon();
	}
	
	

	public void initializeWeapon() {
		listeblocs.add(new Terre(0));
		listeblocs.add(new Herbe(0));
		listeblocs.add(new Bois(0));
		listeblocs.add(new Feuille(0));
		listeblocs.add(new Diamant(0));
		listeblocs.add(new Or(0));
		listeblocs.add(new Rubis(0));
		listeblocs.add(new Charbon(0));
		listeblocs.add(new Pierre(0));
		listeblocs.add(new Eau(0));
	}
	
	
	public Recipe HammerRecipe() {
		Recipe hammer;
		ArrayList<Bloc> lst = new ArrayList<>();
		lst.add(new Bois(1));
		lst.add(new Pierre(1));
		hammer = new Recipe(lst, this);
		hammer.noCraft();
		return hammer;
    }
	
	public String toString() {
		return "Hammer | "+this.id; 
	}
}

