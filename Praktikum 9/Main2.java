import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SortedSet<Integer> sortedResult = new TreeSet<Integer>();
        try {
            String x = scan.nextLine();
            String[] numbers = x.split(" ");
            for (int i = 0; i < numbers.length; i++) {
                sortedResult.add(Integer.parseInt(numbers[i]));
            }
            System.out.println(sortedResult);
        } catch (NumberFormatException e) {
            System.out.println("[]");
        }
        scan.close();
    }

}
