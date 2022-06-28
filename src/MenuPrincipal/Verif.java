package MenuPrincipal;

public class Verif {
	

	public static boolean alpha(String s) {//cette methode vérifie si la chaine donnée ne contient uniquement que des lettres
	      
	      int len = s.length();
	      for (int i = 0; i < len; i++) {
	         if ((Character.isLetter(s.charAt(i)) == false) && s.charAt(i)!=' ') //si le caractère courant n'est pas une lettre ni une espace alors return false	        	
	            return false;			}
	      return true;
	   }

	  public static boolean digit (String s) {//cette methode vérifie si la chaine donnée ne contient uniquement que des chiffres
	      if (s == "") //vérifie si la chaine est vide ou pas
	         return false;
	      
	      int len = s.length();
	      for (int i = 0; i < len; i++) {
	         if ((Character.isDigit(s.charAt(i)) == false))//si le caractère courant est n'est pas numérique(un chiffre) alors return false  {
	            return false;			}
	      return true;
	   }
	
	  public static boolean Aldig (String s) {//cette methode vérifie si la chaine donnée ne contient uniquement que des lettres et des chiffres
	      if (s == "") //vérifie si la chaine est vide ou pas
	         return false;
	      
	      int len = s.length();
	      for (int i = 0; i < len; i++) {
	         if ((Character.isDigit(s.charAt(i)) == false) && (Character.isLetter(s.charAt(i)) == false) && s.charAt(i)!=' ') {//si le caractère courant n'est ni une lettre ni un chiffre ni un espace alors return false
	            return false;
	         }
	      }
	      return true;
	   }
		public static boolean verifcin(String ch)//cette méthode vérifie la validité d'une CIN donnée 
		{int i=0; boolean test=true;
		if (ch.length()!=8)//la longueur est # 8
			test=false;
		else //la longueur=8
		{while(i<ch.length() && test)
			{if (ch.charAt(i)<'0' && ch.charAt(i)>'9' ) //elle ne doit contenir que des chiffres
				test=false;
			else i++;		
			}
		}
		return test; 

		}
		
		
		 public static boolean verifdate(String ch)//cette méthode vérifie le format de la date donnée ainsi que sa validité 
		 {boolean res=true;;
			 if (ch.length()!=10 || ch.charAt(2)!='/' || ch.charAt(5)!='/')
			 res=false;
		 else
		 {String chj=ch.substring(0,2);
		  String chm=ch.substring(3,5);
		  String cha=ch.substring(6,10);
		  int jj=Integer.parseInt(chj);
		  int mm=Integer.parseInt(chm);
		  int aa=Integer.parseInt(cha);
		  switch(mm)//vérification du mois
		  {case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
			  if(jj>31)//vérification du jour
				  {System.out.println("Selon le mois que vous avez donné, le jour doit être <= 31 !");
				  res=false;}
			  break;
		  case 4: case 6: case 9: case 11:
			  if (jj>30)
			  {System.out.println("Selon le mois que vous avez donné, le jour doit être <= 30 !");
			  res=false;}
		  break;
		  case 2:
			  if ( (aa % 4==0 && aa % 100!=0) || (aa % 400==0) )//année bissextile
			  {if (jj>29)//vérification du jour
			  {System.out.println("L'année est bissextile\nSelon le mois que vous avez donné, le jour doit être <= 29 !");
			  res=false;}}
			  else {//année non bissextile
				  if (jj>28)
				  {System.out.println("L'année n'est pas bissextile\nSelon le mois que vous avez donné, le jour doit être <= 28 !");
				  res=false;}
			  }
				  break;
				  default: System.out.println("Le mois n'existe pas !\nVérifier le mois saisi !");//mois non valide
				  res=false;
			  }
		  
		  }
			 return res;
			 		 
		 }


}//end class
