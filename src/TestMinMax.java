import inheritance.BankingAccount.*;

public class TestMinMax
{
    public static void main(String[] args)
    {
        boolean allPassed = true;
        int[][] testTransactions =
                {{0, 10, -50, 5, 0, 300},
                        {0, 60, -80, -10, 300},
                        {-40, -30, -5, 20, -10},
                        {-40, 70, 800, 2, 5, -20}};

        boolean allDebitDone = false;
        boolean allCreditDone = false;

        for(int[] values: testTransactions)
        {
            boolean passed = true;
            String verbose = "Test FAILED:\n";
            verbose += "\t\t\t\tEXPECTED\t\t\t\t\t\tACTUAL\n";
            verbose += "transaction\t\tbalance\t\tmin\t\tmax\t\t\tbalance\t\tmin\t\tmax";


            int current = values[0];
            int expectedMax = current;
            int expectedMin = current;

            Startup s = new Startup(values[0]);
            MinMaxAccount acct = new MinMaxAccount(s);

            for(int i = 1; i < values.length; i++)
            {
                verbose += "\n";
                String msg;
                if(!allDebitDone)
                {
                    msg = debit(acct, values[i]);
                }
                else if(!allCreditDone)
                {
                    msg = credit(acct, values[i]);
                }
                else if(values[i] > 0)
                {
                    msg = credit(acct, values[i]);
                }
                else
                {
                    msg = debit(acct, values[i]);
                }
                verbose += msg;

                current += values[i];
                if(current < expectedMin)
                {
                    expectedMin = current;
                }
                if(current > expectedMax)
                {
                    expectedMax = current;
                }

                verbose += current + "\t\t\t" + expectedMin + "\t\t" + expectedMax + "\t\t\t";
                verbose += acct.getBalance() + "\t\t\t" + acct.getMin() + "\t\t" + acct.getMax();

                if(!(current == acct.getBalance()) ||
                        !(expectedMax == acct.getMax()) ||
                        !(expectedMin == acct.getMin()))
                {
                    passed = false;
                }

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

            if(!allDebitDone)
            {
                allDebitDone = true;
            }
            else if(!allCreditDone)
            {
                allCreditDone = true;
            }

        }

        if(allPassed)
        {
            System.out.println("All tests passed.");
        }




    }


    public static String debit(MinMaxAccount acct, int val)
    {
        Debit d = new Debit(val);
        acct.debit(d);
        return "debit: " + val + "\t\t";
    }


    public static String credit(MinMaxAccount acct, int val)
    {
        Credit c = new Credit(val);
        acct.credit(c);
        return "credit: " + val + "\t\t";
    }

}