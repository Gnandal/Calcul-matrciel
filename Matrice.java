package matrices;

import java.util.Scanner;

public class Matrice {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		boolean quitter = false;
		do {
			try {
				menu();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.print("Voulez vous continuer (true/false) : ");
			quitter = sc.nextBoolean();
		}while(quitter);

		sc.close();
	}


	static void menu() throws Exception{
		System.out.println("Bienvenu le programme de calcul matricielle :");

		System.out.println("---------------------------------------------");
		System.out.println("Voici le menu qui vous est disposée :");
		System.out.println("\t1 - pour faire la somme de deux matrices");
		System.out.println("\t2 - pour faire la diffenrce de deux matrices");
		System.out.println("\t3 - pour faire la produit d'une matrice par un scalaire");
		System.out.println("\t4 - pour faire le produit de deux matrices");
		System.out.println("\t5 - pour determiner la transposée d'une matrice");
		System.out.println("\t6 - pour calculer le determinant d'une matrice 2x2");
		System.out.println("\t7 - pour calculer le determinant d'une matrice 3x3");
		
		System.out.print("Choix : ");
		int choix = sc.nextInt();

		switch(choix) {
		case 1 : int[][] matrice1 = initMatrice("A"), matrice2 = initMatrice("B");
			remplissage(matrice1, "A");
			remplissage(matrice2, "B");
			int[][] matriceSomme = addDeuxMatrices(matrice1, matrice2);
			affichageMatrice(matriceSomme);
			break;
		case 2 :  int[][] matrice3 = initMatrice("A"), matrice4 = initMatrice("B");
			remplissage(matrice3, "A");
			remplissage(matrice4, "B");
			int[][] matriceDiff = diffDeuxMatrices(matrice3, matrice4);
			affichageMatrice(matriceDiff);
			break;
		case 3 : int[][] matrice = initMatrice("A");
			remplissage(matrice, "A");
			int scalaire = sc.nextInt();
			int[][] matriceProduit = produitMatriceAvecScalaire(matrice, scalaire);
			affichageMatrice(matriceProduit);
			break;
		case 4 : int[][] matrice5 = initMatrice("A"), matrice6 = initMatrice("B");
			remplissage(matrice5, "A");
			remplissage(matrice6, "B");
			int[][] matriceProd = produitDeDeuxMatrices(matrice5, matrice6);
			affichageMatrice(matriceProd);
			break;
		case 5 : int[][] matriceTrans = initMatrice("A");
			remplissage(matriceTrans, "A");
			matriceTrans = transposition(matriceTrans);
			affichageMatrice(matriceTrans);
			break;
		case 6 : int[][] matrice2D = new int[2][2];
			remplissage(matrice2D, "2D");
			affichageMatrice(matrice2D);
			int determinant2D = determinant2D(matrice2D);
			System.out.println("Le determinant de la matrice entrer est : " + determinant2D);
			break;
		case 7 : int[][] matrice3D = new int[2][2];
			remplissage(matrice3D, "3D");
			affichageMatrice(matrice3D);
			int determinant3D = determinant2D(matrice3D);
			System.out.println("Le determinant de la matrice entrer est : " + determinant3D);
			break;
		default : System.out.println("Ce choix n'est pas pris en compte");
		}
	}

	static int[][] initMatrice(String name) {
		int[][] matrice = null;
		System.out.println("Definisser la matrice "+name+" : ");
		System.out.print("Ligne : ");
		int n = sc.nextInt();
		System.out.print("Colone : ");
		int m = sc.nextInt();

		if(n > 0 && m > 0) {
			matrice = new int[n][m];
		}
		else initMatrice(name);
		return matrice;
	}

	static void remplissage(int[][] matrice, String name) {
		int i = 0;
		
		System.out.println("Remplissage de la matrice "+name+" : ");
		
		for(int[] ligne : matrice){
			for(int j = 0; j < ligne.length; j++) {
				System.out.print("Veillez sairsir la donnée de ligne "+i+" && colone "+j+" : ");
				matrice[i][j] = sc.nextInt();
			}
			i++;
		}
	}

	static void affichageMatrice(int[][] matrice) {
		System.out.println("------Affichage de la matrice------");
		if (matrice != null) {
			for(int[] ligne : matrice) {
				for(int value : ligne) {
					System.out.print("  "+value);
				}
				System.out.println();
			}
		}
		else System.out.println("## - L'Opération matricielle effectuée a échoué !");
		
	}

	static int[][] addDeuxMatrices(int[][] matrice1, int[][] matrice2) throws Exception {
		int nbreLigneMatrice1 = matrice1.length, nbreLigneMatrice2 = matrice2.length,
				nbreColoneMatrice1 = matrice1[0].length, nbreColoneMatrice2 = matrice2[0].length;

		if(nbreLigneMatrice1 == nbreLigneMatrice2 && nbreColoneMatrice1 == nbreColoneMatrice2) {
			int[][] matriceSomme = new int[nbreLigneMatrice1][nbreColoneMatrice1];
			for(int i = 0; i < nbreLigneMatrice1; i++) {
				for(int j = 0; j < nbreColoneMatrice1; j++) {
					matriceSomme[i][j] = matrice1[i][j] + matrice2[i][j];
				}
			}

			return matriceSomme;
		}
		else throw new Exception("Les deux matrices ne repondent pas aux conditions necessaires pour ce calcul");
	}

