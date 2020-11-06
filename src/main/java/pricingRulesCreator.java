import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class pricingRulesCreator {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Item> items = new ArrayList<>();
    private static boolean finish = false;

    public static void newPricingRule() throws FileNotFoundException {
        System.out.println("Welcome in Pricing Rules Creator!");

        while(!finish){
            System.out.println("Choose option 1-3:");
            System.out.println("1-Add new item to Pricing Rules");
            System.out.println("2-Finish creating Pricing Rules");
            System.out.println("3-Exit without save");

            String chosenOption = scanner.nextLine();

            switch (chosenOption){
                case "1" :
                    addItem();
                    break;
                case "2" :
                    save();
                    break;
                case "3" :
                    finish = true;
                    break;
                default :
                    System.out.println("Wrong input. Please try again.");
            }
        }
    }

    private static void addItem() {

        System.out.println("Enter item's name");
        String name = scanner.nextLine();
        int price;
        do{
            System.out.println("Enter item's price");
            price = enteredInt();
        }while(price == -1);

        items.add(new Item(name, price));
        System.out.println("Item add successful!");
    }

    private static void save() throws FileNotFoundException {
        if(items.size() == 0){
            System.out.println("Pricing Rules don't contains any item");
        }else{
            PrintWriter printWriter = new PrintWriter("src/main/resources/pricing_rules.txt");
            Gson gson = new Gson();

            for(Item item : items) {
                String json = gson.toJson(item);
                printWriter.println(json);
            }
            printWriter.close();
            System.out.println("Pricing Rules saved successful!");
            System.out.println("Enter any key to exit.");
            scanner.nextLine();
            finish = true;
        }
    }

    private static int enteredInt() {
        try{
            int i  = Integer.parseInt(scanner.nextLine());
            if(i<0) throw new NumberFormatException();
            return i;
        }catch(NumberFormatException e){
            System.out.println("Wrong input. Please try again.");
            return -1;
        }
    }
}
