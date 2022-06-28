package GestionBureauVote;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import javax.swing.*;

import GestionResutltats.Frame4;
import MenuPrincipal.Verif;

import java.awt.event.*;
import java.util.ArrayList;


public class ModifBur extends JFrame {

	private JPanel contentPane;
	private JLabel lab1;
	private JLabel lab2;
	private JLabel lab3;
	private JLabel titre;
	private JLabel label;
	private JLabel lblNouvelleRegion;
	private JButton btnModifier;
	private JTextField NvNum;
	private JTextField NvAdr;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;

	JComboBox NvRegion = new JComboBox();
	
	private JTextField numero;
	
	/**
	 * Lancement de l'application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifBur frame = new ModifBur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
		
	

	/**
	 * Creation du frame
	 */
	public ModifBur() {
		setBounds(100, 100, 759, 476);
		setSize(800,650);//dimensions de l'interface
		setResizable(false);//Empêcher le redimensionnement de la fenêtre
		setTitle("MODIFICATION D'UN BUREAU DE VOTE");//titre de la fenêtre
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //on exige que le programme se ferme seulement lorsqu'on ferme la fenêtre interface
		 
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
	

	 	titre = new JLabel("La modification d'un Bureau");
		titre.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		titre.setForeground(Color.RED);//changement de couleur
		titre.setBounds(120,50,600,50);//changement de dimension
		contentPane.add(titre);
		
		btnModifier = new JButton("MODIFIER");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Verif.digit(numero.getText())==false) {//tester le numero du bureau
					JOptionPane.showMessageDialog(null,"Le numero de Bureau ne peut contenir que des chiffres !");
				}else if(Verif.Aldig(NvAdr.getText())==false) {//tester le nouveau adresse du bureau
					JOptionPane.showMessageDialog(null,"une adresse ne peut contenire que des lettres et des chiffres !");
				}else if(Verif.digit(NvNum.getText())==false) {//tester nouveau numero du bureau
					JOptionPane.showMessageDialog(null,"Le numero de Bureau ne peut contenir que des chiffres !");
				}else if(NvRegion.getSelectedIndex()==0) {//tester si la selection d'une region 
					JOptionPane.showMessageDialog(null,"selectionner une region !");
				}else {
					
					//tester l'existence de numéro 
					boolean trouve =false ;
					int i=0 ;//compteur
					while ((!trouve) && i<Frame3.frame_3.B.size()) {//tant qu'on ne trouve pas le numéro dans la liste
						if((Frame3.frame_3.B.get(i)).getNumero()==Integer.parseInt(numero.getText())) {
							trouve =true ;
						}else {
							i++ ;
						}
					}

					if(!trouve) {//si le numéro n'existe pas  
						JOptionPane.showMessageDialog(null,"Ce numéro n'existe pas !\nVérifier le numéro du Bureau !");			
					}else {//si le numéro existe 
						Bureau NvB=new Bureau(Integer.parseInt(NvNum.getText()),NvAdr.getText(),NvRegion.getSelectedItem().toString()) ;
						Frame3.frame_3.B.set(i, NvB) ;//pour modifier le bureaux qu'on a trouver a la postion i 
						JOptionPane.showMessageDialog(null,"Félicitations !\nLa modification s'est effectuée avec succèes !");
						
					}
				}
				
			}
		});
				
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBackground(new Color(225, 13, 25));
		btnModifier.setBounds(360, 500, 283, 36);
		contentPane.add(btnModifier);
		
		lab1 = new JLabel("Numéro du Bureau à modifier");
		lab1.setBounds(360, 150, 283, 14);
		contentPane.add(lab1);
		
		numero = new JTextField();
		numero.setColumns(10);
		numero.setBounds(360, 170, 283, 36);
		contentPane.add(numero);
				
		lab2 = new JLabel("Nouveau Numéro:");
		lab2.setBounds(360, 220, 283, 14);
		contentPane.add(lab2);
		
		NvNum = new JTextField();
		NvNum.setBounds(360, 240, 283, 36);
		contentPane.add(NvNum);
		NvNum.setColumns(10);
		
		lab3 = new JLabel("Nouvelle Adresse:");
		lab3.setBounds(360, 290, 283, 14);
		contentPane.add(lab3);
		
		NvAdr = new JTextField();
		NvAdr.setColumns(10);
		NvAdr.setBounds(360, 310, 283, 36);
		contentPane.add(NvAdr);
		
		
		lblNouvelleRegion = new JLabel("Nouvelle Région");
		lblNouvelleRegion.setBounds(360, 360, 283, 14);
		contentPane.add(lblNouvelleRegion);
		
		NvRegion.setModel(new DefaultComboBoxModel(new String[] {"", "Ariana", "Béja", "Ben Arous", "Bizerte", "Gabès", "Gafsa", "Jendouba", "Kairouan", "Kasserine", "Kébili", "Kef", "Mahdia", "Manouba", "Médenine", "Monastir", "Nabeul", "Sfax", "Sidi Bouzid", "Siliana", "Sousse", "Tataouine", "Tozeur", "Tunis", "Zaghouan"}));
		NvRegion.setBounds(360, 380, 283, 22);
		contentPane.add(NvRegion);
		
		label = new JLabel("");
		label.setBounds(27, 130, 293, 293);
		contentPane.add(label);
		
		image = new ImageIcon("image/isie.png");		
		label.setIcon(image);
		
		
		retourlbl = new JButton("");
		 retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					Frame3.frame_3.setVisible(true);
					
				}
		
		});
		retourlbl.setBounds(37, 436, 100, 100);
		contentPane.add(retourlbl);
		
		imager = new ImageIcon("image/bouton_retour.png");		
		retourlbl.setIcon(imager);
		
		
		
			
	}
}
