package entities;

public class BuilderEntity {
	 private static String firstName;
	 private static String lastName;
	 private static String phno;
	 private static String email;
	 private static String password;
	 
	 public BuilderEntity() {}

	public BuilderEntity setFirstName(String firstName) {
		BuilderEntity.firstName = firstName;
		return this;
	}

	public BuilderEntity setLastName(String lastName) {
		BuilderEntity.lastName = lastName;
		return this;
	}


	public BuilderEntity setPhno(String phno) {
		BuilderEntity.phno = phno;
		return this;
	}


	public BuilderEntity setEmail(String email) {
		BuilderEntity.email = email;
		return this;
	}


	public BuilderEntity setPassword(String password) {
		BuilderEntity.password = password;
		return this;
	}
	 
	 public static User build() {
		 return new User(firstName, lastName, phno, email, password);
	 }
	 
}
