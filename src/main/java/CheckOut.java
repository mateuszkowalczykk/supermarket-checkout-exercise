import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckOut {
    private final Map<String,Item> itemsPrices = new HashMap<>();
    private final Map<String,Integer> scannedItems = new HashMap<>();

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
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void scan(String itemName){
        if(itemsPrices.containsKey(itemName)){
            if(scannedItems.containsKey(itemName)){
                int numberOfItems = scannedItems.get(itemName);
                scannedItems.replace(itemName,++numberOfItems);
            }else{
                scannedItems.put(itemName,1);
            }
        }else{
            System.out.println("Not found this item in our database");
        }
    }

}
