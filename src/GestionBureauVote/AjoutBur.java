package GestionBureauVote;

import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;

import GestionResutltats.Frame4;
import MenuPrincipal.Verif;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;


public class AjoutBur extends JFrame {

	private JPanel contentPane;
	
	private JLabel num;
	private JLabel adr;
	private JLabel reg;
	private JLabel titre;
	private JLabel label;
	private JButton btnAjouter;
	private JButton retourlbl;
	private ImageIcon imager;

	private JTextField numero;
	private JTextField adresse;
	private ImageIcon image;
	
	private JComboBox region;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutBur frame = new AjoutBur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
		
	
	// going to borrow code from a gist to move frame.
	

	/**
	 * Create the frame.
	 */
	public AjoutBur() {
		setBounds(100, 100, 759, 476);
		setSize(780,520);//dimensions de l'interface
		 setResizable(false);//Empêcher le redimensionnement de la fenêtre
		 setTitle("AJOUT D'UN NOUVEAU BUREAU DE VOTE");//titre de la fenêtre
		 setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //on exige que le programme se ferme seulement lorsqu'on ferme la fenêtre interface
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		titre = new JLabel("L'Ajout d'un Nouveau Bureau");
		titre.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		titre.setForeground(Color.RED);//changement de couleur
		titre.setBounds(110,50,600,50);//changement de dimension
		contentPane.add(titre);
		
		btnAjouter = new JButton("AJOUTER");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Verif.digit(numero.getText())==false) {//tester le numero
					JOptionPane.showMessageDialog(null,"Le numero d'un bureau ne peut contenir que des chiffres !");
				}else if(Verif.Aldig(adresse.getText())==false) {//tester l'adresse du bureau
					JOptionPane.showMessageDialog(null,"une adresse ne peut contenire que des lettres et des chiffres !");
				}else if(region.getSelectedIndex()==0) {//tester la selection d'une region 
					JOptionPane.showMessageDialog(null,"selectionner une region !");
				}else {
					Bureau bur=new Bureau(Integer.parseInt(numero.getText()),adresse.getText(),region.getSelectedItem().toString());
					
					//vérification de l'existence du Bureau de vote à ajouter 
					boolean trouve =false ;
					int i=0 ;
					while ((!trouve) && i<Frame3.frame_3.B.size()) {
						if((Frame3.frame_3.B.get(i)).getNumero()==bur.getNumero()) {
							trouve =true ;
						}else {
							i++ ;
						}
					}
					
					if(trouve) {
						JOptionPane.showMessageDialog(null,"Ce bureau existe déjà !");				
					}else {
						Frame3.frame_3.B.add(bur) ;
					JOptionPane.showMessageDialog(null,"Félicitations !\nL'ajout s'est effectué avec succèes !");					
				}
			}
				
			}
		});
				
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setBackground(new Color(225, 13, 25));
		btnAjouter.setBounds(360, 390, 283, 36);
		contentPane.add(btnAjouter);
		
				
		num = new JLabel("NUMÉRO :");
		num.setBounds(360, 150, 114, 14);
		contentPane.add(num);
		
		numero = new JTextField();
		numero.setBounds(360, 170, 283, 36);
		contentPane.add(numero);
		numero.setColumns(10);
		
		adr = new JLabel("ADRESSE :");
		adr.setBounds(360, 220, 114, 14);
		contentPane.add(adr);
		
		adresse = new JTextField();
		adresse.setColumns(10);
		adresse.setBounds(360, 240, 283, 36);
		contentPane.add(adresse);
		
		reg = new JLabel("RÉGION :");
		reg.setBounds(360, 290, 151, 14);
		contentPane.add(reg);
			
		
		label = new JLabel("");
		label.setBounds(20, 111, 293, 293);
		contentPane.add(label);
		
		image = new ImageIcon("image/isie.png");		
		label.setIcon(image);
		
		region = new JComboBox();
		region.setModel(new DefaultComboBoxModel(new String[] {"", "Ariana", "Béja", "Ben Arous", "Bizerte", "Gabès", "Gafsa", "Jendouba", "Kairouan", "Kasserine", "Kébili", "Kef", "Mahdia", "Manouba", "Médenine", "Monastir", "Nabeul", "Sfax", "Sidi Bouzid", "Siliana", "Sousse", "Tataouine", "Tozeur", "Tunis", "Zaghouan"}));
		region.setBounds(360, 310, 283, 22);
		contentPane.add(region);
		
		imager = new ImageIcon("image/bouton_retour.png");		
		retourlbl = new JButton("");
		retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					Frame3.frame_3.setVisible(true);
					
				}
		
		});
		retourlbl.setBounds(30, 381, 100, 100);
		contentPane.add(retourlbl);
		retourlbl.setIcon(imager);
		
	}
	

}