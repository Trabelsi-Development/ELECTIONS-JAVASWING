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
import GestionResutltats.Frame4;
import GestionResutltats.PourcentageVoteparParti;

public class ParBurVote extends JFrame{


	private JPanel contentPane;
	
	private JLabel label;
	private JLabel bur;
	private JTextField burr;
	private ImageIcon image;
	private JTextArea nbrvote;
	private JButton retourlbl;
	private ImageIcon imager;

	private JButton btnAffich;
	private int i=0;
	private int c;
	
	/**
	 * Create the frame.
	 */
	public ParBurVote() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setResizable(false);//Empêcher le redimensionnement de la fenêtre
		setBounds(100, 100, 779, 476);
		setSize(800,580);//dimensions de l'interface
		setTitle("AFFICHAGE DU POURCENTAGE DE VOTES PAR PARTI PAR BUREAU DE VOTE");//titre de la fenêtre
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		 
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		btnAffich = new JButton("AFFICHER");
		btnAffich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					String x1=burr.getText();
					
					if(digit(x1)==false || x1.equals(" ") ||x1.equals(""))//verifier le TextField 
						JOptionPane.showMessageDialog(null,"Le Bureau de Vote doit être numérique !");
					
					else//il va chercher le bureau de vote donné 
					{	boolean trouve=false;
						nbrvote.setText("");
						nbrvote.append("Dans ce Bureau de vote il se trouve:\n\n");
						boolean existe=false;//on suppose qu'il n'y a pas de votes dans ce bureau 
						int nbrtotal=0;
						for (i=0;i<Frame1.frame_1.E.size();i++)
						{if (Integer.parseInt(x1)==Frame1.frame_1.E.get(i).getBurvote())
							nbrtotal++;
							}
						
						for (i=0;i<Frame1.frame_1.E.size();i++)
							{int nbr=0;
							if (Integer.parseInt(x1)==Frame1.frame_1.E.get(i).getBurvote())
								{trouve=true;// il a trouvé le bureau de vote donné au moins une fois
								
								if (Frame1.frame_1.E.get(i).getSituation()=="Voté") //il doit tester si la situation de l'Electeur i est voté ou non voté
									{boolean test=false; String choixx=Frame1.frame_1.E.get(i).getChoix();c=0;
										while (!test && c<i)//cette boucle sert à savoir si le nom du Parti courant est trouvé avant ou pas
										{if (choixx==(Frame1.frame_1.E.get(c)).getChoix()&& Integer.parseInt(x1)==Frame1.frame_1.E.get(c).getBurvote() )//si oui c'est à dire qu'il a trouvé avant le même Parti dans le même bureau de vote alors son nombre de votes est déjà calculé
											test=true;
										else c++;}
								
									if (!test)//si le nom du Parti courant n'est pas trouvé avant alors il va calculer pour la 1ere fois son nombre de votes
										{for (c=i;c<Frame1.frame_1.E.size();c++)
											{if (choixx==Frame1.frame_1.E.get(c).getChoix() && Integer.parseInt(x1)==Frame1.frame_1.E.get(c).getBurvote())//s'il va trouver le même Parti dans le même bureau de vote 
												nbr++;}
										if (nbr!=0 && nbrtotal!=0)
										nbrvote.append((nbr*100)/nbrtotal+" % pour "+choixx+"\n");
										else nbrvote.append(0+" % pour "+choixx+"\n");
										existe=true;}//il y a des votes dans ce bureau
									}
								
							}

						}// end first for
						if (!trouve)						
							JOptionPane.showMessageDialog(null,"Ce Bureau de vote n'existe pas !");
						if (!existe && trouve)
							nbrvote.append("0 % votes");
					}}
					
										
		});
		btnAffich.setForeground(Color.WHITE);
		btnAffich.setBackground(new Color(225, 13, 25));
		btnAffich.setBounds(305, 480, 283, 36);
		contentPane.add(btnAffich);		
		
		bur = new JLabel("BUREAU DE VOTE :");
		bur.setBounds(305, 70, 283, 14);
		contentPane.add(bur);
		
		burr = new JTextField();
		burr.setColumns(10);
		burr.setBounds(305, 100, 283, 36);
		contentPane.add(burr);
		
		label = new JLabel("");
		label.setBounds(27, 50, 293, 293);
		contentPane.add(label);
		
		

		image = new ImageIcon("image/isie.png");		
		label.setIcon(image);
		

		retourlbl = new JButton("");
		 retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					PourcentageVoteparParti.frame4_1.setVisible(true);	
				}
		
		});
		retourlbl.setBounds(29, 415, 100, 100);
		contentPane.add(retourlbl);
		
		imager = new ImageIcon("image/bouton_retour.png");		
		retourlbl.setIcon(imager);

		

		
		
		
		nbrvote = new JTextArea();
		nbrvote.setText("");
		nbrvote.setFont(new Font("Monospaced", Font.BOLD, 16));
		nbrvote.setEditable(false);
		nbrvote.setBounds(305, 170, 430, 320);
		contentPane.add(nbrvote);
		
		
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
				ParBurVote frame = new ParBurVote();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
}//end class

