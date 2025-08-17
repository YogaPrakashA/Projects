import java.util.Scanner;

public class WithdrawalAmount {

    public void withdrawalAmount() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the account number : ");
        long accountNumber = sc.nextLong();
        System.out.println("Enter mobile number : ");
        long mobileNumber = sc.nextLong();
        System.out.println("Enter IFSC code : ");
        String ifscCode = sc.next();
        System.out.println("Enter verification code : ");
        String verificationCode = sc.next();

        if (!Main.tamilNaduBankDB.containsKey(accountNumber)) {
            System.err.println("Invalid Account number");
            return;
        }

        CustomerDetails customerDetails = Main.tamilNaduBankDB.get(accountNumber);

        if (customerDetails.getMobileNumber() != mobileNumber) {
            System.err.println("Invalid MobileNumber");
            return;
        }

        if (!ifscCode.equals(customerDetails.getIfscCode())) {
            System.err.println("Invalid IFSC code ");
            return;
        }

        if (!verificationCode.equals(customerDetails.getAthentication())) {
            System.err.println("Incorrect verification code");
            return;
        }

        System.out.println("Enter withdrawal Amount ");
        long withdrawalAmount = sc.nextLong();

        if (customerDetails.getBalance() < withdrawalAmount) {
            System.err.println("Insufficient balance....");
            return;
        }

        customerDetails.setBalance(customerDetails.getBalance() - withdrawalAmount);

        System.out.println("Thank you!!! visit Again");


    }
}
