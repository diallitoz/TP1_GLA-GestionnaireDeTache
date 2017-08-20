package task.manager.utils;

import java.util.ArrayList;
import java.util.Scanner;

import task.manager.model.Assign;
import task.manager.model.Member;
import task.manager.model.Task;

public class TaskUtils {
	static Scanner keyb = new Scanner(System.in);

	static MemberUtils mu = new MemberUtils();
	static TaskUtils tu = new TaskUtils();
	static AssignUtils au = new AssignUtils();
	// static TaskManager tk = new TaskManager();

	///////////////// GESTION DES TACHES

	public void gererTache(ArrayList<Task> tList, ArrayList<Member> mList, ArrayList<Assign> aList) {
		String itemMenu = "0";
		boolean cmd2 = true;
		do {
			Menu.displayMenuTaskManager();

			itemMenu = keyb.nextLine();
			if (itemMenu.equals("1")) {
				creerTache(tList);

			} else if (itemMenu.equals("2")) {
				modifierTache(tList, mList, aList);

			} else if (itemMenu.equals("3")) {
				supprimerTache(tList);

			} else if (itemMenu.equals("4")) {
				assignerTache(tList, mList, aList);

			} else if (itemMenu.equals("5")) {
				assignerTache(tList, mList, aList);

			} else if (itemMenu.equals("6")) {
				cmd2 = false;
			} else if (itemMenu.equals("7")) {
				quitterProgramme();
			} else if (!itemMenu.equals("1") && !itemMenu.equals("2") && !itemMenu.equals("3") && !itemMenu.equals("4")
					&& !itemMenu.equals("5") && !itemMenu.equals("6") && !itemMenu.equals("7")) {
				choixIncorrect();
			}

		} while (cmd2);

	}

	// Methode pour creer une nouvelle tache
	static void creerTache(ArrayList<Task> tList) {
		boolean test = false;
		do {
			System.out.print("\nNom de la nouvelle tache : ");
			String nom = keyb.nextLine();
			System.out.print("\nDescription : ");
			String description = keyb.nextLine();
			Task new_t = new Task(0, nom, description);
			test = tu.createTask(tList, new_t);
			/*
			 * if (test == false) { System.out.
			 * println("Si vous voulez utiliser le meme NOM veuillez changer la DESCRIPTION alors!!! "
			 * ); System.out.println(
			 * " Oubien Si vous voulez utiliser la meme DESCRIPTION veuillez changer de NOM alors!!! "
			 * ); }
			 */
		} while (test == false);
	}

	// Methode pour modifier une tache
	public void modifierTache(ArrayList<Task> tList, ArrayList<Member> mList, ArrayList<Assign> aList) {
		tu.displayList(tList);

		System.out.println("********************************************************************* ");
		boolean test = false;

		if (!tList.isEmpty()) {

			do {

				Task task;
				int idTask;
				String input = "";

				do {

					do {

						System.out.print("\nSaisir l'identifiant de la tache à modifier : ");
						input = keyb.nextLine();
						if (!verifyInput(input)) {
							System.out.println("Saisie incorrecte, veuiller reprendre");
						}

					} while (!verifyInput(input));

					idTask = Integer.parseInt(input);

					task = tu.getTaskById(tList, idTask);

					if (task == null) {
						System.out.print("\nLa tache que vous avez specifee n'existe pas dans la liste des taches ");
						System.out.println("\nMerci de selectionner une tache existante ");
					}

				} while ((task == null));

				boolean cmd4 = true;
				do {

					Menu.displayTypeModificationTaskMenu();
					String itemMenu1 = keyb.nextLine();
					if (itemMenu1.equals("1")) {

						test = modifyTaskName(task);
						cmd4 = false;

					} else if (itemMenu1.equals("2")) {

						test = modifyTaskDescription(task);
						cmd4 = false;

					} else if (itemMenu1.equals("3")) {

						test = modifyTaskStatus(task);
						cmd4 = false;

					} else if (itemMenu1.equals("4")) {

						assignerTache(tList, mList, aList);

					}

					else if (itemMenu1.equals("5")) {
						cmd4 = false;
						test = true;
						// Menu.displayPrincipalMenu();
					} else if (itemMenu1.equals("6")) {
						quitterProgramme();
					}

					else if (!itemMenu1.equals("1") && !itemMenu1.equals("2") && !itemMenu1.equals("3")
							&& !itemMenu1.equals("4") && !itemMenu1.equals("5") && !itemMenu1.equals("6")) {
						choixIncorrect();
					}

				} while (cmd4);
			} while (test == false);
		}

	}

