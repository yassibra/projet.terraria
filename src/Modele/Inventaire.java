package Modele;

import java.util.ArrayList;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Inventaire {

	private ArrayList<Item> listeobjets;
	
	public Inventaire() {
		listeobjets = new ArrayList<>();
	}

	public int addItem(Item a, GridPane x, SpriteBase h) {
		for (int i = 0; i < this.listeobjets.size(); i++) {
			if (listeobjets.get(i).getId() == a.getId()) {
				this.listeobjets.get(i).setQ(this.listeobjets.get(i).getQ() + 1);
				return 1;
			}
		}
		listeobjets.add(a);
		ImageView v =new ImageView(a.getLink());
		x.getChildren().add(v);
		GridPane.setColumnIndex(v, a.getIid());
		return 0;
	}

	public int size() {
		return listeobjets.size();
	}

	public void remove1(Item a) {
		a.setQ(a.getQ() - 1);
	}

	public void remove(Item a) {
		this.remove1(a);
		if (a.getQ() == 0)
			this.removeFromList(a);
	}

	public void removeFromList(Item a) {
		listeobjets.remove(a);
	}

	public ArrayList<Item> getList() {
		return this.listeobjets;
	}
}









	