	static int[][] diffDeuxMatrices(int[][] matrice1, int[][] matrice2) throws Exception {
		int nbreLigneMatrice1 = matrice1.length, nbreLigneMatrice2 = matrice2.length,
				nbreColoneMatrice1 = matrice1[0].length, nbreColoneMatrice2 = matrice2[0].length;

		if(nbreLigneMatrice1 == nbreLigneMatrice2 && nbreColoneMatrice1 == nbreColoneMatrice2) {
			int[][] matriceSomme = new int[nbreLigneMatrice1][nbreColoneMatrice1];
			for(int i = 0; i < nbreLigneMatrice1; i++) {
				for(int j = 0; j < nbreColoneMatrice1; j++) {
					matriceSomme[i][j] = matrice1[i][j] - matrice2[i][j];
				}
			}

			return matriceSomme;
		}
		else throw new Exception("Les deux matrices ne repondent pas aux conditions necessaires pour ce calcul");
	}

	static int[][] produitMatriceAvecScalaire(int[][] matrice, int scalaire) {
		int nbreLigneMatrice = matrice.length, nbreColoneMatrice = matrice[0].length;

		if(nbreLigneMatrice > 0 && nbreColoneMatrice > 0) {
			int[][] matriceProduit = new int[nbreLigneMatrice][nbreColoneMatrice];
			for(int i = 0; i < nbreLigneMatrice; i++) {
				for(int j = 0; j < nbreColoneMatrice; j++) {
					matriceProduit[i][j] = matrice[i][j] * scalaire;
				}
			}

			return matriceProduit;
		}

		return null;
	}

	static int[][] produitDeDeuxMatrices(int[][] matrice1, int[][] matrice2) throws Exception {
		int nbreLigneMatrice1 = matrice1.length, nbreLigneMatrice2 = matrice2.length,
				nbreColoneMatrice1 = matrice1[0].length, nbreColoneMatrice2 = matrice2[0].length;

		if(nbreColoneMatrice1 == nbreLigneMatrice2) {
			int[][] matriceProduit = new int[nbreLigneMatrice1][nbreColoneMatrice2];

			for(int i = 0; i < nbreLigneMatrice1; i++) {
				for(int j = 0; j < nbreColoneMatrice2; j++) {
					int value = 0;
					for(int k = 0; k < nbreColoneMatrice1; i++) {
						value += matrice1[i][k] * matrice2[k][j];
					}
					matriceProduit[i][j] = value;
				}
			}

			return matriceProduit;
		}
		
		else {
			throw new Exception("Les deux matrices ne repondent pas aux conditions necessaires pour ce calcul");
		}
	}

	static int[][] transposition(int[][] matrice) throws Exception{
		int nbreLigneMatrice = matrice.length, nbreColoneMatrice = matrice[0].length;

		if(nbreColoneMatrice > 0 && nbreLigneMatrice > 0) {
			int[][] matriceTransposee = new int[nbreColoneMatrice][nbreLigneMatrice];
			for(int i = 0; i < nbreColoneMatrice; i++) {
				for(int j = 0; j < nbreLigneMatrice; j++) {
					matriceTransposee[i][j] = matrice[j][i];
				}
			}
			return matriceTransposee;
		}
		else {
			throw new Exception("La matrice fourni n'est pas valide !");
		}
	}	

	static int determinant2D(int[][] matrice) throws Exception {
		int determinant = 0;
		int nbreLigneMatrice = matrice.length, nbreColoneMatrice = matrice[0].length;

		if(nbreColoneMatrice == nbreLigneMatrice && nbreColoneMatrice == 2) {
			determinant = matrice[0][0] * matrice[1][1] - matrice[1][0] * matrice[0][1];
		}
		else{
			throw new Exception("Les deux matrices ne repondent pas aux conditions necessaires pour ce calcul");
		}

		return determinant;
	}

	static int determinant3D(int[][] matrice) throws Exception {
		int determinant = 0;
		int nbreLigneMatrice = matrice.length, nbreColoneMatrice = matrice[0].length;

		if(nbreColoneMatrice == nbreLigneMatrice && nbreColoneMatrice == 3) {
			for(int i = 0; i < nbreLigneMatrice; i++) {
				int[][] matrice2D = new int[2][2];
				for(int j = 0; j < 2; j++) {
					for(int k = 0; k < 2; k++) {
						matrice2D[j][k] = matrice[(i+k+1)%3][(j+k+1)%3];
					}
				}
				determinant += ((i % 2 == 0) ? 1:  -1)*matrice[0][i]*determinant2D(matrice2D);
			}

		}
		else {
			throw new Exception("Les deux matrices ne repondent pas aux conditions necessaires pour ce calcul");
		}

		return determinant;
	}

}
