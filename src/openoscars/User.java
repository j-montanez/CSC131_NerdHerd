package openoscars;

public class User {
    private static String email;
    private static String theme;

    public static String getTheme() {
        return theme;
    }

    public static void setTheme(String theme) {
        User.theme = theme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
