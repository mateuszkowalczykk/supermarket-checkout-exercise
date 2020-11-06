import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckOut {
    private final ArrayList<Item> items = new ArrayList<>();

    public void loadPricingRules(String pricingRulesPath){
        File file = new File(pricingRulesPath);
        try{
            Scanner loadedFile = new Scanner(file);
            Gson gson = new Gson();
            while(loadedFile.hasNextLine()){
                items.add(gson.fromJson(loadedFile.nextLine(),Item.class));
            }
            System.out.println("Pricing Rules loaded successful");
            System.out.println(items);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }


}
