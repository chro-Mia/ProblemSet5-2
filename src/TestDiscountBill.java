/*import inheritance.GroceryBill.*;

public class TestDiscountBill
{
    public static void main(String[] args)
    {
        boolean allPassed = true;

        Item[][] testItems =
                {{new Item("", 5, 2), new Item("", 10, 0), new Item("", 3, 0.5) },
                        {new Item("", 5, 0), new Item("", 3, 0), new Item("", 7.5, 0)},
                        {new Item("", 5, 4), new Item("", 6, 0), new Item("", 7.5, 4.5)},
                        {new Item("", 5, 2), new Item("", 10, 3), new Item("",3, 0.5)}};

        boolean preferred = false;

        for(Item[] items: testItems)
        {
            String verbose = "Test FAILED:\n";
            verbose += "Preferred: " + preferred + "\n";
            verbose += "Item costs: \n";

            double total = 0;
            double discount = 0;
            int discountCount = 0;

            DiscountBill bill = new DiscountBill(new Employee(""), preferred);

            for(Item i: items)
            {
                bill.add(i);
                verbose += i.toString() + "\n";
                total += i.getPrice();
                if(preferred)
                {
                    discount += i.getDiscount();
                    if(i.getDiscount() > 0)
                    {
                        discountCount++;
                    }
                }
            }

            verbose += "EXPECTED:\n";
            verbose += "\ttotal: " + (total - discount) + "\n";
            verbose += "\tdiscount: " + discount + "\n";
            verbose += "\tdiscount count: " + discountCount + "\n";
            verbose += "\tdiscount percent: " + (100 * discount / total) + "\n\n";
            verbose += "ACTUAL:\n";
            verbose += "\ttotal: " + bill.getTotal() + "\n";
            verbose += "\tdiscount: " + bill.getDiscountAmount() + "\n";
            verbose += "\tdiscount count: " + bill.getDiscountCount() + "\n";
            verbose += "\tdiscount percent: " + bill.getDiscountPercent() + "\n\n";

            boolean passed = true;
            if( Math.abs((total - discount) - bill.getTotal()) > 0.01)
            {
                passed = false;
            }
            if( Math.abs(discount - bill.getDiscountAmount()) > 0.01)
            {
                passed = false;
            }
            if( Math.abs((100 * discount / total) - bill.getDiscountPercent()) > 0.01)
            {
                passed = false;
            }
            if(bill.getDiscountCount() !=  discountCount)
            {
                passed = false;
            }

            if(!passed)
            {
                allPassed = false;
                System.out.println(verbose);
            }
            else
            {
                System.out.println("Test passed");
            }


            if(!preferred)
            {
                preferred = true;
            }
        }

        if(allPassed)
        {
            System.out.println("All tests passed");
        }

    }


}*/