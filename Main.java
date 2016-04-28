
/**
 * The Main class that starts up the program and maintains states for all the
 * other class Objects.
 * This class handles user inputs, then sends it down to the appropriate
 * classes.
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main
{ 
    public static int selection = 0; //to store user input 
    public static Shop shop = null; //a Shop
    public static Scanner sc = null; //to engage System.in

    public static void main(String[] args)
    {
        sc = new Scanner(System.in);

        shop = new Shop();
        subMain();
//         //Item type selection sequence
//         if(args[0].equals("sell")){
//             sell();
//         }
//         else if(args[0].equals("show")){
//             show();
//         }        
//         else{
//             System.out.println("Invalid Input");
//         }
    }

    public static void sell()
    {
        String text = "Welcome to the Media Shop\n\n\nChoose from the following:\n1. Books (enter '1')\n2. CDs (enter '2')\n3. Movies (enter '3')";
        System.out.println(text + "\nChoice: ");
        while(true){ //keep looping until user enters the correct selection
            try{
                selection = sc.nextInt();        //choose category
                if(selection > 3 || selection < 1){
                    throw new InputMismatchException();
                }
                break;
            }
            catch(InputMismatchException e){ 
                System.out.println("Input out of range or invalid." + "\nChoice: ");
                continue;
            } 
        }

        if(selection == 1){ //Books
            sellBook();
        }
        else if(selection == 2){ //CDs
            sellCD();
        }    
        else if(selection == 3){
            sellMovie();
        }
        else{
            System.out.println("Invalid Input");
        }
    }

    public static void show()
    {
        System.out.println(shop.show());
    }

    /**
     * keeps selling, getting ratings and show until user quits
     */
    public static void subMain()
    {
        while(true){
            int input = -1;
            System.out.println("\nPlease choose operation. 1.\"Sell\" 2. \"Show\"");
            input = sc.nextInt();
            if(input == 1){
                sell();
            }
            else if(input == 2){
                show();
            }
            else{
                System.exit(0);
            }
        }
    }

    /**
     * sells a book and asks for rating
     */
    public static void sellBook()
    {
        System.out.println(shop.displaySalesItems(selection) + "\nChoice: ");
        while(true){ //keep looping until user enters the correct input
            try{
                selection = sc.nextInt();        //choose item
                if(selection > shop.getSellableBooks() || selection < 1){
                    throw new InputMismatchException(); 
                }
                break;
            }
            catch(InputMismatchException e){ 
                System.out.println("Input out of range or invalid." + "\nChoice: ");
                continue;
            } 
        }

        double lprice = shop.sellBook(selection);
        //sold item, now ask for rating
        System.out.println("You have been charged: " + lprice + "\n\n");
        System.out.println("Rate the book you bought on a scale of 1 to 10.\n 10 is excellent, 1 is absolutely uninteresting.");
        int lrate = 0;
        while(true){
            try{
                lrate = sc.nextInt();
                if(lrate < 1 || lrate > 10){
                    throw new InputMismatchException();
                }
                break;
            }
            catch(InputMismatchException e){ //Movies
                System.out.println("Invalid Input" + "\nChoice: ");
                continue;
            }
        }
        shop.rateBook(selection, lrate);
        System.out.println("Your rating has been saved.Thank you for your feedback.\nGood bye.");
    }

    /**
     * sells a movie and asks for rating
     */
    public static void sellMovie()
    {
        System.out.println(shop.displaySalesItems(selection) + "\nChoice: ");
        while(true){ //keep looping until user enters the correct input
            try{
                selection = sc.nextInt();        //choose item
                if(selection > shop.getSellableMovies() || selection < 1){
                    throw new InputMismatchException(); 
                }
                break;
            }
            catch(InputMismatchException e){ 
                System.out.println("Input out of range or invalid." + "\nChoice: ");
                continue;
            } 
        }

        double lprice = shop.sellMovie(selection);
        //sold item, now ask for rating
        System.out.println("You have been charged: " + lprice + "\n\n");
        System.out.println("Rate the movie you bought on a scale of 1 to 10.\n 10 is excellent, 1 is absolutely uninteresting.");
        int lrate = 0;
        while(true){
            try{
                lrate = sc.nextInt();
                if(lrate < 1 || lrate > 10){
                    throw new InputMismatchException();
                }
                break;
            }
            catch(InputMismatchException e){ //Movies
                System.out.println("Invalid Input" + "\nChoice: ");
                continue;
            }
        }
        shop.rateMovie(selection, lrate);
        System.out.println("Your rating has been saved.Thank you for your feedback.\nGood bye.");
    }

    /**
     * sells a cd and asks for rating
     */
    public static void sellCD()
    {
        System.out.println(shop.displaySalesItems(selection) + "\nChoice: ");
        while(true){ //keep looping until user enters the correct input
            try{
                selection = sc.nextInt();        //choose item
                if(selection > shop.getSellableCDs() || selection < 1){
                    throw new InputMismatchException(); 
                }
                break;
            }
            catch(InputMismatchException e){ 
                System.out.println("Input out of range or invalid." + "\nChoice: ");
                continue;
            } 
        }

        double lprice = shop.sellCD(selection);
        //sold item, now ask for rating
        System.out.println("You have been charged: " + lprice + "\n\n");
        System.out.println("Rate the CD you bought on a scale of 1 to 10.\n 10 is excellent, 1 is absolutely uninteresting.");
        int lrate = 0;
        while(true){
            try{
                lrate = sc.nextInt();
                if(lrate < 1 || lrate > 10){
                    throw new InputMismatchException();
                }
                break;
            }
            catch(InputMismatchException e){ //Movies
                System.out.println("Invalid Input" + "\nChoice: ");
                continue;
            }
        }
        shop.rateCD(selection, lrate);
        System.out.println("Your rating has been saved.Thank you for your feedback.\nGood bye.");
    }
}
