import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        List<Integer> result = new ArrayList<>();
        for (int num : intList) {

            if (num <= 0) {
                continue;
            }

            if (num % 2 == 1) {
                continue;
            }

            result.add(num);
        }

        result.sort(Integer::compareTo);

        for (int num : result) {
            System.out.println(num);
        }
    }
}