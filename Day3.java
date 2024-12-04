import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Path.of("inputs/day3.txt"));

        System.out.println("Part 1: " + partOne(input));
        System.out.println("Part 2: " + partTwo(input));
    }

    public static int partOne(List<String> input) {
        int result = 0;

        for (String line : input) {
            Pattern pattern = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String operation = matcher.group();
                operation = operation.substring(4, operation.length());
                operation = operation.substring(0, operation.length()-1);
                String[] numbersInString = operation.split(",");
                result += Integer.parseInt(numbersInString[0]) * Integer.parseInt(numbersInString[1]);
                
            }
        }

        return result;
    }

    /*
     * mul abans del primer dont
     * dont sense muls fins al seguent do
     * muls abans de l'ultim do
     * 
     * mul mul dont mul mul do mul
     */

    public static boolean isAbled(int indexMul, List<Integer> does, List<Integer> donts, boolean abled) {
        int i = 0;
        int j = 0;
        while (i < does.size() && does.get(i) < indexMul) i++;
        if (i > 0) i--;
        while (j < donts.size() && donts.get(j) < indexMul) j++;
        if (j > 0) j--;
        if (!abled && indexMul > does.get(0)) abled = true;
        return ((j == 0 && indexMul < donts.get(j) && abled) || (does.get(i) > donts.get(j) && indexMul > does.get(i)));
    }

    public static int partTwo(List<String> input) {
        int result = 0;
        boolean abled = true;

        for (String line : input) {
            Pattern patternMul = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");
            Pattern patternDo = Pattern.compile("do\\(\\)");
            Pattern patternDont = Pattern.compile("don\\'t\\(\\)");
            Matcher matcherMul = patternMul.matcher(line);
            Matcher matcherDo = patternDo.matcher(line);
            Matcher matcherDont = patternDont.matcher(line);

            List<Integer> does = new ArrayList<>();
            List<Integer> donts = new ArrayList<>();

            while (matcherDo.find()) {
                does.add(matcherDo.start());
            }
            while (matcherDont.find()) {
                donts.add(matcherDont.start());
            }

            while (matcherMul.find()) {
                if (isAbled(matcherMul.start(), does, donts, abled)) {
                    abled = true;
                    String operation = matcherMul.group();
                    operation = operation.substring(4, operation.length());
                    operation = operation.substring(0, operation.length()-1);
                    String[] numbersInString = operation.split(",");
                    result += Integer.parseInt(numbersInString[0]) * Integer.parseInt(numbersInString[1]);
                }                     
            }
            if (donts.getLast() > does.getLast()) abled = false;
        }

        return result;
    }
}