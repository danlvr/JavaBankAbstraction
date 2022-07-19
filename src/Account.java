public abstract class Account implements IAccount {

    private static final int DEFAULT_ROUTING_NUMBER = 123456789;
    private static int SEQUENTIAL_ACCOUNT_NUMBER = 1;

    protected int routingNumber;
    protected int accountNumber;
    protected double balance;
    protected Client client;

    public Account(Client client) {
        this.routingNumber = Account.DEFAULT_ROUTING_NUMBER;
        this.accountNumber = SEQUENTIAL_ACCOUNT_NUMBER++;
        this.client = client;
    }

    @Override
    public void withdraw(double value) {
        balance -= value;
    }

    @Override
    public void deposit(double value) {
        balance += value;
    }

    @Override
    public void transfer(double value, IAccount destinationAccount) {
        this.withdraw(value);
        destinationAccount.deposit(value);
    }

    public int getRoutingNumber() {
        return routingNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void printCommonInformation() {
        System.out.printf("Account Owner: %s%n", this.client.getName());
        System.out.printf("Routing Number: %d%n", this.routingNumber);
        System.out.printf("Account Number: %d%n", this.accountNumber);
        System.out.printf("Balance: %.2f%n", this.balance);
    }

}
