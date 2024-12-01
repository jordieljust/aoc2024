import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        try {
            File file = new File("inputs/day1.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbers = line.split("   ");
                leftList.add(Integer.parseInt(numbers[0]));
                rightList.add(Integer.parseInt(numbers[1]));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
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