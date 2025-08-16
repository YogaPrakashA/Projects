import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Long, CustomerDetails> tamilNaduBankDB;
    static Map<Long, CustomerDetails> nationalDB;
    static Map<Long, CustomerDetails> transactionHistory;
    static long accountNumber = 8123456783L;

    static {
        transactionHistory = new HashMap<>();
        tamilNaduBankDB = new HashMap<>();
        tamilNaduBankDB.put(8123456780L, new CustomerDetails(8123456780L, "yoga", "TNB00001", 1234567890, 2001, "Ananthan", 100000, "SavingAccount", "Dindigul", 600001, ""));
        tamilNaduBankDB.put(8123456781L, new CustomerDetails(8123456781L, "prakash", "TNB00001", 1234567891, 2002, "Ananthan", 0, "CurrentAccount", "Dindigul", 600001, ""));
        tamilNaduBankDB.put(8123456782L, new CustomerDetails(8123456782L, "arun", "TNB00002", 1234567894, 2003, "Kumar", 500, "SavingAccount", "Chennai", 600002, ""));
        tamilNaduBankDB.put(8123456783L, new CustomerDetails(8123456783L, "mani", "TNB00005", 1234567898, 2010, "Raj", 1000, "CurrentAccount", "Chennai", 600002, ""));

        nationalDB = new HashMap<>();
        nationalDB.put(9876543211L, new CustomerDetails(9876543211L, "yoga", "UKB00001", 223456789, 3000, "Aarya", 10000, "SavingAccount", "Chennai", 600003, ""));
        nationalDB.put(9876543222L, new CustomerDetails(9876543222L, "prakash", "UKB00001", 223456786, 3002, "Mukesh", 50, "CurrentAccount", "Chennai", 600003, ""));
        nationalDB.put(9876543233L, new CustomerDetails(9876543233L, "arun", "UKB00004", 223456781, 3003, "Ramesh", 500, "SavingAccount", "Karur", 600004, ""));
        nationalDB.put(9876543244L, new CustomerDetails(9876543244L, "mani", "UKB00002", 223456784, 3005, "Hari", 100000, "CurrentAccount", "Salem", 600005, ""));

    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("Welcome to tamilNadu online banking...");
            System.out.println("1. Open new account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Transfer Amount");
            System.out.println("5. Check available balance");
            System.out.println("6. Transaction history");
            System.out.println("7. Exit");

            System.out.println("choice the process : ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            if (choice == 1) {
                CreateNewAccount createNewAccount = new CreateNewAccount();
                createNewAccount.createNewAccount();
            } else if (choice == 2) {
                DepositAmount depositAmount = new DepositAmount();
                depositAmount.depositAmount();
            } else if (choice == 3) {
                WithdrawalAmount withdrawalAmount = new WithdrawalAmount();
            } else if (choice == 4) {
                TransferAmount transferAmount = new TransferAmount();
            } else if (choice == 5) {
                CheckAvailableBalance checkAvailableBalance = new CheckAvailableBalance();
                checkAvailableBalance.checkAvailableBalance();
            } else if (choice == 6) {
                TransactionHistory transactionHistory = new TransactionHistory();
                transactionHistory.transaction();
            } else if (choice == 7) {
                System.out.println("Thank you!!! visit again..");
                System.exit(0);
            } else {
                System.err.println("Invalid input");
            }


        }
    }
}