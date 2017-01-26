package cs3354.assignment1;
import java.util.Scanner;

/*******************************************




 */
public class Main {
    public static void main(String[] args) {

        boolean loopMenu = true;
        int menuChoice;
        Scanner input;

        do {
            System.out.println();
            System.out.println("Big Bob's Video Store Inventory Menu");
            System.out.println();
            System.out.println("1. Add Movie");
            System.out.println("2. Remove Movie");
            System.out.println("3. Find Movie by SKU");
            System.out.println("4. Display Current Inventory");
            System.out.println("5. Quit Program");
            System.out.println();
            System.out.print("Enter choice: ");
            input = new Scanner(System.in);
            menuChoice = input.nextInt();

            switch(menuChoice){
                case 1:
                    System.out.println("MADE TO OPTION 1");
                    break;
                case 2:
                    System.out.println("MADE TO OPTION 2");
                    break;
                case 3:
                    System.out.println("MADE TO OPTION 3");
                    break;
                case 4:
                    System.out.println("MADE TO OPTION 4");
                    break;
                case 5:
                    System.out.println("MADE TO OPTION 5");
                    loopMenu = false;
                    break;
                default:
                    System.out.println("Invalid Option! Please choose 1. 2. 3. 4. or 5.");
            }

        } while(loopMenu);


        System.out.println("END OF PROGRAM");
    }
}
