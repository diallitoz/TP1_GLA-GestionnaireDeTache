package task.manager.utils;

import java.util.ArrayList;
import java.util.Scanner;

import task.manager.model.Member;

public class MemberUtils {

	static Scanner keyb = new Scanner(System.in);

	static MemberUtils mu = new MemberUtils();

	///////////////// GESTION DES MEMBRES

	public void gererMembre(ArrayList<Member> mList) {
		String itemMenu = "0";

		boolean cmd1 = true;
		do {
			Menu.displayMenuMemberManager();

			itemMenu = keyb.nextLine();
			if (itemMenu.equals("1")) {
				creerMembre(mList);

			} else if (itemMenu.equals("2")) {
				modifierMembre(mList);

			} else if (itemMenu.equals("3")) {
				supprimerMembre(mList);

			} else if (itemMenu.equals("4")) {
				cmd1 = false;
				// Menu.displayPrincipalMenu();
			} else if (itemMenu.equals("5")) {
				quitterProgramme();

			} else if (!itemMenu.equals("1") && !itemMenu.equals("2") && !itemMenu.equals("3") && !itemMenu.equals("4")
					&& !itemMenu.equals("5")) {
				choixIncorrect();
			}
		} while (cmd1);
	}

	// Methode pour creer un nouveau membre
	static void creerMembre(ArrayList<Member> mList) {
		boolean test = false;
		do {
			System.out.print("\nNom du nouveau membre: ");
			String nom = keyb.nextLine();
			Member new_m = new Member(0, nom);
			test = mu.addMember(mList, new_m);
			/*
			 * if (test == false) { System.out.println(
			 * "Si vous voulez utiliser le meme NOM veuillez ajouter un INDICE DE DIFFERENCIATION!!! "
			 * ); }
			 */
		} while (test == false);

	}

	// Methode pour modifier un membre
	static void modifierMembre(ArrayList<Member> mList) {
		mu.displayList(mList);
		System.out.println("********************************************************************* ");
		boolean test = false;
		do {
			if (!mList.isEmpty()) {
				Member memb;
				int idMember;
				String input = "";

				do {

					do {

						System.out.print("\nSaisir l'identifiant du membre à modifier : ");
						input = keyb.nextLine();
						if (!verifyInput(input)) {
							System.out.println("Saisie incorrecte, veuiller reprendre");
						}

					} while (!verifyInput(input));

					idMember = Integer.parseInt(input);

					memb = mu.getMemberById(mList, idMember);

					if (memb == null) {
						System.out.print("\nLe membre que vous avez specife n'existe pas dans la liste des membres ");
						System.out.println("\nMerci de selectionner un membre existant ");
					}

				} while ((memb == null));

				test = mu.modifyMemberName(mList, idMember);

			}

		} while (test == false);

	}

	// Methode pour supprimer un membre
	static void supprimerMembre(ArrayList<Member> mList) {
		mu.displayList(mList);
		System.out.println("********************************************************************* ");
		boolean test = false;
		do {
			if (!mList.isEmpty()) {
				Member memb;
				int idMember;
				String input = "";

				// System.out.println("\ntSaisir l'identifiant du membre à
				// supprimer: ");
				// String id = keyb.nextLine();
				// test = mu.delMember(mList, Integer.parseInt(id));

				do {

					do {

						System.out.print("\nSaisir l'identifiant du membre à supprimer : ");
						input = keyb.nextLine();
						if (!verifyInput(input)) {
							System.out.println("Saisie incorrecte, veuiller reprendre");
						}

					} while (!verifyInput(input));

					idMember = Integer.parseInt(input);

					memb = mu.getMemberById(mList, idMember);

					if (memb == null) {
						System.out.print("\nLe membre que vous avez specife n'existe pas dans la liste des membres ");
						System.out.println("\nMerci de selectionner un membre existant ");
					}

				} while ((memb == null));

				test = mu.delMember(mList, idMember);
			}

		} while (test == false);
	}

	// Methode pour afficher Liste membre
	public void afficherListeMembre(ArrayList<Member> mList) {
		mu.displayList(mList);
	}

	public boolean addMember(ArrayList<Member> aList, Member memb) {
		if (memb.getName().trim().equals("")) {
			System.out.println("Saisie de nom incorrecte!");
			return false;
		} else {
			Member res = searchMember(aList, memb.getName());
			if (res != null) {
				System.out.println("Le membre " + res.getName() + " existe deja!");
				System.out.println(
						"Si vous voulez utiliser le meme NOM veuillez ajouter un INDICE DE DIFFERENCIATION!!! ");
				return false;
			} else {
				memb.setId(aList.size() + 1);
				aList.add(memb);
				System.out.println("Membre ajouté avec SUCCES!");
				return true;
			}

		}
	}

	public boolean modifyMemberName(ArrayList<Member> aList, int id) {
		String rep = "";
		Member memb = getMemberById(aList, id);
		if (memb != null) {
			System.out.print("Veuiller saisir le NOUVEAU NOM du membre : ");
			rep = keyb.nextLine();
			if (rep.trim().equals("")) {
				System.out.println("Saisie de nom incorrecte!");
				return false;
			} else {
				memb.setName(rep);
				System.out.println("Modification effectuee avec SUCCES!");
				return true;
			}

		} else {
			System.out.print("Ce membre n'existe pas!");
			return false;
		}

	}

	public Member searchMember(ArrayList<Member> aList, String name) {
		Member result = null;
		for (Member memb : aList) {
			if (memb.getName().equals(name))
				result = memb;
		}
		return result;
	}

	public Member getMemberById(ArrayList<Member> aList, int id) {
		Member result = null;
		for (Member memb : aList) {
			if (memb.getId() == id)
				result = memb;
		}
		return result;
	}

	public boolean delMember(ArrayList<Member> aList, int id) {

		Member memb = getMemberById(aList, id);
		if (memb != null) {
			String rep = "";

			do {
				System.out.print("Voulez-vous vraiment supprimer ce membre (o/n) ??? : ");

				rep = keyb.nextLine();

				if (rep.equals("o")) {

					aList.remove(memb);
					reorganizeIds(aList);// Nous avons decide de reorganiser
											// automatiquement les Id
											// Mais cela n,est qu'un choix de
											// conception, Tout depend
											// de l'objectif de l'utilisateur
					System.out.print("\nSuppression effectuee!");
					return true;

				} else if (rep.equals("n")) {
					System.out.print("\nSuppression annulee!!!");
					return true;
				} else {
					System.out.print("\nSaisie incorrecte, veuillez reprendre!!!");
					return false;
				}
			} while (!rep.toUpperCase().equals("O") && !rep.toUpperCase().equals("N"));

		} else {
			System.out.print("Ce membre n'existe pas!");
			return false;
		}
	}

	public void reorganizeIds(ArrayList<Member> aList) {
		if (!aList.isEmpty()) {
			for (Member memb : aList) {
				int index = aList.indexOf(memb);
				memb.setId(index + 1);
				aList.set(index, memb);
			}
		}
	}

	public void displayList(ArrayList<Member> aList) {
		if (!aList.isEmpty()) {
			System.out.println("La liste des membres est :");
			System.out.println("----------------------------------------------------------------- ");
			System.out.print("ID    |   NOM\n");
			for (Member memb : aList) {
				System.out.println("----------------------------------------------------------------- ");
				System.out.print(memb.getId() + "     |   " + memb.getName() + "\n");
			}
		} else {
			System.out.println("La liste des membres est vide!");
		}
	}
	
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
