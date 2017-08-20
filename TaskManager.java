package task.manager.main;

import task.manager.utils.Menu;
import task.manager.utils.TaskUtils;

import java.util.ArrayList;
import java.util.Scanner;

import task.manager.model.Assign;
import task.manager.model.Member;
import task.manager.model.Task;
import task.manager.utils.AssignUtils;
import task.manager.utils.MemberUtils;

public class TaskManager {

	static ArrayList<Member> mList = new ArrayList<>();
	static ArrayList<Task> tList = new ArrayList<>();
	static ArrayList<Assign> aList = new ArrayList<>();

	static MemberUtils mu = new MemberUtils();
	static TaskUtils tu = new TaskUtils();
	static AssignUtils au = new AssignUtils();

	static Scanner keyb = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cmd = "o";
		String choix = "0";
		// int Id = 0;

		Menu.displayWelcomeMsg();

		do {
			// affichage du menu principal
			Menu.displayPrincipalMenu();
			choix = keyb.nextLine();
			if (choix.equals("1")) {

				// Gestion des membres de l'equipe

				mu.gererMembre(mList);

			} else if (choix.equals("2")) {

				// Gestion des taches

				tu.gererTache(tList, mList, aList);

			} else if (choix.equals("3"))

			{
				// Recherche des taches

				tu.rechercherTache(tList, mList, aList);

			} else if (choix.equals("4")) {
				tu.afficherListeTache(tList);
			} else if (choix.equals("5")) {
				mu.afficherListeMembre(mList);

			} else if (choix.equals("6")) {
				quitterProgramme();

			} else if (!choix.equals("1") && !choix.equals("2") && !choix.equals("3") && !choix.equals("4")
					&& !choix.equals("5") && !choix.equals("6")) {
				choixIncorrect();
			}

		} while (cmd.toUpperCase().equals("O"));
	}

	////////////////

	// Methode pour quitter le programme
	static void quitterProgramme() {
		System.out.println("\nMerci d'avoir utiliser notre gestionnaire de taches!");
		System.out.print("Good bye... ");
		System.exit(-1);
	}

	public static boolean verifyInput(String entier) {
		boolean v = false;
		try {
			// on essaie de convertir la chaîne en nombre entier
			Integer.parseInt(entier);
			// conversion aboutie, v prend la valeur true
			v = true;
		} catch (Exception e) {
			// conversion échouée, levée d'une exception, v prend false
			v = false;
		}
		// on retourne v
		return v;
	}

	// Methode pour les choix non corrects
	static void choixIncorrect() {
		String cmd;
		System.out.println("\nVous avez fait un choix non correct");
		do {
			System.out.print("Voulez-vous continuer?(o/n): ");
			cmd = keyb.nextLine();
			if (!cmd.equals("o") && !cmd.equals("n")) {
				System.out.println("Veuillez taper soit 'o' pour OUI soit 'n' pour NON ");
			}

			if (cmd.equals("n")) {
				quitterProgramme();
			}

		} while (!cmd.toUpperCase().equals("O") && !cmd.toUpperCase().equals("N"));
	}
}
