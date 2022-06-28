package GestionPartis;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class AffichPartis extends JFrame {

	private JPanel contentPane;

	private JLabel label;
	private JLabel title;
	private JButton btnSuive;
	private ImageIcon image;
	private int i=0 ;// compteur pour parcourir la liste des Partis
	private JTextArea parti;
	private JButton retourlbl;
	private ImageIcon imager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichPartis frame = new AffichPartis();
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

    public void incrementer() {
        i++;
    }
	public AffichPartis() {
		setBackground(Color.WHITE);
		 setResizable(false);//Empêcher le redimensionnement de la fenêtres
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AFFICHAGE LISTE PARTIS");//titre de la fenêtre
		setBounds(100, 100, 759, 476);
		setSize(750,500);//dimensions de l'interface
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setLocationRelativeTo(null);//l'interface est centrée à l'écran 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// travail de base 
		title = new JLabel("La Liste des Partis");
		title.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		title.setForeground(Color.RED);//changement de couleur
		title.setBounds(190,50,500,40);//changement de dimension
		contentPane.add(title);
		
		btnSuive = new JButton("SUIVANT");
		btnSuive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parti.setText("");//pour supprimer ce qui écrit dans le parti (textarea)
				if(i<Frame2.frame_2.P.size()) {//on affiche chaque Parti jusqu'a i atteint la fin de la liste des Partis 
				parti.append("Nom du Parti: "+Frame2.frame_2.P.get(i).getNom()+"\n");
				parti.append("Symbole du Parti: "+Frame2.frame_2.P.get(i).getSymbole()+"\n");
				parti.append("Nom du Président : "+Frame2.frame_2.P.get(i).getPresident()+"\n");
				parti.append("Nombre d'adhérents : "+Frame2.frame_2.P.get(i).getNbr_adh()+"\n");
				parti.append("Date légalisation : "+Frame2.frame_2.P.get(i).getDatedeb()+"\n");
				parti.append("Idéologie : "+Frame2.frame_2.P.get(i).getIdeologie()+"\n");
				parti.append("\n");//retour à la ligne
				incrementer();//pour incrémenter i au Parti suivant
				}else {//sinon il va informer l'utilisateur qu'il a atteint la fin de la liste tout en lui laissant le droit de parcourir de nouveau la liste
					JOptionPane.showMessageDialog(null,"Vous avez parcouru toute la liste des Partis!");
					i=0;
				}
			}
		});
				
		btnSuive.setForeground(Color.WHITE);
		btnSuive.setBackground(new Color(225, 13, 25));
		btnSuive.setBounds(305, 360, 283, 36);
		contentPane.add(btnSuive);
	
		
		
		label = new JLabel("");
		label.setBounds(27, 80, 293, 293);
		contentPane.add(label);
		
		

		image = new ImageIcon("image/isie.png");		
		label.setIcon(image);
		
		parti = new JTextArea();
		parti.setText("");
		parti.setFont(new Font("Monospaced", Font.BOLD, 16));
		parti.setEditable(false);
		parti.setBounds(305, 180, 420, 100);
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