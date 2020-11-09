import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CheckOut {
    private final Set<Item> itemsPrices = new HashSet<>();
    private final Map<Item,Integer> scannedItems = new HashMap<>();

    public void loadPricingRules(String pricingRulesPath){
        File file = new File(pricingRulesPath);
        try{
            Scanner loadedFile = new Scanner(file);
            Gson gson = new Gson();
            while(loadedFile.hasNextLine()){
                Item item = gson.fromJson(loadedFile.nextLine(),Item.class);
                itemsPrices.add(item);
            }
            System.out.println("Pricing Rules loaded successful");
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void scan(String itemName){
        try{
            Item item = itemsPrices.stream()
                    .filter(item1 -> item1.getName().equals(itemName))
                    .findFirst()
                    .orElseThrow();
            if(scannedItems.containsKey(item)){
                int numberOfItems = scannedItems.get(item);
                scannedItems.replace(item,++numberOfItems);
            }else{
                scannedItems.put(item,1);
            }
        }catch (NoSuchElementException e){
            System.out.println("Not found this item in our database");
        }
    }


}
