import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Formulario {
    public static final String path = "C:\\Users\\Arthur\\Documents\\Arthur\\programação\\LALALA\\src\\Formulario\\formulario.txt";
    public static ArrayList<String> reader() throws IOException { // read the file
        Scanner input = new Scanner(System.in);
        ArrayList<String> user = new ArrayList<>();

        BufferedReader bf = new BufferedReader(new FileReader(path));
        String line = bf.readLine();

        int i = 0;
        while(line != null){
            System.out.println(line);
            String resposta = input.nextLine();
            if(i==0 && resposta.length()<10){
                System.out.println("nome deve contar pelo menos 10 caracteres");
                continue;
            }

            if(i==1){
                if(!EmailValidation.isValidEmail(resposta) || Arquivo.searchUser(resposta)){
                    continue;
                }
            }

            if(i==2){
                int respostaIdade = Integer.parseInt(resposta);
                if(respostaIdade<18){
                    System.out.println("Idade tem que ser maior que 18");
                    continue;
                }
            }

            if(i==3){
                if(!HeightValidation.isValidHeight(resposta)){
                    System.out.println("Altura tem que ter virgula");
                    continue;
                }
            }

            user.add(resposta);
            line = bf.readLine();
            i+=1;
        }

        return user;
    }
    public static void addNewQuestion(){
        ArrayList<String> questions = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        try {
            BufferedReader file = new BufferedReader(new FileReader(path));
            String line = file.readLine();
            while (line != null){
                questions.add(line);
                line = file.readLine();
            }
            System.out.println("Digite a pergunta a ser adicionada: ");
            String question = input.nextLine();

            questions.add(question);

            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for(int i = 0;i<questions.size();i++){
                String quest = questions.get(i);
                if(!Character.isDigit(quest.charAt(0))){
                    quest = (i+1) + " - "+quest;
                }
                writer.append(quest+"\n");
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deletQuestion(){
        ArrayList<String> questions = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        try {
            BufferedReader file = new BufferedReader(new FileReader(path));
            String line = file.readLine();
            while (line != null){
                questions.add(line);
                line = file.readLine();
            }
            System.out.println("Número da pergunta a ser apagada: ");
            String question = input.nextLine();
            int questionInt = Integer.parseInt(question);
            if(questionInt <= 4){
                System.out.println("só pode removar as novas perguntas criadas");
            }else{
                questions.remove(questionInt-1);
                BufferedWriter writer = new BufferedWriter(new FileWriter(path));
                for(int i = 0;i<questions.size();i++){
                    String quest = questions.get(i);
                    String questReplace = "";
                    int num = quest.charAt(0)-'0';
                    if(num > questionInt){
                        questReplace = quest.replace(num+"",""+(i+1));
                        writer.append(questReplace+"\n");
                    }else{
                        writer.append(quest+"\n");
                    }

                }
                writer.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