	public void rechercherTache(ArrayList<Task> tList, ArrayList<Member> mList, ArrayList<Assign> aList) {
		String itemMenu = "0";
		// tu.displayList(tList);
		if (!tList.isEmpty()) {

			boolean cmd3 = true;
			do {

				// affichage du Menu pour la recherche des taches

				Menu.displayTypeSearchTaskMenu();

				itemMenu = keyb.nextLine();
				if (itemMenu.equals("1")) {

					System.out.println("Les taches assignees par membre est : ");

					au.displayList(aList);

				} else if (itemMenu.equals("2")) {

					boolean cmd4 = true;
					do {

						Menu.displayTaskStatusMenu();
						String itemMenu1 = keyb.nextLine();
						if (itemMenu1.equals("1")) {

							displayListTachByStatusNouveau(tList);

						} else if (itemMenu1.equals("2")) {

							displayListTachByStatusEnProgres(tList);

						} else if (itemMenu1.equals("3")) {

							displayListTachByStatusTermine(tList);

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

		}

		else {
			tu.displayList(tList);
		}

	}

	// Methode pour supprimer une tache
	static void supprimerTache(ArrayList<Task> tList) {
		tu.displayList(tList);
		System.out.println("********************************************************************* ");
		boolean test = false;

		if (!tList.isEmpty()) {
			do {
				Task task;
				int idTask;
				String input = "";

				do {

					do {

						System.out.print("\nSaisir l'identifiant de la tache à supprimer : ");
						input = keyb.nextLine();
						if (!verifyInput(input)) {
							System.out.println("Saisie incorrecte, veuiller reprendre");
						}

					} while (!verifyInput(input));

					idTask = Integer.parseInt(input);

					task = tu.getTaskById(tList, idTask);

					if (task == null) {
						System.out.print("\nLa tache que vous avez specifee n'existe pas dans la liste des taches ");
						System.out.println("\nMerci de selectionner une tache existante ");
					}

				} while ((task == null));

				test = tu.delTask(tList, idTask);
			} while (test == false);

		}
	}

	// Methode pour afficher la liste des taches
	public static void afficherListeTache(ArrayList<Task> tList) {
		tu.displayList(tList);
	}

	// Methode pour assigner une tache a un membre
	static void assignerTache(ArrayList<Task> tList, ArrayList<Member> mList, ArrayList<Assign> aList) {
		///
		boolean test = false;
		afficherListeTache(tList);
		System.out.println("\n****************************************************************** ");
		mu.afficherListeMembre(mList);
		System.out.println("\n****************************************************************** ");

		if (!tList.isEmpty() && !mList.isEmpty()) {
			do {
				int idTask;
				int idMember;
				Task task;
				String input = "";

				do {

					do {
						System.out.print("\nSaisir l'identifiant de la tache à assigner : ");
						input = keyb.nextLine();
						if (!verifyInput(input)) {
							System.out.println("Saisie incorrecte, veuiller reprendre");
						}

					} while (!verifyInput(input));

					idTask = Integer.parseInt(input);

					// Methode pour verifier si la tache existe

					task = tu.getTaskById(tList, idTask);

					if (task == null) {
						System.out.print("\nLa tache que vous avez specifee n'existe pas dans la liste des taches ");
						System.out.println("\nMerci de selectionner une tache existante ");
					}
				} while ((task == null));
				// } while (!verifyInput(input) || (task == null));

				Member memb;

				do {

					do {

						System.out.print("Saisir l'identifiant du membre à qui doit etre assigne la tache : ");
						input = keyb.nextLine();
						if (!verifyInput(input)) {
							System.out.println("Saisie incorrecte, veuiller reprendre");
						}

					} while (!verifyInput(input));

					idMember = Integer.parseInt(input);

					// Methode pour verifier si le membre existe

					memb = mu.getMemberById(mList, idMember);

					if (memb == null) {
						System.out.print("\nLe membre que vous avez specife n'existe pas dans la liste des membres ");
						System.out.println("\nMerci de selectionner un membre existant ");
					}

				} while ((memb == null));

				Assign newAssign = new Assign(0, idTask, idMember);
				test = au.createAssign(aList, newAssign);

				if (test) {
					task = tu.getTaskById(tList, idTask);
					int indTask = tList.indexOf(task);
					task.setAssignStatus("OUI");
					tList.set(indTask, task);
					// System.out.println(newAssign);

				}
			} while (test == false);
		}

	}

	// Methode pour ajouter une tache a un membre
	static void ajouterTache() {
		///
	}

	public boolean createTask(ArrayList<Task> aList, Task task) {
		if (task.getName().trim().equals("") || task.getDescription().trim().equals("")) {
			System.out.println("Saisie incorrecte!");
			return false;
		} else {
			Task res = searchTaskNameAndDescription(aList, task.getName(), task.getDescription());
			if (res != null) {
				System.out.println("La tache : " + res.getName());
				System.out.println("Description : " + res.getDescription());
				System.out.println("existe deja!!!");
				System.out.println("Si vous voulez utiliser le meme NOM veuillez changer la DESCRIPTION alors!!! ");
				System.out.println(
						" Oubien Si vous voulez utiliser la meme DESCRIPTION veuillez changer de NOM alors!!! ");
				return false;
			} else {
				task.setId(aList.size() + 1);
				aList.add(task);
				System.out.println("La tache a ete créée avec SUCCES!");
				return true;
			}
		}
	}

	public boolean addTask(ArrayList<Task> aList, Task task) {
		Task res = searchTaskNameAndDescription(aList, task.getName(), task.getDescription());
		if (res != null) {
			System.out.println("Le membre " + res.getName() + " existe deja!");
			return false;
		} else {
			task.setId(aList.size() + 1);
			aList.add(task);
			System.out.println("Ajout effectue!");
			return true;
		}
	}

	public boolean modifyTaskName(Task task) {
		String rep = "";
		// Task task = getTaskById(aList, id);
		if (task != null) {
			System.out.print("Veuiller saisir le NOUVEAU NOM de la tache : ");
			rep = keyb.nextLine();
			if (rep.trim().equals("")) {
				System.out.println("Saisie de nom incorrecte!");
				return false;
			} else {
				task.setName(rep);
				System.out.println("Modification effectuee avec SUCCES!");
				return true;
			}

		} else {
			System.out.print("Cette tache n'existe pas!");
			return false;
		}

	}

	public boolean modifyTaskDescription(Task task) {
		String rep = "";
		// Task task = getTaskById(aList, id);
		if (task != null) {
			System.out.print("Veuiller saisir la NOUVELLE DESCRIPTION  de la tache : ");
			rep = keyb.nextLine();
			if (rep.trim().equals("")) {
				System.out.println("Saisie de nom incorrecte!");
				return false;
			} else {
				task.setDescription(rep);
				System.out.println("Modification effectuee avec SUCCES!");
				return true;
			}

		} else {
			System.out.print("Cette tache n'existe pas!");
			return false;
		}

	}

	public boolean modifyTaskStatus(Task task) {
		String rep = "";
		// Task task = getTaskById(aList, id);
		if (task != null) {
			System.out.print("Veuiller choisir le STATUS la de la tache : ");
			Menu.displaySetStatusTaskMenu();
			rep = keyb.nextLine();
			if (rep.equals("1")) {
				task.setStatus("NOUVEAU");
				System.out.println("Modification effectuee avec SUCCES!");
				return true;
			} else if (rep.equals("2")) {
				task.setStatus("EN_PROGRES");
				System.out.println("Modification effectuee avec SUCCES!");
				return true;
			} else if (rep.equals("3")) {
				task.setStatus("TERMINE");
				System.out.println("Modification effectuee avec SUCCES!");
				return true;
			}

			else {
				choixIncorrect();
				return false;
			}

		} else {
			System.out.print("Cette tache n'existe pas!");
			return false;
		}

	}

	public Task searchTaskNameAndDescription(ArrayList<Task> aList, String name, String description) {
		Task result = null;
		for (Task task : aList) {
			if (task.getName().equals(name) && task.getDescription().equals(description))
				result = task;
		}
		return result;
	}

	public Task getTaskById(ArrayList<Task> aList, int id) {
		Task result = null;
		for (Task task : aList) {
			if (task.getId() == id)
				result = task;
		}
		return result;
	}

	public boolean delTask(ArrayList<Task> aList, int id) {
		Task task = getTaskById(aList, id);
		if (task != null) {
			String rep = "";

			do {
				System.out.print("Voulez-vous vraiment supprimer cette tache (o/n) ??? : ");

				rep = keyb.nextLine();

				if (rep.equals("o")) {

					aList.remove(task);
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
			System.out.print("\nCette tache n'existe pas!");
			return false;
		}
	}

	public void reorganizeIds(ArrayList<Task> aList) {
		if (!aList.isEmpty()) {
			for (Task task : aList) {
				int index = aList.indexOf(task);
				task.setId(index + 1);
				aList.set(index, task);
			}
		}
	}

	public void displayList(ArrayList<Task> aList) {
		if (!aList.isEmpty()) {
			System.out.println("\nLa liste des taches est :");
			System.out.println("------------------------------------------------------------------------- ");
			System.out.print("ID    |   NOM  -   DESCRIPTION  -  STATUS  -  ASSIGNE\n");
			for (Task task : aList) {
				System.out.println("------------------------------------------------------------------------- ");
				System.out.print(task.getId() + "     |   " + task.getName() + "  -   " + task.getDescription()
						+ "  -   " + task.getStatus() + "  -   " + task.getAssignStatus() + "\n");
			}
		} else {
			System.out.println("\nLa liste des taches est vide!");
		}
	}

	public void displayListTachByStatusNouveau(ArrayList<Task> tList) {
		if (!tList.isEmpty()) {
			System.out.println("\nLa liste des nouvelles taches est :");
			System.out.println("------------------------------------------------------------------------- ");
			System.out.print("ID    |   NOM  -   DESCRIPTION  -  STATUS\n");
			for (Task task : tList) {
				if (task.getStatus().equals("NOUVEAU")) {
					System.out.println("------------------------------------------------------------------------- ");
					System.out.print(task.getId() + "     |   " + task.getName() + "  -   " + task.getDescription()
							+ "  -   " + task.getStatus() + "\n");

				}
			}
		} else {
			System.out.println("\nLa liste des taches est vide!");
		}
	}

	public void displayListTachByStatusEnProgres(ArrayList<Task> tList) {
		if (!tList.isEmpty()) {
			System.out.println("\nLa liste des taches en progres est :");
			System.out.println("------------------------------------------------------------------------- ");
			System.out.print("ID    |   NOM  -   DESCRIPTION  -  STATUS\n");
			for (Task task : tList) {
				if (task.getStatus().equals("EN_PROGRES")) {
					System.out.println("------------------------------------------------------------------------- ");
					System.out.print(task.getId() + "     |   " + task.getName() + "  -   " + task.getDescription()
							+ "  -   " + task.getStatus() + "\n");

				}
			}
		} else {
			System.out.println("\nLa liste des taches est vide!");
		}
	}

	public void displayListTachByStatusTermine(ArrayList<Task> tList) {
		if (!tList.isEmpty()) {
			System.out.println("\nLa liste des taches terminees est :");
			System.out.println("------------------------------------------------------------------------- ");
			System.out.print("ID    |   NOM  -   DESCRIPTION  -  STATUS\n");
			for (Task task : tList) {
				if (task.getStatus().equals("TERMINE")) {
					System.out.println("------------------------------------------------------------------------- ");
					System.out.print(task.getId() + "     |   " + task.getName() + "  -   " + task.getDescription()
							+ "  -   " + task.getStatus() + "\n");

				}
			}
		} else {
			System.out.println("\nLa liste des taches est vide!");
		}
	}

	/*
	 * // Methode pour afficher Liste membre static void afficherListeMembre() {
	 * mu.displayList(mList); }
	 */
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

	/*
	 * public static boolean verifyInput(Object obj) { try { int val =
	 * Integer.parseInt(obj.toString()); return true; } catch (Exception ex) {
	 * return false; } }
	 */

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
