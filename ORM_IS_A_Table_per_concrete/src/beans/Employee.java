package beans;

public class Employee {

	private int id;
	private String name;
	private String email;
	private int salary;
	
	public Employee()
	{
		
	}

	public Employee(int id, String name, String email, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getSalary() {
		return salary;
	}
	
}
