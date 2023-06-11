import java.util.*;

public class Main {
    public static List<String> findCommonElements(List<String> list1, List<String> list2) {
        Set<String> set1 = new HashSet<String>(list1);
        Set<String> set2 = new HashSet<String>(list2);
        set1.retainAll(set2);

        List<String> finalList = new ArrayList<String>(set1);

        return finalList;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String line1 = inp.nextLine();
        String line2 = inp.nextLine();

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        String[] words1 = line1.split(" ");
        String[] words2 = line2.split(" ");

        for (String word: words1){
            list1.add(word);
        }

        for (String word: words2){
            list2.add(word);
        }
        List<String> finalList = findCommonElements(list1, list2);
        finalList.sort(null);

        System.out.println(finalList);

    }
}
