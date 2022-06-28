package GestionElecteurs;

public class Electeur {

	private String nom;
	private String prenom;
	private String cin;
	private int age;
	private int burvote;
	private String situation;
	private String choix;
	private String heure;
	
	 public Electeur(String nom,String pren,String cin,int age, int burvote,String situation,String heure, String choix) {
		 this.nom=nom;
		 this.prenom=pren;
		 this.cin=cin;
		 this.age=age;
		 this.burvote=burvote;
		 this.heure=heure;
		 this.situation=situation;
		 this.choix=choix;
	 }
	 
	 public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getCin() {
			return cin;
		}

		public void setCin(String cin) {
			this.cin = cin;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getBurvote() {
			return burvote;
		}

		public void setBurvote(int burvote) {
			this.burvote = burvote;
		}
		
		public String getHeure() {
			return heure;
		}

		public void setHeure(String heure) {
			this.heure = heure;
		}

		public String getSituation() {
			return situation;
		}

		public void setSituation(String situation) {
			this.situation = situation;
		}

		public String getChoix() {
			return choix;
		}

		public void setChoix(String choix) {
			this.choix = choix;
		}
		
		
}
