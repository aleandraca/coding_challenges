import java.nio.file.Files;
import java.nio.file.Paths;
import static java.lang.Math.min;

public class Day1TrebuchetPt2 {

  public static void main(String[] args) throws java.io.IOException {
    var sum = Files.lines(Paths.get(args[0]))
      .map(l -> getCalibNums(l))
      .mapToInt(Integer::valueOf)
      .sum();
    System.out.println("Output: " +  sum);
  }

  private static String getCalibNums(String line){
    String[] digits = {"-", "one", "two", "three", "four", "five", "six",
      "seven", "eight", "nine"};
    var nums = "";
    var chars = line.toCharArray();
    for(int i = 0; i < chars.length; i++){
      if(Character.isDigit(chars[i])){
        nums += chars[i];
        continue;
      }
      var substr = line.substring(i, min(5 + i, line.length()));
      for(int j = 0; j < digits.length; j++){
        if(substr.startsWith(digits[j])){
          i += digits[j].length() - 2;
          nums += j;
          break;
        }
      }
    }
    return "" + nums.charAt(0) + nums.charAt(nums.length() - 1);
  }
}
