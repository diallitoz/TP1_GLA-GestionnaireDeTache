package task.manager.utils;

import java.util.ArrayList;

import task.manager.model.Assign;

public class AssignUtils {

	public boolean createAssign(ArrayList<Assign> aList, Assign ass) {
		Assign res = searchAssign(aList, ass.getIdTask(), ass.getIdMember());
		if (res != null) {
			System.out.println("Cette tache " + res.getIdTask() + " est deja assignée a " + res.getIdMember());
			return false;
		} else {
			ass.setId(aList.size() + 1);
			aList.add(ass);
			System.out.println("Tache assignée avec SUCCES!!!");
			return true;
		}
	}

	public Assign searchAssign(ArrayList<Assign> aList, int idTask, int idMember) {
		Assign result = null;
		for (Assign ass : aList) {
			if (ass.getIdTask() == idTask && ass.getIdMember() == idMember)
				result = ass;
		}
		return result;
	}

	public void displayList(ArrayList<Assign> aList) {
		if (!aList.isEmpty()) {
			System.out.println("La liste des taches assignees est :");
			System.out.println("----------------------------------------------------------------- ");
			System.out.print("ID    -   Id de la tache  -   Id du Assiganteur \n");
			for (Assign asign : aList) {
				System.out.println("----------------------------------------------------------------- ");
				System.out.print(asign.getId() + "         -        " + asign.getIdTask() + "         -        "
						+ asign.getIdMember() + "\n");
			}

		} else {
			System.out.println("La liste des taches est vide!");
		}
	}
}
