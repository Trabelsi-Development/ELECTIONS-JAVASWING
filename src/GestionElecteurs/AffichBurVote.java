package GestionElecteurs;

import GestionBureauVote.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;



public class AffichBurVote extends JFrame {

	private JPanel contentPane;
	
	
	private JLabel title1;
	private JLabel title2;
	private JLabel label;
	private JLabel bur;
	private JTextField burr;
	private JButton btnAffich;
	private ImageIcon image;
	private ImageIcon imager;
	private JButton retourlbl;
	private int i=0,k=0;// compteur pour parcourir la liste des Electeurs

	private JTextArea electeur;


	/**
	 * Create the frame.
	 */
	 public void incrementer() {
	        k++;
	    }
	 
	public AffichBurVote() {
		setBackground(Color.WHITE);
		 setResizable(false);//Empêcher le redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AFFICHAGE LISTE ÉLECTEUR PAR BUREAU DE VOTE DONNÉ");//titre de la fenêtre
		setBounds(100, 100, 759, 476);
		setSize(750,600);//dimensions de l'interface
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// travail de base 
		title1 = new JLabel("La Liste des Électeurs");
		title1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,35));//changement de police
		title1.setForeground(Color.RED);//changement de couleur
		title1.setBounds(180,60,500,40);//changement de dimension
		contentPane.add(title1);

		title2 = new JLabel("par Bureau de Vote");
		title2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,35));//changement de police
		title2.setForeground(Color.RED);//changement de couleur
		title2.setBounds(200,100,500,40);//changement de dimension
		contentPane.add(title2);
		
		btnAffich = new JButton("AFFICHER");
		btnAffich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					String x1=burr.getText();
					
					if(digit(x1)==false || existebureau(Integer.parseInt(x1))==false)//vérifie le numéro du bureau  
						JOptionPane.showMessageDialog(null,"Le numéro du Bureau de Vote doit être numérique !\n Vérifier s'il existe dans la liste des Bureaux de vote");
					
					else//il va mettre tous les Electeurs du bureau de vote donné dans un autre tableau dynamique (Pn)
					{boolean trouve=false;
					ArrayList <Electeur> Pn=new ArrayList<Electeur>();
					int x=Integer.parseInt(burr.getText());
					
					for(i=0;i<Frame1.frame_1.E.size();i++) 
							{if (((Frame1.frame_1.E.get(i)).getBurvote())==x ) //s'il a trouvé le bureau de vote alors il va mettre tous les electeurs du bureau de vote donné dans un autre tableau dynamique (Pn)  
								{Pn.add(Frame1.frame_1.E.get(i));							
								trouve=true;}}//il a au moins trouvé une personne dans le bureau de vote donné
							
							
					if(!trouve) //il n'a pas trouvé le bureau de vote donné
						JOptionPane.showMessageDialog(null,"Ce bureau de vote n'existe pas !\nVérifier le numéro du Bureau de Vote !");
				
					else {if(k<Pn.size())
						{
						electeur.setText("");//pour supprimer ce qui est écrit dans l'electeur(textarea)
						electeur.append("Nom de l'Électeur : "+(Pn.get(k)).getNom()+"\n");
						electeur.append("Prénom de l'Électeur : "+(Pn.get(k)).getPrenom()+"\n");
						electeur.append("CIN de l'Électeur : "+(Pn.get(k)).getCin()+"\n");
						electeur.append("Age de l'Électeur : "+(Pn.get(k)).getAge()+"\n");
						electeur.append("Numéro du Bureau de Vote : "+(Pn.get(k)).getBurvote()+"\n");
						electeur.append("Situation de l'Électeur : "+(Pn.get(k)).getSituation()+"\n");
						if (Pn.get(k).getSituation()=="Voté")
						{electeur.append("Heure de vote de l'Électeur : "+(Pn.get(k).getHeure()+"\n"));
						electeur.append("Choix de l'Électeur : "+(Pn.get(k)).getChoix()+"\n");}
						
						incrementer();
						}else {//s'il a affiché tous les Électeurs du bureau de vote donné
							JOptionPane.showMessageDialog(null,"Vous avez parcouru toute la liste des Électeurs !");	
							k=0;
							electeur.setText("");//pour supprimer ce qui est écrit dans l'electeur(textarea)									
							
							}
						}
					}}
					
					
		});
				
		btnAffich.setForeground(Color.WHITE);
		btnAffich.setBackground(new Color(225, 13, 25));
		btnAffich.setBounds(305, 470, 283, 36);
		contentPane.add(btnAffich);
		
		bur = new JLabel("BUREAU DE VOTE :");
		bur.setBounds(305, 170, 283, 14);
		contentPane.add(bur);
		
		burr = new JTextField();
		burr.setColumns(10);
		burr.setBounds(305, 190, 283, 36);
		contentPane.add(burr);		
		
		label = new JLabel("");
		label.setBounds(27, 100, 293, 293);
		contentPane.add(label);
		
		

		image = new ImageIcon("image/isie.png");		
		label.setIcon(image);
		
		retourlbl = new JButton("");
		 retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					Frame1.frame_1.setVisible(true);
					
				}

        });
		retourlbl.setBounds(27, 432, 100, 100);
		contentPane.add(retourlbl);

		imager = new ImageIcon("image/bouton_retour.png");		
		retourlbl.setIcon(imager);

		
		
		
		
		electeur = new JTextArea();
		electeur.setText("");
		electeur.setFont(new Font("Monospaced", Font.BOLD, 16));
		electeur.setEditable(false);
		electeur.setBounds(305, 250, 420, 200);
		contentPane.add(electeur);
			
	}
	
	  public boolean digit (String s) {//cette méthode vérifie si la chaine donnée ne contient uniquement que des chiffres
      
	      int len = s.length();
	      for (int i = 0; i < len; i++) {
	         if ((Character.isDigit(s.charAt(i)) == false))//si le caractère courant est n'est pas numérique(un chiffre) alors return false  {
	            return false;			}
	      return true;
	   }
		
	  public boolean existebureau(int n)//cette méthode vérifie si le bureau donné existe dans la liste des Bureaux ou pas
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

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AffichBurVote frame = new AffichBurVote();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}	
}