package task.manager.model;

public class Member {

	private int id;
	private String name;

	// constructors
	public Member() {

	}

	public Member(int id, String name) {
		this.id = id;
		this.name = name;
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

	public String toString() {
		return "id = " + id + " name = " + name;
	}
}
