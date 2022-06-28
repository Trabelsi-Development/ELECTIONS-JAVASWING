package GestionPartis;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import GestionElecteurs.Frame1;

public class AffichparSymbole extends JFrame {

	private JPanel contentPane;
	private JLabel symbole;
	private JLabel label;
	private JLabel title;
	private JButton btnAff;
	private JTextField Symbole;
	private ImageIcon image;
	private JTextArea parti;
	private JButton retourlbl;
	private ImageIcon imager;

	/**
	 * lancer l'application 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichparSymbole frame = new AffichparSymbole();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}		
		//créer le frame 
	
		public AffichparSymbole() {
		setBackground(Color.WHITE);
		 setResizable(false);//Empêcher le redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AFFICHAGE PARTI PAR SYMBOLE DONNÉ");//titre de la fenêtre
		setBounds(100, 100, 779, 496);
		setSize(780,500);//dimensions de l'interface
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// travail demandé

		title = new JLabel("Le Parti d'un Symbole donné");
		title.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		title.setForeground(Color.RED);//changement de couleur
		title.setBounds(100,30,570,70);//changement de dimension
		contentPane.add(title);
		
		btnAff = new JButton("AFFICHER");
		btnAff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					////tester l'existance du symbole
					int i=0 ;
					while (i<Frame2.frame_2.P.size()) {
						if (!(Frame2.frame_2.P.get(i).getSymbole().equals(Symbole.getText()))) { //si le i ème symbole est différent   
							i++ ;
						}else {//il a trouvé le nom
							break ;
						}
					}
					if(i>=Frame2.frame_2.P.size()) {//il n'a pas trouvé le nom 
						JOptionPane.showMessageDialog(null,"Ce symbole n'existe pas !\nVérifier le symbole du Parti !");			
					}else {//sinon afficher le Parti correspondant 
						parti.setText("");//pour supprimer ce qui écrit dans le Parti
						parti.append("Nom du Parti : "+Frame2.frame_2.P.get(i).getNom()+"\n");
						parti.append("Symbole du Parti: "+Frame2.frame_2.P.get(i).getSymbole()+"\n");
						parti.append("Nom du Président : "+Frame2.frame_2.P.get(i).getPresident()+"\n");
						parti.append("Nombre d'adhérents : "+Frame2.frame_2.P.get(i).getNbr_adh()+"\n");
					}
				
			}
		});
				
		btnAff.setForeground(Color.WHITE);
		btnAff.setBackground(new Color(225, 13, 25));
		btnAff.setBounds(335, 361, 283, 36);
		contentPane.add(btnAff);
		
		symbole = new JLabel("SYMBOLE DU PARTI:");
		symbole.setBounds(335, 130, 283, 14);
		contentPane.add(symbole);
		
		Symbole = new JTextField();
		Symbole.setColumns(10);
		Symbole.setBounds(335, 150, 283, 36);
		contentPane.add(Symbole);
		
		label = new JLabel("");
		label.setBounds(27, 80, 293, 293);
		contentPane.add(label);

		image = new ImageIcon("image/isie.png");		
		label.setIcon(image);
		
		parti = new JTextArea();
		parti.setFont(new Font("Monospaced", Font.BOLD, 16));
		parti.setEditable(false);
		parti.setBounds(335, 210, 420, 100);
		contentPane.add(parti);
		
		
		retourlbl = new JButton("");
		 retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					Frame2.frame_2.setVisible(true);
					
				}

        });
		retourlbl.setBounds(37, 337, 100, 100);
		contentPane.add(retourlbl);

		imager = new ImageIcon("image/bouton_retour.png");		
		retourlbl.setIcon(imager);

		
			
	}
}