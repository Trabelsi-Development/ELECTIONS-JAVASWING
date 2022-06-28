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
import GestionPartis.Frame2;
import GestionPartis.Partis;
import GestionResutltats.Frame4;
import GestionResutltats.NbrVoteparParti;

public class PartiAyantAucunVote extends JFrame{

private JPanel contentPane;
	
	private JLabel label;
	private ImageIcon image;
	private JTextArea nbrvote;
	private JButton btnAffich;
	private JButton retourlbl;
	private ImageIcon imager;

	private int i=0;
	
	/**
	 * Create the frame.
	 */
	public PartiAyantAucunVote() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);//Empêcher le redimensionnement de la fenêtre
		setBounds(100, 100, 779, 476);
		setSize(800,580);//dimensions de l'interface
		setTitle("AFFICHAGE DES PARTIS AYANT AUCUN VOTE");//titre de la fenêtre
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		 
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		btnAffich = new JButton("AFFICHER");
		btnAffich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
						nbrvote.setText("");
						nbrvote.append("Les Partis ayant aucun vote sont:\n\n");
						
						for (i=0;i<Frame2.frame_2.P.size();i++)
						{int c=0; boolean trouve=false; String ch=Frame2.frame_2.P.get(i).getNom();
							while(c<Frame1.frame_1.E.size()&&!trouve)
							{if (Frame1.frame_1.E.get(c).getSituation()=="Voté" && Frame1.frame_1.E.get(c).getChoix()==ch)//s'il va trouver au moins une fois le nom du Parti courant dans un choix d'un Electeur qui a voté
								trouve=true;
							else c++;								
							}
							if (!trouve)//s'il n'a pas trouve le nom du Parti courant dans un choix d'un Electeur qui a voté on va afficher ce nom
							nbrvote.append(ch+"\n");
						}
						
						
						
					
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
					NbrVoteparParti.frame4_2.setVisible(true);
					
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
				PartiAyantAucunVote frame = new PartiAyantAucunVote();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
}//end class

