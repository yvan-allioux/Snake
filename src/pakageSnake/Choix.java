package pakageSnake;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
//la class
public class Choix extends JFrame {
	
	
	//ex d'atribut ou variable d'instance
	private int mPommeInt;
	private int mGrilleXInt;
	private int mGrilleYInt ;
	private String mPommeItem;
	private String mGrilleItem;
	private JComboBox<String> comboboxPomme;
	private JComboBox<String> comboboxGrille;
	//ex de variable de class
	public String pommeOptions[] = {"5", "10", "15", "20", "50", "100"};
	public String grilleOptions[] = {"10x10", "15x15", "20x20", "50x50", "50x30"}; // max 99x99 XxY
	//public static int compteur=0;
	
	//la métode, ici un constructeur
	public Choix() {
		//setLayout
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		System.out.println("creation objet choix");
		//pour fermer
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        setSize(300, 180);
        setTitle("Snake choix");
        
        //ajout d'un texte au north
        JLabel titreframe = new JLabel("Parametres");
        titreframe.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.getContentPane().add(titreframe);
        
        //q pomme
        JLabel labelPomme = new JLabel("Quantité de pomme : ");
        this.comboboxPomme = new JComboBox<String>(this.pommeOptions);
        //affichage label
        labelPomme.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.getContentPane().add(labelPomme);
        //affichage comboboxPomme
        comboboxPomme.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.getContentPane().add(comboboxPomme);
        
        //desc grille
        JLabel labelGrille = new JLabel("Taille de la grille : ");
        this.comboboxGrille = new JComboBox<String>(this.grilleOptions);
        //affichage label
        labelGrille.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.getContentPane().add(labelGrille);
        //affichage comboboxGrille
        comboboxGrille.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.getContentPane().add(comboboxGrille);
        
        //bouton
        JButton bouton = new JButton("Valider");
        //écouteur bouton
        bouton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
        	  if(e.getSource()==bouton){
        		  //recuperation des valeur
        		  String comboboxmPommeItem = comboboxPomme.getSelectedItem().toString();
        		  String comboboxmGrilleItem = comboboxGrille.getSelectedItem().toString();
        		  setmPommeInt(Integer.parseInt(comboboxmPommeItem));  
        		  setmGrilleXInt(Integer.parseInt(comboboxmGrilleItem.substring(0,2)));
        		  setmGrilleYInt(Integer.parseInt(comboboxmGrilleItem.substring(3,5)));
        		  System.out.println("parametre : " + getmGrilleXInt() + " par "+ getmGrilleYInt() +" pomme " + getmPommeInt());
        		  //ZoneDeJeu zone1 = new ZoneDeJeu(/*getmPommeInt(),*/ getmGrilleXInt(), getmGrilleYInt());
        		  Terrain terrain1 = new Terrain(getmPommeInt(), getmGrilleXInt(), getmGrilleYInt());
              }
          }
        });
        //affichage bouton parametre
        bouton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.getContentPane().add(bouton);
        
        setVisible(true);
	}

	public int getmPommeInt() {
		return mPommeInt;
	}

	public void setmPommeInt(int mPommeInt) {
		this.mPommeInt = mPommeInt;
	}

	public int getmGrilleXInt() {
		return mGrilleXInt;
	}

	public void setmGrilleXInt(int mGrilleXInt) {
		this.mGrilleXInt = mGrilleXInt;
	}

	public int getmGrilleYInt() {
		return mGrilleYInt;
	}

	public void setmGrilleYInt(int mGrilleYInt) {
		this.mGrilleYInt = mGrilleYInt;
	}

}
