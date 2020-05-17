package Modele;

import Bloc.Air;
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

public class Terrain {

	Map csv;
	Bloc[][] terrain;

	public Terrain(Map csv) {
		this.csv = csv;
		this.terrain = new Bloc[56][100];
	}

	public Bloc[][] getTerrain() {
		return this.terrain;
	}

	public void buildMap() {
		for (int x = 0; x < this.csv.getM().length; x++) {
			for (int i = 0; i < this.csv.getM()[0].length; i++) {
				if (this.csv.getM()[x][i].equals("0")) {
					terrain[x][i] = new Herbe(1);
				}
				if (this.csv.getM()[x][i].equals("-1")) {
					terrain[x][i] = new Air(1);
				}
				if (this.csv.getM()[x][i].equals("1")) {
					terrain[x][i] = new Terre(1);
				}
				if (this.csv.getM()[x][i].equals("2")) {
					terrain[x][i] = new Pierre(1);
				}
				if (this.csv.getM()[x][i].equals("3")) {
					terrain[x][i] = new Eau(1);
				}
				if (this.csv.getM()[x][i].equals("5")) {
					terrain[x][i] = new Bois(1);
				}
				if (this.csv.getM()[x][i].equals("6")) {
					terrain[x][i] = new Feuille(1);
				}
				if (this.csv.getM()[x][i].equals("9")) {
					terrain[x][i] = new Diamant(1);
				}
				if (this.csv.getM()[x][i].equals("10")) {
					terrain[x][i] = new Charbon(1);
				}
				if (this.csv.getM()[x][i].equals("11")) {
					terrain[x][i] = new Or(1);
				}
				if (this.csv.getM()[x][i].equals("13")) {
					terrain[x][i] = new Rubis(1);
				}

			}
		}
	}
}
  