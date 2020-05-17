package Modele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Map {

    private Pane grille;
    private String[][] matrice;
    private String csvFile;

    static Image herbe = new Image(
            "file:Tile/Spritesheet(1)(1).png");
    static Image bois = new Image(
            "file:Tile/Spritesheet(5)(1).png");
    static Image feuille = new Image(
            "file:Tile/Spritesheet(6)(1).png");
    static Image pierre = new Image(
            "file:Tile/Spritesheet(3)(1).png");
    static Image terre = new Image(
            "file:Tile/Spritesheet(2)(1).png");
    static Image eau = new Image(
            "file:Tile/Spritesheet(4)(1).png");
    static Image charbon = new Image(
            "file:Tile/Spritesheet(7)(1).png");
    static Image or = new Image(
            "file:Tile/Spritesheet(8)(1).png");
    static Image diamant = new Image(
            "file:Tile/Spritesheet(9)(1).png");
    static Image rubis = new Image(
            "file:Tile/Spritesheet(10)(1).png");
    static Image vide = new Image(
            "file:Tile/New Piskel(5)(1).png");
   

    public Map(Pane p, String[][] m, String csv) {
        this.matrice = m;
        this.grille = p;
        this.csvFile = csv;
    }
    
    public String getCsv() {
        return this.csvFile;
    }
    
    public String[][] getM() {
        return this.matrice;
    }
    
    public Pane getGrille() {
    	return this.grille;
    }
    
    public void setM(String[][] m) {
    	this.matrice=m;
    }
    public void paintMap() {

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int x = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {

                String[] mytab = line.split(cvsSplitBy);
                for (int i = 0; i < mytab.length; i++) {

                    matrice[x][i] = mytab[i];
                    ImageView v1 = new ImageView();
                    
                    
                    
                    if (matrice[x][i].equals("-1")) {
                        v1.setImage(vide);
                        grille.getChildren().add(v1);
                        v1.relocate(i * 32, x * 32);
    
                    }
                    if (matrice[x][i].equals("0")) {
                        v1.setImage(herbe);
                        grille.getChildren().add(v1);
                        v1.relocate(i * 32, x * 32);
                        
                    }
                    if (matrice[x][i].equals("1")) {
                        v1.setImage(terre);
                        grille.getChildren().add(v1);
                        v1.relocate(i * 32, x * 32);
                        
                    }
                    if (matrice[x][i].equals("2")) {
                        v1.setImage(pierre);
                        grille.getChildren().add(v1);
                        v1.relocate(i * 32, x * 32);
                        
                    }
                    if (matrice[x][i].equals("3")) {
                        v1.setImage(eau);
                        grille.getChildren().add(v1);
                        v1.relocate(i * 32, x * 32);
                        
                    }
                    if (matrice[x][i].equals("10")) {
                        v1.setImage(charbon);
                        grille.getChildren().add(v1);
                        v1.relocate(i * 32, x * 32);
                    }
                    if (matrice[x][i].equals("11")) {
                        v1.setImage(or);
                        grille.getChildren().add(v1);
                        v1.relocate(i * 32, x * 32);
                        
                    }
                    if (matrice[x][i].equals("9")) {
                        v1.setImage(diamant);
                        grille.getChildren().add(v1);
                        v1.relocate(i * 32, x * 32);
                        
                    }
                    if (matrice[x][i].equals("13")) {
                        v1.setImage(rubis);
                        grille.getChildren().add(v1);
                        v1.relocate(i * 32, x * 32);
                        
                    }
                    if (matrice[x][i].equals("5")) {
                        v1.setImage(bois);
                        grille.getChildren().add(v1);
                        v1.relocate(i * 32, x * 32);
                        
                    }
                    if (matrice[x][i].equals("6")) {
                        v1.setImage(feuille);
                        grille.getChildren().add(v1);
                        v1.relocate(i * 32, x * 32);
                        
                    }
                }
                x++;
            }

        } catch (FileNotFoundException e) { } 
        catch (IOException e) {} finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {}
            }
        }
    }
}




