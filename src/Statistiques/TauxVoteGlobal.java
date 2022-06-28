package Statistiques;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;

import GestionBureauVote.*;
import GestionElecteurs.Frame1;

import java.awt.Color;
import javax.swing.*;

public class TauxVoteGlobal extends JFrame{

		private JPanel contentPane;

		private JLabel label;
		private JButton btnAffich;
		private JLabel titre1;
		private JLabel titre2;
		private JLabel titre3;
		private ImageIcon image;
		private JButton retourlbl;
		private ImageIcon imager;
		
		private JTextArea tauxr;
		private JTextArea tauxa;
		private int c;
	
		

		/**
		 * Create the frame.
		 */
		public TauxVoteGlobal() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);//Empêcher le redimensionnement de la fenêtre
			setBounds(100, 100, 779, 476);
			setSize(1000,650);//dimensions de l'interface
			setTitle("AFFICHAGE DU TAUX DE VOTE GLOBAL");//titre de la fenêtre
			setLocationRelativeTo(null);//l'interface est centrée à l'écran 
			 
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setBackground(Color.white);
			contentPane.setLayout(null);//pas de positionnement(absolute layout)
			
			titre1 = new JLabel("Le taux de vote Global Par Région");
			titre1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
			titre1.setForeground(Color.RED);//changement de couleur
			titre1.setBounds(180,50,650,60);//changement de dimension
			contentPane.add(titre1);
			
			titre2 = new JLabel("(pourcentage d'électeurs inscrits");
			titre2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
			titre2.setForeground(Color.RED);//changement de couleur
			titre2.setBounds(180,100,750,60);//changement de dimension
			contentPane.add(titre2);
			
			titre3 = new JLabel("qui ont participé au vote)");
			titre3.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));//changement de police
			titre3.setForeground(Color.RED);//changement de couleur
			titre3.setBounds(265,140,750,60);//changement de dimension
			contentPane.add(titre3);
			
			btnAffich = new JButton("AFFICHER");
			btnAffich.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
//affichage par région	
					String ch="";
					tauxr.setText("");
					tauxr.append("Par Région:\n\n");
							int Tab[]=new int[50];//initialisation du tableau d'entiers qui va contenir tous les bureaux de chaque Région
						for (int i=0;i<Frame3.frame_3.B.size();i++)
						{boolean existe=false; c=0; 
						ch=Frame3.frame_3.B.get(i).getRegion();//ch contient la Région du bureau courant
							while(!existe && c<i) //on va tester si la Région du bureau courant est trouvée avant ou pas
							{if (Frame3.frame_3.B.get(c).getRegion()==Frame3.frame_3.B.get(i).getRegion())
								existe=true;
							else c++;}
						if (!existe)// si la Région n'est pas trouvée avant alors on va remplir le tableau Tab avec tous ses bureaux
						{Tab=new int[50]; int k=0;
							for (c=i;c<Frame3.frame_3.B.size();c++)
								{if (Frame3.frame_3.B.get(c).getRegion()==Frame3.frame_3.B.get(i).getRegion())//si la Région du bureau courant est trouvée dans le reste de la liste des Bureaux
							{Tab[k]=Frame3.frame_3.B.get(c).getNumero();
							k++;}//incrémenter k
								}
							
						int nbrtotal=0;int nbr=0;
						for(c=0;c<Tab.length;c++)//une boucle qui va parcourir le tableau Tab
						{for (int c2=0;c2<Frame1.frame_1.E.size();c2++)//une boucle qui va parcourir la liste des Electeurs
							{if (Tab[c]==Frame1.frame_1.E.get(c2).getBurvote())//si la case courante du Tab (qui contient le bureau de la Région du Bureau courant est trouvée dans la liste des Electeurs alors on va incrémenter le nombre des électeurs inscrits (nbrtotal)
								nbrtotal++;
							if (Tab[c]==Frame1.frame_1.E.get(c2).getBurvote()&& Frame1.frame_1.E.get(c2).getSituation()=="Voté")//si la case courante du Tab (qui contient le bureau de la Région du Bureau courant est trouvée dans la liste des Electeurs et la situation de cet electeur est voté alors on va incrémenter le nombre des electeurs inscrits qui ont voté (nbr)
								nbr++;
							}
						}
						if (nbrtotal!=0 && nbr!=0) //pour que la division ou la multiplication ne soit pas par 0
						tauxr.append(ch+" : "+(nbr*100)/nbrtotal+" %\n");
						else 
							tauxr.append(ch+" : "+"0 %\n");//sinon on affiche 0%
						}
						
						}
//affichage par tranche d'âge						
						tauxa.setText("");
						tauxa.append("Par Tranche d'âge:\n\n");
						int a=18; int b= 28;
						for (int i=0;i<10;i++)
						{ int nbr=0;int nbrtotal=0;
							for (int c=0;c<Frame1.frame_1.E.size();c++)
							{if (Frame1.frame_1.E.get(c).getAge()>=a && Frame1.frame_1.E.get(c).getAge()<b)
								nbrtotal++;
							if (Frame1.frame_1.E.get(c).getAge()>=a && Frame1.frame_1.E.get(c).getAge()<b && Frame1.frame_1.E.get(c).getSituation()=="Voté")
								nbr++;
							}
							if (nbrtotal!=0 && nbr!=0) //pour que la division ou la multiplication ne soit pas par 0
								tauxa.append("["+a+".."+b+"["+" : "+(nbr*100)/nbrtotal+" %\n");
							else 
								tauxa.append("["+a+".."+b+"["+" : "+0+" %\n");//sinon on affiche 0%
							
							a=a+10;
							b=b+10;
							
						}
							
						
				
				}											
			});
			btnAffich.setForeground(Color.WHITE);
			btnAffich.setBackground(new Color(225, 13, 25));
			btnAffich.setBounds(420, 550, 283, 36);
			contentPane.add(btnAffich);	
			
			tauxr = new JTextArea();
			tauxr.setText("");
			tauxr.setFont(new Font("Monospaced", Font.BOLD, 16));
			tauxr.setEditable(false);
			tauxr.setBounds(350, 230, 200, 200);
			contentPane.add(tauxr);
			
			tauxa = new JTextArea();
			tauxa.setText("");
			tauxa.setFont(new Font("Monospaced", Font.BOLD, 16));
			tauxa.setEditable(false);
			tauxa.setBounds(650, 230, 400, 400);
			contentPane.add(tauxa);
			
			label = new JLabel("");
			label.setBounds(40, 170, 293, 293);
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
			retourlbl.setBounds(10, 465, 100, 100);
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
						TauxVoteGlobal frame = new TauxVoteGlobal();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
			
			
}
