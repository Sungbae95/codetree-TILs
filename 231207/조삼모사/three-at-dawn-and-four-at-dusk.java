import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int [][] arr;
  static int N;
  static boolean [] visited;
  static int minValue = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    visited = new boolean[N];
    for (int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dfs(0, 0);
    System.out.println(minValue);
  }
  static void dfs(int depth, int idx){
    if (depth == N / 2){
      cal();
      return;
    }
    for (int i = idx; i < N; i++){
      if (visited[i]) continue;
      visited[i] = true;
      dfs(depth + 1, idx + 1);
      visited[i] = false;
    }
  }
  static void cal(){
    int sum = 0;
    int sum2 = 0;
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    for (int i = 0; i < N; i++){
      if (visited[i]){
        list1.add(i);
      } else {
        list2.add(i);
      }
    }
    for (int i = 0; i < list1.size(); i++){
      int num1 = list1.get(i);
      for (int j = i+1; j < list1.size(); j++){
        int num2 = list1.get(j);
        sum += (arr[num1][num2] + arr[num2][num1]);
      }
    }

    for (int i = 0; i < list2.size(); i++){
      int num1 = list2.get(i);
      for (int j = i+1; j < list2.size(); j++){
        int num2 = list2.get(j);
        sum2 += (arr[num1][num2] + arr[num2][num1]);
      }
    }
    minValue = Math.min(minValue, Math.abs(sum - sum2));
  }
}