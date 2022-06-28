package Statistiques;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

import GestionElecteurs.Electeur;
import GestionElecteurs.Frame1;


public class ResTrancheAge extends JFrame{
	
	private JPanel contentPane;

	private JLabel label;
	private JButton affich;
	private JLabel titre;
	private JTextArea trage;
	private ImageIcon image;
	private JButton retourlbl;
	private ImageIcon imager;
	
	private int i=0;//compteur
	
	public void close()
	{WindowEvent winClosingEvent= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);		
	}
	
	/**
	 * Create the frame.
	 */
	public ResTrancheAge() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);//Emp�cher le redimensionnement de la fen�tre
		setBounds(100, 100, 779, 476);
		setSize(750,650);//dimensions de l'interface
		setTitle("AFFINER LES RESULTATS PAR TRANCHE D'AGE");//titre de la fen�tre
		setLocationRelativeTo(null);//l'interface est centr�e � l'�cran 
		 
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);//pas de positionnement(absolute layout)
		
		titre = new JLabel("R�sultats par Tranche d'�ge");
		titre.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
		titre.setForeground(Color.RED);//changement de couleur
		titre.setBounds(110,70,650,60);//changement de dimension
		contentPane.add(titre);
	
		affich = new JButton("Afficher");
		affich.setBounds(300, 520, 283, 36);//Position et Dimension du bouton valider
		affich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame1 GE=new Frame1() ;//instancier l'objet qui contient la liste de tous les Electeurs  
				ArrayList<Electeur> P=new ArrayList<Electeur>() ;//cr�er une nouvelle liste dynamique 
				P=GE.getElecteur() ;//p contient la liste de tous les Electe
				
				int tab[];//tableau qui va contenir les �ges des electeurs inscrits qui ont vot� pour chaque parti
				
				trage.setText("");//vider le textarea
					
					for (i=0;i<P.size();i++)
					{boolean trouve=false; int c=0;
					if ((P.get(i).getSituation()).equals("Vot�"))//tout ce traitement va �tre execut� si et seulement si l'electeur a vot�
						{while(c<i && !trouve)//on va tester si le Parti est trouv� avant ou pas (si oui c'est � dire le resultat est d�j� calcul� avant)
						{if (P.get(i).getChoix()==P.get(c).getChoix())
							trouve=true;
						else c++;							
						}
						if (!trouve)//si le Parti est trouv� pour la 1�re fois
						{tab=new int[50];/*instancier un nouveau tableau d'entiers*/ int k=0;/*compteur qui va parcourir le tableau*/ 
						trage.append("\n"+P.get(i).getChoix()+" : \n");//afficher le nom du Parti dans le textarea
							for (c=i;c<P.size();c++)
							{if (P.get(i).getChoix()==P.get(c).getChoix() )//si on trouve un electeur qui a choisi le m�me nom du Parti courant
								{tab[k]=P.get(c).getAge();//on va mettre l'age de cet electeur dans le tableau
								k++;}//incr�menter k
							}//par la fin, le tableau contient tous les �ges des electeurs qui ont vot� pour ce Parti
							
							// on s'int�resse maintenant � compter le nombre d'occurrences de chaque �ge
							for (c=0;c<k;c++)//on va parcourir le tableau tab (qui contient les ages)
							{int n=0; //compteur qui va commencer le parcours (l'age courant)
							boolean test=false;
								while(n<c && !test)//tant que n<l'age courant etil n'a pas encore touv� le m�me age avant
								{if (tab[c]==tab[n])
									test=true;
								else n++;									
								}
								
								if (!test)//l'�ge n'est pas trouv� avant c'est � dire son nbre d'occurrences va �tre maintenant calcul�
								{int age=0; int a=18; int b=28;
								for (int l=c;l<k;l++)
									{if (tab[l]==tab[c])//lorsque je trouve un �ge pareil 
										age++;	//contient le nombre d'occurrences de l'age								
									}
								//on s'int�resse maintenant � chercher la tranche d'age correspondante � l'age courant
								boolean stop=false;
								while (!stop)
									{if (tab[c]>=a && tab[c]<b)//si j'ai trouv� l'intervalle correspondant
										stop=true;
									else {a=a+10;
									b=b+10;}//sinon passer � l'intervalle suivant (augmenter l'intervalle)
									
									}
								trage.append("["+a+".."+b+"["+" : "+(age*100)/k+" %\n");//l'affichage du r�sultat
								}
								
							}
							
						}
						
						
						
						}	//end grande if
					}//end grande for
					
					
			}
			});
		
		affich.setForeground(Color.WHITE);
		affich.setBackground(new Color(225, 13, 25));		
		contentPane.add(affich);
		

		trage = new JTextArea();
		trage.setText("");
		trage.setFont(new Font("Monospaced", Font.BOLD, 16));
		trage.setEditable(false);
		trage.setBounds(305, 170, 450, 360);
		contentPane.add(trage);
		
		label = new JLabel("");
		label.setBounds(40, 120, 293, 293);
		contentPane.add(label);			

		image = new ImageIcon("image/isie.png");		
		label.setIcon(image);	

		retourlbl = new JButton("");
		 retourlbl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					Frame5.frame_5.setVisible(true);
					
				}

        });
		retourlbl.setBounds(10, 491, 100, 100);
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
					ResTrancheAge frame = new ResTrancheAge();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
