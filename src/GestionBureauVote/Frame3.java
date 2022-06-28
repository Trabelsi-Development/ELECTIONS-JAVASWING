package GestionBureauVote;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import MenuPrincipal.FramePrincipal;

public class Frame3 extends JFrame {

	private JPanel contentPane;
	private JLabel titre;
	private JLabel ajout;
	private JLabel modif;
	private JLabel affich1;
	private JLabel affich2;
	private JLabel affich3;
	private JLabel choix;
	private JLabel imageLbl;
	private JTextField schoix;
	private JButton valider;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;

	public static Frame3 frame_3 = new Frame3();

	public ArrayList<Bureau> B =new ArrayList<Bureau>();
	
	public ArrayList<Bureau> getBureau()
		{return B ;}
	

	public void close()
	{WindowEvent winClosingEvent= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);		
	}
	/**
	 * Create the frame.
	 */
	public Frame3() {
		
		//initialisation de la liste des Bureaux de Vote
				Bureau Bur1= new Bureau(5,"Hammam Chatt","Ben Arous") ;
				B.add(Bur1);
				Bureau Bur2= new Bureau(1,"Oued Ellil","Manouba") ;
				B.add(Bur2);
				Bureau Bur3= new Bureau(2,"Lac 2","Tunis") ;	
				B.add(Bur3);
				Bureau Bur4= new Bureau(3,"Ezzahra","Ben Arous") ;	
				B.add(Bur4);
				Bureau Bur5= new Bureau(7,"Mnihla","Ariana") ;
				B.add(Bur5);
				Bureau Bur6= new Bureau(4,"Sidi Bou Said","Tunis") ;	
				B.add(Bur6);
				
				
			setSize(750,600);//dimensions de l'interface
			 setResizable(false);//Empêcher le redimensionnement de la fenêtre
			 setTitle("Gestion Bureaux de Vote");//titre de la fenêtre
			 setLocationRelativeTo(null);//l'interface est centrée à l'écran 
			 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //on exige que le programme se ferme seulement lorsqu'on ferme la fenêtre interface
			
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setBackground(Color.white);
			contentPane.setLayout(null);//pas de positionnement(absolute layout)
			
			titre = new JLabel("La Gestion des Bureaux de Vote");
			titre.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
			titre.setForeground(Color.RED);//changement de couleur
			titre.setBounds(70,50,650,40);//changement de dimension
			contentPane.add(titre);

			ajout = new JLabel("1- Ajout d'un nouveau Bureau de Vote");
			ajout.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
			ajout.setBounds(260,140,350,20);
			contentPane.add(ajout);
			
			modif = new JLabel("2- Modification des informations d'un Bureau de Vote");
			modif.setBounds(260,190,450,20);
			modif.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
			contentPane.add(modif);
			
			affich1 = new JLabel("3- Affichage de la liste des Bureaux de Vote");
			affich1.setBounds(260,240,450,20);
			affich1.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
			contentPane.add(affich1);
			
			affich2 = new JLabel("4- Affichage du nombre total d’inscrits par Bureau de Vote");
			affich2.setBounds(260,290,450,20);
			affich2.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
			contentPane.add(affich2);
			

			affich3 = new JLabel("5- Affichage du nombre d’inscrits qui ont voté");
			affich3.setBounds(260,340,350,20);
			affich3.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
			contentPane.add(affich3);
			 
				
			choix = new JLabel("Veuillez saisir votre choix: ");
			choix.setBounds(260,410,350,20);
			choix.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
			contentPane.add(choix);
					
			schoix = new JTextField();
			schoix.setColumns(10);
			schoix.setBounds(260, 440, 283, 36);//Position et Dimension du champ de texte du choix saisi
			contentPane.add(schoix);
					
			valider = new JButton("Valider");
			valider.setBounds(260, 500, 283, 36);//Position et Dimension du bouton valider
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
						if (xi<1 || xi>5)
							JOptionPane.showMessageDialog(null,"Votre choix doit être entre 1 et 5!");
						else
						{switch (xi)
							{case 1: AjoutBur menu3_1=new AjoutBur();
							close();//fermeture du frame3(sous menu3)
							menu3_1.setVisible(true);// la fenêtre menu3_1 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 												
							break;
							
							case 2: ModifBur menu3_2=new ModifBur();
							close();//fermeture du frame3(sous menu3)
							menu3_2.setVisible(true);// la fenêtre menu3_2 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 	
							break;
							
							case 3:AffichBureaux menu3_3=new AffichBureaux();
							close();//fermeture du frame3(sous menu3)
							menu3_3.setVisible(true);// la fenêtre menu3_3 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 	
								break;
								
							case 4:AffichInscritsBur menu3_4=new AffichInscritsBur();
							close();//fermeture du frame3(sous menu3)
							menu3_4.setVisible(true);// la fenêtre menu3_4 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 	
								break;
													
							
							case 5:AffichInscritsVoteparBur menu3_5=new AffichInscritsVoteparBur();
							close();//fermeture du frame3(sous menu3)
							menu3_5.setVisible(true);// la fenêtre menu3_5 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 	
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
			imageLbl.setBounds(573, 9, 46, 14);
			contentPane.add(imageLbl);
			
			image = new ImageIcon("image/isie.png");
			imageLbl.setBounds(20,120,220,200);
			imageLbl.setIcon(image);
			getContentPane().add(imageLbl);		
			

			imager = new ImageIcon("image/home.jpg");		
			retourlbl = new JButton("");
			retourlbl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						FramePrincipal.frame.setVisible(true);
						
					}
			
			});
			retourlbl.setBounds(27, 405, 100, 100);
			contentPane.add(retourlbl);
			retourlbl.setIcon(new ImageIcon("image/home.png"));
			
			

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
					frame_3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
