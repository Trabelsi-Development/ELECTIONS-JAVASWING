package GestionResutltats;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;

import MenuPrincipal.FramePrincipal;


public class Frame4 extends JFrame {

	private JPanel contentPane;
	
	private JLabel choix;
	private JLabel titre;
	private JLabel affich1;
	private JLabel affich2;
	private JLabel imageLbl;
	private JTextField schoix;
	private JButton valider;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;

	public static Frame4 frame_4 = new Frame4();
	
	
	public void close()
	{WindowEvent winClosingEvent= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);		
	}
	
	/**
	 * Create the frame.
	 */
	
	public Frame4() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 setResizable(false);//Empêcher le redimensionnement de la fenêtres
		setBounds(100, 100, 779, 476);
		setSize(800,580);//dimensions de l'interface
		setTitle("GESTION RÉSULTATS");//titre de la fenêtre
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		 
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		titre = new JLabel("La Gestion des Résultats");
		titre.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		titre.setForeground(Color.RED);//changement de couleur
		titre.setBounds(165,70,500,40);//changement de dimension
		contentPane.add(titre);
		
		affich1 = new JLabel("1- Affichage du nombre de votes par Parti");
		affich1.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		affich1.setBounds(260,180,390,20);
		contentPane.add(affich1);
		
		affich2 = new JLabel("2- Affichage du pourcentage de votes pour chaque Parti");
		affich2.setBounds(260,230,450,20);
		affich2.setFont(new Font("",Font.BOLD+Font.PLAIN,14));
		contentPane.add(affich2);
		
		choix = new JLabel("Veuillez saisir votre choix: ");
		choix.setBounds(260,290,390,20);
		choix.setFont(new Font("",Font.BOLD+Font.ITALIC,14));
		contentPane.add(choix);
		
		schoix = new JTextField();
		schoix.setColumns(10);
		schoix.setBounds(260, 320, 283, 36);//Position et Dimension du champ de texte du choix saisi
		contentPane.add(schoix);
				
		valider = new JButton("Valider");
		valider.setBounds(260, 400, 283, 36);//Position et Dimension du bouton valider
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
						JOptionPane.showMessageDialog(null,"Vous devez choisir soit 1 soit 2!");
					else
					{switch (xi)
						{case 1: 
							NbrVoteparParti menu4_1=new NbrVoteparParti();
							close();//fermeture du frame4(sous menu4)
							menu4_1.setVisible(true);// la fenêtre menu4_1 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 												
							break;
						
						case 2: 
							PourcentageVoteparParti menu4_2=new PourcentageVoteparParti();
							close();//fermeture du frame4(sous menu4)
							menu4_2.setVisible(true);// la fenêtre menu4_2 est par défaut invisible alors il faut la rendre visible à l'aide de cette méthode 
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
		imageLbl.setBounds(20,150,220,200);
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
		
		
	}//end public frame4
	
	

	/**
	 * Launch the application.
	 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				frame_4.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
}//end class
	



