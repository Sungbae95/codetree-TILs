import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n, k;
  static int [] arr;
  static boolean [] person;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new int[2 * n];
    person = new boolean[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0 ; i < 2*n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int level = 0;
    while(true){
      level++;
      // 1단계
      int tmp = arr[2*n - 1];
      for (int i = 2*n -1; i > 0; i--){
        arr[i] = arr[i-1];
      }
      arr[0] = tmp;
      for (int i = n-1; i > 0; i--){
        person[i] = person[i-1];
      }
      person[0] = false;
      person[n-1] = false;

      // 2단계
      for (int i = n-1; i > 0; i--){
        if (person[i-1] && !person[i] && arr[i] > 0){
          person[i-1] = false;
          person[i] = true;
          arr[i]--;
          person[n-1] = false;
        }
      }

      // 3단계
      if (arr[0] > 0 && !person[0]) {
        person[0] = true;
        arr[0]--;
      }
      int count = 0;
      for (int i = 0; i < 2*n; i++){
        if (arr[i] == 0)  count++;
      }
      if (count >= k) break;
    }
    System.out.println(level);
  }
}