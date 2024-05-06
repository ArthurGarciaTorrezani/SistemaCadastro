import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
    public static boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile("^(.+)@(\\S+)");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
