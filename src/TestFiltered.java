import inheritance.Account.*;

import java.util.Arrays;

public class TestFiltered {
    public static void main(String[] args)
    {
        boolean allPassed = true;

        int[] transactions = {-600, -100, -99, 0, 50, 999999, 1000000, 5000000};
        boolean[] returns = {false, false, true, true, true, true, false, false};

        System.out.println("Testing individual transactions:");
        for(int i = 0; i < transactions.length; i++)
        {
            String verbose = "Test FAILED:\n";
            verbose += "Transaction amount: " + transactions[i] + "\n";
            FilteredAccount acct = new FilteredAccount(new Client());

            boolean resp = acct.process(new Transaction(transactions[i]));

            boolean failed = (resp != returns[i]);
            if(resp != returns[i])
            {
                failed = true;
                verbose += "Reason: Return value doesn't match superclass version.\n";
            }
            if(transactions[i] == 0)
            {
                if(acct.__processCalled)
                {
                    failed = true;
                    verbose += "Reason: super.process() called for 0-value transaction\n";
                }
            }

            if(failed)
            {
                System.out.println(verbose);
                allPassed = false;

            }

        }
        if(allPassed)
        {
            System.out.println("Individual transaction tests passed.");
        }

        int[][] percentTests =
                {{-1000, 0, 50, 0, 30, 5000000, 0},
                        {},
                        {0, 0, 0, 0},
                        {1, 1, 1, 0}};

        System.out.println("Testing percentFiltered:");
        for(int[] test: percentTests)
        {
            String verbose = "Test FAILED:\n";
            verbose += "Transaction amounts: " + Arrays.toString(test) + "\n";

            FilteredAccount acct = new FilteredAccount(new Client());

            int total = test.length;
            int filtered = 0;

            for(int transaction: test)
            {
                acct.process(new Transaction(transaction));
                if(transaction == 0)
                {
                    filtered++;
                }
            }
            double expected = (filtered*100.0/total);
            if(total == 0)
            {
                expected = 0;
            }

            verbose += "Expected percent filtered: " + expected + "\n";
            verbose += "Actual: " + acct.percentFiltered() + "\n";

            if(Math.abs(acct.percentFiltered() - expected) < 0.001)
            {
                System.out.println("Test passed.");
            }
            else
            {
                allPassed = false;
                System.out.println(verbose);
            }

        }



        if(allPassed)
        {
            System.out.println("All tests passed.");
        }
    }
}