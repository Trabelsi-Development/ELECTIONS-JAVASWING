package GestionElecteurs;
import GestionBureauVote.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;

import GestionPartis.*;
import MenuPrincipal.Verif;


public class AjoutElecteur extends JFrame {

	private JPanel contentPane;
	private JLabel title;
	private JLabel nom;
	private JLabel prenom;
	private JLabel cin;
	private JLabel age;
	private JLabel burvote;
	private JLabel choix;
	private JLabel situation;
	private JLabel imageLbl;
	private JTextField zone1;
	private JTextField zone2;
	private JTextField zone3;
	private JTextField zone4;
	private JTextField zone5;
	private JTextField zone6;
	private JRadioButton vote = new JRadioButton("Voté");	
	private JRadioButton nonVote = new JRadioButton("Non Voté");
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;
	private ArrayList<Electeur> P;
	
	
	
	
	public void close() //appeler cette methode pour fermer le frame en cas de besoin
	{WindowEvent winClosingEvent= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);		
	}

	/**
	 * Create the frame.
	 */
	public AjoutElecteur() {
		setBounds(100, 100, 759, 476);
		setSize(800,700);//dimensions de l'interface
		 setResizable(false);//Empêcher le redimensionnement de la fenêtre
		 setTitle("INSCRIPTION D'UN NOUVEL ÉLECTEUR");//titre de la fenêtre
		 setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		title = new JLabel("L'Ajout d'un Nouvel Électeur");
		title.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		title.setForeground(Color.RED);//changement de couleur
		title.setBounds(120,30,600,50);//changement de dimension
		contentPane.add(title);
		JButton button = new JButton("S'INSCRIRE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x1=zone1.getText();
				String x2=zone2.getText();
				String x3=zone3.getText();
				String x4=zone4.getText();
				String x5=zone5.getText();
				String x6=zone6.getText();
				
				if(Verif.alpha(x1)==false ) {//vérifie le nom saisi
					JOptionPane.showMessageDialog(null,"Le nom de l'Électeur ne peut contenir que des lettres !");
					
				}else if(Verif.alpha(x2)==false) {//vérifie le prénom saisi
					
					JOptionPane.showMessageDialog(null,"Le prénom de l'Électeur ne peut contenir que des lettres !");
					
				}else if(Verif.verifcin(x3)==false) {//vérifie la cin saisie
					JOptionPane.showMessageDialog(null,"Le numéro de la CIN ne peut contenir que des chiffres !");
					
				}else if (Integer.parseInt(x4)<18 || Verif.digit(x4)) {//vérifie l'age saisi
					JOptionPane.showMessageDialog(null,"Vous devez être Majeur !\nL'âge doit être supérieur à 18 ans !");
					
				}else if(Verif.digit(x5)==false || existebureau(Integer.parseInt(x5))==false) {//vérifie le n° du bureau saisi
					JOptionPane.showMessageDialog(null,"Le numéro du bureau de vote doit être numérique !\nVérifier aussi s'il existe dans la liste des Bureaux de vote !");
				
				}else if(existeparti(x6)==false) {//vérifie le choix
						JOptionPane.showMessageDialog(null,"Le choix de l'Électeur doit contenir que des lettres !\nVérifier aussi s'il existe dans la liste des Partis !");
				
				}else if(vote.isSelected()==false && nonVote.isSelected()==false) {//vérifie la situation
					JOptionPane.showMessageDialog(null,"Veuillez sélectionner une situation !");
				}
				else {boolean trouve=false;	int i=0;	
				while(i<Frame1.frame_1.E.size() && !trouve)
				{if (x3.equals((Frame1.frame_1.E.get(i)).getCin())) //s'il a trouvé la CIN donnée  								
					trouve=true;
				else i++;}
				
				if(trouve) //l'électeur existe déjà
			JOptionPane.showMessageDialog(null,"Cet Électeur existe déjà !");
				else {	//il n'a pas trouvé la CIN donnée (il s'agit réellement d'in nouvel électeur)				
					Calendar cal = Calendar.getInstance();
				String ch=(cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
				String situation ;//va contenir la situation séléctionée
				if(vote.isSelected()) {
					situation=vote.getText() ;
				}else {
					situation=nonVote.getText() ;
				}
					Electeur electeur=new Electeur(x1,x2,x3,Integer.parseInt(x4),Integer.parseInt(x5),x6,situation,ch) ;
					Frame1.frame_1.E.add(electeur);
					JOptionPane.showMessageDialog(null,"L'Ajout s'est effectué avec succèes !");
				}
				
			}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(225, 13, 25));
		button.setBounds(395, 585, 283, 36);
		contentPane.add(button);
		
		nom = new JLabel("NOM:");
		nom.setBounds(395, 95, 114, 14);
		contentPane.add(nom);
		
		zone1= new JTextField();
	   	zone1.setBounds(395, 115, 283, 30);
		contentPane.add(zone1);
		zone1.setColumns(10);
			
		prenom = new JLabel("PRÉNOM:");
		prenom.setBounds(395, 165, 100, 14);
		contentPane.add(prenom);
		
		zone2= new JTextField();
	   	zone2.setBounds(395, 185, 283, 30);
		contentPane.add(zone2);
		zone2.setColumns(10);
				
		cin = new JLabel("CIN:");
		cin.setBounds(395, 235, 100, 14);
		contentPane.add(cin);
		
		zone3= new JTextField();
	   	zone3.setBounds(395, 255, 283, 30);
		contentPane.add(zone3);
		zone3.setColumns(10);
			
		age = new JLabel("AGE:");
		age.setBounds(395, 305, 100, 14);
		contentPane.add(age);
		
		zone4= new JTextField();
	   	zone4.setBounds(395, 325, 50, 30);
		contentPane.add(zone4);
		zone4.setColumns(10);
		
		
		burvote = new JLabel("NUMÉRO DU BUREAU DE VOTE:");
		burvote.setBounds(395, 375, 200, 14);
		contentPane.add(burvote);
		
		zone5= new JTextField();
	   	zone5.setBounds(395, 395, 50, 30);
		contentPane.add(zone5);
		zone5.setColumns(10);
		
		choix = new JLabel("CHOIX: (Symbole du parti choisi)");
		choix.setBounds(395, 445, 250, 14);
		contentPane.add(choix);
		
		zone6= new JTextField();
	   	zone6.setBounds(395, 465, 283, 30);
		contentPane.add(zone6);
		zone6.setColumns(10);
		
		situation = new JLabel("SITUATION:");
		situation.setBounds(395, 515, 100, 14);
		contentPane.add(situation);
		
		vote.setBounds(395, 536, 109, 23);
		contentPane.add(vote);
		nonVote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nonVote.isSelected()) {
					vote.setSelected(false);
				}
			}
		});
		
		nonVote.setBounds(536, 540, 109, 23);
		contentPane.add(nonVote);
		
		imageLbl = new JLabel("");
		imageLbl.setBounds(27, 99, 350, 350);
		contentPane.add(imageLbl);

		image = new ImageIcon("image/isie.png");		
		imageLbl.setIcon(image);
		
		retourlbl = new JButton("");
		 retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					Frame1.frame_1.setVisible(true);
					
				}

         });
		retourlbl.setBounds(10, 465, 100, 100);
		contentPane.add(retourlbl);

		imager = new ImageIcon("image/bouton_retour.png");		
		retourlbl.setIcon(imager);
		
		
	}
	
	
	

	  
	  public boolean existebureau(int n)
	  {boolean test=false;
		Frame3 GB=new Frame3() ;//instancier l'objet qui contient la liste de tous les Bureaux de vote  
		ArrayList<Bureau> B=new ArrayList<Bureau>() ;//créer une nouvelle liste dynamique 
		B=GB.getBureau() ;//B contient la liste de tous les Bureaux de vote
		int i=0;
		while(i<B.size() && !test)
		 {if (B.get(i).getNumero()==n)
			 test=true;
		 else i++;
		 }
		 return test;
			 
		 }
	  
	  public boolean existeparti(String ch)
	  {boolean test=false;
		Frame2 GP=new Frame2() ;//instancier l'objet qui contient la liste de tous les Partis  
		ArrayList<Partis> P2=new ArrayList<Partis>() ;//créer une nouvelle liste dynamique 
		P2=GP.getParti() ;//P2 contient la liste de tous les Partis
		int i=0;
		while(i<P2.size() && !test)
		 {if (ch.equals(P2.get(i).getNom()))		 
			 test=true;
		 else i++;
		 }
		 return test;
			 
		 }

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AjoutElecteur frame = new AjoutElecteur();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
}
		
