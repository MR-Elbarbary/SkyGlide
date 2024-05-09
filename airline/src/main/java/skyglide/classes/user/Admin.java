package skyglide.classes.user;

public class Admin extends User {

    public Admin(int id, String username, String password, String role) {
        super(id, username, password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }
}
