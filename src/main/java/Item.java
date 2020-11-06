public class Item {
    private final String name;
    private final int price;
    private int specialOfferItemsNumber;
    private int specialOfferPrice;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Item(String name, int price, int specialOfferItemsNumber, int specialOfferPrice) {
        this.name = name;
        this.price = price;
        this.specialOfferItemsNumber = specialOfferItemsNumber;
        this.specialOfferPrice = specialOfferPrice;
    }
}
