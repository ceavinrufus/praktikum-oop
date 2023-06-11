/* Untuk mengaktifkan assertion, jalankan driver dengan flag -ea
   Contoh:
   $ javac MultithreadArraySum.java MultithreadArraySumDriver.java
   $ java -ea MultithreadArraySumDriver
 */
public class MultithreadArraySumDriver {
   public static void main(String[] args) throws InterruptedException {
      int nWorkers = 2;
      Integer[] arr = { 1, 2, 3, 4, 5 };

      MultithreadArraySum arraySum = new MultithreadArraySum(nWorkers, arr);

      Integer expectedArraySum = 15;
      Integer actualWordCounts = arraySum.calculateSum();

      assert expectedArraySum.equals(actualWordCounts);

      System.out.println("Congrats! No Errors :)");
   }
}
