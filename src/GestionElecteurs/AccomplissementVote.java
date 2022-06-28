package GestionElecteurs;
import GestionPartis.*;
import MenuPrincipal.Verif;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;




public class AccomplissementVote extends JFrame{
private JPanel contentPane;
	
	
	private JLabel title;
	private JLabel label;
	private JLabel cinn;
	private JTextField cin;
	private JLabel symbol;
	private JTextField symbole;
	private JButton acc;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;
	private int i=0;// compteur pour parcourir la liste des Electeurs

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccomplissementVote frame = new AccomplissementVote();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public AccomplissementVote() {
		setBackground(Color.WHITE);
		 setResizable(false);//Empêcher le redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("L'ACCOMPLISSEMENT DU VOTE");//titre de la fenêtre
		setBounds(100, 100, 759, 476);
		setSize(750,520);//dimensions de l'interface
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		// travail de base 
		title = new JLabel("L'accomplissement du Vote");
		title.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,35));//changement de police
		title.setForeground(Color.RED);//changement de couleur
		title.setBounds(150,60,500,40);//changement de dimension
		contentPane.add(title);

		Calendar cal = Calendar.getInstance();
		String ch=(cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
		
		acc = new JButton("ACCOMPLIR");
		acc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					String x1=cin.getText();
					String x2= symbole.getText();
					
					if(Verif.verifcin(x1)==false || x1.equals(" ") ||x1.equals(""))//verifier le TextField 
						JOptionPane.showMessageDialog(null,"La CIN doit être composée de 8 chiffres!");
					else if (Verif.alpha(x2)==false || existeSymbole(x2) )//véerifier le TextField
						JOptionPane.showMessageDialog(null,"Le Symbole du Parti doit être alphabétique !");
					
					else//il va mettre tous les Electeurs du bureau de vote donné dans un autre arraylist 
					{boolean trouve=false;		
					while(i<Frame1.frame_1.E.size() && !trouve)
							{if (x1.equals((Frame1.frame_1.E.get(i)).getCin())) //s'il a trouvé la CIN donnée  								
								trouve=true;
							else i++;}
							
					if(!trouve) //il n'a pas trouvé le bureau de vote
						JOptionPane.showMessageDialog(null,"Cet Électeur n'existe pas !\nVeuillez l'ajouter d'abord !");
				
					else {if (Frame1.frame_1.E.get(i).getSituation()=="Voté")
						JOptionPane.showMessageDialog(null,"Cet Électeur a déjà voté !");
					else {Electeur NvE=new Electeur(Frame1.frame_1.E.get(i).getNom(),Frame1.frame_1.E.get(i).getPrenom(),
							Frame1.frame_1.E.get(i).getCin(),
							Frame1.frame_1.E.get(i).getAge(),Frame1.frame_1.E.get(i).getBurvote(),"Voté",ch,x2) ;
					Frame1.frame_1.E.set(i, NvE) ;
					JOptionPane.showMessageDialog(null,"Félicitations !\nL'accomplissement s'est effectué avec succèes !");
						
					}
						
						}
					}}
					
					
		});
				
		acc.setForeground(Color.WHITE);
		acc.setBackground(new Color(225, 13, 25));
		acc.setBounds(305, 370, 283, 36);
		contentPane.add(acc);
		
		cinn = new JLabel("CIN :");
		cinn.setBounds(305, 200, 283, 14);
		contentPane.add(cinn);
		
		cin = new JTextField();
		cin.setColumns(10);
		cin.setBounds(305, 220, 283, 36);
		contentPane.add(cin);		
		
		symbol = new JLabel("SYMBOLE :");
		symbol.setBounds(305, 260, 283, 14);
		contentPane.add(symbol);
		
		symbole = new JTextField();
		symbole.setColumns(10);
		symbole.setBounds(305, 280, 283, 36);
		contentPane.add(symbole);		
		
		
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
		retourlbl.setBounds(10, 361, 100, 100);
		contentPane.add(retourlbl);

		imager = new ImageIcon("image/bouton_retour.png");		
		retourlbl.setIcon(imager);

		
	}
	



	public boolean existeSymbole(String ch)//cette méthode vérifie si le symbole donné existe dans les symboles de la liste des Partis ou pas
	{
		boolean test=false;
		Frame2 GP=new Frame2() ;//instancier l'objet qui contient la liste de tous les Partis  
		ArrayList<Partis> P=new ArrayList<Partis>() ;//créer une nouvelle liste dynamique 
		P=GP.getParti() ;//B contient la liste de tous les Partis
		int i=0;
		while(i<P.size() && !test)
		 {if (ch.equals(P.get(i).getSymbole()))
			 test=true;
		 else i++;
		 }
		 return test;
			 
		 }





}
