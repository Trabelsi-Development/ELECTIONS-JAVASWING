package GestionPartis;

public class Partis {
	private String nom ;
	private String symbole ;
	private String president ;
	private int nbr_adh ;
	private String datedeb;
	private String ideologie;
	
	 public Partis(String n,String s,String p,int nbr, String dated, String ideo) {
		 nom=n ;
		 symbole=s ;
		 president=p ;
		 nbr_adh=nbr ;
		 datedeb=dated;
		 ideologie=ideo;
	 }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}

	public int getNbr_adh() {
		return nbr_adh;
	}

	public void setNbr_adh(int nbr_adh) {
		this.nbr_adh = nbr_adh;
	}

	public String getDatedeb() {
		return datedeb;
	}

	public void setDatedeb(String datedeb) {
		this.datedeb = datedeb;
	}

	public String getIdeologie() {
		return ideologie;
	}

	public void setIdeologie(String ideologie) {
		this.ideologie = ideologie;
	}
	
}
