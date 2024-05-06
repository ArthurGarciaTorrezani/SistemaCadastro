import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    private HashMap<Integer, String> menU = new HashMap<>();
    public Menu(){
        menU.put(1,"1 - Cadastrar o usuário");
        menU.put(2,"2 - Listar todos usuários cadastrados");
        menU.put(3,"3 - Cadastrar nova pergunta no formulário");
        menU.put(4,"4 - Deletar pergunta do formulário");
        menU.put(5,"5 - Pesquisar usuário por nome ou idade ou email");
    }

    public void viewMenu() throws IOException {
        Set<Integer> keys = menU.keySet();
        for(Integer key:keys){
            String opcao = menU.get(key);
            System.out.println(opcao);
        }
        Scanner input = new Scanner(System.in);
        String escolha = input.nextLine();

        if(escolha.equals("1")){
            System.out.println("Cirar usuário: "); // user
            User.createUser();
        }

        if(escolha.equals("2")){
            System.out.println("Lista de todos os usuários: "); // user
            Arquivo.getAllUsers();
        }

        if(escolha.equals("3")){
            System.out.println("Adicionar nova pergunta: "); // form
            Formulario.addNewQuestion();
        }

        if(escolha.equals("4")){
            System.out.println("Apagar uma pergunta: "); // form
            Formulario.deletQuestion();
        }

        if(escolha.equals("5")){
            System.out.println("Pesquisar usuarios: "); // user
            Arquivo.searchUsers();
        }
    }
}
