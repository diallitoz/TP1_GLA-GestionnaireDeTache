package task.manager.model;

public class Task {

	private int id;
	private String name;
	private String description;
	private String status = "NOUVEAU";
	private String idMember;
	private String assignStatus = "NON";

	// constructors
	public Task() {

	}

	public Task(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		// this.status = status;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIdMember() {
		return idMember;
	}

	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}

	public String getAssignStatus() {
		return assignStatus;
	}

	public void setAssignStatus(String assignStatus) {
		this.assignStatus = assignStatus;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return "id = " + id + " name = " + name + " description = " + description + " status = " + status;
	}
}
