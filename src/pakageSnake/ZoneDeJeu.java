package pakageSnake;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

//ma class
public class ZoneDeJeu extends JPanel {
	
	private int mGrilleX;
	private int mGrilleY;
	private int mTableau[][];
	private int mScore;
	private int X;
	private int Y;
	private int mSerpentX;
	private int mSerpentY;
	
	//ma métode constructeur
	public ZoneDeJeu (int tebleauParam[][], int mGrilleXParam,int mGrilleYParam) {
		mGrilleX = mGrilleXParam;
		mGrilleY = mGrilleYParam;
		mTableau = tebleauParam;
		mScore = 0;
		int nbPixelX = mGrilleX*20+20;
		int nbPixelY = mGrilleY*20+20;
		System.out.println("creation objet zone de jeux, dimension en x 0-" + mGrilleX + " en y 0-"+ mGrilleY);
		
		//ZoneDeJeu m = new ZoneDeJeu(tebleauParam, mGrilleYParam, mGrilleYParam);  
        JFrame f = new JFrame(); 
        f.getContentPane().add(this);
        //f.add(this);  
        System.out.println("fenaitre de dimension " + nbPixelX + " par "+ nbPixelY);
        f.setSize(nbPixelX+18,nbPixelY+41);  
        //f.setLayout(null);  
        f.setVisible(true);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //affichage des pomme
        //setmSerpentX(2);
        System.out.println("getmSerpentX :" + getmSerpentX() );
        
        repaint();
	}
	
	
	public void paint(Graphics g) {
		setBackground(Color.WHITE);
		
		//pomme affichage
		for (int i = 0;i < mTableau.length; i++) {
	         for (int j = 0;j < mTableau[i].length;j++) {
	            if(mTableau[i][j]==1) {
	            	g.setColor(Color.red);
	        		g.fillRect(j*20, i*20,20, 20);
	        		System.out.print("x:"+i*20);
	        		System.out.print(" y:"+j*20+" - ");
	            }
	         }
	      }
		
        //g.setColor(Color.white);
        //g.fillRect(0, 0, getSize().width, getSize().height);
        //Terrain.dessiner(g);
		
        //g.drawString("score : ", 0, 0+10);  
		g.setColor(Color.black);
		//gauche
		g.fillRect(0, 0,2, mGrilleY*20+20);
        //droite
        g.fillRect(mGrilleX*20+20, 0,2, mGrilleY*20+20);
        //haut
        g.fillRect(0, 0,mGrilleX*20+20, 2);
        //bas
        g.fillRect(0, mGrilleY*20+20,mGrilleX*20+20, 2);
        
        
        //serpent
        g.setColor(Color.green);
        g.fillRect(mSerpentX, mSerpentY,20, 20);
        
        
        
        //g.drawOval(30,130,50, 60);
        //g.fillOval(130,130,50, 60);  
        //g.drawArc(30, 200, 40,50,90,60);  
        //g.fillArc(30, 130, 40,50,180,40);
        
    }
	public void repaintFrame() {
		mSerpentX = 100;
		System.out.println("getmSerpentX :" + getmSerpentX() );
		repaint();
	}


	public int getmSerpentX() {
		return mSerpentX;
	}


	public void setmSerpentX(int mSerpentX) {
		this.mSerpentX = mSerpentX*20;
	}


	public int getmSerpentY() {
		return mSerpentY;
	}


	public void setmSerpentY(int mSerpentY) {
		this.mSerpentY = mSerpentY*20;
	}
}
