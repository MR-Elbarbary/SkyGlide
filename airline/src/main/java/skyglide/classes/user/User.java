package skyglide.classes.user;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;

    private static int logedid;
    private static String logedusername;
    private static String logedpassword;
    private static String logedemail;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getter and setter methods for the fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public static void setLogedemail(String logedemail) {
        User.logedemail = logedemail;
    }
    public static void setLogedid(int logedid) {
        User.logedid = logedid;
    }
    public static void setLogedpassword(String logedpassword) {
        User.logedpassword = logedpassword;
    }
    public static void setLogedusername(String logedusername) {
        User.logedusername = logedusername;
    }
    public static String getLogedemail() {
        return logedemail;
    }
    public static int getLogedid() {
        return logedid;
    }
    public static String getLogedpassword() {
        return logedpassword;
    }
    public static String getLogedusername() {
        return logedusername;
    }

    public void logout(){
        logedemail = "";
        logedid = 0;
        logedpassword = "";
        logedusername = "";
    }

    // toString method to provide a string representation of the object
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}