package GestionResutltatsPourcentage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import GestionElecteurs.Electeur;
import GestionElecteurs.Frame1;
import GestionResutltats.PourcentageVoteparParti;

public class PartiVainqueur extends JFrame{

private JPanel contentPane;
	
	private JLabel label;
	private ImageIcon image;
	private JTextArea nbrvote;
	private JButton btnAffich;
	private JButton retourlbl;
	private ImageIcon imager;

	private int i=0;
	private int k=0;
	private int c;
	private int T[]=new int[50]; //tableau pour les totaux de votes pour chaque parti (nombre)
	private String TN[]=new String [50]; //tableau pour les totaux de votes pour chaque parti (Nom)
	
	/**
	 * Create the frame.
	 */
	public PartiVainqueur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setResizable(false);//Empêcher le redimensionnement de la fenêtre
		setBounds(100, 100, 779, 476);
		setSize(800,580);//dimensions de l'interface
		setTitle("AFFICHAGE DU PARTI AYANT LE MAXIMUM DES VOTES (PARTI VAINQUEUR)");//titre de la fenêtre
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		 
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		btnAffich = new JButton("AFFICHER");
		btnAffich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
					int nbrtotal=0;
					
					for (i=0;i<Frame1.frame_1.E.size();i++)
					{if (Frame1.frame_1.E.get(i).getSituation()=="Voté")
						nbrtotal++;}
					
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
										T[k]=(nbr*100)/nbrtotal;
										TN[k]=choixx;
										k++;
										if (nbr!=0 && nbrtotal!=0)
										nbrvote.append((nbr*100)/nbrtotal+" % pour "+choixx+"\n");
										else nbrvote.append(0+" % pour "+choixx+"\n");
										}
									}
								
								
							
						}// end first for
						
						int max=T[0]; String maxnom=TN[0]; boolean egal=false;

				for (k=0;k<T.length;k++)
				{
					if (T[k]>max)
					{maxnom=TN[k];
					egal=false;}
					else if(T[k]==max)
						egal=true;
				}
				if (egal==true)
					nbrvote.append("\nIl n'y a pas de Parti Vainqueur\ncar ils sont tous égaux !");
				else	
				nbrvote.append("\nLe Parti Vainqueur est : "+maxnom);
					
			}	
										
		});
		btnAffich.setForeground(Color.WHITE);
		btnAffich.setBackground(new Color(225, 13, 25));
		btnAffich.setBounds(305, 480, 283, 36);
		contentPane.add(btnAffich);	
		
		label = new JLabel("");
		label.setBounds(27, 50, 293, 293);
		contentPane.add(label);
		
		

		image = new ImageIcon("image/isie.png");		
		label.setIcon(image);
		
		nbrvote = new JTextArea();
		nbrvote.setText("");
		nbrvote.setFont(new Font("Monospaced", Font.BOLD, 16));
		nbrvote.setEditable(false);
		nbrvote.setBounds(305, 120, 450, 360);
		contentPane.add(nbrvote);
		

		retourlbl = new JButton("");
		 retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					PourcentageVoteparParti.frame4_1.setVisible(true);	
				}
		
		});
		retourlbl.setBounds(27, 416, 100, 100);
		contentPane.add(retourlbl);
		
		imager = new ImageIcon("image/bouton_retour.png");		
		retourlbl.setIcon(imager);

		

		
	}
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				PartiVainqueur frame = new PartiVainqueur();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
}//end class
