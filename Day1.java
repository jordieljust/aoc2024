import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) {
        int[] leftList = new int[1000];
        int[] rightList = new int[1000];
        int i = 0;

        try {
            File file = new File("inputs/day1.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbers = line.split("   ");
                leftList[i] = Integer.parseInt(numbers[0]);
                rightList[i] = Integer.parseInt(numbers[1]);
                i++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Arrays.sort(leftList);
        Arrays.sort(rightList);

        System.out.println("Part 1: " + partOne(leftList, rightList));
        System.out.println("Part 2: " + partTwo(leftList, rightList));
    }

    public static int partOne(int[] leftList, int[] rightList) {      
        int result = 0;       

        for (int j = 0; j < leftList.length; j++) {
            result += Math.abs(leftList[j] - rightList[j]);
        }

        return result;

    }

    public static int partTwo(int[] leftList, int[] rightList) {
        int result = 0;

        for (int i = 0; i < leftList.length; i++) {
            int index = -1; 
            for (int j = 0; j < rightList.length; j++) {
                if (leftList[i] == rightList[j]) {
                    index = j;
                    break;
                }
            }
            if (index > 0) {
                int counter = 0;
                while (rightList[index] == leftList[i]) {
                    counter++;
                    index++;
                }
                result += leftList[i] * counter;
            }
        }

        return result;

    }
}