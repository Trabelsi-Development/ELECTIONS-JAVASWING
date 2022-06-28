package GestionPartis;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;

import MenuPrincipal.FramePrincipal;

public class Frame2 extends JFrame {

	private JPanel contentPane;

	private JLabel titre;
	private JLabel inscri;
	private JLabel modif;
	private JLabel affich1;
	private JLabel affich2;
	private JLabel choix;
	private JLabel imageLbl;
	private JTextField schoix;
	private JButton valider;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;
	
	public static Frame2 frame_2 = new Frame2();
	 
	
public ArrayList<Partis> P =new ArrayList<Partis>();
	
	public ArrayList<Partis> getParti() {
		return P ;
	}
	
	
	public void close()
	{WindowEvent winClosingEvent= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);		
	}
	
	/**
	 * Create the frame.
	 */
	public Frame2() {
		
		
		//initialisation de la liste des Partis
		Partis part1= new Partis("Ennahdha", "Pigeon","Rached Ghannouchi",112,"01/03/2011","Islamisme");
		Partis part2= new Partis("Nidaa Tounes", "Palmier et Etoile","Med.Hafedh Caïd Essebsi",104,"06/07/2012","Bouguibisme");
		Partis part3= new Partis("Qalb Tounes", "Lion","Nabil Karoui",107,"20/06/2019","Populisme");
		Partis part4= new Partis("Tahya Tounes", "Main","Youssef Chahed",105,"04/03/2019","Libéralisme");
		Partis part5= new Partis("Courant Démocrate", "Bicyclette","Mohamed Abbou",110,"30/05/2013","Social démocratie");
		Partis part6= new Partis("Front Populaire", "Coeur","Hamma Hammami",106,"22/07/2019","Socilisme démocratique");
		P.add(part1) ;
		P.add(part2) ;
		P.add(part3) ;
		P.add(part4) ;
		P.add(part5) ;
		P.add(part6);		
		
		
		setSize(700,550);//dimensions de l'interface
		 setResizable(false);//Empêcher le redimensionnement de la fenêtre
		 setTitle("GESTION DES PARTIS");//titre de la fenêtre
		 setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //on exige que le programme se ferme seulement lorsqu'on ferme la fenêtre interface
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		titre = new JLabel("La Gestion des Partis");
		titre.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		titre.setForeground(Color.RED);//changement de couleur
		titre.setBounds(150,30,450,40);//changement de dimension
		contentPane.add(titre);

		inscri = new JLabel("1- Iinscription d'un nouveau Parti");
		inscri.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		inscri.setBounds(260,110,350,20);
		contentPane.add(inscri);
		
		modif = new JLabel("2- Modification d'un Parti donné");
		modif.setBounds(260,150,350,20);
		modif.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		contentPane.add(modif);
		
		affich1 = new JLabel("3- Affichage de la liste des Partis");
		affich1.setBounds(260,190,350,20);
		affich1.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		contentPane.add(affich1);
		
		affich2 = new JLabel("4- Affichage du nombre total de Partis par Bureau de vote");
		affich2.setBounds(260,230,450,20);
		affich2.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		contentPane.add(affich2);
			

		choix = new JLabel("Veuillez saisir votre choix: ");
		choix.setBounds(260,300,390,20);
		choix.setFont(new Font("",Font.BOLD+Font.ITALIC,14));
		contentPane.add(choix);
				
		schoix = new JTextField();
		schoix.setColumns(10);
		schoix.setBounds(260, 330, 283, 36);//Position et Dimension du champ de texte du choix saisi
		contentPane.add(schoix);
		
		valider = new JButton("Valider");
		valider.setForeground(Color.WHITE);
		valider.setBackground(new Color(225, 13, 25));
		valider.setBounds(260, 390, 283, 36);
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane d = new JOptionPane();
				String x=schoix.getText().toString();
				if(x.equals("")||x.equals(" ")||x.length()>1)
				{JOptionPane.showMessageDialog(null,"Veuillez saisir un choix parmi les choix cités!\nVeuillez réessayer!");}
				else if (x.length()==1)
				{if (!Character.isDigit(x.charAt(0)))
						JOptionPane.showMessageDialog(null,"Votre choix doit être numérique!\nVeuillez réessayer!");
				else
					{int xi=Integer.parseInt(x); 
					if (xi<1 || xi>4)
						JOptionPane.showMessageDialog(null,"Votre choix doit être entre 1 et 4!");
					else
					{switch (xi)
						{case 1: AjoutParti menu2_1=new AjoutParti();
						close();//fermeture du GestionParti du menu principal
						menu2_1.setVisible(true);// la fenêtre menu1_2 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 												
						break;
						
						case 2:
							ModifParti menu2_2=new ModifParti() ;
							close();//fermetrue du GestionParti du menu principal
							menu2_2.setVisible(true);// la fenêtre menu2_2 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 												
								
						break;
						
						case 3: AffichPartis menu2_3= new AffichPartis();
						close();
						menu2_3.setVisible(true);
							break;
							
						case 4: AffichparSymbole menu2_4=new AffichparSymbole();
						close();
						menu2_4.setVisible(true);
							break;
												
						
						}
					
					}
					
					}
					}				
			}
			});
		contentPane.add(valider);

		
		imageLbl = new JLabel();
		imageLbl.setBounds(573, 9, 46, 14);
		contentPane.add(imageLbl);
		
		image = new ImageIcon("image/isie.png");
		imageLbl.setBounds(20,116,220,200);
		imageLbl.setIcon(image);
		getContentPane().add(imageLbl);		
		

		imager = new ImageIcon("image/home.png");		
		retourlbl = new JButton("");
		retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					FramePrincipal.frame.setVisible(true);
					
				}
		
		});
		retourlbl.setBounds(27, 405, 100, 100);
		contentPane.add(retourlbl);
		retourlbl.setIcon(imager);
			
		
		
		}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}