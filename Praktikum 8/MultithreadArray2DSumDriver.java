/* Untuk mengaktifkan assertion, jalankan driver dengan flag -ea
   Contoh:
   $ javac MultithreadArraySum.java MultithreadArraySumDriver.java
   $ java -ea MultithreadArraySumDriver
 */

import java.util.ArrayList;

public class MultithreadArray2DSumDriver {
    public static void main(String[] args) throws InterruptedException {
        int nWorkers = 2;
        Integer[] arr = { 1, 2, 3, 4, 5 };
        Integer[] arr2 = { 1, 2, 3, 4, 5, 6 };

        ArrayList<Integer[]> arr2D = new ArrayList<>();
        arr2D.add(arr);
        arr2D.add(arr2);

        MultithreadArray2DSum arraySum = new MultithreadArray2DSum(nWorkers, arr2D);

        Integer expectedArraySum = 36;
        Integer actualWordCounts = arraySum.calculateSum2();

        assert expectedArraySum.equals(actualWordCounts);

        System.out.println("Congrats! No Errors :)");
    }
}
