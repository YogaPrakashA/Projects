import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class CreateNewAccount {

    public void createNewAccount() {
        long aadhaarNumber = 0L;
        try {
            System.out.println("Please fill given fields....");
            Scanner sc = new Scanner(System.in);
            System.out.print("Name : ");
            String accountHolderName = sc.nextLine();
            System.out.print("MobileNumber : ");
            long mobileNumber = sc.nextLong();
            System.out.println("AadhaarNumber : ");
            aadhaarNumber = sc.nextLong();
            System.out.println("Father's Name : ");
            String fatherName = sc.next();
            System.out.println("City : ");
            String city = sc.next();
            System.out.println("Pincode : ");
            Integer pinCode = sc.nextInt();
            System.out.println("Enter verification code for future identification : ");
            String verificationCode = sc.next();

            try {
                Main.tamilNaduBankDB.put(++Main.accountNumber, new CustomerDetails(Main.accountNumber, accountHolderName, "TNB00001", mobileNumber, aadhaarNumber, fatherName, 0, "SavingAccount", city, pinCode, verificationCode));
            } catch (Exception e) {
                Main.transactionHistory.put(++Main.accountNumber, new TransactionHistoryDetails(Main.accountNumber, "TNB00001", aadhaarNumber, "Opened new Account", "Failure", 0, e.getMessage(), LocalDateTime.now()));
                return;
            }

            Main.transactionHistory.put(Main.accountNumber, new TransactionHistoryDetails(Main.accountNumber, "TNB00001", aadhaarNumber, "Opened new Account", "Success", 0, "Bank Account created Successfully", LocalDateTime.now()));


            System.out.println("Account successfully created!!!.");
        } catch (Exception e) {
            System.err.println("Create new account exception : " + e.getMessage());
            Main.transactionHistory.put(++Main.accountNumber, new TransactionHistoryDetails(Main.accountNumber, "TNB00001", aadhaarNumber, "Opened new Account", "Failure", 0, e.getMessage(), LocalDateTime.now()));

        }

    }
}
