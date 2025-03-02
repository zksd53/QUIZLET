import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\tWelcome to Quizer App");
        Scanner scnr = new Scanner(System.in);
        boolean check = true;
        
        while (check) {
            userOptions();
            int userValue = 0;
            
            while (true) {
                userValue = scnr.nextInt();
                if (userValue >= 1 && userValue <= 4) {
                    break;
                } else {
                    System.out.println("Enter value between 1 and 4");
                }
            }
            
            if (userValue == 4) {
                exit();
                break;
            } else {
                operator(userValue, scnr);
            }
        }
        
        scnr.close();
    }
    
    public static void userOptions() {  
        System.out.println("1.) Create new Quiz");
        System.out.println("2.) Take Quiz");
        System.out.println("3.) Check Score");
        System.out.println("4.) Exit the game");
    }
    
    public static String[] newQuiz(Scanner scnr, int quizLength) {
        String[] questionHolder = new String[quizLength];
        scnr.nextLine();
        for (int i = 0; i < quizLength; i++) {  
            System.out.println("Enter your question " + (i + 1) + ":");
            questionHolder[i] = scnr.nextLine().trim();  
        }
        return questionHolder;
    }
    
    public static String[] quizSolution(Scanner scnr, int quizLength) {
        String[] answerHolder = new String[quizLength];
        for (int i = 0; i < quizLength; i++) {  
            System.out.println("Enter the answer for question " + (i + 1) + ":");
            answerHolder[i] = scnr.nextLine().trim();  
        }
        return answerHolder;
    }
    
    public static int[] randomQuestion(int quizLength) {
        int[] randomQuestion = new int[quizLength];
        for (int i = 0; i < quizLength; i++) {
            randomQuestion[i] = i;
        }
        return randomQuestion;
    }
    
    public static String[] quizInitializer(Scanner scnr, int[] questionSet, String[] questions) {
        String[] userSolution = new String[questions.length];
        for (int i = 0; i < questionSet.length; i++) {
            System.out.println(questions[questionSet[i]]);
            userSolution[i] = scnr.nextLine().trim();
        }
        return userSolution;
    }
    
    public static void answerMatching(String[] correctAnswers, String[] userAnswers, int[] questionSet) {
        int count = 0;
        for (int i = 0; i < questionSet.length; i++) {
            if (correctAnswers[questionSet[i]].equalsIgnoreCase(userAnswers[questionSet[i]])) {
                count++;
            }
        }
        System.out.println("You scored " + count + " out of " + correctAnswers.length);
    }
    
    public static void exit() {
        System.out.println("Enjoy your day!");
    }
    
    public static void operator(int value, Scanner scnr) {
        if (value == 1) {
            int quizLength = quizLength(scnr);
            String[] questions = newQuiz(scnr, quizLength);
            String[] answers = quizSolution(scnr, quizLength);
        } else if (value == 2) {
            System.out.println("Starting Quiz...");
        } else if (value == 3) {
            System.out.println("Checking Score...");
        }
    }
    
    public static int quizLength(Scanner scnr) {
        System.out.println("How many questions do you want?");
        System.out.println("1.) 5 questions");
        System.out.println("2.) 10 questions");
        System.out.println("3.) 15 questions");
        System.out.println("4.) 20 questions");
        
        int quizL = scnr.nextInt();
        switch (quizL) {
            case 1: return 5;
            case 2: return 10;
            case 3: return 15;
            case 4: return 20;
            default: System.out.println("Invalid choice"); return 0;
        }
    }
}
