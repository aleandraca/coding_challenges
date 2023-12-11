import java.nio.file.Files;
import java.nio.file.Paths;

public class Day1TrebuchetPt1 {
  public static void main(String[] args) throws Exception{
    System.out.println("Output: " +  recoverCalibration(args[0]));
  }

  public static int recoverCalibration(String file) throws Exception {
    return Files.lines(Paths.get(file))
      .map(l -> {
          var digits = l.replaceAll("\\D", "");
          digits = "" + digits.charAt(0) + digits.charAt(digits.length() - 1);
          return Integer.parseInt(digits);})
      .mapToInt(Integer::valueOf)
      .sum();
  }
}
