import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int [] dp = new int[N+1];
    int [] t = new int[N];
    int [] p = new int[N];
    for (int i = 0; i<N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      t[i] = Integer.parseInt(st.nextToken());
      p[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < N; i++){
      if (i + t[i] <= N){
        dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] +  p[i]);
      }
      else dp[i+1] = Math.max(dp[i+1], p[i]);
    }
    System.out.println(dp[N]);
  }

}