package plane;

public class person {
	private String User;
	private String pwd;
	int id;
	
	person(String User, String pwd, int id){
		this.User = User;
		this.pwd = pwd;
		this.id = id;
	}
	
	person(String User, String pwd){
		this.User = User;
		this.pwd = pwd;
	}
	
	person(){
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}