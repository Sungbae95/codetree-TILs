import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int [] dy = {-1, 0, 1, 0};
  static int [] dx = {0, 1, 0, -1};
  static int [][] arr;
  static boolean [][] visited;
  static int count = 1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N][M];
    visited = new boolean[N][M];
    st = new StringTokenizer(br.readLine());
    int startY = Integer.parseInt(st.nextToken());
    int startX = Integer.parseInt(st.nextToken());
    int di = Integer.parseInt(st.nextToken());
    for (int i = 0 ; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dfs(startY, startX, di);
    System.out.println(count);
  }
  static void dfs(int y, int x, int di){
    arr[y][x] = 2;
    for (int i = 0; i < 4; i++){
      di -= 1;
      if (di == -1) di = 3;
      int nY = y + dy[di];
      int nX = x + dx[di];
      if (nY <= 0 || nX <= 0 || nY >= N ||  nX >= M || visited[nY][nX] || arr[nY][nX] != 0) continue;
      count++;
      dfs(nY, nX, di);
      return;
    }
    int dir = (di + 2) % 4;
    for (int i = 0; i < 4; i++){
      int nY = y + dy[dir];
      int nX = x + dx[dir];
      if (nY <= 0 || nX <= 0 || nY >= N ||  nX >= M || arr[nY][nX] == 1) continue;
      dfs(nY, nX, di);
    }
  }
}