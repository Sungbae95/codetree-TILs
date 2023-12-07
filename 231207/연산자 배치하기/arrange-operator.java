import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int [] arr;
  static int [] cal = new int[3];
  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 3; i++){
      cal[i] = Integer.parseInt(st.nextToken());
    }
    dfs(arr[0], 1);
    System.out.print(min +" " + max);
  }
  static void dfs(int value, int depth){
    if (depth == N){
      min = Math.min(min, value);
      max = Math.max(max, value);
      return;
    }
    for (int i = 0 ; i < 3; i++){
      if (cal[i] > 0){
        cal[i]--;
        if (i == 0) dfs(value + arr[depth], depth+1);
        else if (i == 1) dfs(value  - arr[depth], depth+1);
        else dfs(value * arr[depth], depth+1);
        cal[i]++;
      }
    }
  }
}