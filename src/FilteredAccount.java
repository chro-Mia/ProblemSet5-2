import inheritance.Account;

public class FilteredAccount extends Account{
    int transactions = 0;
    int filteredTransactions = 0;

    public FilteredAccount(Client c){
        super(c);
    }

    public boolean process(Transaction t){
        if(t.value() != 0){
            transactions++;
            return super.process(t);
        }
        else{
            transactions++;
            filteredTransactions++;
            return true;
        }
    }

    public double percentFiltered(){
        if(transactions == 0){
            return 0;
        }
        else{
            return 100 * ((double)filteredTransactions / transactions);
        }
    }
}