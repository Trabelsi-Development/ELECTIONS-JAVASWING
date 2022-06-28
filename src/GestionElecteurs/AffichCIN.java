package GestionElecteurs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import MenuPrincipal.Verif;

public class AffichCIN extends JFrame {

	private JPanel contentPane;
	
	private JLabel title1;
	private JLabel title2;
	private JLabel label;
	private JLabel cinn;
	private JTextField cin;
	private JButton btnAffich;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;
	private int i=0;// compteur pour parcourir la liste des Electeurs

	private JTextArea electeur;	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichCIN frame = new AffichCIN();
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

	public AffichCIN() {
		setBackground(Color.WHITE);
		 setResizable(false);//Empêcher le redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AFFICHAGE N° DU BUREAU DE VOTE PAR CIN DONNÉ");//titre de la fenêtre
		setBounds(100, 100, 759, 476);
		setSize(750,520);//dimensions de l'interface
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		// travail de base 
		title1 = new JLabel("Le N° du Bureau de Vote");
		title1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,35));//changement de police
		title1.setForeground(Color.RED);//changement de couleur
		title1.setBounds(160,60,500,40);//changement de dimension
		contentPane.add(title1);

		title2 = new JLabel("par CIN");
		title2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,35));//changement de police
		title2.setForeground(Color.RED);//changement de couleur
		title2.setBounds(290,100,500,40);//changement de dimension
		contentPane.add(title2);
		
		btnAffich = new JButton("AFFICHER");
		btnAffich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					String x1=cin.getText();

					
					if(Verif.verifcin(x1)==false || x1.equals(" ") ||x1.equals(""))//verifier le TextField 
						JOptionPane.showMessageDialog(null,"La CIN doit être composée de 8 chiffres!");
					
					else//il va mettre tous les Electeurs du bureau de vote donné dans un autre arraylist 
					{boolean trouve=false;		
					while(i<Frame1.frame_1.E.size() && !trouve)
							{if (x1.equals((Frame1.frame_1.E.get(i)).getCin())) //s'il a trouvé la CIN donnée  
								trouve=true;
							else i++;}
							
					if(!trouve) //il n'a pas trouvé le bureau de vote
						JOptionPane.showMessageDialog(null,"Cette CIN n'existe pas !\nVérifier le numéro de la CIN !");
				
					else {electeur.setText("");//pour supprimer ce qui est écrit dans l'electeur(textarea)
						electeur.append("Numéro du Bureau de Vote : "+(Frame1.frame_1.E.get(i)).getBurvote()+"\n");
						
						}
					}
						  }
						 					
					
		});
				
		btnAffich.setForeground(Color.WHITE);
		btnAffich.setBackground(new Color(225, 13, 25));
		btnAffich.setBounds(305, 400, 283, 36);
		contentPane.add(btnAffich);
		
		cinn = new JLabel("CIN :");
		cinn.setBounds(305, 200, 283, 14);
		contentPane.add(cinn);
		
		cin = new JTextField();
		cin.setColumns(10);
		cin.setBounds(305, 220, 283, 36);
		contentPane.add(cin);		
		
		label = new JLabel("");
		label.setBounds(27, 120, 293, 293);
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
		retourlbl.setBounds(20, 381, 100, 100);
		contentPane.add(retourlbl);

		imager = new ImageIcon("image/bouton_retour.png");		
		retourlbl.setIcon(imager);

		
		
		
		electeur = new JTextArea();
		electeur.setText("");
		electeur.setFont(new Font("Monospaced", Font.BOLD, 16));
		electeur.setEditable(false);
		electeur.setBounds(305, 300, 420, 100);
		contentPane.add(electeur);
			
	}





}
