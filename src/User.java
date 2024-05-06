import java.io.IOException;
import java.util.ArrayList;

public class User {
    public static void createUser(){

        try {
            ArrayList<String> user = Formulario.reader();
            Arquivo arquivo = new Arquivo(user.get(0));
            arquivo.createFile();
            arquivo.writeInFile(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
