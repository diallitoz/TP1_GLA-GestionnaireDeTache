package task.manager.model;

public class Assign {
	
	private int id;
	private int idMember;
	private int idTask;
	
	// constructors
	public Assign() {
		
	}

	public Assign(int id, int idMember, int idTask) {
		//super();
		this.id = id;
		this.idMember = idMember;
		this.idTask = idTask;
	}

	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMember() {
		return idMember;
	}

	public void setIdMmember(int idMember) {
		this.idMember = idMember;
	}

	public int getIdTask() {
		return idTask;
	}

	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}

	@Override
	public String toString() {
		return "Assign [id=" + id + ", id_member=" + idMember + ", id_task=" + idTask + "]";
	}
	
}
