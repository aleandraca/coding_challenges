public class FrogJump {
  public static void main(String[] args) {
    var ac = solution(10, 85, 30);
    var ex = 3;
    System.out.println((ex == ac ? "🟢" : "🔴") + " Result -> " + ac);
  }

  // 100% O(1)
  public static int solution(int x, int y, int d) {
    return (int)Math.ceil((y - x) / (double)d);
  }
}
