package task.manager.utils;

import java.util.ArrayList;

import task.manager.model.Assign;
public class AssignUtils {

	public boolean createAssign(ArrayList<Assign> aList, Assign ass) {
		if (ass.getIdTask() == 0) {/// A completer......
			System.out.println("Saisie de Id incorrect!");
			return false;
		} else {
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
			System.out.println(aList);
		} else {
			System.out.println("La liste des taches est vide!");
		}
	}

}
