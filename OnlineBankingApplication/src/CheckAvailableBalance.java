import java.util.Scanner;

public class CheckAvailableBalance {

    public void checkAvailableBalance() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number : ");
        long accountNumber = sc.nextLong();
        System.out.println("Enter verification code : ");
        String verificationCode = sc.next();

        CustomerDetails customerDetails = Main.tamilNaduBankDB.get(accountNumber);

        if (customerDetails == null) {
            System.err.println("Invalid AccountNumber");
            return;
        }

        if (!customerDetails.getAthentication().equals(verificationCode)) {
            System.out.println("Invalid verificationCode");
            return;
        }

        System.out.println("Available balance : " + customerDetails.getBalance());

    }
}
