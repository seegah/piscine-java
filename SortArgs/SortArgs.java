import java.util.Arrays;

public class SortArgs {
    public static void sort(String[] args) {
        int [] numbers = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            numbers[i] = Integer.parseInt(args[i]);
        }
        Arrays.sort(numbers);

        StringBuilder res = new StringBuilder();
        for (int num : numbers) {
            res.append(num).append(" ");
        }
        System.out.println(res.toString().trim());

    }
}