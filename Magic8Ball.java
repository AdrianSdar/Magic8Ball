import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Magic8Ball {
        public static void main(String[] args) throws IOException{
        magic8BallFrame();
        questionInputs();
    }
    
    private static void magic8BallFrame(){
        System.out.println("==================\n\nMAGIC    8    BALL\n\n==================\n");
    }
    
    private static void questionInputs() throws IOException{
        Scanner input = new Scanner(System.in);
        String answer = "";
        while(!answer.equalsIgnoreCase("exit")){
            System.out.print("Your question please: ");
            answer = input.nextLine();
            System.out.println();
            answers();
        }
        System.out.println("See you next time...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        input.close();
    }
    private static void answers() throws IOException{
        FileReader fileReader = new FileReader("C:\\Users\\adria\\Downloads\\magic8ball.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> answers = new ArrayList<>();
        String line;
        while((line = bufferedReader.readLine()) != null){
            answers.add(line);
        }
        Random random = new Random();
        int randomIndex = random.nextInt(answers.size());
        String randomAnswer = answers.get(randomIndex);
        System.out.println(randomAnswer);
        System.out.println();
        bufferedReader.close();
    }
}
