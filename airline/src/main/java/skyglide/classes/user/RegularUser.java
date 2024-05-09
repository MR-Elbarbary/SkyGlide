package skyglide.classes.user;

public class RegularUser extends User {
    public RegularUser(int id, String username, String password) {
        super(id, username, password);
    }

    @Override
    public String toString() {
        return "RegularUser{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }
}