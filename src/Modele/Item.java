package Modele;

import javafx.scene.image.Image;

public abstract class Item {

	protected int id;
	protected int rarity; 
	protected int q;
	protected int invId;
	protected String lien;

	public Item(int rarity, int id, int q, int invId, String l) {
		this.rarity = rarity;
		this.id = id;
		this.q=q;
		this.invId=invId;
		this.lien=l;
	}

	public int getRarity() {
		return this.rarity;
	}
	
	public int getId() {
		return id;
		
	}
	
	public int getQ() {
		return this.q;
	}
	
	public void setQ(int x) {
		this.q=x;
	}
	
	public int getIid() {
		return this.invId;
	}
	
	public String getLink() {
		return this.lien;
	}
}