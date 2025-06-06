import java.util.*;

public class Fish {
  // O(n) time complexity using stack
  public int optimalSolution(int[] fishSizes, int[] fishDirs) {
    Deque<Integer> dsFish = new ArrayDeque<>();
    int upSurvivors = 0;
    for (int i = 0; i < fishSizes.length; i++) {
      int fishSize = fishSizes[i];
      if (fishDirs[i] == 1) {
        dsFish.push(fishSize);
      } else {
        while (!dsFish.isEmpty()) {
          if (dsFish.peek() > fishSize) {
            fishSize = -1;
            break;
          }
          dsFish.pop();
        }
        if (fishSize != -1) {
          upSurvivors++;
        }
      }
    }
    return dsFish.size() + upSurvivors;
  }

  private record FishDir(int fish, int dir) {
  }

  // O(n^2) time complexity
  public int bruteForceSolution(int[] fishSizes, int[] fishDirs) {
    int eaten = 1;
    List<FishDir> fishList = new ArrayList<>();

    for (int i = 0; i < fishSizes.length; i++) {
      fishList.add(new FishDir(fishSizes[i], fishDirs[i]));
    }
    while (eaten > 0) {
      eaten = 0;
      for (int i = 1; i < fishList.size(); i++) {
        if (fishList.get(i - 1).dir > fishList.get(i).dir) {
          eaten++;
          if (fishList.get(i - 1).fish > fishList.get(i).fish) {
            fishList.remove(i);
          } else {
            fishList.remove(i - 1);
          }
          i--;
        }
      }
    }
    return fishList.size();
  }

  public static void main(String[] args) {
    test(new TestCase(new int[] { 3, 7, 1, 9, 10 }, new int[] { 1, 1, 0, 0, 1 }, 2));
    test(new TestCase(new int[] { 4, 3, 2, 1, 5 }, new int[] { 0, 1, 0, 0, 0 }, 2));
  }

  private record TestCase(int[] fishSizes, int[] fishDirs, int expected) {
    @Override
    public final String toString() {
      return "fishSizes:" + Arrays.toString(fishSizes) + " fishDirs:" + Arrays.toString(fishSizes) + " | Expected: "
          + expected;
    }
  }

  private static void test(TestCase testCase) {
    var app = new Fish();
    var actual = app.optimalSolution(testCase.fishSizes, testCase.fishDirs);
    System.out.print(actual == testCase.expected ? "🟢 " : "🔴 ");
    System.out.println(testCase + " actual: " + actual);
  }
}
