package constants;

import java.util.HashMap;

/**
 * Created by Matus on 23.11.2016.
 */
public final class Constants {

    //users
    public static final HashMap<String, String> usersMap;
    static{
        usersMap = new HashMap<>();
        usersMap.put("user1", "123");
        usersMap.put("user2", "123");
    }

    //layouts
    public static final String LAYOUT_LOGIN = "../layouts/loginLayout.fxml";
    public static final String LAYOUT_USER1 = "../layouts/loginLayout.fxml";
    public static final String LAYOUT_USER2 = "../layouts/loginLayout.fxml";

    public static final int MAXIMUM_NOTES = 5;
    public static final int MIN_ROW_INDEX = 2;
    public static final int SUBSTRING_START = 18;
    public static final int SUBSTRING_END = 44;
    public static final int DELETE_BUTTON_SUBSTRING_INDEX = 2;

    public static final String NUMBER_OF_NOTES_ERROR = "Number of notes can't be greater than 5";
    public static final String FAILED_LOGIN_RESPONSE = "Invalid user name or password";
    public static final String EMPTY_FIELDS_LOGIN_RESPONSE = "Fields can't be empty";
    public static final String FAILED_SAVE_EMPTY_NOTE = "Can't save empty note";

}
