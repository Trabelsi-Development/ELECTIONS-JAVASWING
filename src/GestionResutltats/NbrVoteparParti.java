package GestionResutltats;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;

import GestionPartis.Frame2;
import GestionResutltatsNombre.ParBurVote;
import GestionResutltatsNombre.Globalement;
import GestionResutltatsNombre.PartiAyantAucunVote;
import GestionResutltatsNombre.PartiVainqueur;

public class NbrVoteparParti extends JFrame{
	
	private JPanel contentPane;
	
	private JLabel choix;
	private JLabel titre1;
	private JLabel titre2;
	private JLabel affich1;
	private JLabel affich2;
	private JLabel affich3;
	private JLabel affich3_suite;
	private JLabel affich4;
	private JLabel imageLbl;
	private JTextField schoix;
	private JButton valider;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;
	public static NbrVoteparParti frame4_2 = new NbrVoteparParti();
	
	public void close()
	{WindowEvent winClosingEvent= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);		
	}

	
	/**
	 * Create the frame.
	 */
	public NbrVoteparParti() {
	setBounds(100, 100, 779, 476);
	 setResizable(false);//Empêcher le redimensionnement de la fenêtre
	setSize(800,680);//dimensions de l'interface
	 setResizable(false);//Empêcher le redimensionnement de la fenêtre
	 setTitle("AFFICHAGE DU NOMBRE DE VOTES PAR PARTI");//titre de la fenêtre
	 setLocationRelativeTo(null);//l'interface est centrée à l'écran 
	 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //on exige que le programme se ferme seulement lorsqu'on ferme la fenêtre interface
	
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setBackground(Color.white);
	contentPane.setLayout(null);//pas de positionnement(absolute layout)
	
	titre1 = new JLabel("L'Affichage du nombre de votes");
	titre1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
	titre1.setForeground(Color.RED);//changement de couleur
	titre1.setBounds(95,50,650,60);//changement de dimension
	contentPane.add(titre1);
	
	titre2 = new JLabel("par Parti");
	titre2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
	titre2.setForeground(Color.RED);//changement de couleur
	titre2.setBounds(300,100,650,60);//changement de dimension
	contentPane.add(titre2);
	
	affich1 = new JLabel("1- Par Bureau de vote ");
	affich1.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
	affich1.setBounds(300,190,390,20);
	contentPane.add(affich1);
	
	affich2 = new JLabel("2- Globalement par tous les Bureaux de vote");
	affich2.setBounds(300,240,450,20);
	affich2.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
	contentPane.add(affich2);
	

	affich3 = new JLabel("3- Le Parti vainqueur des Élections");
	affich3.setBounds(300,290,450,20);
	affich3.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
	contentPane.add(affich3);
	
	affich3_suite = new JLabel("(celui qui a obtenu le maximum des votes)");
	affich3_suite.setBounds(300,320,450,20);
	affich3_suite.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
	contentPane.add(affich3_suite);
	
	affich4 = new JLabel("4- Les Partis qui n'ont obtenu aucun vote");
	affich4.setBounds(300,370,450,20);
	affich4.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
	contentPane.add(affich4);
	
	choix = new JLabel("Veuillez saisir votre choix: ");
	choix.setBounds(300,440,390,20);
	choix.setFont(new Font("",Font.BOLD+Font.ITALIC,14));
	contentPane.add(choix);
	
	schoix = new JTextField();
	schoix.setColumns(10);
	schoix.setBounds(300, 470, 283, 36);//Position et Dimension du champ de texte du choix saisi
	contentPane.add(schoix);
			
	valider = new JButton("Valider");
	valider.setBounds(300, 540, 283, 36);//Position et Dimension du bouton valider
	valider.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String x=schoix.getText();

			if(x.equals("")||x.equals(" ")||x.length()>1)
			{JOptionPane.showMessageDialog(null,"Veuillez saisir un choix parmi les choix cités!\nVeuillez réessayer!");}
			else if (x.length()==1)
			{if (!Character.isDigit(x.charAt(0)))
					JOptionPane.showMessageDialog(null,"Votre choix doit être numérique!\nVeuillez réessayer!");
			else
				{int xi=Integer.parseInt(x); 
				if (xi<1 || xi>4)
					JOptionPane.showMessageDialog(null,"Votre choix doit être entre 1 et 4 !");
				else
				{switch (xi)
					{case 1: 
						ParBurVote menu4_1_1=new ParBurVote();
						close();//fermeture du ParBurVote(sous menu4_1)
						menu4_1_1.setVisible(true);// la fenêtre menu4_1_1 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 												
						break;
					
					case 2: 
						Globalement menu4_1_2=new Globalement();
						close();//fermeture du Globalement(sous menu4_1)
						menu4_1_2.setVisible(true);// la fenêtre menu4_1_2 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 
						break;
						
					case 3: 
						PartiVainqueur menu4_1_3=new PartiVainqueur();
						close();//fermeture du PartiVainqueur(sous menu4_1)
						menu4_1_3.setVisible(true);// la fenêtre menu4_1_3 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 
						break;
						
					case 4: 
						PartiAyantAucunVote menu4_1_4=new PartiAyantAucunVote();
						close();//fermeture du PartiAyantAucunVote(sous menu4_1)
						menu4_1_4.setVisible(true);// la fenêtre menu4_1_4 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 
						break;
						
					}
}
				
				}
				}				
		}
		});
	valider.setForeground(Color.WHITE);
	valider.setBackground(new Color(225, 13, 25));		
	contentPane.add(valider);
	
	imageLbl = new JLabel();
	imageLbl.setBounds(573, 20, 46, 14);
	contentPane.add(imageLbl);
	
	image = new ImageIcon("image/isie.png");
	imageLbl.setBounds(40,200,220,200);
	imageLbl.setIcon(image);
	getContentPane().add(imageLbl);		
	
	
	
	retourlbl = new JButton("");
	 retourlbl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Frame4.frame_4.setVisible(true);
				
			}
	
	});
	retourlbl.setBounds(36, 526, 100, 100);
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
				frame4_2.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
	
}
