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

		Menu.displayWelcomeMsg();

		do {
			// affichage du menu principal
			Menu.displayPrincipalMenu();
			choix = keyb.nextLine();
			String itemMenu = "0";
			if (choix.equals("1")) {

				// affichage du Menu pour la gestion des membres de l'equipe
				
				mu.gererMembre(mList);
				

			} else if (choix.equals("2")) {
				// affichage du Menu pour la gestion des taches

				tu.gererTache(tList, mList, aList);
				
				
			} else if (choix.equals("3"))

			{
				// affichage du Menu pour la recherche des taches
				boolean cmd3 = true;
				do {

					Menu.displayTypeSearchTaskMenu();

					itemMenu = keyb.nextLine();
					if (itemMenu.equals("1")) {

						System.out.println("taches assignees a un membre");

					} else if (itemMenu.equals("2")) {

						boolean cmd4 = true;
						do {

							Menu.displayTaskStatusMenu();
							String itemMenu1 = keyb.nextLine();
							if (itemMenu1.equals("1")) {
								System.out.println("taches nouvelles");
							} else if (itemMenu1.equals("2")) {
								System.out.println("taches en progres");
							} else if (itemMenu1.equals("3")) {
								System.out.println("taches terminees");
							} else if (itemMenu1.equals("4")) {
								cmd4 = false;
							} else if (itemMenu1.equals("5")) {
								cmd4 = false;
								cmd3 = false;
								// Menu.displayPrincipalMenu();
							}

							else if (itemMenu1.equals("6")) {
								quitterProgramme();
							}

							else if (!itemMenu1.equals("1") && !itemMenu1.equals("2") && !itemMenu1.equals("3")
									&& !itemMenu1.equals("4") && !itemMenu1.equals("5") && !itemMenu1.equals("6")) {
								choixIncorrect();
							}

						} while (cmd4);

					} else if (itemMenu.equals("3")) {
						cmd3 = false;
					} else if (itemMenu.equals("4")) {
						quitterProgramme();
					} else if (!itemMenu.equals("1") && !itemMenu.equals("2") && !itemMenu.equals("3")
							&& !itemMenu.equals("4")) {
						choixIncorrect();
					}
				} while (cmd3);

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
