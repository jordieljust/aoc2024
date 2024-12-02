import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Path.of("inputs/day2.txt"));

        

        System.out.println("Part 1: " + partOne(input));
        System.out.println("Part 2: " + partTwo(input));
    }

    public static boolean isSafe(List<Integer> report) {
        int trend = report.get(0) - report.get(1);
        if (trend >= 1 && trend <= 3) {
            for (int i = 1; i < report.size()-1; i++) {
                trend = report.get(i) - report.get(i+1);
                if (trend < 1 || trend > 3) {
                    return false;
                }
            } 
        } else if (trend >= -3 && trend <= -1) {
            for (int i = 1; i < report.size()-1; i++) {
                trend = report.get(i) - report.get(i+1);
                if (trend > -1 || trend < -3) {
                    return false;
                }
            }
        } else return false;

        return true;
    }

    public static int partOne(List<String> input) {
        int result = 0;
        for (int i = 0; i < input.size(); i++) {
            String[] reportString = input.get(i).split(" ");
            List<Integer> report = new ArrayList<Integer>();
            for (String data : reportString) {
                report.add(Integer.parseInt(data));
            }

            if (isSafe(report)) result++;
        }


        return result;
    }

    public static int partTwo(List<String> input) {
        int result = 0;
        for (int i = 0; i < input.size(); i++) {
            String[] reportString = input.get(i).split(" ");
            List<Integer> report = new ArrayList<Integer>();
            for (String data : reportString) {
                report.add(Integer.parseInt(data));
            }

            if (isSafe(report)) result++;
            else {
                for (int j = 0; j < report.size(); j++) {
                    List<Integer> reportDampened = new ArrayList<>(report);
                    reportDampened.remove(j);
                    if (isSafe(reportDampened)) {
                        result++;
                        break;
                    }
                }
            }
        }


        return result;
    }
}