package openoscars;

public class User {
    private static String email;
    private static String theme;
    private static String search;

    public static String getTheme() {
        return theme;
    }

    public static void setTheme(String theme) {
        User.theme = theme;
    }

    public static String getSearch() {
        return search;
    }

    public static void setSearch(String search) {
        User.search = search;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
