package GestionResutltatsNombre;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import GestionElecteurs.Electeur;
import GestionElecteurs.Frame1;
import GestionResutltats.Frame4;
import GestionResutltats.NbrVoteparParti;

public class Globalement extends JFrame{

private JPanel contentPane;
	
	private JLabel label;
	private ImageIcon image;
	private JTextArea nbrvote;
	private JButton btnAffich;
	private JButton retourlbl;
	private ImageIcon imager;

	private int i=0;
	private int c;
	
	/**
	 * Create the frame.
	 */
	public Globalement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setResizable(false);//Empêcher le redimensionnement de la fenêtre
		setBounds(100, 100, 779, 476);
		setSize(800,580);//dimensions de l'interface
		setTitle("AFFICHAGE DU NOMBRE DE VOTES PAR PARTI DANS TOUS LES BUREAUX DE VOTE");//titre de la fenêtre
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		 
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		btnAffich = new JButton("AFFICHER");
		btnAffich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
						nbrvote.setText("");
						nbrvote.append("Les Résultats finaux sont les suivants:\n\n");
						for (i=0;i<Frame1.frame_1.E.size();i++)
							{int nbr=0;
								
								if (Frame1.frame_1.E.get(i).getSituation()=="Voté") //il doit tester si la situation de l'Electeur i est voté ou non voté
									{boolean test=false; String choixx=Frame1.frame_1.E.get(i).getChoix();c=0;
										while (!test && c<i)//cette boucle sert à savoir si le nom du Parti courant est trouvé avant ou pas
										{if (choixx==(Frame1.frame_1.E.get(c)).getChoix())//si oui c'est à dire que son nombre de votes est déjà calculé
											test=true;
										else c++;}
								
									if (!test)//si le nom du Parti courant n'est pas trouvé avant alors il va calculer pour la 1ere fois son nombre de votes
										{for (c=i;c<Frame1.frame_1.E.size();c++)
											{if (choixx==Frame1.frame_1.E.get(c).getChoix())
												nbr++;}
										nbrvote.append(nbr+" vote(s) pour "+choixx+"\n");}
									}
															
						}// end first for
					
			}	
										
		});
		btnAffich.setForeground(Color.WHITE);
		btnAffich.setBackground(new Color(225, 13, 25));
		btnAffich.setBounds(305, 480, 283, 36);
		contentPane.add(btnAffich);	
		
		label = new JLabel("");
		label.setBounds(27, 80, 293, 293);
		contentPane.add(label);
		
		

		image = new ImageIcon("image/isie.png");		
		label.setIcon(image);
		
		nbrvote = new JTextArea();
		nbrvote.setText("");
		nbrvote.setFont(new Font("Monospaced", Font.BOLD, 16));
		nbrvote.setEditable(false);
		nbrvote.setBounds(305, 170, 450, 360);
		contentPane.add(nbrvote);
		

		retourlbl = new JButton("");
		 retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					NbrVoteparParti.frame4_2.setVisible(true);
					
				}
		
		});
		retourlbl.setBounds(27, 416, 100, 100);
		contentPane.add(retourlbl);
		
		imager = new ImageIcon("image/bouton_retour.png");		
		retourlbl.setIcon(imager);
		
		
		
	}
	public boolean digit (String s) {//cette methode vérifie si la chaine donnée ne contient uniquement que des chiffres
	      if (s == "") //vérifie si la chaine est vide ou pas
	         return false;
	      
	      int len = s.length();
	      for (int i = 0; i < len; i++) {
	         if ((Character.isDigit(s.charAt(i)) == false))//si le caractère courant est n'est pas numérique(un chiffre) alors return false  {
	            return false;			}
	      return true;
	   }
	

		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Globalement frame = new Globalement();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
}//end class

