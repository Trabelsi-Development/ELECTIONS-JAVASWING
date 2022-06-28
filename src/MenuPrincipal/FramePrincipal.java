package MenuPrincipal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import GestionBureauVote.Frame3;
import GestionElecteurs.Frame1;
import GestionPartis.Frame2;
import GestionResutltats.Frame4;
import Statistiques.Frame5;


public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	
	private JLabel titre;
	private JLabel gelecteurs;
	private JLabel gpartis;
	private JLabel gburvote;
	private JLabel gres;
	private JLabel stat;
	private JLabel choix;
	private JLabel imageLbl;
	private JTextField schoix;
	private JButton valider;
	private ImageIcon image;
	
	public static FramePrincipal frame = new FramePrincipal();
	
	
	public void close()
	{WindowEvent winClosingEvent= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);		
	}
	
	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		setBounds(100, 200, 759, 636);
		setSize(750,680);//dimensions de l'interface
		 setResizable(false);//Empêcher le redimensionnement de la fenêtre
		 setTitle("ELECTIONS 2024");//titre de la fenêtre
		 setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //on exige que le programme se ferme seulement lorsqu'on ferme la fenêtre interface
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		titre = new JLabel("ELECTIONS 2024");
		titre.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		titre.setForeground(Color.RED);//changement de couleur
		titre.setBounds(190,50,350,40);//changement de dimension
		contentPane.add(titre);

		gelecteurs = new JLabel("1- La gestion des électeurs");
		gelecteurs.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		gelecteurs.setBounds(260,130,350,20);
		contentPane.add(gelecteurs);
		
		gpartis = new JLabel("2- La gestion des partis");
		gpartis.setBounds(260,180,350,20);
		gpartis.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		contentPane.add(gpartis);
		
		gburvote = new JLabel("3- La gestion des bureaux de votes");
		gburvote.setBounds(260,230,350,20);
		gburvote.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		contentPane.add(gburvote);
		
		gres = new JLabel("4- La gestion des résultats");
		gres.setBounds(260,280,350,20);
		gres.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		contentPane.add(gres);
		
		stat = new JLabel("5- Statistiques ");
		stat.setBounds(260,330,350,20);
		stat.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		contentPane.add(stat);
		
		choix = new JLabel("Veuillez saisir votre choix: ");
		choix.setBounds(260,380,350,20);
		choix.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		contentPane.add(choix);
				
		schoix = new JTextField();
		schoix.setColumns(10);
		schoix.setBounds(260, 420, 283, 36);//Position et Dimension du champ de texte du choix saisi
		contentPane.add(schoix);
				
		valider = new JButton("Valider");
		valider.setForeground(Color.WHITE);
		valider.setBackground(new Color(225, 13, 25));
		valider.setBounds(260, 490, 283, 36);
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
						{case 1: Frame1 menu1=new Frame1();
						close();//fermeture du frame du menu principal
						menu1.setVisible(true);// la fenêtre menu1 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 												
						break;
						
						case 2: Frame2 menu2=new Frame2();
						close();//fermeture du frame du menu principal
						menu2.setVisible(true);// la fenêtre menu2 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 												
						break;
						
						case 3: Frame3 menu3=new Frame3();
						close();//fermeture du frame du menu principal
						menu3.setVisible(true);// la fenêtre menu3 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 												
							break;
							
						case 4: Frame4 menu4=new Frame4();
						close();//fermeture du frame du menu principal
						menu4.setVisible(true);// la fenêtre menu4 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 
							break;
							
						case 5: Frame5 menu5=new Frame5();
						close();//fermeture du frame du menu principal
						menu5.setVisible(true);// la fenêtre menu4 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode5 
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
		imageLbl.setBounds(20,120,220,200);
		imageLbl.setIcon(image);
		getContentPane().add(imageLbl);		
		
			
		}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
