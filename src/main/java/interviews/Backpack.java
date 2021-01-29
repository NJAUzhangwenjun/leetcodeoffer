package interviews;

public class Backpack {
  public int maxValue(int[] w, int[] v, int n, int cap) {
    if (n < 0 || cap <= 0) {
      return 0;
    }

    int ret = solve(w, v, n - 1, cap);
    if (w[n] <= cap) {
      ret = Math.max(ret, v[n] + solve(w, v, n - 1, cap - w[n]));
    }
    return ret;
  }

  private int solve(int[] w, int[] v, int i, int cap) {
    int size = w.length;

    return solve(w, v, size - 1, cap);
  }
}
