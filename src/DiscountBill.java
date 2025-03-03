import inheritance.GroceryBill;

public class DiscountBill extends GroceryBill{
    boolean preferred;

    public DiscountBill(Employee clerk, boolean preferred){
        super(clerk);
        this.preferred = preferred;
    }


}
