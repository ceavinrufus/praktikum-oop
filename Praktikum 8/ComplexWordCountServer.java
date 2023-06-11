import java.util.ArrayList;

public class ComplexWordCountServer {

    private int nWorkers;
    private ArrayList<String> array;
    private int[] res = new int[26];

    public ComplexWordCountServer(int nWorkers, ArrayList<String> array) {
        this.nWorkers = nWorkers;
        this.array = array;
    }

    public void countSpecialString() throws InterruptedException {
        Thread[] threads = new Thread[nWorkers];
        int temp = array.size() / nWorkers;
        int start = 0;
        for (int i = 0; i < nWorkers; i++) {
            int end = start + temp;
            if (i == nWorkers - 1)
                end = array.size();
            ArrayList<String> subarray = new ArrayList<>(array.subList(start, end));
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (String word : subarray) {
                        int[] characterCount = characterCountHelper(word);
                        synchronized (res) {
                            for (int j = 0; j < 26; j++) {
                                res[j] += characterCount[j];
                            }
                        }
                    }
                }
            });
            threads[i].start();
            start = end;
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    protected int[] characterCountHelper(String str) {
        int[] counts = new int[26];
        for (char c : str.toCharArray()) {
            counts[c - 'a']++;
        }
        return counts;
    }

    public String toString() {
        int one_occurence = Math.min(res['o' - 'a'], Math.min(res['n' - 'a'], res['e' - 'a']));
        for (int i = 0; i < one_occurence; i++) {
            res['o' - 'a']--;
            res['n' - 'a']--;
            res['e' - 'a']--;
        }
        int two_occurence = Math.min(res['t' - 'a'], Math.min(res['w' - 'a'], res['o' - 'a']));
        for (int i = 0; i < two_occurence; i++) {
            res['t' - 'a']--;
            res['w' - 'a']--;
            res['o' - 'a']--;
        }
        int three_occurence = Math.min(res['t' - 'a'],
                Math.min(res['h' - 'a'], Math.min(res['r' - 'a'], (res['e' - 'a'] / 2))));
        for (int i = 0; i < three_occurence; i++) {
            res['t' - 'a']--;
            res['h' - 'a']--;
            res['r' - 'a']--;
            res['e' - 'a']--;
            res['e' - 'a']--;
        }
        return String.format("one : %d, two : %d, three : %d\n", one_occurence, two_occurence, three_occurence);
    }
}
