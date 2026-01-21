// Stuart Reges
// 1/19/00
//

import java.util.*;

public class ShoppingCart {

    public static final double DISCOUNT_PERCENT = 0.9;
    private ArrayList<ItemOrder> orders;
    private boolean discount;

    public ShoppingCart() {
        orders = new ArrayList<>();
    }

    public void add(ItemOrder next) {
      for (int i = 0; i < orders.size(); i++) {
        ItemOrder current = orders.get(i);
        if (current.getItem().equals(next.getItem())) {
            orders.remove(i); 
            break;
        }
      }


      if (next.getPrice() > 0) {
        cart.add(next);
      }
   }
    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public double getTotal() {
        double total = 0.0;

        for (ItemOrder order : orders) {
            total += order.getPrice();
        }

        if (discount) {
            total *= DISCOUNT_PERCENT;
        }

        return total;
    }
}
