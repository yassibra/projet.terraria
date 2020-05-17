package Modele;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;

public class Craft {

	private ArrayList<Recipe> craftList;
	
	public Craft() {
		this.craftList=new ArrayList<>();
	}
	
	public void addRecipe(Recipe e) {
		this.craftList.add(e);
	}
	
	public void verifCraft(SpriteBase hero, GridPane inv) {
		for(int i=0; i<craftList.size(); i++) { 
			this.craftList.get(i).verifInventory(hero, inv);
			if(this.craftList.get(i).canCraft())
				System.out.println("Ca marche");
		}
	}
	
	public ArrayList<Recipe> getList() {
		return this.craftList;
	}
}








