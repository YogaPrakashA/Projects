import java.time.LocalDateTime;

public record TransactionHistoryDetails(long accountNumber, String ifscCode, long aadhaarNumber, String transactionType,
                                        String transactionStatus, long amount, String reason,
                                        LocalDateTime transactionDateTime) {

    public TransactionHistoryDetails(long accountNumber, String ifscCode, long aadhaarNumber, String transactionType, String transactionStatus, long amount, String reason, LocalDateTime transactionDateTime) {
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.aadhaarNumber = aadhaarNumber;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
        this.amount = amount;
        this.reason = reason;
        this.transactionDateTime = transactionDateTime;
    }

    @Override
    public String toString() {
        return "[" + "accountNumber=" + accountNumber + ", ifscCode='" + ifscCode + '\'' + ", transactionType='" + transactionType + '\'' + ", transactionStatus='" + transactionStatus + '\'' + ", amount=" + amount + ", reason='" + reason + '\'' + ", transactionDateTime=" + transactionDateTime + ']';
    }
}
