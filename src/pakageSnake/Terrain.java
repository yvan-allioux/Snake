package pakageSnake;

import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class Terrain {
	
	private int mGrilleX;
	private int mGrilleY;
	private int mPomme;
	private int mPommeRestante;
	private int mPommeManger;
	private int[][] tableau;
	private int[][] mTeteSterpent;
	private int mSerpentX;
	private int mSerpentY;
	private int mDeplacementDirection;
	
	public Terrain(int nbPommeParam,int mGrilleXParam,int mGrilleYParam) {
		
		mGrilleX = mGrilleXParam;
		mGrilleY = mGrilleYParam;
		mPomme = nbPommeParam;
		mPommeManger = 0;
		setmPommeRestante(nbPommeParam);
		
		System.out.println("creation objet Terrain, dimension " + mGrilleX + " par "+ mGrilleY +" pomme " + mPomme);
		
		//creation et affichage du tableau
		tableau = new int[mGrilleX][mGrilleY];
		int k=0;
	      for (int i = 0;i < tableau.length; i++) {
	         for (int j = 0;j < tableau[i].length;j++) {
	            tableau[i][j] = k;
	            //System.out.print(tableau[i][j] + " ");
	         }
	         //System.out.println();
	      }      
	      //placement des pomme
	      int initRandomX = ThreadLocalRandom.current().nextInt(0, mGrilleX-1 + 1);
	      int initRandomY = ThreadLocalRandom.current().nextInt(0, mGrilleY-1 + 1);
	      tableau[initRandomX][initRandomY] = 1;
	      for(int i = 0;i < mPomme-1;) {
	    	  int randomX = ThreadLocalRandom.current().nextInt(0, mGrilleX-1 + 1);
		      int randomY = ThreadLocalRandom.current().nextInt(0, mGrilleY-1 + 1);
		      
		      if(tableau[initRandomX][initRandomY] != tableau[randomX][randomY]) {
		    	  tableau[randomX][randomY] = 1;
		    	  i++;
		      }
	      }

	      //affichage
	      for (int i = 0;i < tableau.length; i++) {
		         for (int j = 0;j < tableau[i].length;j++) {
		            System.out.print(tableau[i][j] + " ");
		         }
		         System.out.println();
		      }
	      //ceration zone de jeux
	      Serpent serpent1 = new Serpent();
	      ZoneDeJeu zone1 = new ZoneDeJeu(tableau, mGrilleX-1, mGrilleY-1);
	      Processus pross1 = new Processus();
	      
	      //serpent1.setX(pross1.deplacementX(2, serpent1.getX()));
	      
	      zone1.setmSerpentX(2);
	      zone1.setmSerpentY(2);
	      //pross1.pause(200);
	      zone1.repaintFrame();
	      
	      //pross1.deplacementY(2, serpent1.getY());
	      
	      
	      //serpent1.setX(pross1.deplacementX(2, serpent1.getX()));
	      //on passe la tete du serpent dans la zone
	      zone1.setmSerpentX(serpent1.getX());
	      zone1.setmSerpentY(serpent1.getY());
	      //serpent1.setmSerpentX();
	      pross1.run();
	      //pross1.start();
	}
	
	public boolean pommeCaseTest(int X, int Y){
		boolean YaUnePomme;
		if (tableau[X][Y] == 1) {
			YaUnePomme = true;
		}else {
			YaUnePomme = false;
		}
		return YaUnePomme;
	}
	public void suprimePomme(int X, int Y) {
		tableau[X][Y] = 0;
		setmPommeManger(getmPommeManger() + 1);
		setmPommeRestante(getmPommeRestante() - 1);
	}
	public boolean terrainVide(int X, int Y) {
			boolean terrainEstVide;
			if (X == -1 || Y == -1 || X == mGrilleX || Y == mGrilleY) {
				terrainEstVide = true;
			}else {
				terrainEstVide = false;
			}
			return terrainEstVide;
	}

	public int getmPommeRestante() {
		return mPommeRestante;
	}

	public void setmPommeRestante(int mPommeRestante) {
		this.mPommeRestante = mPommeRestante;
	}

	public static void dessiner(Graphics g) {
		//g.drawImage(images[imageCourante].getImage(),x,y,largeurImage,hauteurImage,null);
		
	}

	public int getmPommeManger() {
		return mPommeManger;
	}

	public void setmPommeManger(int mPommeManger) {
		this.mPommeManger = mPommeManger;
	}

	public int[][] getmTeteSterpent() {
		return mTeteSterpent;
	}

	public void setmTeteSterpent(int[][] mTeteSterpent) {
		this.mTeteSterpent = mTeteSterpent;
	}
}
