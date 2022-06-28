package GestionBureauVote;

import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.*;

import GestionResutltats.Frame4;

import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

public class AffichInscritsBur extends JFrame {

	private JPanel contentPane;
	private JLabel titre1;
	private JLabel titre2;
	private JLabel label;
	private JButton btnAffich;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;

	private int i=0 ;// compteur pour parcourir la liste des Bureaux
	private JTextArea nbrInscrit;
	
	/**
	 * Lancement de l'application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichInscritsBur frame = new AffichInscritsBur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
		
	

	/**
	 * Creation du frame.
	 */

    public void incrementer() {
        i++;//incrementer i
    }
	public AffichInscritsBur() {
		setBounds(100, 100, 759, 476);
		setSize(800,600);//dimensions de l'interface
		setResizable(false);//Empêcher le redimensionnement de la fenêtre
		setTitle("AFFICHAGE DU NOMBRE TOTAL D'INSCRITS PAR BUREAU");//titre de la fenêtre
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //on exige que le programme se ferme seulement lorsqu'on ferme la fenêtre interface
		 
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		titre1 = new JLabel("L'affichage du nombre total");
		titre1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		titre1.setForeground(Color.RED);//changement de couleur
		titre1.setBounds(140,50,650,50);//changement de dimension
		contentPane.add(titre1);
		
		titre2 = new JLabel("d’inscrits par bureau");
		titre2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		titre2.setForeground(Color.RED);//changement de couleur
		titre2.setBounds(210,90,650,50);//changement de dimension
		contentPane.add(titre2);

		
		btnAffich = new JButton("SUIVANT");
		btnAffich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				nbrInscrit.setText("");//pour supprimer ce qui est écrit
				if(i<Frame3.frame_3.B.size()) {//on affiche chaque bureau jusqu'a i atteint la fin de la liste  
					nbrInscrit.append("Bureau N° "+(Frame3.frame_3.B.get(i)).getNumero()+" : "+Frame3.frame_3.B.get(i).getIE().size()+" électeur(s) inscrit(s)");
					incrementer();//pour incrementer i au parti suivant
				}else {//sinon informer l'utilisateur qu'il a parcouru toute la liste des électeurs inscrits
					JOptionPane.showMessageDialog(null,"Vous avez parcouru toute la liste des électeurs inscrits!");
					i=0;
				}
			}
		});
				
		btnAffich.setForeground(Color.WHITE);
		btnAffich.setBackground(new Color(225, 13, 25));
		btnAffich.setBounds(360, 380, 283, 36);
		contentPane.add(btnAffich);
		
		
		label = new JLabel("");
		label.setBounds(50, 100, 293, 293);
		contentPane.add(label);
		

		image = new ImageIcon("image/isie.png");		
		label.setIcon(image);
		
		nbrInscrit = new JTextArea();
		nbrInscrit.setText("Nombre D'inscription :");
		nbrInscrit.setFont(new Font("Monospaced", Font.BOLD, 16));
		nbrInscrit.setEditable(false);
		nbrInscrit.setBounds(360,200, 283, 340);
		contentPane.add(nbrInscrit);

		imager = new ImageIcon("image/bouton_retour.png");		
		retourlbl = new JButton("");
		retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					Frame3.frame_3.setVisible(true);
					
				}
		
		});
		retourlbl.setBounds(21, 410, 100, 100);
		contentPane.add(retourlbl);
		retourlbl.setIcon(imager);
				
	}
	

}