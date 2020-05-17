package Modele;

import java.util.ArrayList;

public abstract class Weapon extends Item{

    private ArrayList<Bloc> listeblocs;
    private int range;
    
    public Weapon(int rarity, int id, int invId, String link, ArrayList<Bloc> list, int range) {
        super(rarity, id, 1, invId, link);
        listeblocs = list;
        this.range =  range;
    }

    public int getRarity() {
        return this.rarity;
    }
    public int getRange() {
        return range;
    }
    public boolean checkifBlocThere(int id) {
        for(int i=0; i<listeblocs.size(); i++) {
            if ( listeblocs.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }
    
}

 