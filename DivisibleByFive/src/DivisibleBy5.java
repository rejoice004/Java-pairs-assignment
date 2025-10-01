import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DivisibleBy5 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 4, 5, 20, 30, 6));

        List<Integer> divisibleBy5 = nums.stream()
                                      .filter(n -> n % 5 == 0)
                                      .toList();

        System.out.println("List of numbers divisible by 5: " + divisibleBy5);
    }
}
