/**
 * @author 18221162 Ceavin Rufus De Prayer Purba
 */
public class DelayedCounting {
    public static void printDelayed(int delayMillisec, int maxCount) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delayMillisec);
                    for (int i = 1; i <= maxCount; i++) {
                        System.out.println(i);
                    }
                } catch (InterruptedException e) {

                }
            }
        });
        thread1.start();
    }
}
