public class CustomerDetails {

    private long accountNumber;
    private String accountHolderName;
    private String ifscCode;
    private long mobileNumber;
    private long aadhaarNumber;
    private String fatherName;
    private long balance;
    private String accountType;
    private String city;
    private Integer pinCode;
    private String athentication;

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public long getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(long aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public String getAthentication() {
        return athentication;
    }

    public void setAthentication(String athentication) {
        this.athentication = athentication;
    }

    public CustomerDetails() {

    }

    public CustomerDetails(long accountNumber, String accountHolderName, String ifscCode, long mobileNumber, long aadhaarNumber, String fatherName, long balance, String accountType, String city, Integer pinCode, String athentication) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.ifscCode = ifscCode;
        this.mobileNumber = mobileNumber;
        this.aadhaarNumber = aadhaarNumber;
        this.fatherName = fatherName;
        this.balance = balance;
        this.accountType = accountType;
        this.city = city;
        this.pinCode = pinCode;
        this.athentication = athentication;
    }

    @Override
    public String toString() {
        return "[" + "accountNumber=" + accountNumber + "; accountHolderName='" + accountHolderName + '\'' + "; ifscCode='" + ifscCode + '\'' + "; mobileNumber=" + mobileNumber + "; aadhaarNumber=" + aadhaarNumber + "; fatherName='" + fatherName + '\'' + "; balance=" + balance + "; accountType='" + accountType + '\'' + "; city='" + city + '\'' + "; pinCode=" + pinCode + ']';
    }
}
