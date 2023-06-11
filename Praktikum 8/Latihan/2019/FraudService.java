public class FraudService {
    public boolean isFraud(int saldo, int nominal) {
        try {
            Thread.sleep(nominal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}