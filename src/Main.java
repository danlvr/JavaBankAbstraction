public class Main {
    public static void main(String[] args) {

        Client johnDoe = new Client();
        johnDoe.setName("John Doe");

        Account checkingAccount = new CheckingAccount(johnDoe);
        Account savingsAccount = new SavingsAccount(johnDoe);

        checkingAccount.deposit(200);
        checkingAccount.transfer(150, savingsAccount);

        checkingAccount.printStatement();
        savingsAccount.printStatement();
    }
}