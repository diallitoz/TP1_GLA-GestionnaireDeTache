package task.manager.utils;

public class Menu {

	public static void displayWelcomeMsg() {
		StringBuilder aAfficher = new StringBuilder();
		String separateur = "\n*****************************************************************";
		aAfficher.append(separateur);
		aAfficher.append("\n Bienvenue dans le gestionnaire de taches d'une equipe de travail ");
		aAfficher.append("\n Cette apllication a ete developpee par DIALLO Azise Oumar ");
		aAfficher.append(separateur);
		System.out.println(aAfficher);
	}

	public static void displayPrincipalMenu() {
		StringBuilder aAfficher = new StringBuilder();
		String separateur = "\n******************************************************";
		aAfficher.append(separateur);
		aAfficher.append("\n*************** Menu Principal ***********************");
		aAfficher.append(separateur);
		aAfficher.append("\n1- Pour gerer les membres");
		aAfficher.append("\n2- Pour gerer les taches");
		aAfficher.append("\n3- Pour rechercher des taches ");
		aAfficher.append("\n4- Pour consulter la liste des taches ");
		aAfficher.append("\n5- Pour consulter la liste des membres ");
		aAfficher.append("\n6- Pour quitter le programme ");
		aAfficher.append(separateur);
		aAfficher.append("\n\nVeuillez specifier votre choix: ");
		System.out.print(aAfficher);
	}

	public static void displayMenuTaskManager() {
		StringBuilder aAfficher = new StringBuilder();
		String separateur = "\n******************************************************";
		aAfficher.append(separateur);
		aAfficher.append("\nMenu pour la gestion des taches");
		aAfficher.append(separateur);
		aAfficher.append("\n1- Creer une nouvelle tache");
		aAfficher.append("\n2- Modifier une tache");
		aAfficher.append("\n3- Supprimer une tache");
		aAfficher.append("\n4- Ajouter une tache à un membre");
		aAfficher.append("\n5- Assigner une tache à un membre");
		aAfficher.append("\n6- Revenir au MENU PRINCIPAL");
		aAfficher.append("\n7- Pour quitter le programme ");
		aAfficher.append(separateur);
		aAfficher.append("\n\nVeuillez specifier votre choix: ");
		System.out.print(aAfficher);
	}

	public static void displayMenuMemberManager() {
		StringBuilder aAfficher = new StringBuilder();
		String separateur = "\n******************************************************";
		aAfficher.append(separateur);
		aAfficher.append("\nMenu pour la gestion des membres de l'equipe");
		aAfficher.append(separateur);
		aAfficher.append("\n1- Creer un nouveau membre");
		aAfficher.append("\n2- Modifier un membre");
		aAfficher.append("\n3- Supprimer un membre");
		aAfficher.append("\n4- Revenir au MENU PRINCIPAL");
		aAfficher.append("\n5- Pour quitter le programme ");
		aAfficher.append(separateur);
		aAfficher.append("\n\nVeuillez specifier votre choix: ");
		System.out.print(aAfficher);
	}

	public static void displayTaskStatusMenu() {
		StringBuilder aAfficher = new StringBuilder();
		String separateur = "\n**********************************************************";
		aAfficher.append(separateur);
		aAfficher.append("\nMenu pour la recherche et l'affichage des taches par STATUS");
		aAfficher.append(separateur);
		aAfficher.append("\n1- Rechercher nouvelles taches");
		aAfficher.append("\n2- Rechercher les taches en progrès");
		aAfficher.append("\n3- Rechercher les taches terminées");
		aAfficher.append("\n4- Revenir au MENU DE LA RECHERCHE");
		aAfficher.append("\n5- Revenir au MENU PRINCIPAL ");
		aAfficher.append("\n6- Pour quitter le programme ");
		aAfficher.append(separateur);
		aAfficher.append("\n\nVeuillez specifier votre choix: ");
		System.out.print(aAfficher);
	}

	public static void displayTypeSearchTaskMenu() {
		StringBuilder aAfficher = new StringBuilder();
		String separateur = "\n******************************************************";
		aAfficher.append(separateur);
		aAfficher.append("\nMenu pour le type de recherche à effectuer");
		aAfficher.append(separateur);
		aAfficher.append("\n1- Rechercher les taches  assignées à un membre");
		aAfficher.append("\n2- Rechercher les taches en fonction de leur status");
		aAfficher.append("\n3- Revenir au MENU PRINCIPAL");
		aAfficher.append("\n4- Pour quitter le programme ");
		aAfficher.append(separateur);
		aAfficher.append("\n\nVeuillez specifier votre choix: ");
		System.out.print(aAfficher);
	}

	public static void displayTypeModificationTaskMenu() {
		StringBuilder aAfficher = new StringBuilder();
		String separateur = "\n******************************************************";
		aAfficher.append(separateur);
		aAfficher.append("\nMenu pour la MODIFICATION d'une TACHE");
		aAfficher.append(separateur);
		aAfficher.append("\n1- Modifier le NOM d'une TACHE");
		aAfficher.append("\n2- Modifier la DESCRIPTION d'une TACHE");
		aAfficher.append("\n3- Modifier le STATUS d'une TACHE");
		aAfficher.append("\n4- Modifier l'ASSIGNATEUR d'une TACHE");
		aAfficher.append("\n5- Revenir au MENU DE GESTION des taches");
		aAfficher.append("\n6- Pour quitter le programme ");
		aAfficher.append(separateur);
		aAfficher.append("\n\nVeuillez specifier votre choix: ");
		System.out.print(aAfficher);
	}

	public static void displaySetStatusTaskMenu() {
		StringBuilder aAfficher = new StringBuilder();
		String separateur = "\n******************************************************";
		aAfficher.append(separateur);
		aAfficher.append("\nMenu pour changement du STATUS d'une TACHE");
		aAfficher.append(separateur);
		aAfficher.append("\n1- Mettre le status a NOUVEAU");
		aAfficher.append("\n2- Mettre le status a EN_PROGRES");
		aAfficher.append("\n3- Mettre le status a TERMINER");
		aAfficher.append(separateur);
		aAfficher.append("\n\nVeuillez specifier votre choix: ");
		System.out.print(aAfficher);
	}

}
