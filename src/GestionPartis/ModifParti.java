package GestionPartis;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import MenuPrincipal.Verif;

public class ModifParti extends JFrame {

	private JPanel contentPane;
	private JLabel nparti;
	private JLabel symbole;
	private JLabel npres;
	private JLabel nbradh;
	private JLabel datedeb;
	private JLabel ideologie;
	private JLabel title;
	private JLabel label;
	private JButton btnModifier;

	private JTextField NvNom;
	private JTextField NvSymbole;
	private JTextField NvPresident;
	private JTextField Nvnbr_adh;
	private JTextField Nvdatedebb;
	private JTextField Nvideo;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;

	int xx,xy;
	private JTextField NomP;
	/**
	 * Create the frame.
	 */
	public ModifParti() {
		setBackground(Color.WHITE);
		 setResizable(false);//Empêcher le redimensionnement de la fenêtres
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MODIFICATION D'UN PARTI");
		setBounds(100, 100, 729, 556);
		setSize(750,680);//dimensions de l'interface
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// travail de base 
		title = new JLabel("La Modification d'un Parti");
		title.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		title.setForeground(Color.RED);//changement de couleur
		title.setBounds(115,30,500,40);//changement de dimension
		contentPane.add(title);
		
		btnModifier = new JButton("MODIFIER");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x1=NvNom.getText();
				String x2=NvSymbole.getText();
				String x3=NvPresident.getText();
				String x4=Nvnbr_adh.getText();
				String x5=Nvdatedebb.getText();
				String x6=Nvideo.getText();
				

				if(Verif.alpha(x1)==false || x1.equals("") || x1.equals(" ")) {//vérifie le nouveau nom du Parti 
					JOptionPane.showMessageDialog(null,"Le nouveau nom d'un Parti ne peut contenir que des lettres !");
				}else if(Verif.alpha(x2)==false || x2.equals("") || x2.equals(" ")) {//vérifie le nouveau symbole du Parti
					JOptionPane.showMessageDialog(null,"Le nouveau symbole du Parti ne peut contenir que des lettres !");
				}else if(Verif.alpha(x3)==false || x3.equals("") || x3.equals(" ")) {//vérifie le nouveau nom du Parti
					JOptionPane.showMessageDialog(null,"Le nouveau nom du Président ne peut contenir que des lettres !");
				}else if(Verif.digit(x4)==false || x4.equals("") || x4.equals(" ")) {//vérifie le nouveau nombre d'adhérents du Parti
					JOptionPane.showMessageDialog(null,"Le nouveau nombre d'Adhérents ne peut contenir que des chiffres !");
				}else if(Verif.verifdate(x5)==false || x5.equals("") || x5.equals(" ")) {//vérifie la nouvelle date de légalisation donnée
						JOptionPane.showMessageDialog(null,"La nouvelle date de légalisation est incorrecte !\nVérifier cette date !");
				}else if(Verif.alpha(x6)==false || x6.equals("") || x6.equals(" ")) {//vérifie l'idéologie donnée
						JOptionPane.showMessageDialog(null,"La nouvelle idéologie ne peut contenir que des lettres !");
				}else {
					//tester l'existance de nom 
					int i=0 ;
					while (i<Frame2.frame_2.P.size()) {
						if (!(Frame2.frame_2.P.get(i).getNom().equals(NomP.getText()))) { //si le ieme nom de la liste différent de nom donnée par l'utilistateur  
							i++ ;
						}else {//il a trouvé le nom du Parti à modifier
							break ;
						}
					}
					if(i>=Frame2.frame_2.P.size()) {//si le nom du Parti à modifier n'existe pas  
						JOptionPane.showMessageDialog(null,"Le nom du Parti à modifier n'existe pas !\nVérifier ce nom du Parti !");			
					}else {//si le nom existe 
						Partis NvP=new Partis(NvNom.getText(),NvSymbole.getText(),NvPresident.getText(),Integer.parseInt(Nvnbr_adh.getText()),Nvdatedebb.getText(),Nvideo.getText()) ;
						Frame2.frame_2.P.set(i, NvP) ;
						JOptionPane.showMessageDialog(null,"Félicitations !\nLa modification s'est effectuée avec succèes !");
						
					}
				}
				
			}
		});
				
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBackground(new Color(225, 13, 25));
		btnModifier.setBounds(365, 590, 283, 36);
		contentPane.add(btnModifier);
		
		
		JLabel Nom_Du_Parti = new JLabel("NOM DU PARTI À MODIFIER :");
		Nom_Du_Parti.setBounds(365, 88, 283, 14);
		contentPane.add(Nom_Du_Parti);
		
		NomP = new JTextField();
		NomP.setColumns(10);
		NomP.setBounds(365, 108, 283, 36);
		contentPane.add(NomP);
		
		nparti = new JLabel("NOUVEAU NOM DU PARTI :");
		nparti.setBounds(365, 156, 283, 14);
		contentPane.add(nparti);
		
		NvNom = new JTextField();
		NvNom.setBounds(365, 176, 283, 36);
		contentPane.add(NvNom);
		NvNom.setColumns(10);
		
		symbole = new JLabel("NOUVEAU SYMBOLE DU PARTI:");
		symbole.setBounds(365, 226, 283, 14);
		contentPane.add(symbole);
		
		NvSymbole = new JTextField();
		NvSymbole.setColumns(10);
		NvSymbole.setBounds(365, 246, 283, 36);
		contentPane.add(NvSymbole);
		
		npres = new JLabel("NOUVEAU NOM DU PRÉSIDENT:");
		npres.setBounds(365, 296, 283, 14);
		contentPane.add(npres);
		
		NvPresident = new JTextField();
		NvPresident.setColumns(10);
		NvPresident.setBounds(365, 316, 283, 36);
		contentPane.add(NvPresident);
		
		
		nbradh = new JLabel("NOUVEAU NOMBRE D'ADHÉRANTS:");
		nbradh.setBounds(365, 366, 277, 14);
		contentPane.add(nbradh);
		
		Nvnbr_adh = new JTextField();
		Nvnbr_adh.setColumns(10);
		Nvnbr_adh.setBounds(365, 386, 283, 36);
		contentPane.add(Nvnbr_adh);
		
		datedeb = new JLabel("DATE DE LÉGALISATION:");
		datedeb.setBounds(365, 430, 163, 14);
		contentPane.add(datedeb);
		
		Nvdatedebb = new JTextField();
		Nvdatedebb.setColumns(10);
		Nvdatedebb.setBounds(365, 450, 283, 36);
		contentPane.add(Nvdatedebb);
		
		ideologie = new JLabel("IDÉOLOGIE:");
		ideologie.setBounds(365, 510, 163, 14);
		contentPane.add(ideologie);
		
		Nvideo = new JTextField();
		Nvideo.setColumns(10);
		Nvideo.setBounds(365, 530, 283, 36);
		contentPane.add(Nvideo);
		
		
		label = new JLabel("");
		label.setBounds(47, 120, 293, 293);
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
		retourlbl.setBounds(26, 526, 100, 100);
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
					ModifParti frame = new ModifParti();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
