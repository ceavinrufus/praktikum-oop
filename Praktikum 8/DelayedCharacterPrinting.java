/**
 * @author 18221162 Ceavin Rufus De Prayer Purba
 */
public class DelayedCharacterPrinting {
    public static void printDelayed(int delayMillisec, String word) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delayMillisec);
                    for (int i = 0; i < word.length(); i++) {
                        System.out.println(word.charAt(i));
                    }
                }
                catch (InterruptedException e) {

                }
            }
        });
        thread1.start();
    }
}
