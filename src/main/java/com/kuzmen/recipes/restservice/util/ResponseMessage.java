package com.kuzmen.recipes.restservice.util;


@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class ResponseMessage {
    //Constants
    //result
    public static final String RESULT_FAILURE = "Failure";
    public static final String RESULT_SUCCESS = "Success";
    //message
    //Failure
    public static final String MSG_FAILURE_PARAMETRES = "Invalid parametres!";
    public static final String MSG_FAILURE_PARAMETRES_EMPTY = "Parametres should not be empty!";

    public static final String MSG_FAILURE_EMAIL = "Invalid email!";
    public static final String MSG_FAILURE_USER_EXIST = "User already registred!";
    public static final String MSG_FAILURE_REGISTRATION = "Registration failure!";
    public static final String MSG_FAILURE_LOGIN = "Invalid login credentials!";
    //Success

    public static final String MSG_SUCCESS_REGISTRED = "You have successfully registred!";
    public static final String MSG_SUCCESS_LOGGED_IN = "You logged in!";
    public static final String MSG_SUCCESS_PASSWORD_CHANGED = "Password changed succesfully";


    private String result;
    private String message;
    private String token;




}
