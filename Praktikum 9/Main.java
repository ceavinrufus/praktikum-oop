import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Deque<Integer> myQ = new ArrayDeque<Integer>();

        int q = inp.nextInt();
        boolean isReversed = false;
        int newInt;
        String command;

        for (int i = 0; i < q; i++) {
            command = inp.next();
            // MAKE SURE INI NEXT BUKAN NEXTINT
            if (command.equals("addFirst")) {
                newInt = inp.nextInt();
                if (isReversed) {
                    myQ.addLast(newInt);
                } else {
                    myQ.addFirst(newInt);
                }
            }

            else if (command.equals("addLast")) {
                newInt = inp.nextInt();
                if (isReversed) {
                    myQ.addFirst(newInt);
                } else {
                    myQ.addLast(newInt);
                }
            }

            else if (command.equals("pollFirst")) {
                if (myQ.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    if (isReversed) {
                        System.out.println(myQ.pollLast());
                    } else {
                        System.out.println(myQ.pollFirst());
                    }
                }

            }

            else if (command.equals("pollLast")) {
                if (myQ.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    if (isReversed) {
                        System.out.println(myQ.pollFirst());
                    } else {
                        System.out.println(myQ.pollLast());
                    }
                }
            }

            else if (command.equals("reverse")) {
                isReversed = !isReversed;
            }

        }

        inp.close();

    }
}