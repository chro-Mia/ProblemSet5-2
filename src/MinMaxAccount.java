import inheritance.BankingAccount;

public class MinMaxAccount extends BankingAccount {
    private int min;
    private int max;

    public MinMaxAccount(Startup s) {
        super(s);
        min = this.getBalance();
        max = this.getBalance();
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void debit(Debit d) {
        super.debit(d);
        if(this.getBalance() > max)
        {
            max = this.getBalance();
        }
        if(this.getBalance() < min)
        {
            min = this.getBalance();
        }
    }

    public void credit(Credit c)
    {
        super.credit(c);
        if(this.getBalance() > max)
        {
            max = this.getBalance();
        }
        if(this.getBalance() < min)
        {
            min = this.getBalance();
        }
    }
}