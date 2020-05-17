package Modele;

import java.util.List;

import javafx.scene.layout.GridPane;

public class Recipe {

	private List<Bloc> inputs;// This can assume that each ThingsStack has a unique Things
	private Item output;// can be extended to List<ThingsStack> outputs
	private Boolean canCraft;

	public Recipe(List<Bloc> inputs, Item output) {
		this.inputs = inputs;
		this.output = output;
	}

	// Goes through inputs and sees if inventory contains everything
	public Boolean verifInventory(SpriteBase hero,  GridPane inv) {
		int y = 0;
		for (int i = 0; i < hero.getInv().getList().size(); i++) {
			for (int x = 0; x < this.inputs.size(); x++) {
				if (hero.getInv().getList().get(i).getId() == this.inputs.get(x).getId()) {
					y++;
					if (y==this.inputs.size()) {
						System.out.println("ta dead ca chackal");
						this.canCraft=true;
						return canCraft;
					}
				}
			}
		}
		System.out.println("té boxer");
		return canCraft;
	}
		
	public void delItems(SpriteBase hero) {
		int x = 0;
		for (int i = 0; i < hero.getInv().getList().size(); i++) {
			while (x < this.inputs.size()) {
				if (hero.getInv().getList().get(i).getId() == this.inputs.get(x).getId()) {
					hero.getInv().getList().remove(i);
					x++;
				}
			}
		}
	} 

	// Craft the Things, checks canCraft again to sure, removes all the inputs from
	// inventory, and puts the output in the inventory
	

	public void noCraft() {
		canCraft = false;
	}

	public boolean canCraft() {
		return this.canCraft;
	}

}






