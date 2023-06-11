
/**
 * @author 18221162 Ceavin Rufus De Prayer Purba
 */

import java.util.ArrayList;

public class MultithreadArray2DSum {

    private int nWorkers;
    private ArrayList<Integer[]> array;

    MultithreadArray2DSum(int nWorkers, ArrayList<Integer[]> array) {
        // Inisialisasi attributes
        this.nWorkers = nWorkers;
        this.array = array;
    }

    public int calculateSum2() throws InterruptedException {
        // calculateSum2 akan membuat thread dan memetakan array 2 dimensi masukan
        // secara rata ke semua threads yang dapat dibuat
        // setiap thread akan menghitung jumlah dari setiap baris array
        // gunakan fungsi findSum pada kelas MultithreadArraySum untuk menghitung setiap
        // baris array
        int numRows = array.size();

        if (nWorkers > numRows) {
            nWorkers = numRows;
        }
        int chunkSize = (int) Math.floor((double) numRows / nWorkers);
        int[] sums = new int[numRows];
        Thread[] threads = new Thread[nWorkers];

        for (int i = 0; i < nWorkers; i++) {
            int startIndex = i * chunkSize;
            int endIndex = Math.min(startIndex + chunkSize, numRows);

            final int threadIndex = i;

            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (this) {
                        try {
                            for (int j = startIndex; j < endIndex; j++) {
                                MultithreadArraySum arraySum = new MultithreadArraySum(1, array.get(j));
                                sums[threadIndex] += findSum(arraySum);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        int totalSum = 0;
        for (int sum : sums) {
            totalSum += sum;
        }
        return totalSum;
    }

    protected int findSum(MultithreadArraySum arraySum) throws InterruptedException {
        // findSum menerima parameter arraySum berupa kelas MultithreadArraySum yang
        // diinisiasi
        // setiap baris pada array 2 Dimensi untuk menghitung total penjumlahan setiap
        // baris
        return arraySum.calculateSum();
    }
}
