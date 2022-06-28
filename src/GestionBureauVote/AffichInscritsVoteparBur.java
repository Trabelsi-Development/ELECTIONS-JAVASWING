package GestionBureauVote;

import java.awt.EventQueue;
import GestionElecteurs.Electeur;
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

public class AffichInscritsVoteparBur extends JFrame {

	private JPanel contentPane;
	private JLabel titre1;
	private JLabel titre2;
	private JLabel label;
	private JButton btnAffich;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;

	private int i=0 ;// compteur pour parcourir la liste des Bureaux
	private JTextArea nbrVoter;// o� les r�sultats seront affich�s
	
	/**
	 * lancement de l'application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichInscritsVoteparBur frame = new AffichInscritsVoteparBur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
		
	
	/**
	 * creation du frame
	 */

    public void incrementer() { //incrementer i
        i++;
    }
	public AffichInscritsVoteparBur() {
		setBounds(100, 100, 759, 476);
		setSize(750,550);//dimensions de l'interface
		setResizable(false);//Emp�cher le redimensionnement de la fen�tre
		setTitle("AFFICHAGE DU NOMBRE TOTAL D'INSCRITS QUI ONT VOT�");//titre de la fen�tre
		setLocationRelativeTo(null);//l'interface est centr�e � l'�cran 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //on exige que le programme se ferme seulement lorsqu'on ferme la fen�tre interface
		 
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		titre1 = new JLabel("L'affichage du nombre total");
		titre1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		titre1.setForeground(Color.RED);//changement de couleur
		titre1.setBounds(120,50,650,50);//changement de dimension
		contentPane.add(titre1);
		
		titre2 = new JLabel("d�inscrits qui ont vot�");
		titre2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		titre2.setForeground(Color.RED);//changement de couleur
		titre2.setBounds(180,90,650,50);//changement de dimension
		contentPane.add(titre2);
		
		btnAffich = new JButton("SUIVANT");
		btnAffich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				nbrVoter.setText("");//pour supprimer ce qui est ecrit
				if(i<Frame3.frame_3.B.size()) {//on affiche chaque bureau jusqu'� i atteint la fin de la liste des Bureaux
					int v=0 ;// nombre des electeur qui ont vot�
					for(Electeur e:Frame3.frame_3.B.get(i).getIE()) {
						if(e.getSituation()=="Vot�") {//si l'�lecteur a vot�
							v++ ;//incrementer compteur v (contenant le nombre des �lecteurs vot�s)
						}
					}
					// afficher le r�sultat
					nbrVoter.append("Bureau N� "+(Frame3.frame_3.B.get(i)).getNumero()+" : \n"+Frame3.frame_3.B.get(i).getIE().size()+" �lecteur(s) inscrit(s) \n"+v+" �lecteur(s) vot�(s)");
					incrementer();//pour incr�menter i au Bureau suivant
				}else {//sinon informer l'utilisateur qu'il a parcouru toute la liste des �lecteurs inscrits qui ont vot�s
					JOptionPane.showMessageDialog(null,"Vous avez parcouru toute la liste des �lecteurs inscrits qui ont vot�s !");
					i=0;
				}
			}
		});
				
		btnAffich.setForeground(Color.WHITE);
		btnAffich.setBackground(new Color(225, 13, 25));
		btnAffich.setBounds(350, 391, 283, 36);
		contentPane.add(btnAffich);
		
		label = new JLabel("");
		label.setBounds(50, 90, 293, 293);
		contentPane.add(label);
		

		image = new ImageIcon("image/isie.png");		
		label.setIcon(image);
		
		nbrVoter = new JTextArea();
		nbrVoter.setText("Nombre d'inscrits qui ont vot� :");
		nbrVoter.setFont(new Font("Monospaced", Font.BOLD, 16));
		nbrVoter.setEditable(false);
		nbrVoter.setBounds(350, 180, 330, 200);
		contentPane.add(nbrVoter);
		imager = new ImageIcon("image/bouton_retour.png");		
		retourlbl = new JButton("");
		retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					Frame3.frame_3.setVisible(true);
					
				}
		
		});
		retourlbl.setBounds(10, 365, 100, 100);
		contentPane.add(retourlbl);
		retourlbl.setIcon(imager);
		
			
	}
	

}