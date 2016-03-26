public class Employee {

  private int id;
  private String name;
  private String phone;
  private String supervisor;
  private String username;
  private String password;

  	public Employee(int id, String name, String phone, String supervisor,
                  String username, String password)
        {
          this.setEmployeeID(id);
          this.setName(name);
          this.setPhone(phone);
          this.setSupervisor(supervisor);
          this.setUsername(username);
          this.setPassword(password);
        }
  
  	public Employee() {
	    //nothing here
	  }

	public void setEmployeeID(int id) {
		this.id = id;	
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
			
	public int getId() {
		return id;
	  }

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}