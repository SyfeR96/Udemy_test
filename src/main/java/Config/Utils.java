package Config;

public class Utils {

    private final String EMAIL_FOR_REGISTRATION = System.currentTimeMillis() + "@appcreative.net";

    private final String NAME_FOR_REGISTRATION = "Jacob";

    private final String PASSWORD_FOR_REGISTRATION = "Qwerty1234";

    public String getName () {
        return NAME_FOR_REGISTRATION;
    }

    public String getPassword () {
        return PASSWORD_FOR_REGISTRATION;
    }

    public String getEmailForRegistration () {
        return EMAIL_FOR_REGISTRATION; }


    public String getSearchText() {
        return "Angular";
    }



}
