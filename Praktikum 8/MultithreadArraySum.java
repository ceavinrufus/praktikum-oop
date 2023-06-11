/**
 * @author 18221162 Ceavin Rufus De Prayer Purba
 */

public class MultithreadArraySum {
    // nWorkers menyatakan jumlah maximum threads yang tersedia
    private int nWorkers;
    // array menyatakan array masukan
    private Integer[] array;

    MultithreadArraySum(int nWorkers, Integer[] array) {
        // Inisialisasi attributes
        // Please provide your solution in the space below
        this.nWorkers = nWorkers;
        this.array = array;
    }

    public int calculateSum() throws InterruptedException {
        // calculateSum akan membuat thread dan memetakan array masukan secara rata ke
        // semua threads yang dapat dibuat
        int arrayLength = array.length;
        int chunkSize = (int) Math.floor((double) arrayLength / nWorkers);
        int[] sums = new int[arrayLength];
        Thread[] threads = new Thread[nWorkers];

        for (int i = 0; i < nWorkers; i++) {
            int startIndex, endIndex;
            startIndex = i * chunkSize;
            if (i < nWorkers - 1) {
                endIndex = Math.min(startIndex + chunkSize, arrayLength);
            } else {
                endIndex = arrayLength;
            }

            final int threadIndex = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (this) {
                        sums[threadIndex] += findSum(startIndex, endIndex);
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

    protected int findSum(int start, int end) {
        // findSum akan melakukan penjumlahan elemen-elemen array pada index `start`
        // sampai `end-1`
        // Please provide your solution in the space below
        int partialSum = 0;
        for (int i = start; i < end; i++) {
            partialSum += array[i];
        }
        return partialSum;
    }
}
