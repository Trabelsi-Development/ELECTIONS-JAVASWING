package GestionBureauVote;


import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.*;

import GestionResutltats.Frame4;

import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;


public class AffichBureaux extends JFrame {

	private JPanel contentPane;
	private JLabel titre;
	private JLabel label;
	private JButton btnAffich;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;

	private int i=0 ;// compteur pour parcourir la liste des bureaux
	private JTextArea bureau;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichBureaux frame = new AffichBureaux();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		

	/**
	 * Create the frame.
	 */

    public void incrementer() {
        i++;
    }
	public AffichBureaux() {
		setBounds(100, 100, 759, 476);
		setSize(800,600);//dimensions de l'interface
		setResizable(false);//Emp�cher le redimensionnement de la fen�tre
		setTitle("AFFICHAGE DE LA LISTE DES BUREAUX");//titre de la fen�tre
		setLocationRelativeTo(null);//l'interface est centr�e � l'�cran 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //on exige que le programme se ferme seulement lorsqu'on ferme la fen�tre interface
		 
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		titre = new JLabel("L'affichage de la liste des bureaux");
		titre.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		titre.setForeground(Color.RED);//changement de couleur
		titre.setBounds(80,50,650,50);//changement de dimension
		contentPane.add(titre);
		
		btnAffich = new JButton("SUIVANT");
		btnAffich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				bureau.setText("");//pour supprimer ce qui est �crit
				if(i<Frame3.frame_3.B.size()) {//on affiche chaque parti jusqu'� i atteint la fin de la liste des bureaux 
				bureau.append("Numéro : "+Frame3.frame_3.B.get(i).getNumero()+"\n");
				bureau.append("Adresse : "+Frame3.frame_3.B.get(i).getAdresse() +"\n");
				bureau.append("Région : "+Frame3.frame_3.B.get(i).getRegion()+"\n");
				bureau.append("\n");//retour � la ligne
				incrementer();//pour incr�menter i au parti suivant
				}else {//sinon informer l'utilisateur qu'il a parcouru toute la liste des bureaux
					JOptionPane.showMessageDialog(null,"Vous avez parcouru toute la liste des bureaux!");
					i=0;
				}
			}
		});
				
		btnAffich.setForeground(Color.WHITE);
		btnAffich.setBackground(new Color(225, 13, 25));
		btnAffich.setBounds(370, 400, 283, 36);
		contentPane.add(btnAffich);
				
		label = new JLabel("");
		label.setBounds(50, 80, 293, 293);
		contentPane.add(label);

		image = new ImageIcon("/image/isie.png");
		label.setIcon(image);
		
		bureau = new JTextArea();
		bureau.setText("LISTE DES BUREAUX");
		bureau.setFont(new Font("Monospaced", Font.BOLD, 16));
		bureau.setEditable(false);
		bureau.setBounds(390, 180, 283, 200);
		contentPane.add(bureau);


		imager = new ImageIcon("/image/home.png");
		retourlbl = new JButton("");
		retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					Frame3.frame_3.setVisible(true);
					
				}
		
		});
		retourlbl.setBounds(27, 405, 100, 100);
		contentPane.add(retourlbl);
		retourlbl.setIcon(imager);
		
	}
	


}