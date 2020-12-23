package genshinApp;

public class User {
	
	private int id;
	private String name;
	
	public User(int i, String n) {
		this.id = i;
		this.name = n;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
