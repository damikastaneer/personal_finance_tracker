package nl.dami.fintrack.util;

import nl.dami.fintrack.model.User;

public class SessionManager {

    private static User currentUser;

    public static void setCurrentUser(User user){
        currentUser = user;
    }

    public static User getCurrentUser(){
        return currentUser;
    }

    public static String getCurrentUserId(){
        return currentUser != null ? currentUser.getId() : null;
    }

    public static void logout() {
        currentUser = null;
    }
}
