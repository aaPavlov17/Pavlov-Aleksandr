package user;

public class User {
  public String firstName;
  public String lastName;

  public User(String firstName, String lastName) throws IllegalArgumentException {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
