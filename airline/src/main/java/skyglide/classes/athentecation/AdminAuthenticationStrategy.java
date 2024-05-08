package skyglide.classes.athentecation;

import skyglide.classes.DatabaseConnection;

public class AdminAuthenticationStrategy implements AuthenticationStrategy {
    @Override
    public boolean authenticate(String username, String password) {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        return databaseConnection.isValidAdmin(username, password);
    }
} 