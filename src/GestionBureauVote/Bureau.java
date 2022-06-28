package GestionBureauVote; 

import java.util.ArrayList;

import GestionElecteurs.Electeur;
import GestionElecteurs.Frame1;

public class Bureau {
	private int numero ;//numero de bureau
	private String adresse ;//adresse de bureau
	private String region  ;//region de bureau
	private ArrayList<Electeur> IE;//liste des electeurs inscrits dans ce bureau 
	
	public Bureau() {
		numero=0 ;
		adresse="";
		region="" ;
		IE=new ArrayList<Electeur>() ;
		
		Frame1 GE=new Frame1() ;
		ArrayList<Electeur>	E=	GE.getElecteur() ;
		for (int i=0;i<E.size();i++) {
			if (E.get(i).getBurvote()==numero) {
				IE.add(E.get(i));
			}
		}
	
	}
	public Bureau(int numero ,String adresse,String region) {
		this.numero=numero  ;
		this.adresse=adresse;
		this.region=region ;
		IE=new ArrayList<Electeur>() ;
		
		Frame1 GE=new Frame1() ;
		ArrayList<Electeur>	E=	GE.getElecteur() ;
		for (int i=0;i<E.size();i++) {
			if (E.get(i).getBurvote()==numero) {
				IE.add(E.get(i));
			}
		}

	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public ArrayList<Electeur> getIE() {	
		return IE ;
	}
	public void setIE(ArrayList<Electeur> IE) {
		this.IE = IE;
	}
	
	
}
