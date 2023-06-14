package MagicOf21;

// The code is implementing a game called "Magic of 21". It generates a list of 21 random numbers
// between 1 and 21, and then divides them into three piles of 7 numbers each. The user is asked to
// guess a number between 1 and 21, and then the piles are rearranged based on the user's response
// to a question about which pile their number is in. This process is repeated three times, and
// then the program reveals the user's number.

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MagicOf21 {

    // These lines of code are declaring and initializing three arrays of integers named `pile1`,
    // `pile2`, and `pile3`, each with a length of 7. These arrays will be used to store the random
    // numbers generated for the game and to divide them into three piles.
    static int[] pile1 = new int[7];
    static int[] pile2 = new int[7];
    static int[] pile3 = new int[7];

    // This line of code is declaring and initializing a static ArrayList of integers named
    // `randomNumbers`. It is used to store the 21 random numbers generated for the game.
    static ArrayList<Integer> randomNumbers = new ArrayList<>();


    // This variable is used to store the user's response to a question about which pile their guessed number is in, and
    // is later used in the `rearrangeRandomNumbers()` method to rearrange the piles of numbers based
    // on the user's response.
    static int response;

    /**
     * This function generates a list of 21 unique random numbers between 1 and 21.
     */
    public static void setRandomNumbers(){
        Random random = new Random();

        boolean[] checkNumbers = new boolean[21];
        for (int i = 0; i < 21; i++) {
            checkNumbers[i] = false;
        }

        while(randomNumbers.size() != 21) {
            int idx = random.nextInt(0,21);
            if(!checkNumbers[idx]){
                checkNumbers[idx] = true;
                randomNumbers.add(idx+1);
            }
        }
    }

    /**
     * The function sets the values of three arrays representing piles of numbers with randomly
     * generated numbers.
     */
    public static void setPiles(){
        int j = 0;
        for (int i = 0; i < 7; i++) {
            pile1[i] = randomNumbers.get(j++);
            pile2[i] = randomNumbers.get(j++);
            pile3[i] = randomNumbers.get(j++);
        }
    }

    /**
     * The function displays the contents of three piles in a tabular format.
     */
    public static void showPiles(){
        System.out.println("Pile-1\tPile-2\tPile-3\t");
        for (int i = 0; i < 7; i++) {
            System.out.println(" "+pile1[i]+"\t\t "+pile2[i]+"\t\t "+pile3[i]);
        }
    }

    /**
     * The function rearranges a list of random numbers based on the user's input of which pile their
     * number is present in.
     */
    public static void rearrangeRandomNumbers(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\nIn which pile your number is present?");
        System.out.print("Enter(1/2/3): ");
        response = scan.nextInt();
        if(response == 1){
            int k = 0;
            for (int i = 0; i < 7; i++) {
                randomNumbers.set(k++,pile2[i]);
            }
            for (int i = 0; i < 7; i++) {
                randomNumbers.set(k++,pile1[i]);
            }
            for (int i = 0; i < 7; i++) {
                randomNumbers.set(k++,pile3[i]);
            }
        } else if (response == 3) {
            int k = 0;
            for (int i = 0; i < 7; i++) {
                randomNumbers.set(k++,pile1[i]);
            }
            for (int i = 0; i < 7; i++) {
                randomNumbers.set(k++,pile3[i]);
            }
            for (int i = 0; i < 7; i++) {
                randomNumbers.set(k++,pile2[i]);
            }
        } else {
            int k = 0;
            for (int i = 0; i < 7; i++) {
                randomNumbers.set(k++,pile1[i]);
            }
            for (int i = 0; i < 7; i++) {
                randomNumbers.set(k++,pile2[i]);
            }
            for (int i = 0; i < 7; i++) {
                randomNumbers.set(k++,pile3[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Magic Of 21 game!");
        System.out.println("\nGuess any number between 1 to 21 (both included)");
        System.out.print("Guessed? (Yes/No): ");
        String str = scan.next();

        if(Objects.equals(str, "Yes")){
            setRandomNumbers();
//            System.out.println(randomNumbers);

            setPiles();
            showPiles();
            rearrangeRandomNumbers();
//            System.out.println(randomNumbers);

            setPiles();
            showPiles();
            rearrangeRandomNumbers();
//            System.out.println(randomNumbers);

            setPiles();
            showPiles();
            rearrangeRandomNumbers();
//            System.out.println(randomNumbers);

            System.out.println("\nYour number is "+randomNumbers.get(10));

        }
        System.out.println("\nGame Ended. Thanks for playing.");
    }
}