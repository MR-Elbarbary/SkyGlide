package skyglide.classes.athentecation;

public interface AuthenticationStrategy {
    boolean authenticate(String username, String password);
}