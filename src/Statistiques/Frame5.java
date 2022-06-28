package Statistiques;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;

import GestionBureauVote.Frame3;
import MenuPrincipal.FramePrincipal;


public class Frame5 extends JFrame {

	private JPanel contentPane;
	
	private JLabel titre;
	private JLabel tvg1;
	private JLabel tvg2;
	private JLabel choix;
	private JLabel affres;
	private JLabel imageLbl;
	private JTextField schoix;
	private JButton valider;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;

	public static Frame5 frame_5 = new Frame5();
	
	public void close()
	{WindowEvent winClosingEvent= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);		
	}

	/**
	 * Create the frame.
	 */
	public Frame5() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 779, 476);
		setSize(800,550);//dimensions de l'interface
		setTitle("STATISTIQUES");//titre de la fenêtre
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		titre = new JLabel("Les Statistiques");
		titre.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		titre.setForeground(Color.RED);//changement de couleur
		titre.setBounds(240,70,500,40);//changement de dimension
		contentPane.add(titre);

		tvg1 = new JLabel("1- Affichage du Taux de vote global");
		tvg1.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		tvg1.setBounds(260,150,390,20);
		contentPane.add(tvg1);
		
		tvg2 = new JLabel("(Pourcentage d’électeurs inscrits qui ont participé au vote)");
		tvg2.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		tvg2.setBounds(270,175,500,20);
		contentPane.add(tvg2);
		
		affres = new JLabel("2- Affiner les résultats par tranche d'âges des électeurs");
		affres.setBounds(260,240,450,20);
		affres.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		contentPane.add(affres);
		
		
		choix = new JLabel("Veuillez saisir votre choix:");
		choix.setBounds(260,300,390,20);
		choix.setFont(new Font("",Font.BOLD+Font.ITALIC,14));
		contentPane.add(choix);
				
		schoix = new JTextField();
		schoix.setColumns(10);
		schoix.setBounds(260, 330, 283, 36);//Position et Dimension du champ de texte du choix saisi
		contentPane.add(schoix);
				
		valider = new JButton("Valider");
		valider.setBounds(260, 390, 283, 36);//Position et Dimension du bouton valider
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
					if (xi<1 || xi>2)
						JOptionPane.showMessageDialog(null,"Votre choix doit être soit 1 soit 2 !");
					else
					{switch (xi)
						{case 1: TauxVoteGlobal menu5_1=new TauxVoteGlobal();
						close();//fermeture du frame1(sous menu1)
						menu5_1.setVisible(true);// la fenêtre menu5_1 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 												
						break;
						
						case 2: ResTrancheAge menu5_2=new ResTrancheAge();
						close();
						menu5_2.setVisible(true);
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
					frame_5.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
