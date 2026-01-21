import java.text.*;
import java.util.Objects;


public class Item {
    private String name; 
    private double price;
    private double bulkPrice;
    private int bulkQuantity;
    private static final NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public Item(String name, double price) {
        if (price < 0) { 
            throw new IllegalArgumentException("price cannot be negative.");
        } else {
            this.name = name; 
            this.price = price; 
        }
    }

    public Item(String name, double price, int bulkQuantity, double bulkPrice) {
        this(name, price);
        if (bulkQuantity < 0 || bulkPrice < 0) { 
            throw new IllegalArgumentException("bulkQuantity or bulkPrice cannot be negative.");
        } else {
            this.bulkQuantity = bulkQuantity; 
            this.bulkPrice = bulkPrice; 
        }
    }

    public double priceFor(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }

        if (bulkQuantity > 0 && quantity >= bulkQuantity) {
            int bulkGroups = quantity / bulkQuantity;
            int remainder = quantity % bulkQuantity;
            return bulkGroups * bulkPrice + remainder * price;
        } else {
            return quantity * price;
        }
    }

    @Override
    public String toString() {
        String result = name + ", " + formatter.format(price);
        if (bulkQuantity > 0) {
            result += " (" + bulkQuantity + " for " + formatter.format(bulkPrice) + ")";
        } 
        return result;
    }
    
    @Override 
    public boolean equals(Object obj) {
        if (obj instanceof Item) {
            Item item = (Item) obj; 
            return (price == item.price && name.equals(item.name)); 
        } else {
            return false; 
        }
    }
    
}
