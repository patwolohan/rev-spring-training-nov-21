package ie.rc.userdao;

public class User {
	
	// member variables
	private int id;
	private String name;
	private String email;
	private boolean active;
	
	// member functions
	
	// constructors
	public User() {
		super();
	}
	
	public User(int id, String name, String email, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.active = active;
	}
	public User(String name, String email, boolean active) {
		super();
		this.name = name;
		this.email = email;
		this.active = active;
	}

	// get & set methods
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	// toString
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", active=" + active + "]";
	}	

	// equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (active != other.active)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		User u = new User(1, "Alice", "alice@gmail.com", false);
		
		System.out.println(u);
	}




}
