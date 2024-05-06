import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeightValidation {
    public static boolean isValidHeight(String idade){
        Pattern pattern = Pattern.compile("^[0-9]\\,[0-9]");
        Matcher matcher = pattern.matcher(idade);
        return matcher.matches();
    }
}
