package beans;

public class Student {

	private int id;
	private String name;
	private String email;
	private int marks;
	private int allrank;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public int getMarks() {
		return marks;
	}
	
	public void setAllrank(int allrank) {
		this.allrank = allrank;
	}
	
	public int getAllrank() {
		return allrank;
	}
}

