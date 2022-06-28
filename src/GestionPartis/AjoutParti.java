package GestionPartis;

import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.*;

import MenuPrincipal.Verif;

import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;


public class AjoutParti extends JFrame {

	private JPanel contentPane;
	
	private JLabel nparti;
	private JLabel symbole;
	private JLabel npres;
	private JLabel nbradh;
	private JLabel datedeb;
	private JLabel ideologie;
	private JLabel title;
	private JLabel label;
	private JButton button;

	private JTextField nom;
	private JTextField symbol;
	private JTextField president;
	private JTextField nbr_adh;
	private JTextField datedebb;
	private JTextField ideo;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;

	
	
	private int i=0;

	private ArrayList<Partis> P;
	

	/**
	 * Create the frame.
	 */
	public AjoutParti() {
		setBackground(Color.WHITE);
		 setResizable(false);//Empêcher le redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("AJOUT D'UN NOUVEAU PARTI");//titre de la fenêtre	
		setBounds(100, 200, 759, 636);
		setSize(750,680);//dimensions de l'interface
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// travail de base 
		title = new JLabel("L'Ajout d'un Nouveau Parti");
		title.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		title.setForeground(Color.RED);//changement de couleur
		title.setBounds(120,30,550,50);//changement de dimension
		contentPane.add(title);
		
		button = new JButton("S'INSCRIRE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x1=nom.getText();
				String x2=symbol.getText();
				String x3=president.getText();
				String x4=nbr_adh.getText();
				String x5=datedebb.getText();
				String x6=ideo.getText();
				
				
				if(Verif.alpha(x1)==false) {//verifie le nom du Parti
					JOptionPane.showMessageDialog(null,"Le nom d'un Parti ne peut contenir que des lettres !");
				}else if(Verif.alpha(x2)==false) {//vérifie le symbole du parti
					JOptionPane.showMessageDialog(null,"Le symbole du Parti ne peut contenir que des lettres !");
				}else if(Verif.alpha(x3)==false) {//vérifie le nom du président
					JOptionPane.showMessageDialog(null,"Le nom du Président ne peut contenir que des lettres !");
				}else if(Verif.digit(x4)==false) {//vérifie le nombre d'adhérents
					JOptionPane.showMessageDialog(null,"Le nombre d'Adhérents ne peut contenir que des chiffres !");
				}else if(Verif.verifdate(x5)==false) {//vérifie la date
						JOptionPane.showMessageDialog(null,"La date de légalisation est incorrecte !\nVérifier cette date !");
				}else if(Verif.alpha(x6)==false) {//vérifie l'idéologie du Parti
						JOptionPane.showMessageDialog(null,"L'idéologie ne peut contenir que des lettres !");
				}else {boolean trouve=false;		
				while(i<Frame2.frame_2.P.size() && !trouve)
				{if (x1.equals((Frame2.frame_2.P.get(i)).getNom())) //s'il a trouvé le nom du Parti 								
					trouve=true;
				else i++;}
				
				if(trouve) //il a trouvé le nom du Parti donc il affiche un message d'erreur
					JOptionPane.showMessageDialog(null,"Ce Parti existe déjà !");
				else {	//il n'a pas trouvé le nom du Parti donc il va l'ajouter				
				
					Partis parti=new Partis(nom.getText(),symbol.getText(),president.getText(),Integer.parseInt(nbr_adh.getText()),datedebb.getText(),ideo.getText()) ;
					Frame2.frame_2.P.add(parti) ;
					JOptionPane.showMessageDialog(null,"Félicitations !\nL'Ajout s'est effectué avec succèes !");					
				}
				}
				
			}
		});
				
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(225, 13, 25));
		button.setBounds(365, 590, 283, 36);
		contentPane.add(button);
		
				
		nparti = new JLabel("NOM DU PARTI:");
		nparti.setBounds(365, 110, 114, 14);
		contentPane.add(nparti);
		
		nom = new JTextField();
		nom.setBounds(365, 130, 283, 36);
		contentPane.add(nom);
		nom.setColumns(10);
		
		symbole = new JLabel("SYMBOLE DU PARTI:");
		symbole.setBounds(365, 190, 150, 14);
		contentPane.add(symbole);
		
		symbol = new JTextField();
		symbol.setColumns(10);
		symbol.setBounds(365, 210, 283, 36);
		contentPane.add(symbol);
		
		npres = new JLabel("NOM DU PRÉSIDENT:");
		npres.setBounds(365, 270, 151, 14);
		contentPane.add(npres);
		
		president = new JTextField();
		president.setColumns(10);
		president.setBounds(365, 290, 283, 36);
		contentPane.add(president);
		
		
		nbradh = new JLabel("NOMBRE D'ADHÉRANTS:");
		nbradh.setBounds(365, 350, 163, 14);
		contentPane.add(nbradh);
		
		nbr_adh = new JTextField();
		nbr_adh.setColumns(10);
		nbr_adh.setBounds(365, 370, 283, 36);
		contentPane.add(nbr_adh);
		
		datedeb = new JLabel("DATE DE LÉGALISATION:");
		datedeb.setBounds(365, 430, 163, 14);
		contentPane.add(datedeb);
		
		datedebb = new JTextField();
		datedebb.setColumns(10);
		datedebb.setBounds(365, 450, 283, 36);
		contentPane.add(datedebb);
		
		ideologie = new JLabel("IDÉOLOGIE:");
		ideologie.setBounds(365, 510, 163, 14);
		contentPane.add(ideologie);
		
		ideo = new JTextField();
		ideo.setColumns(10);
		ideo.setBounds(365, 530, 283, 36);
		contentPane.add(ideo);
		
		label = new JLabel("");
		label.setBounds(47, 130, 303, 273);
		contentPane.add(label);
		
		image = new ImageIcon("image/isie.png");		
		label.setIcon(image);
			
		
		retourlbl = new JButton("");
		 retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					Frame2.frame_2.setVisible(true);
					
				}

      });
		retourlbl.setBounds(36, 526, 100, 100);
		contentPane.add(retourlbl);

		imager = new ImageIcon("image/bouton_retour.png");		
		retourlbl.setIcon(imager);

	}
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutParti frame = new AjoutParti();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
	
