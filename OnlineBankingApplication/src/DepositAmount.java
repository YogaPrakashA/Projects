import java.util.Scanner;

public class DepositAmount {

    public void depositAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number : ");
        long accountNumber = sc.nextLong();
        System.out.println("Enter bank IFSC code : ");
        String ifscCode = sc.next();
        System.out.println("Enter deposit amount : ");
        long amount = sc.nextLong();

        if (!Main.tamilNaduBankDB.containsKey(accountNumber)) System.err.println("Given AccountNumber is Invalid.");

        System.out.println("Kindly verify AccountHolderName (Yes/No): ");
        System.out.println("**  " + Main.tamilNaduBankDB.get(accountNumber).getAccountHolderName().toUpperCase() + "  **");
        String verification = sc.next();
        if (verification.equalsIgnoreCase("No")) return;

        CustomerDetails cd = Main.tamilNaduBankDB.get(accountNumber);
        cd.setBalance(cd.getBalance() + amount);

        System.out.println("Do you want to see available balance (Y/N): ");
        String verify = sc.next();

        if (verify.equalsIgnoreCase("Y"))
            System.out.println("Available Balance : " + Main.tamilNaduBankDB.get(accountNumber).getBalance());


        System.out.print("------Thank you!!!-----");
        System.out.println();

    }

}
