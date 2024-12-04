import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day4 {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Path.of("inputs/day4.txt"));

        System.out.println("Part 1: " + partOne(input));
        System.out.println("Part 2: " + partTwo(input));
    }

    public static int lookForXMAS(int posX, int posY) {
        return 0;
    }

    public static int partOne(List<String> input) {
        int result = 0;

        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.size(); j++) {
                if (input.get(i).charAt(j) == 'X') result += lookForXMAS(i, j);
            }
        }
        
        return result;
    }

    public static int partTwo(List<String> input) {
        int result = 0;
        

        return result;
    }
}