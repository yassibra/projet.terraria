package Modele;


import Bloc.Air;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpriteBase {

    Image image;
    ImageView imageView;
    double x;
    double y;
    double health;
    double damage;
    double w;
    double h;
    boolean canMove = true;
    double speed;
    Inventaire inventaire;
    Weapon weapon;
    Bloc blocActif;
    
    public SpriteBase(Image image, double x, double y, double health, double damage, double speed, double damage2, int maxslots) {

        this.image = image;
        this.x = x;
        this.y = y;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.imageView = new ImageView(image);
        this.w = image.getWidth(); 
        this.h = image.getHeight();   
        this.inventaire = new Inventaire();
        this.weapon=new Hand();
        this.blocActif=new Air(0);
        }
    public Image getImage() {
    	return this.image;
    }
    public void setImage(Image i) {
    	this.image=i;
    }
    public void setImageView(ImageView img) {
    	this.imageView=img;
    }
    public double getX() {
        return x;
    }
    
    public void setBlocA(Bloc b) {
    	this.blocActif=b;
    }
    
    public Bloc getBlocA() {
    	return this.blocActif;
    }
    
    public Weapon getWeapon() {
        return this.weapon;
    }
    
    public void setWeapon(Weapon i) {
    	this.weapon=i;
    }
    
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public boolean isAlive() {
        return Double.compare(health, 0) > 0;
    }

    public ImageView getView() {
        return imageView;
    }

    public Inventaire getInv() {
    	return this.inventaire;
    }
}




