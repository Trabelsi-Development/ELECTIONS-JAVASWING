package GestionElecteurs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;

import MenuPrincipal.FramePrincipal;

public class Frame1 extends JFrame {

	private JPanel contentPane;
	
	private JLabel titre;
	private JLabel inscri;
	private JLabel affich1;
	private JLabel affich2;
	private JLabel acc;
	private JLabel choix;
	private JLabel imageLbl;
	private JTextField schoix;
	private JButton valider;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;

	public static Frame1  frame_1 = new Frame1();
	
	public  ArrayList<Electeur> E =new ArrayList<Electeur>();
	
	public ArrayList<Electeur> getElecteur() {
		return E;}

	
	public void close()
	{WindowEvent winClosingEvent= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);		
	}
	
	/**
	 * Create the frame.
	 */
	public Frame1() {
	
		E =new ArrayList <Electeur>();
		Calendar cal = Calendar.getInstance();
		String ch=(cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
		
		//initialisation de la liste des Électeurs
		Electeur e1=new Electeur("Trabelsi","Abir","000000000",19,2,"Voté",ch,"Courant Démocrate");
		E.add(e1);
		Electeur e2=new Electeur("Selmi","Ameni","0000000",20,4,"Non Voté","","");
		E.add(e2);
		Electeur e3=new Electeur("Jaziri","Skander","17832475",25,2,"Voté",ch,"Front Populaire");
		E.add(e3);
		Electeur e4=new Electeur("Benzina","Nabiha","09697743",19,2,"Voté",ch,"Ennahdha");
		E.add(e4);
		Electeur e5=new Electeur("Wrimi","Foued","30842506",35,7,"Non Voté","","");
		E.add(e5);
		Electeur e6=new Electeur("Trabelsi","Elyess","45732420",45,5,"Voté",ch,"Ennahdha");
		E.add(e6);
		
		
		
		setBounds(100, 100, 779, 476);
		setSize(800,580);//dimensions de l'interface
		 setResizable(false);//Empêcher le redimensionnement de la fenêtre
		 setTitle("GESTION ÉLECTEURS");//titre de la fenêtre
		 setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //on exige que le programme se ferme seulement lorsqu'on ferme la fenêtre interface
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		titre = new JLabel("La Gestion des Électeurs");
		titre.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		titre.setForeground(Color.RED);//changement de couleur
		titre.setBounds(165,50,500,40);//changement de dimension
		contentPane.add(titre);

		inscri = new JLabel("1- Iinscription d'un nouveau électeur");
		inscri.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		inscri.setBounds(260,150,390,20);
		contentPane.add(inscri);
		
		affich1 = new JLabel("2- Affichage de la liste des électeurs par Bureau de vote donné");
		affich1.setBounds(260,190,450,20);
		affich1.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		contentPane.add(affich1);
		
		affich2 = new JLabel("3- Affichage du numéro de Bureau de vote d'un électeur de CIN donné");
		affich2.setBounds(260,230,520,20);
		affich2.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		contentPane.add(affich2);
		
		acc = new JLabel("4- Accomplissement de vote");
		acc.setBounds(260,270,390,20);
		acc.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		contentPane.add(acc);
			
		choix = new JLabel("Veuillez saisir votre choix: ");
		choix.setBounds(260,350,390,20);
		choix.setFont(new Font("",Font.BOLD+Font.ITALIC,14));
		contentPane.add(choix);
				
		schoix = new JTextField();
		schoix.setColumns(10);
		schoix.setBounds(260, 390, 283, 36);//Position et Dimension du champ de texte du choix saisi
		contentPane.add(schoix);
				
		valider = new JButton("Valider");
		valider.setBounds(260, 450, 283, 36);//Position et Dimension du bouton valider
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
						JOptionPane.showMessageDialog(null,"Votre choix doit être entre 1 et 4 !");
					else
					{switch (xi)
						{case 1: AjoutElecteur menu1_1=new AjoutElecteur();
						close();//fermeture du frame1(sous menu1)
						menu1_1.setVisible(true);// la fenêtre menu1_1 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 												
						break;
						
						case 2: AffichBurVote menu1_2=new AffichBurVote();
						close();
						menu1_2.setVisible(true);
						break;
						
						case 3:AffichCIN menu1_3=new AffichCIN();
						close();
						menu1_3.setVisible(true);
							break;
							
						case 4:AccomplissementVote menu1_4=new AccomplissementVote();
						close();
						menu1_4.setVisible(true);
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
						frame_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
