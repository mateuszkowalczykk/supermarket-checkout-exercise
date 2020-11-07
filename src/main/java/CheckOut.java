import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckOut {
    private final Map<String,Item> itemsPrices = new HashMap<>();

    public void loadPricingRules(String pricingRulesPath){
        File file = new File(pricingRulesPath);
        try{
            Scanner loadedFile = new Scanner(file);
            Gson gson = new Gson();
            while(loadedFile.hasNextLine()){
                Item item = gson.fromJson(loadedFile.nextLine(),Item.class);
                itemsPrices.put(item.getName(),item);
            }
            System.out.println("Pricing Rules loaded successful");
            System.out.println(itemsPrices);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

}
