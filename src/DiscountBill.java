import inheritance.GroceryBill;

public class DiscountBill extends GroceryBill{
    private boolean preferred;
    private int discountCount = 0;
    private double discountAmount = 0;

    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        this.preferred = preferred;
    }

    public void add(Item i) {
        if(preferred && i.getDiscount() > 0)
        {
            discountAmount += i.getDiscount();
            discountCount++;
            super.add(i);
        }
        else
        {
            super.add(i);
        }
    }

    public double getTotal() {
       if(preferred == true)
       {
           double preferredTotal = super.getTotal() - discountAmount;
           return preferredTotal;
       }
       else
       {
           double total = super.getTotal();
           return total;
       }
    }

    public double getDiscountAmount(){
        return discountAmount;
    }

    public int getDiscountCount(){
        return discountCount;
    }

    public double getDiscountPercent(){
        double discountPercent = 100 * (discountAmount / super.getTotal());
        return discountPercent;
    }
}