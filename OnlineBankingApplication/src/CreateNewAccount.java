import java.util.Map;
import java.util.Scanner;

public class CreateNewAccount {

    public void createNewAccount() {

        System.out.println("Please fill given fields....");
        Scanner sc = new Scanner(System.in);
        System.out.print("AccountHolderName : ");
        String accountHolderName = sc.nextLine();
        System.out.print("MobileNumber : ");
        long mobileNumber = sc.nextLong();
        System.out.println("AadhaarNumber : ");
        long aadhaarNumber = sc.nextLong();
        System.out.println("Father's Name : ");
        String fatherName = sc.next();
        System.out.println("City : ");
        String city = sc.next();
        System.out.println("Pincode : ");
        Integer pinCode = sc.nextInt();
        System.out.println("Enter verification code for future identification : ");
        String verificationCode = sc.next();

        Main.tamilNaduBankDB.put(++Main.accountNumber, new CustomerDetails(Main.accountNumber, accountHolderName, "TNB00001", mobileNumber, aadhaarNumber, fatherName, 0, "SavingAccount", city, pinCode, verificationCode));

        System.out.println("Account successfully created!!!.");

    }
}
