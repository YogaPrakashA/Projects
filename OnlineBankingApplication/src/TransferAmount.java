import java.util.Scanner;

public class TransferAmount {

    public void transferAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your account Number below : ");
        System.out.print("Enter your account number : ");
        long accountNumber = sc.nextLong();
        System.out.println("Enter your verification code : ");
        String verificationCode = sc.next();

        CustomerDetails cd = Main.tamilNaduBankDB.get(accountNumber);
        if (cd == null) {
            System.err.println("Invalid Account number!!!!!");
            return;
        }

        if (!verificationCode.equals(cd.getAthentication())) {
            System.err.println("Invalid verification code!!!!");
            return;
        }

        System.out.println("Enter sender Account Details ");
        System.out.println("Enter Account Number : ");
        long senderAccountNumber = sc.nextLong();
        System.out.println("Enter IFSC code :");
        String ifscCode = sc.next();

        CustomerDetails senderAccountDetails = Main.nationalDB.get(senderAccountNumber);

        if (senderAccountDetails == null) {
            System.err.println("Invalid Account number!!!!!");
            return;
        }

        System.out.println("Please verify Account Holder details....");
        System.out.println("Account Number : " + senderAccountDetails.getAccountNumber());
        System.out.println("IFSC code : " + senderAccountDetails.getIfscCode());
        System.out.println("Account Holder name : " + senderAccountDetails.getAccountHolderName());

        System.out.println("Please confirm details (Yes/No) :");
        String confirmation = sc.next();

        if (confirmation.equalsIgnoreCase("No")) {
            System.err.println("Your transaction is declined!!");
            return;
        }

        System.out.println("Please enter amount : ");
        long sendingAmount = sc.nextLong();

        if (sendingAmount > cd.getBalance()) {
            System.err.println("Insufficient amount!!!!");
            return;
        }

        senderAccountDetails.setBalance(senderAccountDetails.getBalance() + sendingAmount);

        Main.nationalDB.put(senderAccountNumber, senderAccountDetails);

        cd.setBalance(cd.getBalance() - sendingAmount);

        Main.tamilNaduBankDB.put(accountNumber, cd);

        System.out.println("Transaction successful...");


    }
}
