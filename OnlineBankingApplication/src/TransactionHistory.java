import java.util.Map;

public class TransactionHistory {

    public void transaction() {
        for (Map.Entry<Long, CustomerDetails> s : Main.tamilNaduBankDB.entrySet()) {
            System.out.println(s.toString());
        }
    }
}
