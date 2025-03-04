import inheritance.GroceryBill;

public class DiscountBill extends GroceryBill{
    private final boolean preferred;
    private double discountTotal = 0;
    private int itemsDiscounted = 0;
    private double discountAmount = 0;

    public DiscountBill(Employee clerk, boolean preferred){
        super(clerk);
        this.preferred = preferred;
    }

    public void add(Item i){
        if(preferred && i.getDiscount() > 0){
            discountTotal += i.getPrice() - i.getDiscount();
            itemsDiscounted++;
            discountAmount += i.getDiscount();
            super.add(i);
        }
        else{
            super.add(i);
        }
    }

    public double getTotal(){
       if(preferred){
           return super.getTotal() - discountAmount;
       }
       else{
           return super.getTotal();
       }
    }

    public double getDiscountAmount(){
        return discountAmount;
    }

    public int getDiscountCount(){
        return itemsDiscounted;
    }

    public double getDiscountPercent(){
        return 100 * (discountAmount / super.getTotal());
    }
}