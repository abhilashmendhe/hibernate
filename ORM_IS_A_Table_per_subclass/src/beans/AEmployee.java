package beans;

public class AEmployee extends Employee{

	private String branchname;
	
	public AEmployee() {}
	
	public AEmployee(int id, String name, String email, int salary, String branchname) {
		super(id, name, email, salary);
		this.branchname = branchname;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	
}
