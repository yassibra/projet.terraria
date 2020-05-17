package Modele;

public class Bloc extends Item{

    private boolean cassable;
    private boolean recoltable;
    private boolean blocable;
    

    public Bloc(int rarity,  int id, boolean cassable, boolean recoltable, boolean blocable, int q, int invId, String link) {
        
        super(rarity, id, q, invId, link);
        this.cassable = cassable;
        this.recoltable = recoltable;
        this.blocable = blocable;
        
     }
    
    public boolean estCassable() {
        return this.cassable;
    }
    public boolean estRecoltable() {
        return this.recoltable;
    }
    public boolean estBlocable() {
        return this.blocable;
    }
    public boolean jesuisEau() {
        if (id == 5) {
            return true;
        }
        return false;
    }

    
}
