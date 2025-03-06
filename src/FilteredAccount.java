import inheritance.Account;

public class FilteredAccount extends Account {
    int transactionsMade = 0;
    int filtered = 0;

    public FilteredAccount(Client c) {
        super(c);
    }

    public boolean process(Transaction t) {
        if(t.value() != 0)
        {
            transactionsMade++;
            boolean valid;
            valid = super.process(t);
            return valid;
        }
        else
        {
            transactionsMade++;
            filtered++;
            return true;
        }
    }

    public double percentFiltered() {
        if(transactionsMade != 0)
        {
            return 100 * (filtered / (double) transactionsMade);
        }
        else
        {
            return 0;
        }
    }
}