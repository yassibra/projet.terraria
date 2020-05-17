package Modele;

import java.util.ArrayList;

import Bloc.Bois;
import Bloc.Feuille;
import Bloc.Pierre;

public class Hand extends Weapon{
    private static  ArrayList<Bloc> listeblocs = new ArrayList<Bloc>();
    @SuppressWarnings("null")
    public Hand() {
        super(1,999, 999, null, listeblocs,6);
        initializeWeapon();
    }
    
    

    public void initializeWeapon() {
        listeblocs.add(new Bois(0));
        listeblocs.add(new Feuille(0));
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


 