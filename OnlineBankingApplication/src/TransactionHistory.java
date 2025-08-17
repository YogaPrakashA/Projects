import java.util.Map;

public class TransactionHistory {

    public void transaction() {
        for (Map.Entry<Long, TransactionHistoryDetails> s : Main.transactionHistory.entrySet()) {
            System.out.println(s.toString());
        }
    }
}
