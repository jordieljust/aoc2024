import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws IOException {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        List<String> input = Files.readAllLines(Path.of("inputs/day1.txt"));

        for (int i = 0; i < input.size(); i++) {
            leftList.add(Integer.parseInt(input.get(i).split("   ")[0]));
            rightList.add(Integer.parseInt(input.get(i).split("   ")[1]));
        }

        leftList.sort(null);
        rightList.sort(null);

        System.out.println("Part 1: " + partOne(leftList, rightList));
        System.out.println("Part 2: " + partTwo(leftList, rightList));
    }

    public static int partOne(List<Integer> leftList, List<Integer> rightList) {
        int result = 0;

        for (int i = 0; i < leftList.size(); i++) {
            result += Math.abs(leftList.get(i) - rightList.get(i));
        }

        return result;

    }

    public static int partTwo(List<Integer> leftList, List<Integer> rightList) {
        int result = 0;

        for (int i = 0; i < leftList.size(); i++) {
            int number = leftList.get(i);
            int index = rightList.indexOf(number);
            if (index > 0) {
                int counter = 0;
                while (rightList.get(index) == number) {
                    counter++;
                    index++;
                }
                result += number * counter;
            }
        }

        return result;

    }
}