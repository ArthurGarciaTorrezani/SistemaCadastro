import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Arquivo {
    static String path = "C:\\Users\\Arthur\\Documents\\Arthur\\programação\\LALALA\\src\\Files\\";
    public Arquivo(String name) throws IOException {
        String namePath = name.replaceAll("\s+","").toUpperCase(); // tirar os espaços em branco
        path += namePath+".txt";
    }
//    public static void reader() throws IOException { // read the file
//        BufferedReader bf = new BufferedReader(new FileReader(path));
//        String line = bf.readLine();
//        while(line != null){
//            System.out.println(line);
//            line = bf.readLine();
//        }
//    }
    public void createFile(){ // create a file
        java.io.File file = new java.io.File(path);
        try{
            file.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void writeInFile( ArrayList<String> user) throws IOException { // escrever no arquivo
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for(String linha:user){
                writer.write(linha);
                writer.newLine();
            }
            writer.flush();
            writer.close(); // Importante fechar o arquivo para garantir escrita
        }catch (Exception e){
                e.printStackTrace();
        }
    }
    public static void getAllUsers() throws IOException {
        File paasta = new File(path);
        String[] pastas = paasta.list();

        int i = 1;
        for(String pasta:pastas){
            BufferedReader bf = new BufferedReader(new FileReader(path+pasta));
            System.out.println(i+" - "+bf.readLine());
            i+=1;
        }
    }
    public static void searchUsers() throws IOException {
        File paasta = new File(path);
        Scanner input = new Scanner(System.in);
        String[] pastas = paasta.list();
        Arrays.stream(pastas).sorted();

        System.out.println("Digite o usuário a ser buscado: ");
        String user = input.nextLine();
        String[] users = new String[2];

        int countUsers = 0;
        for(String pasta:pastas){
            if(countUsers == 2){
                break;
            }

            String userFormatado = user.toLowerCase();

            BufferedReader bf = new BufferedReader(new FileReader(path+pasta));
            String line = bf.readLine();
            String lineComparation = line.toLowerCase();
            String name = line;
            // nome
            if (lineComparation.contains(userFormatado)){
                users[countUsers] = name;
                countUsers+=1;
                System.out.println(name);
                continue;
            }

            // email
            lineComparation = bf.readLine().toLowerCase();
            if (lineComparation.contains(userFormatado)){
                users[countUsers] = name;
                countUsers+=1;
                System.out.println(name);
            }

            //idade
            lineComparation = bf.readLine().toLowerCase();
            if (lineComparation.contains(userFormatado)){
                users[countUsers] = name;
                countUsers+=1;
                System.out.println(name);
            }
        }
    }

    public static boolean searchUser(String email) throws IOException {
        File paasta = new File(path);
        String[] pastas = paasta.list();

        for(String pasta:pastas){
            BufferedReader bf = new BufferedReader(new FileReader(path+pasta));
            String line = bf.readLine();
            line = bf.readLine();
            if(line.equals(email)){
                System.out.println("email ja cadastrado");
                return true;
            }
        }
        return false;
    }

}
