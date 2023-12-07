import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int [][] arr;
  static boolean [] visited;
  static ArrayList<int[]> persons = new ArrayList<>();
  static ArrayList<int[]> hospitals = new ArrayList<>();
  static ArrayList<int[]> choices = new ArrayList<>();
  static int result = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N][N];
    for (int i = 0 ; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
        if (arr[i][j] == 1) persons.add(new int[]{i, j});
        else if (arr[i][j] == 2) hospitals.add(new int[]{i, j});
      }
    }
    visited = new boolean[hospitals.size()];

    dfs(0, 0);
    System.out.println(result);
  }
  static void dfs(int depth, int start){
    if (depth == M){
      cal();
      return ;
    }
    for (int i = start; i < hospitals.size(); i++){
      if (visited[i]) continue;
      visited[i] = true;
      choices.add(hospitals.get(i));
      dfs(depth + 1, i);
      choices.remove(choices.size() - 1);
      visited[i] = false;
    }
  }
  static void cal(){
    int sum = 0;
    for (int [] person : persons){
      int min = Integer.MAX_VALUE;
      for (int [] choice : choices){
        int value = Math.abs( person[0] - choice[0]) + Math.abs(person[1] - choice[1]);
        min = Math.min(min, value);
      }
      sum += min;
    }
    result = Math.min(result, sum);
    return ;
  }
}